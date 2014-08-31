package org.twbbs.peak.uml.object;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.TestElement;
import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.connection.UMLConnectionType;
import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.connection.LineHandler;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.manage.object.UMLObjectManagerImpl;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;
import org.twbbs.peak.uml.util.Point;

import com.google.gwt.junit.client.GWTTestCase;

public class UMLObjectManagerTest extends GWTTestCase{
    UMLObjectFactory factory;
    public UMLObjectManagerTest() {
        factory=TestElement.initFactory();
    }
	public void testCreateClassObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl,factory);
		manager.createObject(0, 0, UMLObjectType.CLASS);
		UMLObject object=umlCoreImpl.getUmlObject(1, 1);
		assertNotNull(object);
	}
	public void testCreateUseCaseObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl,factory);
		manager.createObject(0, 0, UMLObjectType.CLASS);
		UMLObject object=umlCoreImpl.getUmlObject(1, 1);
		assertNotNull(object);
	}
	public void testGetAllObjects(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl,factory);
		manager.createObject(0, 0, UMLObjectType.CLASS);
		manager.createObject(20, 20, UMLObjectType.INTERFACE);
		manager.createObject(50, 50, UMLObjectType.CLASS);
		List<UMLObject> list =manager.getAllObjects();
		assertEquals(3, list.size());
	}
	public void testAssociateObjects(){
		UMLBasicObject object1=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
		UMLBasicObject object2=(UMLBasicObject)factory.create(20, 25, UMLObjectType.CLASS);
		LineHandler lineHandler = new LineHandler();
		lineHandler.connectObjects(UMLConnectionType.ASSOCIATION,new Point(0, 0),object1,new Point(20, 25), object2);
		UMLConnection connection=object1.getConnections().get(0);
		assertEquals(UMLConnectionType.ASSOCIATION, connection.getType());
	}
	public void testCompositeObjects(){
		UMLBasicObject object1=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
		UMLBasicObject object2=(UMLBasicObject)factory.create(20, 25, UMLObjectType.CLASS);
		LineHandler lineHandler = new LineHandler();
		lineHandler.connectObjects(UMLConnectionType.COMPOSITION,new Point(0, 0),object1,new Point(20, 25), object2);
		UMLConnection connection=object1.getConnections().get(0);
		assertEquals(UMLConnectionType.COMPOSITION, connection.getType());
	}
	public void testGeneralizeObjects(){
		UMLBasicObject object1=(UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS);
		UMLBasicObject object2=(UMLBasicObject)factory.create(20, 25, UMLObjectType.CLASS);
		LineHandler lineHandler = new LineHandler();
		lineHandler.connectObjects(UMLConnectionType.GENERALIZATION,new Point(0, 0),object1,new Point(20, 25), object2);
		UMLConnection connection=object1.getConnections().get(0);
		assertEquals(UMLConnectionType.GENERALIZATION, connection.getType());
	}
	public void testGroup(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl,factory);
		List<UMLObject> list=new ArrayList<UMLObject>();
		list.add((UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS));
		list.add((UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS));
		list.add((UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS));
		manager.group(list);
		UMLObject object=umlCoreImpl.getUmlObject(0, 0);
		assertNotNull(object);
		assertTrue(object instanceof GroupObject);
	}
	public void testUnGroup(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl,factory);
		List<UMLObject> list=new ArrayList<UMLObject>();
		list.add((UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS));
		list.add((UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS));
		list.add((UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS));
		manager.group(list);
		UMLObject object=umlCoreImpl.getUmlObject(0, 0);
		manager.unGroup((GroupObject) object);
		object=umlCoreImpl.getUmlObject(0, 0);
		assertFalse(object instanceof GroupObject);
		
	}
	public void testGetUMLObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl,factory);
		assertNull(manager.getUMLObject(0, 0));
		umlCoreImpl.addUMLObject((UMLBasicObject)factory.create(0, 0, UMLObjectType.CLASS));
		assertNotNull(manager.getUMLObject(0, 0));
	}
	public void testEnum(){
	    UMLObjectType.valueOf(UMLObjectType.CLASS.toString());
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
