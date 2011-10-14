package org.apromore.dao.jpa;

import org.apromore.dao.UserDao;
import org.apromore.dao.model.User;
import org.springframework.orm.jpa.JpaCallback;
import org.springframework.orm.jpa.JpaTemplate;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

/**
 * Hibernate implementation of the org.apromore.dao.UserDao interface.
 *
 * @author <a href="mailto:cam.james@gmail.com">Cameron James</a>
 * @since 1.0
 */
@Repository(value = "UserDao")
@Transactional(propagation = Propagation.REQUIRED)
public class UserDaoJpa extends JpaTemplate implements UserDao {

    /**
     * @see org.apromore.dao.UserDao#findUser(String)
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public User findUser(String username) {
        return find(User.class, username);
    }

    /**
     * @see org.apromore.dao.UserDao#findAllUsers()
     * {@inheritDoc}
     */
    @Override
    @Transactional(readOnly = true)
    public List<User> findAllUsers() {
        return execute(new JpaCallback<List<User>>() {

            @SuppressWarnings("unchecked")
            public List<User> doInJpa(EntityManager em) {
                Query query = em.createNamedQuery(User.FIND_ALL_USERS);
                List<User> users = query.getResultList();
                if (users.isEmpty()) {
                    return null;
                } else {
                    return users;
                }
            }
        });
    }


    /**
     * Save a Log Event.
     * @see org.apromore.dao.UserDao#save(org.apromore.dao.model.User)
     * {@inheritDoc}
     */
    @Override
    public final void save(User user) {
        persist(user);
    }

    /**
     * Update a Log Event.
     * @see org.apromore.dao.UserDao#update(org.apromore.dao.model.User)
     * {@inheritDoc}
     */
    @Override
    public final void update(User user) {
        merge(user);
    }

    /**
     * Remove the log event.
     * @see org.apromore.dao.UserDao#delete(org.apromore.dao.model.User)
     * {@inheritDoc}
     */
    @Override
    public void delete(User user) {
        remove(user);
    }

}
