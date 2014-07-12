package org.twbbs.peak.canvastest.client.connector;

public interface PortalConnector {
	void onMouseDown(int x,int y);
	void onMouseMove(int x,int y);
	void onMouseUp(int x,int y);
	void onMouseOut();
}
