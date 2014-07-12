package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.UMLObject;

public class AssociationConnection extends UMLAbstractConnection{
	public AssociationConnection(UMLObject head,UMLObject tail,int headPostition,int tailPostition) {
		super(head, tail, headPostition, tailPostition, ASSOCIATION);
	}
}
