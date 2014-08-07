package org.twbbs.peak.uml.object.basic;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.state.ObjectState;

public abstract class UmlAbstractObject implements UMLBasicObject{
    private String name;
    private String type;
    private List<UMLConnection> list;
    private ObjectState objectState;
    
    public UmlAbstractObject(String name,String type,ObjectState objectState) {
        this.setName(name);
        this.setType(type);
        this.objectState=objectState;
        list =new ArrayList<UMLConnection>();
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
    public ObjectState getObjectState() {
        return objectState;
    }
    public void setObjectState(ObjectState objectState) {
        this.objectState=objectState;
    }

}
