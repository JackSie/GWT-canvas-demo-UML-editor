package org.twbbs.peak.uml.object;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.UMLCore;
import org.twbbs.peak.uml.object.defaults.DefaultClassObject;
import org.twbbs.peak.uml.object.defaults.DefaultInterfaceObject;

public class ObjectHandler {
	private UMLCore umlCore;
	public ObjectHandler(UMLCore umlCore) {
		this.umlCore=umlCore;
	}
	public void createClassObject(int x, int y) {
		umlCore.addUMLObject(new DefaultClassObject(x,y));
	}

	public void createUseCaseObject(int x, int y) {
		umlCore.addUMLObject(new DefaultInterfaceObject(x, y));	
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
