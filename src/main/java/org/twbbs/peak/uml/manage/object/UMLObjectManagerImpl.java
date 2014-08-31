package org.twbbs.peak.uml.manage.object;

import java.util.List;

import org.twbbs.peak.uml.core.UMLCore;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;

public class UMLObjectManagerImpl implements UMLObjectManager{
    private UMLCore umlCore;    
    private ObjectHandler objectHandler;
    private GroupHandler groupHandler;    
    public UMLObjectManagerImpl(UMLCore core,UMLObjectFactory factory) {
        this.umlCore=core;        
        this.objectHandler=new ObjectHandler(umlCore,factory);
        this.groupHandler=new GroupHandler(core,factory);
    }        
    public UMLObject getUMLObject(int x, int y) {
        return objectHandler.getUMLObject(x, y);
    }
    public UMLBasicObject getUMLBasicObject(int x, int y) {
        return objectHandler.getUMLBasicObject(x, y);
    }
    public void update() {
        umlCore.update();
    }
    public List<UMLObject> getAllObjects() {
        return objectHandler.getAllObjects();
    }
    public void group(List<UMLObject> list) {
        groupHandler.group(list);
    }
    public void unGroup(GroupObject object) {
        groupHandler.unGroup(object);
    }
    public void createObject(int x, int y, UMLObjectType type) {
        objectHandler.createObject(x, y, type);
    }
}
