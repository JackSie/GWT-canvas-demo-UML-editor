package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.UMLObject;

public class CompositionConnection extends UMLAbstractConnection{
	public CompositionConnection(UMLObject head, UMLObject tail,int headPostition,int tailPostition) {
		super(head, tail, headPostition, tailPostition,COMPOSITION);
	}
}
