package org.twbbs.peak.uml.modes;

import org.twbbs.peak.uml.TestElement;
import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.manage.object.UMLObjectManagerImpl;
import org.twbbs.peak.uml.modes.operation.SelectionMode;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;
import org.twbbs.peak.uml.portal.UMLCorePortalImpl;

import com.google.gwt.junit.client.GWTTestCase;

public class SelectionModeTest extends GWTTestCase{
    UMLObjectFactory factory;
    public SelectionModeTest() {
        factory=TestElement.initFactory();
    }
	public void testOnClick(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		UMLCorePortalImpl corePortalImpl=new UMLCorePortalImpl();
        SelectionMode mode=new SelectionMode(manager,corePortalImpl);
        corePortalImpl.addMode(UMLModeSeries.SELECTION_MODE, mode);
        corePortalImpl.changeMode(UMLModeSeries.SELECTION_MODE);
		UMLObject object= factory.create(0, 0, UMLObjectType.CLASS);
		coreImpl.addUMLObject(object);
		mode.onClick(1, 1);
		assertTrue(object.getObjectState().isSelected());
	}
	public void testDragWithNothing(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		UMLCorePortalImpl corePortalImpl=new UMLCorePortalImpl();
        SelectionMode mode=new SelectionMode(manager,corePortalImpl);
        corePortalImpl.addMode(UMLModeSeries.SELECTION_MODE, mode);
        corePortalImpl.changeMode(UMLModeSeries.SELECTION_MODE);
		UMLObject object= factory.create(10, 10, UMLObjectType.CLASS);
		coreImpl.addUMLObject(object);
		mode.startDrag(0, 0);
		mode.onDrag(300, 300);
		mode.stopDrag(400, 400);
		assertTrue(object.getObjectState().isSelected());
	}
	public void testDrag(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		UMLCorePortalImpl corePortalImpl=new UMLCorePortalImpl();
        SelectionMode mode=new SelectionMode(manager,corePortalImpl);
        corePortalImpl.addMode(UMLModeSeries.SELECTION_MODE, mode);
        corePortalImpl.changeMode(UMLModeSeries.SELECTION_MODE);
		UMLObject object= factory.create(0, 0, UMLObjectType.CLASS);
		coreImpl.addUMLObject(object);
		mode.startDrag(5, 5);
		assertTrue(object.getObjectState().isDraged());
		mode.onDrag(100, 100);
		assertNotSame(0, object.getObjectState().getX());
		mode.stopDrag(400, 400);
		assertFalse(object.getObjectState().isDraged());
	}
	public void testDragGroup(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		UMLCorePortalImpl corePortalImpl=new UMLCorePortalImpl();
        SelectionMode mode=new SelectionMode(manager,corePortalImpl);
        corePortalImpl.addMode(UMLModeSeries.SELECTION_MODE, mode);
        corePortalImpl.changeMode(UMLModeSeries.SELECTION_MODE);
		UMLObject object= factory.create(10, 10, UMLObjectType.CLASS);
		coreImpl.addUMLObject(object);
		manager.createObject(20, 20, UMLObjectType.CLASS);
		mode.startDrag(5, 5);
		mode.onDrag(100, 100);
		mode.stopDrag(400, 400);
		mode.group(true);
		
		mode.startDrag(15, 15);
		mode.onDrag(100, 100);
		mode.stopDrag(400, 400);
		assertFalse(object.getObjectState().isDraged());
	}
	public void testModeChanged(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		UMLCorePortalImpl corePortalImpl=new UMLCorePortalImpl();
        SelectionMode mode=new SelectionMode(manager,corePortalImpl);
        corePortalImpl.addMode(UMLModeSeries.SELECTION_MODE, mode);
        corePortalImpl.changeMode(UMLModeSeries.SELECTION_MODE);
		UMLObject object= factory.create(10, 10, UMLObjectType.CLASS);
		coreImpl.addUMLObject(object);
		mode.startDrag(0, 0);
		mode.onDrag(300, 300);
		mode.stopDrag(400, 400);
		mode.modeChanged();
		assertFalse(object.getObjectState().isSelected());
		
		mode.onClick(11, 11);
		mode.modeChanged();
		assertFalse(object.getObjectState().isSelected());
	}
	public void testChangeName(){
		String name="hoho";
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		UMLCorePortalImpl corePortalImpl=new UMLCorePortalImpl();
        SelectionMode mode=new SelectionMode(manager,corePortalImpl);
        corePortalImpl.addMode(UMLModeSeries.SELECTION_MODE, mode);
        corePortalImpl.changeMode(UMLModeSeries.SELECTION_MODE);
		UMLObject object= factory.create(0, 0, UMLObjectType.CLASS);
		coreImpl.addUMLObject(object);
		mode.onClick(1, 1);
		mode.changeName(name);
		assertEquals(name, object.getName());
	}
	public void testChangeNameWithGroupObject(){
	    UMLCoreImpl coreImpl=new UMLCoreImpl();
        UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
        UMLCorePortalImpl corePortalImpl=new UMLCorePortalImpl();
        SelectionMode mode=new SelectionMode(manager,corePortalImpl);
        corePortalImpl.addMode(UMLModeSeries.SELECTION_MODE, mode);
        corePortalImpl.changeMode(UMLModeSeries.SELECTION_MODE);
        UMLObject object=factory.create(50, 50, UMLObjectType.CLASS);
        coreImpl.addUMLObject(object);
        manager.createObject(60, 60, UMLObjectType.CLASS);
        manager.createObject(500, 500, UMLObjectType.CLASS);
        mode.startDrag(400, 400);
        mode.onDrag(300, 300);
        mode.stopDrag(40, 40);
        
        mode.group(true);
        GroupObject groupObject=(GroupObject) manager.getAllObjects().get(1);
        mode.onClick(50, 50);
        mode.changeName("hah");
        assertNotSame("hah", groupObject.getName());
        
	}
	public void testGroup(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		UMLCorePortalImpl corePortalImpl=new UMLCorePortalImpl();
        SelectionMode mode=new SelectionMode(manager,corePortalImpl);
        corePortalImpl.addMode(UMLModeSeries.SELECTION_MODE, mode);
        corePortalImpl.changeMode(UMLModeSeries.SELECTION_MODE);
		UMLObject object= factory.create(50, 50, UMLObjectType.CLASS);
		coreImpl.addUMLObject(object);
		manager.createObject(60, 60, UMLObjectType.CLASS);
		manager.createObject(500, 500, UMLObjectType.CLASS);
		mode.startDrag(400, 400);
		mode.onDrag(300, 300);
		mode.stopDrag(40, 40);
		
		mode.group(true);
		assertTrue(manager.getAllObjects().get(1) instanceof GroupObject);
	}
	public void testUnGroup(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl,factory);
		UMLCorePortalImpl corePortalImpl=new UMLCorePortalImpl();
		SelectionMode mode=new SelectionMode(manager,corePortalImpl);
		corePortalImpl.addMode(UMLModeSeries.SELECTION_MODE, mode);
		corePortalImpl.changeMode(UMLModeSeries.SELECTION_MODE);
		UMLObject object= factory.create(10, 10, UMLObjectType.CLASS);
		coreImpl.addUMLObject(object);
		manager.createObject(20, 20, UMLObjectType.CLASS);
		mode.startDrag(0, 0);
		mode.onDrag(300, 300);
		mode.stopDrag(400, 400);
		mode.group(true);
		mode.onClick(30, 30);
		mode.group(false);
		assertFalse(manager.getAllObjects().get(0) instanceof GroupObject);
	}
	public void testEnum(){
	    UMLModeSeries.valueOf(UMLModeSeries.ASSOCAITION_MODE.toString());
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
