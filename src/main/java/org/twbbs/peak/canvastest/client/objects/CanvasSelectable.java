package org.twbbs.peak.canvastest.client.objects;

public interface CanvasSelectable {
	
	void setSelected(boolean isSelected);
	boolean isSelected();
	boolean isIn(int x,int y);
}
