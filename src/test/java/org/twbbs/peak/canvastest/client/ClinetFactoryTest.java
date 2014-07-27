package org.twbbs.peak.canvastest.client;

import org.twbbs.peak.canvastest.client.umleditor.UmlEditorView;

import com.google.gwt.junit.client.GWTTestCase;

public class ClinetFactoryTest extends GWTTestCase{

	public void testGetUmlEditorView(){
		ClientFactory clientFactory=new ClientFactoryImpl();
		UmlEditorView umlEditorView= clientFactory.getUmlEditorView();
		assertNotNull(umlEditorView);
	}
	
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.canvastest.canvasmJUnit";
	}
}
