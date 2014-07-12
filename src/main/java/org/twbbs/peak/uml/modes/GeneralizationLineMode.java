package org.twbbs.peak.uml.modes;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.UMLObjectManager;

public class GeneralizationLineMode extends LinesMode{
	private UMLObjectManager manager;
	protected void createLine(UMLObject objectA, UMLObject objectB) {
		manager.generalizeObjects(objectA, objectB);
	}
}
