package org.twbbs.peak.uml;

import java.util.List;

import org.twbbs.peak.uml.object.UMLObject;

public interface UMLCore {
    void addUMLObject(UMLObject umlObject);
    void removeUMLObject(UMLObject umlObject);
    void update();
    UMLObject getUmlObject(int x,int y);
    List<UMLObject> getRealObjects(int layer);
    int[] getNotEmptyLayers();
}
