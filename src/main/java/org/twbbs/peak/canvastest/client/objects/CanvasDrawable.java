package org.twbbs.peak.canvastest.client.objects;


public interface CanvasDrawable<T> {
	void draw(T context);
	void setState(ObjectState state);
	ObjectState getState();
	void moving(int x,int y);
	
}
