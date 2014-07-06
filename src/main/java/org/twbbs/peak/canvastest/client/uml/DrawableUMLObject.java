package org.twbbs.peak.canvastest.client.uml;

import java.awt.Point;

import org.twbbs.peak.canvastest.client.objects.CanvasDrawable;
import org.twbbs.peak.canvastest.client.objects.ObjectState;

import com.google.gwt.canvas.dom.client.Context2d;

public abstract class DrawableUMLObject implements CanvasDrawable<Context2d>{
	
	protected int x;
	protected int y;
	private ObjectState objectState;
	
	public DrawableUMLObject(int x,int y) {
		moving(x, y);
	}

	public void setState(ObjectState state) {
		this.objectState=state;
	}

	public ObjectState getState() {
		return objectState;
	}

	public void moving(int x, int y) {
		this.x=x;
		this.y=y;
	}

	public Point getPosition() {
		return new Point(x,y);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

}
