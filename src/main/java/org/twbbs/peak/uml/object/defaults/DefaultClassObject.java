package org.twbbs.peak.uml.object.defaults;

import org.twbbs.peak.uml.object.basic.ClassObject;
import org.twbbs.peak.uml.object.state.DefaultClassState;

public class DefaultClassObject extends ClassObject{
	public DefaultClassObject(int x,int y) {
		super("Unnamed",new DefaultClassState(x, y));
	}
}
