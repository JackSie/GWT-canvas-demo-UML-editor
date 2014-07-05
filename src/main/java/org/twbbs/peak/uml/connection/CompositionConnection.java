package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.UMLObject;

public class CompositionConnection extends UMLAbstractConnection{

	public CompositionConnection(UMLObject head, UMLObject tail, int postion) {
		super(head, tail, postion,COMPOSITION);
	}

}
