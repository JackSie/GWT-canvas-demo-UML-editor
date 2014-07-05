package org.twbbs.peak.canvastest.client;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.canvastest.client.objects.CanvasDrawable;
import org.twbbs.peak.canvastest.client.objects.GraphicCenter;
import org.twbbs.peak.canvastest.client.objects.GraphicCenterImpl;
import org.twbbs.peak.canvastest.client.objects.ShinyFrame;
import org.twbbs.peak.canvastest.client.objects.UmlClass;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.dom.client.CanvasElement;
import com.google.gwt.dom.client.ImageElement;
import com.google.gwt.event.dom.client.DragEnterEvent;
import com.google.gwt.event.dom.client.DragEnterHandler;
import com.google.gwt.event.dom.client.DragStartEvent;
import com.google.gwt.event.dom.client.DragStartHandler;
import com.google.gwt.event.dom.client.LoadEvent;
import com.google.gwt.event.dom.client.LoadHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class HelloWorldE implements EntryPoint {
	public static int refreshRate = 25;
	 Context2d context;
	 GraphicCenter<Context2d> graphicCenter;
	 Label greetingwords;
	 UmlClass umlClass;
	public void onModuleLoad() {
		
		greetingwords = new Label("hello Canvas");
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
		context=canvas.getContext2d();
	
		
		Image image = new Image("images/ab.png");
		final ImageElement im = ImageElement.as(image.getElement());
		image.addLoadHandler(new LoadHandler() {
			
			public void onLoad(LoadEvent event) {
				context.drawImage(im, 50.0, 50.0);
			}
		});
		
		image.setVisible(false);
		RootPanel.get().add(image);
		
		
		context.fillText("hwwwwwwwwwwwwwwwwwww", 100, 100);
		context.drawImage(im, 50.0, 50.0);
		
		
		
		
		graphicCenter = new GraphicCenterImpl();
		ShinyFrame shinyFrame= new ShinyFrame(graphicCenter);
		
		umlClass = new UmlClass(200,200,graphicCenter);
		
		

		
		
		

		
		
//	    final Timer timer = new Timer() {
//	        @Override
//	        public void run() {
	          doUpdate();
//	        }
//	      };
//	      timer.scheduleRepeating(refreshRate);
	      
	      greetingwords.setText("start");
	      initHandler(canvas);
	}
	
	void doUpdate(){
		
		graphicCenter.draw(context);
	}
	
	private void initHandler(Canvas canvas){
		canvas.addMouseDownHandler(new MouseDownHandler() {
			
			public void onMouseDown(MouseDownEvent event){
				int x=event.getX();
				int y=event.getY();
				greetingwords.setText("down1: "+x+" , "+y);
				if(x>=umlClass.getX()&&x<=umlClass.getX()+20 && y>=umlClass.getY()&&y<=umlClass.getY()+50){
						umlClass.setSelected(true,x,y);
				}else{
					umlClass.setSelected(false);
				}
				doUpdate();
			}
		});
	
		canvas.addMouseMoveHandler(new MouseMoveHandler() {
			
			public void onMouseMove(MouseMoveEvent event) {
				int x=event.getX();
				int y=event.getY();
				if(umlClass.isSelected()){
					umlClass.moving(x, y);
					doUpdate();
				}
			}
		});
		
		canvas.addMouseUpHandler(new MouseUpHandler() {
			
			public void onMouseUp(MouseUpEvent event) {
				int x=event.getX();
				int y=event.getY();
				if(umlClass.isSelected()){
					umlClass.moving(x, y);
					
				}
				umlClass.setSelected(false);
				doUpdate();
			}
		});

	}

}
