package org.twbbs.peak.uml.modes.object;

import org.twbbs.peak.uml.ElementTest;
import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.manage.object.UMLObjectManagerImpl;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.ClassObject;
import org.twbbs.peak.uml.object.basic.InterfaceObject;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.junit.client.GWTTestCase;

public class ObjectsModeTest extends GWTTestCase{
    UMLObjectFactory factory;
    public ObjectsModeTest() {
        factory=ElementTest.initFactory();
    }
	public void testClassMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		ObjectsMode mode=new ObjectsMode(manager,UMLObjectType.CLASS);
		mode.onClick(0, 0);
		UMLObject object=coreImpl.getUmlObject(1, 1);
		assertNotNull(object);
		assertTrue(object instanceof ClassObject);
	}
	public void testUseCaseMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		ObjectsMode mode=new ObjectsMode(manager,UMLObjectType.INTERFACE);
		mode.onClick(0, 0);
		UMLObject object=coreImpl.getUmlObject(1, 1);
		assertNotNull(object);
		assertTrue(object instanceof InterfaceObject);
	}
	public void testUnuseMethod(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		ObjectsMode mode=new ObjectsMode(manager,UMLObjectType.CLASS);
		mode.startDrag(0, 0);
		mode.onDrag(0, 0);
		mode.group(true);
		mode.changeName(null);
		mode.stopDrag(0, 0);
		UMLObject object=coreImpl.getUmlObject(1, 1);
		assertNotNull(object);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
