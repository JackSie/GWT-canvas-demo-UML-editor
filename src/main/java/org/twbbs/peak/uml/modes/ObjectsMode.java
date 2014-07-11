package org.twbbs.peak.uml.modes;

public abstract class ObjectsMode implements UmlMode{

	public abstract void onClick(int x, int y);
	public void startDrag(int x, int y) {}
	public void onDrag(int x, int y) {}
	public void stopDrag(int x, int y) {
		onClick(x, y);
	}
}
