package org.twbbs.peak.canvastest.client.objects;

public interface CanvasSelectable {
	static String blue ="#0000FF";
	void setSelected(boolean isSelected);
	boolean isSelected();
	boolean isIn(int x,int y);
}
