package org.twbbs.peak.uml.object.defaults;

import java.util.List;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.state.DefaultGroupState;

public class DefaultGroupObject extends GroupObject{
	public DefaultGroupObject(List<UMLObject> list) {
		super("group", UMLObject.GROUP, new DefaultGroupState(0, 0), list);
	}
}
