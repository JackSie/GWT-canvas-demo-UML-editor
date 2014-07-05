package org.twbbs.peak.canvastest.client.objects;

import com.google.gwt.canvas.dom.client.Context2d;

public interface CanvasDrawable {
	void draw(Context2d context);
	void setState(ObjectState state);
	ObjectState getState();
}
