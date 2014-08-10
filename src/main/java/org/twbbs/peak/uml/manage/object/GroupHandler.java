package org.twbbs.peak.uml.manage.object;

import java.util.List;

import org.twbbs.peak.uml.core.UMLCore;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.defaults.DefaultGroupObject;

public class GroupHandler {
    private UMLCore umlCore;
    public GroupHandler(UMLCore umlCore) {
        this.umlCore=umlCore;
    }
    public void group(List<UMLObject> list) {
        for(UMLObject object : list){
            object.getObjectState().setSelected(false);
            umlCore.removeUMLObject(object);
        }
        UMLObject groupObject = new DefaultGroupObject(list);
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
