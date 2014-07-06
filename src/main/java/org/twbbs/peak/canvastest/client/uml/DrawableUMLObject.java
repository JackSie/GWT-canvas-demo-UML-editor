package org.twbbs.peak.canvastest.client.uml;


import org.twbbs.peak.canvastest.client.objects.CanvasDrawable;
import org.twbbs.peak.canvastest.client.objects.ObjectState;

import com.google.gwt.canvas.dom.client.Context2d;

public abstract class DrawableUMLObject implements CanvasDrawable<Context2d>{
	
	private ObjectState objectState;
	
	public DrawableUMLObject(ObjectState objectState) {
		this.objectState=objectState;
	}

	
	public void setState(ObjectState state) {
		this.objectState=state;
	}

	public ObjectState getState() {
		return objectState;
	}

	public void moving(int x, int y) {
		setX(x);
		setY(y);
	}

	public int getX() {
		return objectState.getY();
	}

	public void setX(int x) {
		objectState.setX(x);
	}

	public int getY() {
		return objectState.getY();
	}

	public void setY(int y) {
		objectState.setY(y);
	}
}
