package org.twbbs.peak.canvastest.client.objects;

import java.awt.Point;

import com.google.gwt.canvas.dom.client.Context2d;

public interface CanvasDrawable<T> {
	void draw(T context);
	void setState(ObjectState state);
	ObjectState getState();
	void moving(int x,int y);
	Point getPosition();
}
