package org.twbbs.peak.uml.manage.object;

import java.util.List;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;

public interface UMLObjectManager {
    void createClassObject(int x,int y);
    void createUseCaseObject(int x,int y);       
    UMLObject getUMLObject(int x,int y);
    UMLBasicObject getUMLBasicObject(int x,int y);
    List<UMLObject> getAllObjects();
    void update();
    void group(List<UMLObject> list);
    void unGroup(GroupObject object);
}
