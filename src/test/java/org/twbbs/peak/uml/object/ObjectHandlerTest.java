package org.twbbs.peak.uml.object;

import java.util.List;

import org.twbbs.peak.uml.ElementTest;
import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.object.ObjectHandler;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.junit.client.GWTTestCase;

public class ObjectHandlerTest extends GWTTestCase{
    UMLObjectFactory factory;
    public ObjectHandlerTest() {
        factory=ElementTest.initFactory();
    }
	public void testCreateClassObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		ObjectHandler handler=new ObjectHandler(umlCoreImpl,factory);
		handler.createObject(0, 0, UMLObjectType.CLASS);
		UMLObject object=umlCoreImpl.getUmlObject(1, 1);
		assertNotNull(object);
	}
	public void testCreateUseCaseObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		ObjectHandler handler=new ObjectHandler(umlCoreImpl,factory);
		handler.createObject(0, 0, UMLObjectType.CLASS);
		UMLObject object=umlCoreImpl.getUmlObject(1, 1);
		assertNotNull(object);
	}
	public void testGetAllObjects(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		ObjectHandler handler=new ObjectHandler(umlCoreImpl,factory);
		handler.createObject(0, 0, UMLObjectType.CLASS);
		handler.createObject(20, 20, UMLObjectType.INTERFACE);
		handler.createObject(50, 50, UMLObjectType.CLASS);
		List<UMLObject> list =handler.getAllObjects();
		assertEquals(3, list.size());
	}
	
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
