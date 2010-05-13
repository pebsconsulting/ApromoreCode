package org.apromore.portal.dialogController;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.apromore.portal.model_manager.FormatsType;
import org.apromore.portal.model_manager.ProcessSummaryType;
import org.apromore.portal.model_manager.VersionSummaryType;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.event.Event;
import org.zkoss.zk.ui.event.EventListener;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zul.Button;
import org.zkoss.zul.Listbox;
import org.zkoss.zul.Listitem;
import org.zkoss.zul.Window;

public class EditListNativesController extends Window {

	private MenuController menuC ;
	private Window chooseNativeW;
	private Button okB;
	private Button cancelB;
	private Listbox nativeTypesLB;
//	private Listitem emptynative;
	private HashMap<ProcessSummaryType,List<VersionSummaryType>> processVersions;

	public EditListNativesController (MenuController menuC, FormatsType formats, 
			HashMap<ProcessSummaryType,List<VersionSummaryType>> processVersions) {

		Window win = (Window) Executions.createComponents("macros/choosenative.zul", null, null);

		this.chooseNativeW = (Window) win.getFellow("choosenativeW");
		this.okB = (Button) win.getFellow("choosenativeOkB");
		this.cancelB = (Button) win.getFellow("choosenativeCancelB");
		this.nativeTypesLB = (Listbox) win.getFellow("choosenativeLB");
		//this.emptynative = (Listitem) win.getFellow("emptynative");
		this.menuC = menuC;

		this.processVersions = processVersions;

		for (int i=0; i<formats.getFormat().size(); i++) {
			Listitem cbi = new Listitem();
			this.nativeTypesLB.appendChild(cbi);
			cbi.setLabel(formats.getFormat().get(i));
		}

		this.nativeTypesLB.addEventListener("onSelect",
				new EventListener() {
			public void onEvent(Event event) throws Exception {
				activateOkButton();
			}
		});

		this.okB.addEventListener("onClick",
				new EventListener() {
			public void onEvent(Event event) throws Exception {
				choiceOk();
			}
		});
		this.chooseNativeW.addEventListener("onOK",
				new EventListener() {
			public void onEvent(Event event) throws Exception {
				choiceOk();
			}
		});
		this.cancelB.addEventListener("onClick",
				new EventListener() {
			public void onEvent(Event event) throws Exception {
				cancel();
			}
		});	

	}

	protected void activateOkButton() {
		this.okB.setDisabled(false);
		//this.nativeTypesLB.removeChild(this.emptynative);
	}

	protected void choiceOk () {
		Listitem cbi = nativeTypesLB.getSelectedItem();
		Set<ProcessSummaryType> keys = processVersions.keySet();
		Iterator it = keys.iterator();
		String instruction="", url; 
		int offsetH = 100, offsetV=200;
		
		while (it.hasNext()) {
			ProcessSummaryType process = (ProcessSummaryType) it.next();
			for (Integer i=0; i<processVersions.get(process).size();i++) {
				VersionSummaryType version = processVersions.get(process).get(i);
				offsetH-=100; offsetV-=100;
				
				
			//	Clients.evalJavaScript("window.open('http://www.google.com','" + i.toString() + "')");
				url = "http://www.google.com/search?q="+process.getId()+".."+process.getName()+ "..." +version.getName();
				instruction += "window.open('" + url + "','','top=" + offsetH + ",left=" + offsetV 
					+ ",height=600,width=800,scrollbars=1,resizable=1'); ";
			}
		}
		Clients.evalJavaScript(instruction);
		cancel();
	}

	protected void cancel() {
		this.getChildren().clear();
		this.chooseNativeW.detach();
	}

}
