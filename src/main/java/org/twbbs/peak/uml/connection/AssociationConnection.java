package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.UMLObject;

public class AssociationConnection extends UMLAbstractConnection{
	public AssociationConnection(UMLObject head,UMLObject tail,int postion) {
		super(head, tail, postion, ASSOCIATION);
	}
}
