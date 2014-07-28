package org.twbbs.peak.uml.modes.line;

import org.twbbs.peak.uml.UMLCoreImpl;
import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.UMLObjectManager;
import org.twbbs.peak.uml.object.UMLObjectManagerImpl;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;

import com.google.gwt.junit.client.GWTTestCase;

public class LinesModeTest extends GWTTestCase{
	public void testAssociationLineMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		AssociationLineMode mode=new AssociationLineMode(manager);
		UMLBasicObject objectA= new DefaultClassObject(0, 0);
		UMLBasicObject objectB= new DefaultClassObject(0, 0);
		mode.createLine(objectA, objectB);
		assertEquals(UMLConnection.ASSOCIATION, objectA.getConnections().get(0).getType());
	}
	public void testCompositionLineMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		CompositionLineMode mode=new CompositionLineMode(manager);
		UMLBasicObject objectA= new DefaultClassObject(0, 0);
		UMLBasicObject objectB= new DefaultClassObject(0, 0);
		mode.createLine(objectA, objectB);
		assertEquals(UMLConnection.COMPOSITION, objectA.getConnections().get(0).getType());
	}
	public void testGeneralizationLineMode(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		GeneralizationLineMode mode=new GeneralizationLineMode(manager);
		UMLBasicObject objectA= new DefaultClassObject(0, 0);
		UMLBasicObject objectB= new DefaultClassObject(0, 0);
		mode.createLine(objectA, objectB);
		assertEquals(UMLConnection.GENERALIZATION, objectA.getConnections().get(0).getType());
	}
	public void testStartDrag(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		AssociationLineMode mode=new AssociationLineMode(manager);
		manager.createClassObject(0, 0);
		mode.startDrag(1, 1);
		assertNotNull(mode.nowObject);
	}
	public void testStopDrag(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		AssociationLineMode mode=new AssociationLineMode(manager);
		UMLBasicObject object=new DefaultClassObject(0, 0);
		coreImpl.addUMLObject(object);
		manager.createClassObject(500, 500);
		mode.startDrag(1, 1);
		mode.stopDrag(501, 501);
		assertEquals(UMLConnection.ASSOCIATION, object.getConnections().get(0).getType());
	}
	public void testUnuseMethod(){
		UMLCoreImpl coreImpl=new UMLCoreImpl();
		UMLObjectManager manager=new UMLObjectManagerImpl(coreImpl);
		AssociationLineMode mode=new AssociationLineMode(manager);
		mode.onClick(0, 0);
		mode.onDrag(0, 0);
		mode.modeChanged();
		mode.changeName(null);
		mode.group(true);
	}
	@Override
	public String getModuleName() {
		return "org.twbbs.peak.umlJUnit";
	}
}
