package org.twbbs.peak.uml.object;

import java.util.List;

import org.twbbs.peak.uml.connection.UMLConnection;

public interface UMLObject {
	static String CLASS ="class";
	static String INTERFACE="interface";
	void setConnection(UMLConnection umlConnection);
	void removeConnection(UMLConnection umlConnection);
	List<UMLConnection> getConnections();
	String getName();
	void setName(String name);
	String getType();
	void setType(String type);
	
}
