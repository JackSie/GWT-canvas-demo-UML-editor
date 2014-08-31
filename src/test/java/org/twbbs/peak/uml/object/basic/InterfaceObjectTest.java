package org.twbbs.peak.uml.object.basic;

import org.twbbs.peak.uml.ElementTest;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.junit.client.GWTTestCase;

public class InterfaceObjectTest extends GWTTestCase{
    UMLObjectFactory factory;
    public InterfaceObjectTest() {
        factory=ElementTest.initFactory();
    }
	public void testInit(){
		InterfaceObject interfaceObject=(InterfaceObject)factory.create(0, 0, UMLObjectType.INTERFACE);
		assertNotNull(interfaceObject);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
