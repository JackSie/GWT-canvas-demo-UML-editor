package org.twbbs.peak.canvastest.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloWorldE implements EntryPoint {

	public void onModuleLoad() {
		Label greetingwords = new Label("hello Canvas");
		RootPanel.get().add(greetingwords);
		Canvas canvas = Canvas.createIfSupported();
		if(canvas==null){
			Label errormsg = new Label("canvas not supported");
			RootPanel.get().add(errormsg);
			return;
		}
		canvas.setWidth("800px");
		canvas.setHeight("400px");
		canvas.setCoordinateSpaceWidth(800);
		canvas.setCoordinateSpaceHeight(400);
		
		RootPanel.get().add(canvas);
		Context2d ctx=canvas.getContext2d();
		ctx.rect(1, 1, 10, 20);
		

	}

}
