package org.twbbs.peak.uml.modes;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.UMLObjectManager;

public class CompositionLineMode extends LinesMode{
	public CompositionLineMode(UMLObjectManager manager) {
		super(manager);
	}
	protected void createLine(UMLObject objectA, UMLObject objectB) {
		manager.compositeObjects(objectA, objectB);
	}
}
