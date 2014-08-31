package org.twbbs.peak.uml.object.basic;

import org.twbbs.peak.uml.ElementTest;
import org.twbbs.peak.uml.object.basic.detail.UMLDetailMember;
import org.twbbs.peak.uml.object.basic.detail.UMLDetailMethod;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.junit.client.GWTTestCase;

public class ClassObjectTest extends GWTTestCase{
    UMLObjectFactory factory;
    public ClassObjectTest() {
        factory=ElementTest.initFactory();
    }
	public void testAddMember(){
		ClassObject classObject=(ClassObject)factory.create(0, 0, UMLObjectType.CLASS);
		classObject.addMember(new UMLDetailMember());
	}
	public void testAddMethod(){
		ClassObject classObject=(ClassObject)factory.create(0, 0, UMLObjectType.CLASS);
		classObject.addMethod(new UMLDetailMethod());
	}
	public void testEemoveMember(){
		ClassObject classObject=(ClassObject)factory.create(0, 0, UMLObjectType.CLASS);
		UMLDetailMember member=new UMLDetailMember();
		classObject.addMember(member);
		classObject.removeMember(member);
	}
	public void testEemoveMethod(){
		ClassObject classObject=(ClassObject)factory.create(0, 0, UMLObjectType.CLASS);
		UMLDetailMethod method=new UMLDetailMethod();
		classObject.addMethod(method);
		classObject.removeMethod(method);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
