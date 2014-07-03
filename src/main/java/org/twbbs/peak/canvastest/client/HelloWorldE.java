package org.twbbs.peak.canvastest.client;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.user.client.Timer;
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
		image.addLoadHandler(new LoadHandler() {
			
			public void onLoad(LoadEvent event) {
				ctx.drawImage(im, 50.0, 50.0);
				 Timer t = new Timer() {
					int i=0;
					public void run() {
						ctx.drawImage(im, 2*i , 50.0);
						i++;
						if(i>500){
							i=0;
						}
//						try { Thread.sleep(100); } catch (InterruptedException e) { e.printStackTrace(); }
					}
				};
				t.scheduleRepeating(10);;
			}
		});
		
		image.setVisible(false);
		RootPanel.get().add(image);
		
		
		ctx.fillText("hwwwwwwwwwwwwwwwwwww", 100, 100);
		ctx.drawImage(im, 50.0, 50.0);
		
		ctx.setStrokeStyle("#000000");
		ctx.strokeRect(5, 5, 1014, 758);

		
		canvas.addMouseMoveHandler(new MouseMoveHandler() {
			
			public void onMouseMove(MouseMoveEvent event) {
				int x=event.getClientX();
				int y=event.getClientY();
				ctx.drawImage(im, x-100, y-100);
				
			}
		});
	}

}
