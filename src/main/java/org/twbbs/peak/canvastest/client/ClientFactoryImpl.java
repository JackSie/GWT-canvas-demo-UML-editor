package org.twbbs.peak.canvastest.client;

import org.twbbs.peak.canvastest.client.umleditor.UmlEditorView;
import org.twbbs.peak.canvastest.client.umleditor.UmlEditorViewImpl;

public class ClientFactoryImpl implements ClientFactory{
	private UmlEditorView umlEditorView;

	public UmlEditorView getUmlEditorView() {
		if (umlEditorView==null){
			umlEditorView=new UmlEditorViewImpl();
		}
		return umlEditorView;
	}

}
