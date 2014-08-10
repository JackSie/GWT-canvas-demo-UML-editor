package org.twbbs.peak.uml.object.basic.detail;

import com.google.gwt.junit.client.GWTTestCase;

public class UMLDetailsAllTest extends GWTTestCase{
	public void testUMLDetailMemberName(){
	    UMLDetailMember member=new UMLDetailMember();
        String name="haha";        
        member.setName(name);       
        assertEquals(name, member.getName());
	}
	public void testUMLDetailMemberType(){
	    UMLDetailMember member=new UMLDetailMember();
        String type="String";
        member.setType(type);
        assertEquals(type, member.getType());
	}
	public void testUMLDetailMemberScope(){
	    UMLDetailMember member=new UMLDetailMember();        
        int scope=3;
        member.setScope(scope);
        assertEquals(scope, member.getScope());
	}

    public void testUMLDetailMethodName() {
        UMLDetailMethod method = new UMLDetailMethod();
        String name = "haha";
        method.setName(name);
        assertEquals(name, method.getName());
    }

    public void testUMLDetailMethodType() {
        UMLDetailMethod method = new UMLDetailMethod();
        String type = "String";
        method.setType(type);
        assertEquals(type, method.getType());
    }

    public void testUMLDetailMethodScope() {
        UMLDetailMethod method = new UMLDetailMethod();
        int scope = 3;
        method.setScope(scope);
        assertEquals(scope, method.getScope());
    }

    public void testUMLDetailMethodParameter() {
        UMLDetailMethod method = new UMLDetailMethod();
        String parameters[] = { "Integer", "String" };
        method.setParameters(parameters);
        assertEquals(parameters[0], method.getParameters()[0]);
    }
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
