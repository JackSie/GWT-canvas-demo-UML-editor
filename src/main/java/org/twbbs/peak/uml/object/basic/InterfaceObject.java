package org.twbbs.peak.uml.object.basic;

import org.twbbs.peak.uml.object.series.UMLObjectType;
import org.twbbs.peak.uml.object.state.ObjectState;

public class InterfaceObject extends UmlAbstractObject{
    public InterfaceObject(String name,ObjectState objectState) {
        super(name, UMLObjectType.INTERFACE,objectState);
    }
}
