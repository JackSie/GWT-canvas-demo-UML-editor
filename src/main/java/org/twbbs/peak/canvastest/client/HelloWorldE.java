package org.twbbs.peak.canvastest.client;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.canvastest.client.objects.CanvasDrawable;
import org.twbbs.peak.canvastest.client.objects.GraphicCenter;
import org.twbbs.peak.canvastest.client.objects.GraphicCenterImpl;
import org.twbbs.peak.canvastest.client.objects.ShinyFrame;
import org.twbbs.peak.canvastest.client.objects.UmlClass;
import org.twbbs.peak.canvastest.client.umleditor.UmlEditorActivity;

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

	
	
	 
	public void onModuleLoad() {
		
		ClientFactory clientFactory= new ClientFactoryImpl();
		UmlEditorActivity umlEditorActivity = new UmlEditorActivity(clientFactory);
		umlEditorActivity.start(RootPanel.get("umleditor"));

	     
	}

}
