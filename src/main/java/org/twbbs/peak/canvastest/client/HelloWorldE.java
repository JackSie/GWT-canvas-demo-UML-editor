package org.twbbs.peak.canvastest.client;


import org.twbbs.peak.canvastest.client.umleditor.UmlEditorActivity;



import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloWorldE implements EntryPoint {

	
	
	 
	public void onModuleLoad() {
		
		ClientFactory clientFactory= new ClientFactoryImpl();
		UmlEditorActivity umlEditorActivity = new UmlEditorActivity(clientFactory);
		umlEditorActivity.start(RootPanel.get("umleditor"));

	     
	}

}
