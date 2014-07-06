package org.twbbs.peak.canvastest.client.objects;


public interface CanvasDragable {
	
	void setDraged(boolean isDraged,int x,int y);
	boolean isDraged();
	void moving(int x,int y);
	boolean isIn(int x,int y);
}
