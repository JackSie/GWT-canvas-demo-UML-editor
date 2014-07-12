package org.twbbs.peak.uml.object;

import org.twbbs.peak.uml.UMLCore;
import org.twbbs.peak.uml.connection.AssociationConnection;
import org.twbbs.peak.uml.connection.CompositionConnection;
import org.twbbs.peak.uml.connection.GeneralizationConnection;
import org.twbbs.peak.uml.connection.UMLConnection;

public class UMLObjectManagerImpl implements UMLObjectManager{
	private UMLCore umlCore;
	
	public void createClassObject(int x, int y) {
		umlCore.addUMLObject(new DefaultClassObject(x,y));
	}

	public void createUseCaseObject(int x, int y) {
		umlCore.addUMLObject(new DefaultInterfaceObject(x, y));	
	}

	public void associateObjects(UMLObject objectA, UMLObject objectB) {
//		int ax=objectA.getObjectState().getX();
//		int ay=objectA.getObjectState().getY();
//		int bx=objectB.getObjectState().getX();
//		int by=objectB.getObjectState().getY();
//		int aw=objectA.getObjectState().getSizeW();
//		int ah=objectA.getObjectState().getSizeH();
//		int bw=objectB.getObjectState().getSizeW();
//		int bh=objectB.getObjectState().getSizeH();
		//TODO some math have to be done here.
		objectA.setConnection(new AssociationConnection(objectA, objectB, UMLConnection.NORTH,UMLConnection.SOUTH));
		update();
	}

	public void compositeObjects(UMLObject objectA, UMLObject objectB) {
		objectA.setConnection(new CompositionConnection(objectA, objectB, UMLConnection.NORTH,UMLConnection.SOUTH));
		update();
	}

	public void generalizeObjects(UMLObject objectA, UMLObject objectB) {
		objectA.setConnection(new GeneralizationConnection(objectA, objectB, UMLConnection.NORTH,UMLConnection.SOUTH));
		update();
	}

	public UMLObject getUMLObject(int x, int y) {
		return umlCore.getUmlObject(x, y);
	}

	public void update() {
		umlCore.update();
	}

}
