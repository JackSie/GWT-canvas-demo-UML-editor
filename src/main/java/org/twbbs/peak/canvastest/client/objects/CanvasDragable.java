package org.twbbs.peak.canvastest.client.objects;


public interface CanvasDragable {
	static String black = "#000000";
	static String red = "#FF0000";
	void setDraged(boolean isDraged,int x,int y);
	boolean isDraged();
	void moving(int x,int y);
	boolean isIn(int x,int y);
}
