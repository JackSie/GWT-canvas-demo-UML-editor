package org.twbbs.peak.canvastest.client.objects;

public interface GraphicCenter<T> {
	void regist(CanvasDrawable<T> canvasDrawable);
	void remove(CanvasDrawable<T> canvasDrawable);
	void regist(CanvasDrawable<T> canvasDrawable,int level);
	void remove(CanvasDrawable<T> canvasDrawable,int level);
	void draw(T context);
}
