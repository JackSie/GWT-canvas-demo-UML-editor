package org.twbbs.peak.uml.object;

import java.util.List;

import org.twbbs.peak.uml.UMLCoreImpl;

import com.google.gwt.junit.client.GWTTestCase;

public class ObjectHandlerTest extends GWTTestCase{
	public void testCreateClassObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		ObjectHandler handler=new ObjectHandler(umlCoreImpl);
		handler.createClassObject(0, 0);
		UMLObject object=umlCoreImpl.getUmlObject(1, 1);
		assertNotNull(object);
	}
	public void testCreateUseCaseObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		ObjectHandler handler=new ObjectHandler(umlCoreImpl);
		handler.createUseCaseObject(0, 0);
		UMLObject object=umlCoreImpl.getUmlObject(1, 1);
		assertNotNull(object);
	}
	public void testGetAllObjects(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		ObjectHandler handler=new ObjectHandler(umlCoreImpl);
		handler.createClassObject(0, 0);
		handler.createUseCaseObject(20, 20);
		handler.createClassObject(50, 50);
		List<UMLObject> list =handler.getAllObjects();
		assertEquals(3, list.size());
	}
	
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}