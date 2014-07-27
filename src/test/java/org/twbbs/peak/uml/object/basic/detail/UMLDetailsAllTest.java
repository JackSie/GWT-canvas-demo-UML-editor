package org.twbbs.peak.uml.object.basic.detail;

import com.google.gwt.junit.client.GWTTestCase;

public class UMLDetailsAllTest extends GWTTestCase{
	public void testUMLDetailMember(){
		UMLDetailMember member=new UMLDetailMember();
		String name="haha";
		String type="String";
		int scope=3;
		member.setName(name);
		member.setType(type);
		member.setScope(scope);
		assertEquals(name, member.getName());
		assertEquals(type, member.getType());
		assertEquals(scope, member.getScope());
	}
	public void testUMLDetailMethod(){
		UMLDetailMethod method=new UMLDetailMethod();
		String name="haha";
		String type="String";
		String parameters[]={"Integer","String"};
		int scope=3;
		method.setName(name);
		method.setType(type);
		method.setScope(scope);
		method.setParameters(parameters);
		assertEquals(name, method.getName());
		assertEquals(type, method.getType());
		assertEquals(scope, method.getScope());
		assertEquals(parameters[0], method.getParameters()[0]);
		assertEquals(parameters[1], method.getParameters()[1]);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
