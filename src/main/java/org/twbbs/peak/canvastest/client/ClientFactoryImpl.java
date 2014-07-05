package org.twbbs.peak.canvastest.client;

import org.twbbs.peak.canvastest.client.umleditor.UmlEditorView;
import org.twbbs.peak.canvastest.client.umleditor.UmlEditorViewImpl;

import com.google.gwt.user.client.ui.RootPanel;

public class ClientFactoryImpl implements ClientFactory{
	private UmlEditorView umlEditorView;

	public UmlEditorView getUmlEditorView() {
		if (umlEditorView==null){
			umlEditorView=new UmlEditorViewImpl();
		}
		return umlEditorView;
	}

}
