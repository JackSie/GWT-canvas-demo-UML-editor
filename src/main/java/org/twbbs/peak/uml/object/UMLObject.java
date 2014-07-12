package org.twbbs.peak.uml.object;

import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.state.ObjectState;

public interface UMLObject extends UMLObjectReader{
	void setConnection(UMLConnection umlConnection);
	void removeConnection(UMLConnection umlConnection);
	void setName(String name);
	void setType(String type);
	void setObjectState(ObjectState objectState);
}
