package org.twbbs.peak.canvastest.client.umleditor;


import org.twbbs.peak.canvastest.client.ClientFactory;
import org.twbbs.peak.canvastest.client.connector.ModeConnector;
import org.twbbs.peak.canvastest.client.connector.PortalConnector;
import org.twbbs.peak.canvastest.client.objects.GraphicCenterImpl;
import org.twbbs.peak.canvastest.client.objects.ShinyFrame;
import org.twbbs.peak.canvastest.client.uml.UmlClass;
import org.twbbs.peak.uml.UMLCoreImpl;
import org.twbbs.peak.uml.portal.UMLCoreObserver;
import org.twbbs.peak.uml.portal.UMLCoreSubject;
import org.twbbs.peak.uml.portal.UMLModeObserver;
import org.twbbs.peak.uml.portal.UMLModeSubject;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.ClickHandler;
import com.google.gwt.event.dom.client.MouseDownEvent;
import com.google.gwt.event.dom.client.MouseDownHandler;
import com.google.gwt.event.dom.client.MouseMoveEvent;
import com.google.gwt.event.dom.client.MouseMoveHandler;
import com.google.gwt.event.dom.client.MouseOutEvent;
import com.google.gwt.event.dom.client.MouseOutHandler;
import com.google.gwt.event.dom.client.MouseUpEvent;
import com.google.gwt.event.dom.client.MouseUpHandler;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootPanel;

public class UmlEditorActivity implements UMLCoreObserver,UMLModeObserver{
	private UmlEditorView umlEditorView;
	private GraphicCenterImpl graphicCenter;
	private UmlClass umlClass;
	private Canvas canvas;
	private Context2d context;
	private Context2d bufferedContext;
	private Label movePostion;
	ModeConnector modeConnector;
	PortalConnector portalConnector;
	UMLCoreSubject umlCore;
	UMLModeSubject modeSubject;
	public UmlEditorActivity(ClientFactory clientFactory,ModeConnector modeConnector,PortalConnector portalConnector,UMLCoreSubject umlCore,UMLModeSubject modeSubject) {
		umlEditorView =clientFactory.getUmlEditorView();
		this.modeConnector=modeConnector;
		this.portalConnector=portalConnector;
		this.umlCore=umlCore;
		this.modeSubject=modeSubject;
		graphicCenter = new GraphicCenterImpl();
	}
	public void start(RootPanel panel){
		panel.add(umlEditorView.asWidget());
		
		movePostion=umlEditorView.getMousePostitionRight();
		canvas=umlEditorView.getCanvas();
		context=canvas.getContext2d();
		bufferedContext=umlEditorView.getBufferedCanvas().getContext2d();
				
		
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
	
	private void initHandler(){
		canvas.addMouseDownHandler(new MouseDownHandler() {			
			public void onMouseDown(MouseDownEvent event){
				int x=event.getX();
				int y=event.getY();				
				portalConnector.onMouseDown(x, y);
			}
		});	
		canvas.addMouseMoveHandler(new MouseMoveHandler() {
			public void onMouseMove(MouseMoveEvent event) {
				int x=event.getX();
				int y=event.getY();
				portalConnector.onMouseMove(x, y);
			}
		});		
		canvas.addMouseUpHandler(new MouseUpHandler() {			
			public void onMouseUp(MouseUpEvent event) {
				int x=event.getX();
				int y=event.getY();
				portalConnector.onMouseUp(x, y);
			}
		});
		canvas.addMouseOutHandler(new MouseOutHandler() {
			public void onMouseOut(MouseOutEvent event) {
				portalConnector.onMouseOut();
			}
		});
		umlEditorView.getBtnSelection().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToSelection();				
			}
		});
		umlEditorView.getBtnNewButton().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToAssocaition();
			}
		});
		umlEditorView.getBtnCompostion().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToCompostion();				
			}
		});
		umlEditorView.getBtnGerenalization().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToGeneralization();				
			}
		});
		umlEditorView.getBtnClass().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToClassMode();				
			}
		});
		umlEditorView.getBtnUsecase().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToUseCaseMode();				
			}
		});
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
//				System.out.println("up: "+x+" , "+y);
			}
		});
		
		
	}
	public void modeChanged(int mode) {
		// TODO Auto-generated method stub
		
	}
	public void update() {
		// TODO Auto-generated method stub
		
	}
}
