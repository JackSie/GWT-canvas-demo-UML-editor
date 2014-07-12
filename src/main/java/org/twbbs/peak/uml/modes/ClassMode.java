package org.twbbs.peak.uml.modes;

import org.twbbs.peak.uml.object.UMLObjectManager;

public class ClassMode extends ObjectsMode{
	private UMLObjectManager manager;
	public void onClick(int x, int y) {
		manager.createClassObject(x, y);
	}
}
