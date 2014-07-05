package org.twbbs.peak.canvastest.client.objects;

public interface GraphicCenter<T> {
	void regist(CanvasDrawable canvasDrawable);
	void remove(CanvasDrawable canvasDrawable);
	void regist(CanvasDrawable canvasDrawable,int level);
	void remove(CanvasDrawable canvasDrawable,int level);
	void draw(T context);
}
