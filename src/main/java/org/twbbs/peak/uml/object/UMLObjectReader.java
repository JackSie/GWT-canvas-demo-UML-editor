package org.twbbs.peak.uml.object;

import java.util.List;

import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.state.ObjectState;

public interface UMLObjectReader {
	static String CLASS ="class";
	static String INTERFACE="interface";
	List<UMLConnection> getConnections();
	String getName();
	String getType();
	ObjectState getObjectState();
}
