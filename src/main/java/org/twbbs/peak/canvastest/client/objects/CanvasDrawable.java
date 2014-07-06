package org.twbbs.peak.canvastest.client.objects;


public interface CanvasDrawable<T> {
	void draw(T context);
	void setState(ObjectState state);
	ObjectState getState();
	void setX(int x);
	int getX();
	void setY(int y);
	int getY();
	
}
