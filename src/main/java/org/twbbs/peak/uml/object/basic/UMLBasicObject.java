package org.twbbs.peak.uml.object.basic;

import java.util.List;

import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.UMLObject;

public interface UMLBasicObject extends UMLObject{
	void setConnection(UMLConnection umlConnection);
	List<UMLConnection> getConnections();
	void removeConnection(UMLConnection umlConnection);
}