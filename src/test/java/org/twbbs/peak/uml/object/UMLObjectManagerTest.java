package org.twbbs.peak.uml.object;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.connection.UMLConnectionType;
import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.manage.object.UMLObjectManagerImpl;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.junit.client.GWTTestCase;

public class UMLObjectManagerTest extends GWTTestCase{
	public void testCreateClassObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl);
		manager.createClassObject(0, 0);
		UMLObject object=umlCoreImpl.getUmlObject(1, 1);
		assertNotNull(object);
	}
	public void testCreateUseCaseObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl);
		manager.createUseCaseObject(0, 0);
		UMLObject object=umlCoreImpl.getUmlObject(1, 1);
		assertNotNull(object);
	}
	public void testGetAllObjects(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl);
		manager.createClassObject(0, 0);
		manager.createUseCaseObject(20, 20);
		manager.createClassObject(50, 50);
		List<UMLObject> list =manager.getAllObjects();
		assertEquals(3, list.size());
	}
	public void testAssociateObjects(){
		UMLBasicObject object1=new DefaultClassObject(0, 0);
		UMLBasicObject object2=new DefaultClassObject(20, 25);
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl);
		manager.associateObjects(object1, object2);
		UMLConnection connection=object1.getConnections().get(0);
		assertEquals(UMLConnectionType.ASSOCIATION, connection.getType());
	}
	public void testCompositeObjects(){
		UMLBasicObject object1=new DefaultClassObject(0, 0);
		UMLBasicObject object2=new DefaultClassObject(20, 25);
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl);
		manager.compositeObjects(object1, object2);
		UMLConnection connection=object1.getConnections().get(0);
		assertEquals(UMLConnectionType.COMPOSITION, connection.getType());
	}
	public void testGeneralizeObjects(){
		UMLBasicObject object1=new DefaultClassObject(0, 0);
		UMLBasicObject object2=new DefaultClassObject(20, 25);
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl);
		manager.generalizeObjects(object1, object2);
		UMLConnection connection=object1.getConnections().get(0);
		assertEquals(UMLConnectionType.GENERALIZATION, connection.getType());
	}
	public void testGroup(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl);
		List<UMLObject> list=new ArrayList<UMLObject>();
		list.add(new DefaultClassObject(0, 0));
		list.add(new DefaultClassObject(0, 0));
		list.add(new DefaultClassObject(0, 0));
		manager.group(list);
		UMLObject object=umlCoreImpl.getUmlObject(0, 0);
		assertNotNull(object);
		assertTrue(object instanceof GroupObject);
	}
	public void testUnGroup(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl);
		List<UMLObject> list=new ArrayList<UMLObject>();
		list.add(new DefaultClassObject(0, 0));
		list.add(new DefaultClassObject(0, 0));
		list.add(new DefaultClassObject(0, 0));
		manager.group(list);
		UMLObject object=umlCoreImpl.getUmlObject(0, 0);
		manager.unGroup((GroupObject) object);
		object=umlCoreImpl.getUmlObject(0, 0);
		assertFalse(object instanceof GroupObject);
		
	}
	public void testGetUMLObject(){
		UMLCoreImpl umlCoreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(umlCoreImpl);
		assertNull(manager.getUMLObject(0, 0));
		umlCoreImpl.addUMLObject(new DefaultClassObject(0, 0));
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
