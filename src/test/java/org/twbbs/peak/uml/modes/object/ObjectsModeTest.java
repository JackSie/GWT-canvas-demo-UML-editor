package org.twbbs.peak.uml.modes.object;

import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.manage.object.UMLObjectManagerImpl;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.ClassObject;
import org.twbbs.peak.uml.object.basic.InterfaceObject;

import com.google.gwt.junit.client.GWTTestCase;

public class ObjectsModeTest extends GWTTestCase{
	public void testClassMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		ObjectsMode mode=new ClassMode(manager);
		mode.onClick(0, 0);
		UMLObject object=coreImpl.getUmlObject(1, 1);
		assertNotNull(object);
		assertTrue(object instanceof ClassObject);
	}
	public void testUseCaseMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		ObjectsMode mode=new UseCaseMode(manager);
		mode.onClick(0, 0);
		UMLObject object=coreImpl.getUmlObject(1, 1);
		assertNotNull(object);
		assertTrue(object instanceof InterfaceObject);
	}
	public void testUnuseMethod(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		ObjectsMode mode=new ClassMode(manager);
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
