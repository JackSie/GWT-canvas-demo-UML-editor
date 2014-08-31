package org.twbbs.peak.uml.object.factory;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.factory.creator.UMLObjectCreator;
import org.twbbs.peak.uml.object.series.UMLObjectType;

public interface UMLObjectFactory {
    void addCreator(UMLObjectType type,UMLObjectCreator creator);
    UMLObject create(int x, int y, UMLObjectType type);
}
