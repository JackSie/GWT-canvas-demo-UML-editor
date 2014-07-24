package org.twbbs.peak.uml.portal;

public interface UMLCorePortal {
	void onClick(int x, int y);
	void startDrag(int x,int y);
	void onDrag(int x,int y);
	void stopDrag(int x,int y);
	void modifyToChaneName();
}
