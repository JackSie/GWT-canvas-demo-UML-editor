package org.twbbs.peak.canvastest.client.objects.draw;

import com.google.gwt.canvas.dom.client.Context2d;

public interface DrawBehavior {
	double shadowOffsetNormal=5;
	double shadowOffsetUp=10;
	static String blue ="#0000FF";
	static String black = "#000000";
	static String red = "#FF0000";
	void toDraw(Context2d context);
}
