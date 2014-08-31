package org.twbbs.peak.uml;

import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.factory.UMLObjectFactoryImpl;
import org.twbbs.peak.uml.object.factory.creator.ClassObjectCreator;
import org.twbbs.peak.uml.object.factory.creator.GroupObjectCreator;
import org.twbbs.peak.uml.object.factory.creator.InterfaceObjectCreator;
import org.twbbs.peak.uml.object.series.UMLObjectType;

public class TestElement {
    private TestElement(){        
    }
    public static UMLObjectFactory initFactory(){
        UMLObjectFactory factory= new UMLObjectFactoryImpl();
        factory.addCreator(UMLObjectType.CLASS, new ClassObjectCreator());
        factory.addCreator(UMLObjectType.INTERFACE, new InterfaceObjectCreator());
        factory.addCreator(UMLObjectType.GROUP, new GroupObjectCreator());
        return factory;
    }
}
