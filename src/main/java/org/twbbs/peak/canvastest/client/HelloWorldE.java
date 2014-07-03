package org.twbbs.peak.canvastest.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.user.client.ui.Image;
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
		canvas.setWidth("1024px");
		canvas.setHeight("768px");
		canvas.setCoordinateSpaceWidth(1024);
		canvas.setCoordinateSpaceHeight(768);
		
		RootPanel.get().add(canvas);
		final Context2d ctx=canvas.getContext2d();
		ctx.fillRect(1, 1, 10, 20);
		
		Image image = new Image("images/ab.png");
		final ImageElement im = ImageElement.as(image.getElement());
		
		
		ctx.fillText("hwwwwwwwwwwwwwwwwwww", 100, 100);
		ctx.drawImage(im, 50.0, 50.0);

	}

}
