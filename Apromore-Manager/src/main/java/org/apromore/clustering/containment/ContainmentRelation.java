package org.apromore.clustering.containment;

import java.util.List;

public interface ContainmentRelation {

    int getNumberOfFragments();

    Integer getFragmentId(int index);

    Integer getFragmentIndex(Integer fragmentId);

    int getFragmentSize(Integer fragmentId);

    boolean areInContainmentRelation(int index1, int index2);

    List<Integer> getRoots();

    List<Integer> getHierarchy(Integer rootFragmentId);

    void setMinSize(int minSize);

    void initialize() throws Exception;

}
