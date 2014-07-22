package org.twbbs.peak.canvastest.client.umleditor;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;

public class UmlEditorViewImpl implements UmlEditorView{

	public final static int WIDTH = 1024;
	public final static int HEIGHT = 768;
	private FlowPanel panel;
	private Label mousePostitionLeft;
	private Label mousePostitionRight;
	private Canvas canvas;
	private Canvas bufferedCanvas;
	private DockPanel dockPanel;
	private VerticalPanel verticalPanel;
	private PushButton btnSelection;
	private PushButton btnNewButton;
	private PushButton btnCompostion;
	private PushButton btnGerenalization;
	private PushButton btnClass;
	private PushButton btnUsecase;
	
	public UmlEditorViewImpl() {
		panel = new FlowPanel();
		canvas = Canvas.createIfSupported();
		bufferedCanvas=Canvas.createIfSupported();
		if(canvas==null){
			Label errormsg = new Label("canvas not supported");
			panel.add(errormsg);
			return;
		}
		bufferedCanvas.setCoordinateSpaceWidth(WIDTH);
		bufferedCanvas.setCoordinateSpaceHeight(HEIGHT);
		
		dockPanel = new DockPanel();
		panel.add(dockPanel);
		HTMLPanel labelsPanel = new HTMLPanel("");
		dockPanel.add(labelsPanel, DockPanel.NORTH);
		mousePostitionLeft = new Label("Move:");
		mousePostitionRight= new Label();
		
		labelsPanel.add(mousePostitionLeft);
		labelsPanel.add(mousePostitionRight);
		
		
		dockPanel.add(canvas, DockPanel.CENTER);
		
		canvas.setWidth(WIDTH+"px");
		canvas.setHeight(HEIGHT+"px");
		canvas.setCoordinateSpaceWidth(WIDTH);
		canvas.setCoordinateSpaceHeight(HEIGHT);
		
		verticalPanel = new VerticalPanel();
		dockPanel.add(verticalPanel, DockPanel.WEST);
		
		btnSelection = new PushButton(new Image("images/select_mode.png"),new Image("images/select_mode2.png"));
		verticalPanel.add(btnSelection);
		
		btnNewButton = new PushButton(new Image("images/association_mode.png"),new Image("images/association_mode2.png"));
		verticalPanel.add(btnNewButton);
		
		btnCompostion = new PushButton(new Image("images/composition_mode.png"),new Image("images/composition_mode2.png"));
		verticalPanel.add(btnCompostion);
		
		btnGerenalization = new PushButton(new Image("images/generalization_mode.png"),new Image("images/generalization_mode2.png"));
		verticalPanel.add(btnGerenalization);
		
		btnClass = new PushButton(new Image("images/class_mode.png"),new Image("images/class_mode2.png"));
		verticalPanel.add(btnClass);
		
		btnUsecase = new PushButton(new Image("images/usecase_mode.png"),new Image("images/usecase_mode2.png"));
		verticalPanel.add(btnUsecase);
	}
	
	public Label getMousePostitionLeft() {return mousePostitionLeft;}
	public Label getMousePostitionRight() {return mousePostitionRight;}
	public Canvas getCanvas() {return canvas;}
	public Canvas getBufferedCanvas() {return bufferedCanvas;}
	public Widget asWidget() {return panel;}
	public PushButton getBtnSelection() {return btnSelection;}
	public PushButton getBtnNewButton() {return btnNewButton;}
	public PushButton getBtnCompostion() {return btnCompostion;}
	public PushButton getBtnGerenalization() {return btnGerenalization;}
	public PushButton getBtnClass() {return btnClass;}
	public PushButton getBtnUsecase() {return btnUsecase;}

}
