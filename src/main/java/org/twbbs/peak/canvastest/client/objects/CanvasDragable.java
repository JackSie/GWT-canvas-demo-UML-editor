package org.twbbs.peak.canvastest.client.objects;


public interface CanvasDragable {
	static String black = "#000000";
	static String red = "#FF0000";
	void setSelected(boolean isSelected,int x,int y);
	void moving(int x,int y);
}
