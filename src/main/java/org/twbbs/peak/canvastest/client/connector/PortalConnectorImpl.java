package org.twbbs.peak.canvastest.client.connector;

import org.twbbs.peak.uml.portal.UMLCorePortal;

public class PortalConnectorImpl implements PortalConnector{
	private UMLCorePortal portal;
	private int saveX;
	private int saveY;
	private boolean isMouseDown=false;
	private boolean isDrag=false;
	
	public PortalConnectorImpl(UMLCorePortal portal) {
		this.portal=portal;
	}
	public void onMouseDown(int x, int y) {
		isMouseDown=true;
		saveX=x;
		saveY=y;
	}

	public void onMouseMove(int x, int y) {
		if(isMouseDown){
			if(!isDrag){
				portal.startDrag(saveX, saveY);
				isDrag=true;
			}
				portal.onDrag(x, y);
		}
	}

	public void onMouseUp(int x, int y) {
		isMouseDown=false;
		if(isDrag){
			portal.stopDrag(x, y);
		}else{
			portal.onClick(x, y);
		}
		isDrag=false;
	}

	public void onMouseOut() {
		if(isMouseDown){
			onMouseUp(saveX, saveY);
		}
	}

}
