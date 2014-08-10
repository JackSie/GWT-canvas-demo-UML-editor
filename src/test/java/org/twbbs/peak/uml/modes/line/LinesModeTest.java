package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.connection.UMLConnectionType;
import org.twbbs.peak.uml.core.UMLCoreImpl;
import org.twbbs.peak.uml.manage.connection.UMLConnectionManager;
import org.twbbs.peak.uml.manage.connection.UMLConnectionManagerImpl;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.manage.object.UMLObjectManagerImpl;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;

import com.google.gwt.junit.client.GWTTestCase;

public class LinesModeTest extends GWTTestCase{
	public void testAssociationLineMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager managero=new UMLObjectManagerImpl(coreImpl);
		UMLConnectionManager manager=new UMLConnectionManagerImpl(managero);
		AssociationLineMode mode=new AssociationLineMode(manager);
		UMLBasicObject objectA= new DefaultClassObject(0, 0);
		coreImpl.addUMLObject(objectA);
		UMLBasicObject objectB= new DefaultClassObject(300, 300);
		coreImpl.addUMLObject(objectB);
		mode.startDrag(1, 1);
		mode.stopDrag(301, 301);
		assertEquals(UMLConnectionType.ASSOCIATION, objectA.getConnections().get(0).getType());
	}
	public void testCompositionLineMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager managero=new UMLObjectManagerImpl(coreImpl);
		UMLConnectionManager manager=new UMLConnectionManagerImpl(managero);
		CompositionLineMode mode=new CompositionLineMode(manager);
		UMLBasicObject objectA= new DefaultClassObject(0, 0);
        coreImpl.addUMLObject(objectA);
        UMLBasicObject objectB= new DefaultClassObject(300, 300);
        coreImpl.addUMLObject(objectB);
        mode.startDrag(1, 1);
        mode.stopDrag(301, 301);
		assertEquals(UMLConnectionType.COMPOSITION, objectA.getConnections().get(0).getType());
	}
	public void testGeneralizationLineMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager managero=new UMLObjectManagerImpl(coreImpl);
		UMLConnectionManager manager=new UMLConnectionManagerImpl(managero);
		GeneralizationLineMode mode=new GeneralizationLineMode(manager);
		UMLBasicObject objectA= new DefaultClassObject(0, 0);
        coreImpl.addUMLObject(objectA);
        UMLBasicObject objectB= new DefaultClassObject(300, 300);
        coreImpl.addUMLObject(objectB);
        mode.startDrag(1, 1);
        mode.stopDrag(301, 301);
		assertEquals(UMLConnectionType.GENERALIZATION, objectA.getConnections().get(0).getType());
	}
	public void testStopDrag(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager managero=new UMLObjectManagerImpl(coreImpl);
		UMLConnectionManager manager=new UMLConnectionManagerImpl(managero);
		AssociationLineMode mode=new AssociationLineMode(manager);
		UMLBasicObject object=new DefaultClassObject(0, 0);
		coreImpl.addUMLObject(object);
		managero.createClassObject(500, 500);
		mode.startDrag(1, 1);
		mode.stopDrag(501, 501);
		assertEquals(UMLConnectionType.ASSOCIATION, object.getConnections().get(0).getType());
	}
	public void testUnuseMethod(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager managero=new UMLObjectManagerImpl(coreImpl);
		UMLConnectionManager manager=new UMLConnectionManagerImpl(managero);
		AssociationLineMode mode=new AssociationLineMode(manager);
		mode.onClick(0, 0);
		mode.onDrag(0, 0);
		mode.modeChanged();
		mode.changeName(null);
		mode.group(true);
	}
	public void testDragNothing(){
	    UMLCoreImpl coreImpl=new UMLCoreImpl();
        UMLObjectManager managero=new UMLObjectManagerImpl(coreImpl);
        UMLConnectionManager manager=new UMLConnectionManagerImpl(managero);
        GeneralizationLineMode mode=new GeneralizationLineMode(manager);  
        UMLBasicObject objectA= new DefaultClassObject(600, 600);
        coreImpl.addUMLObject(objectA);
        mode.startDrag(1, 1);
        mode.stopDrag(301, 301);
        assertTrue(objectA.getConnections().isEmpty());
	}
	   public void testDragSameThing(){
	        UMLCoreImpl coreImpl=new UMLCoreImpl();
	        UMLObjectManager managero=new UMLObjectManagerImpl(coreImpl);
	        UMLConnectionManager manager=new UMLConnectionManagerImpl(managero);
	        GeneralizationLineMode mode=new GeneralizationLineMode(manager);  
	        UMLBasicObject objectA= new DefaultClassObject(0, 0);
	        coreImpl.addUMLObject(objectA);
	        mode.startDrag(1, 1);
	        mode.stopDrag(11, 11);
	        assertTrue(objectA.getConnections().isEmpty());
	    }
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
