package org.twbbs.peak.uml.object;

import org.twbbs.peak.uml.object.state.DefaultClassState;

public class DefaultClassObject extends ClassObject{
	public DefaultClassObject(int x,int y) {
		super("Unnamed",new DefaultClassState(x, y));
	}
}
