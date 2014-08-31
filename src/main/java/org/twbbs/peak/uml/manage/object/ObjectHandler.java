package org.twbbs.peak.uml.manage.object;

import java.util.ArrayList;
import java.util.List;

import org.twbbs.peak.uml.core.UMLCore;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.factory.UMLObjectFactory;
import org.twbbs.peak.uml.object.series.UMLObjectType;
import org.twbbs.peak.uml.object.state.StateUtility;

public class ObjectHandler {
    private UMLCore umlCore;
    private UMLObjectFactory factory;
    public ObjectHandler(UMLCore umlCore,UMLObjectFactory factory) {
        this.umlCore=umlCore;
        this.factory=factory;
    }
    public void createClassObject(int x, int y) {
        umlCore.addUMLObject(factory.create(x, y, UMLObjectType.CLASS));
    }

    public void createUseCaseObject(int x, int y) {
        umlCore.addUMLObject(factory.create(x, y, UMLObjectType.INTERFACE));    
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
    public UMLObject getUMLObject(int x, int y) {
        return umlCore.getUmlObject(x, y);
    }
    public UMLBasicObject getUMLBasicObject(int x, int y) {
        UMLObject object=getUMLObject(x, y);      
        return getObject(x,y,object);
    }
    private UMLBasicObject getObject(int x,int y,UMLObject object){
        UMLBasicObject returnObject= null;
        if(object!=null && StateUtility.isInit(x,y,object.getObjectState())){
            if(object instanceof UMLBasicObject){                
                returnObject= (UMLBasicObject)object;            
            }else if(object instanceof GroupObject){                
                returnObject= getObjectInSideGroup(x,y,object);
            }
        }
        return returnObject;
    }
    private UMLBasicObject getObjectInSideGroup(int x,int y,UMLObject object){
        List<UMLObject> objectList=((GroupObject)object).getObjectList();
        for(int i=objectList.size()-1;i>=0;i--){
            UMLBasicObject returnObject = getObject(x, y, objectList.get(i));
            if(returnObject!=null){
                return returnObject;
            }
        }
        return null;
    }
}
