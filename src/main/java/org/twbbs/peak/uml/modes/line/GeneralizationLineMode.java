package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.object.UMLObjectManager;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public class GeneralizationLineMode extends LinesMode{
	public GeneralizationLineMode(UMLObjectManager manager) {
		super(manager);
	}
	protected void createLine(UMLBasicObject objectA, UMLBasicObject objectB) {
		manager.generalizeObjects(objectA, objectB);
	}
}
