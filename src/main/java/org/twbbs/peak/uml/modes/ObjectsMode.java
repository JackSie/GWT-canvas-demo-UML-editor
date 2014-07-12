package org.twbbs.peak.uml.modes;

import org.twbbs.peak.uml.object.UMLObjectManager;

public abstract class ObjectsMode implements UmlMode{
	protected UMLObjectManager manager;
	public ObjectsMode(UMLObjectManager manager) {
		this.manager=manager;
	}
	public abstract void onClick(int x, int y);
	public void startDrag(int x, int y) {}
	public void onDrag(int x, int y) {}
	public void modeChanged() {}
	public void stopDrag(int x, int y) {
		onClick(x, y);
	}
}
