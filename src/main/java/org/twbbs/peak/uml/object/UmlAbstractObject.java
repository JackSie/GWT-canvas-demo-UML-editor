package org.twbbs.peak.uml.object;

import java.util.List;

import org.twbbs.peak.uml.connection.UMLConnection;

public abstract class UmlAbstractObject implements UMLObject{
	private String name;
	private String type;
	private List<UMLConnection> list;
	
	public UmlAbstractObject(String name,String type) {
		this.setName(name);
		this.setType(type);
	}
	public void setConnection(UMLConnection umlConnection){
		list.add(umlConnection);
	}
	public void removeConnection(UMLConnection umlConnection){
		list.remove(umlConnection);
	}
	public List<UMLConnection> getConnections(){
		return list;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}

}
