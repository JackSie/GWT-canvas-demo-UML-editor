package org.twbbs.peak.canvastest.client.objects;

import java.awt.Point;

public interface CanvasDragable {
	static String black = "#000000";
	static String red = "#FF0000";
	void setSelected(boolean isSelected,int x,int y);
	void moving(int x,int y);
	Point getPosition();
}
