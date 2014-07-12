package org.twbbs.peak.uml.modes;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.UMLObjectManager;

public class AssociationLineMode extends LinesMode{
	public AssociationLineMode(UMLObjectManager manager) {
		super(manager);
	}
	protected void createLine(UMLObject objectA, UMLObject objectB) {
		manager.associateObjects(objectA, objectB);
	}
}
