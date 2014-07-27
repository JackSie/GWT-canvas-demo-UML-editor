package org.twbbs.peak.uml.object.basic;

import org.twbbs.peak.uml.object.defaults.DefaultInterfaceObject;

import com.google.gwt.junit.client.GWTTestCase;

public class InterfaceObjectTest extends GWTTestCase{
	public void testInit(){
		InterfaceObject interfaceObject=new DefaultInterfaceObject(0, 0);
		assertNotNull(interfaceObject);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
