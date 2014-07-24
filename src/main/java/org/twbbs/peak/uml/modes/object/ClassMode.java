package org.twbbs.peak.uml.modes.object;

import org.twbbs.peak.uml.object.UMLObjectManager;

public class ClassMode extends ObjectsMode{
	public ClassMode(UMLObjectManager manager) {
		super(manager);
	}
	public void onClick(int x, int y) {
		manager.createClassObject(x, y);
	}
}
