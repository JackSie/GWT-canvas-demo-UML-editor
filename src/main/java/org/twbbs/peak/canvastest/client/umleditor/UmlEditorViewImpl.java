package org.twbbs.peak.canvastest.client.umleditor;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.HTMLPanel;
import com.google.gwt.user.client.ui.Image;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Panel;
import com.google.gwt.user.client.ui.PushButton;
import com.google.gwt.user.client.ui.Widget;
import com.google.gwt.user.client.ui.DockPanel;
import com.google.gwt.user.client.ui.VerticalPanel;
import com.google.gwt.user.client.ui.MenuBar;
import com.google.gwt.user.client.ui.MenuItem;
import com.google.gwt.user.client.Command;

public class UmlEditorViewImpl implements UmlEditorView{

	public final static int WIDTH = 1024;
	public final static int HEIGHT = 768;
	private FlowPanel panel;
	private Canvas canvas;
	private Canvas bufferedCanvas;
	private DockPanel dockPanel;
	private PushButton btnSelection;
	private PushButton btnNewButton;
	private PushButton btnCompostion;
	private PushButton btnGerenalization;
	private PushButton btnClass;
	private PushButton btnUsecase;
	private MenuBar menuBar;
	private MenuItem mntmFile;
	private MenuItem mntmEdit;
	private MenuItem mntmChangeObjectName;
	private MenuItem mntmGroup;
	private MenuItem mntmUngroup;
	
	public UmlEditorViewImpl() {
		panel = new FlowPanel();
		Widget canvas = initCenter();
		if(canvas==null)
			return;
		dockPanel = new DockPanel();
		panel.add(dockPanel);
		dockPanel.add(intNorthPanel(), DockPanel.NORTH);
		dockPanel.add(canvas, DockPanel.CENTER);
		dockPanel.add(intWestPanel(), DockPanel.WEST);
	}
	private Panel intWestPanel(){
		VerticalPanel verticalPanel = new VerticalPanel();
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
		return verticalPanel;
	}
	private Panel intNorthPanel(){
		HTMLPanel labelsPanel = new HTMLPanel("");
		
		menuBar = new MenuBar(false);
		labelsPanel.add(menuBar);
		MenuBar menuBar_1 = new MenuBar(true);
		
		mntmFile = new MenuItem("File", false, menuBar_1);
		menuBar.addItem(mntmFile);
		MenuBar menuBar_2 = new MenuBar(true);
		
		mntmEdit = new MenuItem("Edit", false, menuBar_2);
		
		mntmGroup = new MenuItem("group", false, (Command) null);
		menuBar_2.addItem(mntmGroup);
		
		mntmUngroup = new MenuItem("ungroup", false, (Command) null);
		menuBar_2.addItem(mntmUngroup);
		
		mntmChangeObjectName = new MenuItem("change object name", false, (Command) null);
		menuBar_2.addItem(mntmChangeObjectName);
		menuBar.addItem(mntmEdit);
		return labelsPanel;
	}
	private Widget initCenter(){
		canvas = Canvas.createIfSupported();
		bufferedCanvas=Canvas.createIfSupported();
		if(canvas==null){
			Label errormsg = new Label("canvas not supported");
			panel.add(errormsg);
			return null;
		}
		bufferedCanvas.setCoordinateSpaceWidth(WIDTH);
		bufferedCanvas.setCoordinateSpaceHeight(HEIGHT);
		canvas.setWidth(WIDTH+"px");
		canvas.setHeight(HEIGHT+"px");
		canvas.setCoordinateSpaceWidth(WIDTH);
		canvas.setCoordinateSpaceHeight(HEIGHT);
		return canvas;
	}
	public Canvas getCanvas() {return canvas;}
	public Canvas getBufferedCanvas() {return bufferedCanvas;}
	public Widget asWidget() {return panel;}
	public PushButton getBtnSelection() {return btnSelection;}
	public PushButton getBtnNewButton() {return btnNewButton;}
	public PushButton getBtnCompostion() {return btnCompostion;}
	public PushButton getBtnGerenalization() {return btnGerenalization;}
	public PushButton getBtnClass() {return btnClass;}
	public PushButton getBtnUsecase() {return btnUsecase;}
	public MenuItem getMntmChangeObjectName() {return mntmChangeObjectName;}
	public MenuItem getMntmGroup() {return mntmGroup;}
	public MenuItem getMntmUngroup() {return mntmUngroup;}
}
