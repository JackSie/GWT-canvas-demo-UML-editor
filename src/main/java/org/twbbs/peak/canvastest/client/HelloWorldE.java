package org.twbbs.peak.canvastest.client;

import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloWorldE implements EntryPoint {

	public void onModuleLoad() {
		Label greetingwords = new Label("hello Canvas");
		RootPanel.get().add(greetingwords);

	}

}
