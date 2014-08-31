package org.twbbs.peak.uml;

import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.factory.UMLObjectFactoryImpl;
import org.twbbs.peak.uml.object.factory.creator.ClassObjectCreator;
import org.twbbs.peak.uml.object.factory.creator.GroupObjectCreator;
import org.twbbs.peak.uml.object.factory.creator.InterfaceObjectCreator;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.junit.client.GWTTestCase;

public class ElementTest extends GWTTestCase{
    public void testGetInt(){
        assertTrue(true);
    }
    public static UMLObjectFactory initFactory(){
        UMLObjectFactory factory= new UMLObjectFactoryImpl();
        factory.addCreator(UMLObjectType.CLASS, new ClassObjectCreator());
        factory.addCreator(UMLObjectType.INTERFACE, new InterfaceObjectCreator());
        factory.addCreator(UMLObjectType.GROUP, new GroupObjectCreator());
        assertTrue(true);
        return factory;
    }
    @Override
    public String getModuleName() {
        return "org.twbbs.peak.umlJUnit";
    }
}
