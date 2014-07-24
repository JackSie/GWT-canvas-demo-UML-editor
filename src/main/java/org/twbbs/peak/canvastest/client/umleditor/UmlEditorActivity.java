package org.twbbs.peak.canvastest.client.umleditor;


import org.twbbs.peak.canvastest.client.ClientFactory;
import org.twbbs.peak.canvastest.client.connector.ModeConnector;
import org.twbbs.peak.canvastest.client.connector.PortalConnector;
import org.twbbs.peak.canvastest.client.objects.draw.CanvasCenter;
import org.twbbs.peak.uml.portal.UMLCoreSubject;
import org.twbbs.peak.uml.portal.UMLModeObserver;
import org.twbbs.peak.uml.portal.UMLModeSubject;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.core.client.Scheduler.ScheduledCommand;
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
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.RootPanel;

public class UmlEditorActivity implements UMLModeObserver{
	private UmlEditorView umlEditorView;
	private Canvas canvas;
	private Canvas bufferedCanvas;
	ModeConnector modeConnector;
	PortalConnector portalConnector;
	UMLCoreSubject umlCore;
	UMLModeSubject modeSubject;
	private CanvasCenter canvasCenter;
	private PushButton buttonIsEnable;
	private ChangeNameDialogBox changeNameDialogBox;
	public UmlEditorActivity(ClientFactory clientFactory,ModeConnector modeConnector,PortalConnector portalConnector,UMLCoreSubject umlCore,UMLModeSubject modeSubject) {
		umlEditorView =clientFactory.getUmlEditorView();
		this.modeConnector=modeConnector;
		this.portalConnector=portalConnector;
		this.umlCore=umlCore;
		this.modeSubject=modeSubject;
		canvas=umlEditorView.getCanvas();
		bufferedCanvas=umlEditorView.getBufferedCanvas();
		this.canvasCenter=new CanvasCenter(canvas,bufferedCanvas,umlCore);
		this.changeNameDialogBox=new ChangeNameDialogBox();
		modeSubject.regist(this);
	}
	public void start(RootPanel panel){
		panel.add(umlEditorView.asWidget());
		
		initHandler();
		doUpdate();
	}
	void doUpdate(){
		canvasCenter.update();
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
				buttonDisable(umlEditorView.getBtnSelection());
			}
		});
		buttonDisable(umlEditorView.getBtnSelection());
		umlEditorView.getBtnNewButton().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToAssocaition();
				buttonDisable(umlEditorView.getBtnNewButton());
			}
		});
		umlEditorView.getBtnCompostion().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToCompostion();
				buttonDisable(umlEditorView.getBtnCompostion());
			}
		});
		umlEditorView.getBtnGerenalization().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToGeneralization();
				buttonDisable(umlEditorView.getBtnGerenalization());
			}
		});
		umlEditorView.getBtnClass().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToClassMode();
				buttonDisable(umlEditorView.getBtnClass());
			}
		});
		umlEditorView.getBtnUsecase().addClickHandler(new ClickHandler() {			
			public void onClick(ClickEvent event) {
				modeConnector.chageToUseCaseMode();
				buttonDisable(umlEditorView.getBtnUsecase());
			}
		});
		umlEditorView.getMntmChangeObjectName().setScheduledCommand(new ScheduledCommand() {
			public void execute() {
				modeConnector.changeName(null);
			}
		});
		umlEditorView.getMntmGroup().setScheduledCommand(new ScheduledCommand() {			
			public void execute() {
				modeConnector.group();
			}
		});
		umlEditorView.getMntmUngroup().setScheduledCommand(new ScheduledCommand() {			
			public void execute() {
				modeConnector.upGroup();
			}
		});
		changeNameDialogBox.getButtonOK().addClickHandler(new ClickHandler() {
			public void onClick(ClickEvent event) {
				modeConnector.changeName(changeNameDialogBox.getTextBox().getText());
				changeNameDialogBox.hide();
			}
		});
	}
	
	private void buttonDisable(PushButton button){
		if(buttonIsEnable!=null){
			buttonIsEnable.setEnabled(true);
		}
		buttonIsEnable=button;
		buttonIsEnable.setEnabled(false);
	}
	
	public void modeChanged(int mode) {
		// TODO Auto-generated method stub
	}
	public void changeName() {
		changeNameDialogBox.center();
	}
}
