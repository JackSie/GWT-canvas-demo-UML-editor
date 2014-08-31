package org.twbbs.peak.uml.object.factory;

import java.util.HashMap;
import java.util.Map;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.factory.creator.UMLObjectCreator;
import org.twbbs.peak.uml.object.series.UMLObjectType;

public class UMLObjectFactoryImpl implements UMLObjectFactory{
    private Map<UMLObjectType,UMLObjectCreator> creatorMap;
    public UMLObjectFactoryImpl() {
        this.creatorMap=new HashMap<UMLObjectType, UMLObjectCreator>();
    }

    public void addCreator(UMLObjectType type, UMLObjectCreator creator) {
        creatorMap.put(type, creator);
    }

    public UMLObject create(int x, int y, UMLObjectType type) {
        UMLObject object=null;
        UMLObjectCreator creator = creatorMap.get(type);
        if(creator!=null){
            object= creator.create(x, y);
        }
        return object;
    }
}
