package org.twbbs.peak.canvastest.client.umleditor;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.Button;

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
	private Button btnSelection;
	private Button btnNewButton;
	private Button btnCompostion;
	private Button btnGerenalization;
	private Button btnClass;
	private Button btnUsecase;
	
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
		
		btnSelection = new Button("Selection");
		verticalPanel.add(btnSelection);
		
		btnNewButton = new Button("Asscoiation");
		verticalPanel.add(btnNewButton);
		
		btnCompostion = new Button("Compostion");
		verticalPanel.add(btnCompostion);
		
		btnGerenalization = new Button("Gerenalization");
		verticalPanel.add(btnGerenalization);
		
		btnClass = new Button("Class");
		verticalPanel.add(btnClass);
		
		btnUsecase = new Button("UseCase");
		verticalPanel.add(btnUsecase);
	}
	
	public Label getMousePostitionLeft() {return mousePostitionLeft;}
	public Label getMousePostitionRight() {return mousePostitionRight;}
	public Canvas getCanvas() {return canvas;}
	public Canvas getBufferedCanvas() {return bufferedCanvas;}
	public Widget asWidget() {return panel;}
	public Button getBtnSelection() {return btnSelection;}
	public Button getBtnNewButton() {return btnNewButton;}
	public Button getBtnCompostion() {return btnCompostion;}
	public Button getBtnGerenalization() {return btnGerenalization;}
	public Button getBtnClass() {return btnClass;}
	public Button getBtnUsecase() {return btnUsecase;}

}
