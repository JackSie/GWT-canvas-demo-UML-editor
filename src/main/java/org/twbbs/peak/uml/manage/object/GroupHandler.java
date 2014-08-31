package org.twbbs.peak.uml.manage.object;

import java.util.List;

import org.twbbs.peak.uml.core.UMLCore;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;

public class GroupHandler {
    private UMLCore umlCore;
    private UMLObjectFactory factory;
    public GroupHandler(UMLCore umlCore,UMLObjectFactory factory) {
        this.umlCore=umlCore;
        this.factory=factory;
    }
    public void group(List<UMLObject> list) {
        for(UMLObject object : list){
            object.getObjectState().setSelected(false);
            umlCore.removeUMLObject(object);
        }
        GroupObject groupObject = (GroupObject)factory.create(0, 0, UMLObjectType.GROUP);
        groupObject.setObjectList(list);
        umlCore.addUMLObject(groupObject);
    }

    public void unGroup(GroupObject object) {
        umlCore.removeUMLObject(object);
        List<UMLObject> list = object.getObjectList();
        for(UMLObject object2:list){
            umlCore.addUMLObject(object2);
        }
    }
}
