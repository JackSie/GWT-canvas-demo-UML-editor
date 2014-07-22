package org.twbbs.peak.uml.object;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.UMLCore;
import org.twbbs.peak.uml.connection.AssociationConnection;
import org.twbbs.peak.uml.connection.CompositionConnection;
import org.twbbs.peak.uml.connection.GeneralizationConnection;

public class UMLObjectManagerImpl implements UMLObjectManager{
	private UMLCore umlCore;
	public UMLObjectManagerImpl(UMLCore core) {
		this.umlCore=core;
	}
	
	public void createClassObject(int x, int y) {
		umlCore.addUMLObject(new DefaultClassObject(x,y));
	}

	public void createUseCaseObject(int x, int y) {
		umlCore.addUMLObject(new DefaultInterfaceObject(x, y));	
	}

	public void associateObjects(UMLObject objectA, UMLObject objectB) {
		Point point = calc(objectA, objectB);		
		objectA.setConnection(new AssociationConnection(objectA, objectB, point.x,point.y));
		update();
	}

	public void compositeObjects(UMLObject objectA, UMLObject objectB) {
		Point point = calc(objectA, objectB);	
		objectA.setConnection(new CompositionConnection(objectA, objectB, point.x,point.y));
		update();
	}

	public void generalizeObjects(UMLObject objectA, UMLObject objectB) {
		Point point = calc(objectA, objectB);	
		objectA.setConnection(new GeneralizationConnection(objectA, objectB, point.x,point.y));
		update();
	}
	protected Point calc(UMLObject objectA, UMLObject objectB){
		int ax=objectA.getObjectState().getX();
		int ay=objectA.getObjectState().getY();
		int bx=objectB.getObjectState().getX();
		int by=objectB.getObjectState().getY();
		int aw=objectA.getObjectState().getSizeW();
		int ah=objectA.getObjectState().getSizeH();
		int bw=objectB.getObjectState().getSizeW();
		int bh=objectB.getObjectState().getSizeH();
		
		int ansOne=0,ansTwo=0;
		double length=Double.MAX_VALUE;
		int oneX[]={ax+ aw/2,ax+ aw,ax+ aw/2,ax};
		int oneY[]={ay,ay+ah/2,ay+ah,ay+ah/2};
		int twoX[]={bx+ bw/2,bx+ bw,bx+ bw/2,bx};
		int twoY[]={by,by+bh/2,by+bh,by+bh/2};
		for(int i=0;i<4;i++){
			for(int j=0;j<4;j++){
				double len=Math.pow((oneX[i] - twoX[j]),2) + Math.pow((oneY[i] - twoY[j]),2);
				if(len < length){
					length=len;
					ansOne=i;
					ansTwo=j;
				}
			}
		}
		return new Point(ansOne, ansTwo);
	}

	public UMLObject getUMLObject(int x, int y) {
		return umlCore.getUmlObject(x, y);
	}

	public void update() {
		umlCore.update();
	}

	public List<UMLObject> getAllObjects() {
		List<UMLObject> outList = new ArrayList<UMLObject>();
		int[] layers=umlCore.getNotEmptyLayers();
		for(int i=0;i<layers.length;i++){
			List<UMLObject> list=umlCore.getRealObjects(layers[i]);
			for(UMLObject object:list){
				outList.add(object);
			}
		}
		return outList;
	}

}
