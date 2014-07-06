package org.twbbs.peak.canvastest.client.umleditor;

import java.io.Console;

import org.twbbs.peak.canvastest.client.ClientFactory;
import org.twbbs.peak.canvastest.client.objects.GraphicCenterImpl;
import org.twbbs.peak.canvastest.client.objects.ShinyFrame;
import org.twbbs.peak.canvastest.client.uml.UmlClass;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class UmlEditorActivity {
	private UmlEditorView umlEditorView;
	private GraphicCenterImpl graphicCenter;
	private UmlClass umlClass;
	private Canvas canvas;
	private Context2d context;
	private Context2d bufferedContext;
	private Label movePostion;
	public UmlEditorActivity(ClientFactory clientFactory) {
		umlEditorView =clientFactory.getUmlEditorView();
	}
	public void start(RootPanel panel){
		panel.add(umlEditorView.asWidget());
		
		movePostion=umlEditorView.getMousePostitionRight();
		canvas=umlEditorView.getCanvas();
		context=canvas.getContext2d();
		bufferedContext=umlEditorView.getBufferedCanvas().getContext2d();
		
		graphicCenter = new GraphicCenterImpl();
		
		new ShinyFrame(graphicCenter);
		
		umlClass = new UmlClass(200,200);
		graphicCenter.regist(umlClass);
		initHandler(canvas);
		doUpdate();
	}
	
	void doUpdate(){
		bufferedContext.setFillStyle("#FFFFFF");
		bufferedContext.fillRect(0, 0, 1024, 768);
		graphicCenter.draw(bufferedContext);
		context.drawImage(bufferedContext.getCanvas(), 0, 0);
	}
	
	private void initHandler(Canvas canvas){
		canvas.addMouseDownHandler(new MouseDownHandler() {			
			public void onMouseDown(MouseDownEvent event){
				int x=event.getX();
				int y=event.getY();				
				if(umlClass.isIn(x, y)){
						umlClass.setDraged(true,x,y);
				}else{
					umlClass.setDraged(false);
				}
				doUpdate();
				System.out.println("down: "+x+" , "+y);
			}
		});
	
		canvas.addMouseMoveHandler(new MouseMoveHandler() {
			public void onMouseMove(MouseMoveEvent event) {
				int x=event.getX();
				int y=event.getY();
				movePostion.setText(x+" , "+y);
				if(umlClass.isDraged()){
					umlClass.moving(x, y);
					doUpdate();
				}
			}
		});
		
		canvas.addMouseUpHandler(new MouseUpHandler() {			
			public void onMouseUp(MouseUpEvent event) {
				int x=event.getX();
				int y=event.getY();
				if(umlClass.isDraged()){
					umlClass.moving(x, y);					
				}
				umlClass.setDraged(false);
				doUpdate();
				System.out.println("up: "+x+" , "+y);
			}
		});
		
	}
}
