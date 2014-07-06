package org.twbbs.peak.canvastest.client.umleditor;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;

public class UmlEditorViewImpl implements UmlEditorView{

	public final static int WIDTH = 1024;
	public final static int HEIGHT = 768;
	private FlowPanel panel;
	private Label mousePostitionLeft;
	private Label mousePostitionRight;
	private Canvas canvas;
	private Canvas bufferedCanvas;
	
	public UmlEditorViewImpl() {
		panel = new FlowPanel();
		HTMLPanel labelsPanel = new HTMLPanel("");
		mousePostitionLeft = new Label("Move:");
		mousePostitionRight= new Label();
		
		canvas = Canvas.createIfSupported();
		bufferedCanvas=Canvas.createIfSupported();
		if(canvas==null){
			Label errormsg = new Label("canvas not supported");
			panel.add(errormsg);
			return;
		}
		
		canvas.setWidth(WIDTH+"px");
		canvas.setHeight(HEIGHT+"px");
		canvas.setCoordinateSpaceWidth(WIDTH);
		bufferedCanvas.setCoordinateSpaceWidth(WIDTH);
		canvas.setCoordinateSpaceHeight(HEIGHT);
		bufferedCanvas.setCoordinateSpaceHeight(HEIGHT);
		
		labelsPanel.add(mousePostitionLeft);
		labelsPanel.add(mousePostitionRight);
		panel.add(labelsPanel);
		panel.add(canvas);
	}
	
	public Label getMousePostitionLeft() {
		return mousePostitionLeft;
	}


	public Label getMousePostitionRight() {
		return mousePostitionRight;
	}

	public Canvas getCanvas() {
		return canvas;
	}


	public Canvas getBufferedCanvas() {
		return bufferedCanvas;
	}


	public Widget asWidget() {
		return panel;
	}

}
