package org.twbbs.peak.uml.portal;

import java.util.List;

import org.twbbs.peak.uml.UMLCoreObserver;
import org.twbbs.peak.uml.object.UMLObject;

public interface UMLCoreSubject {
    void regist(UMLCoreObserver observer);
    void remove(UMLCoreObserver observer);
    List<UMLObject> getObjects(int layer);
    int[] getNotEmptyLayers();
}
