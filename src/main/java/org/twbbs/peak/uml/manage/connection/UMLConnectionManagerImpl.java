package org.twbbs.peak.uml.manage.connection;

import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public class UMLConnectionManagerImpl implements UMLConnectionManager{
    protected UMLObjectManager manager;
    protected UMLBasicObject nowObject;
    protected UMLBasicObject object;
    public UMLConnectionManagerImpl(UMLObjectManager manager) {
        this.manager=manager;
    }
    public void connectStart(int x, int y) {
        UMLObject object=manager.getUMLObject(x, y);
        if(object!=null && object instanceof UMLBasicObject){
            nowObject=(UMLBasicObject)object;
        }
    }
    public boolean connectEnd(int x, int y) {
        object=null;
        if(nowObject!=null){
            UMLObject umlObject=manager.getUMLObject(x, y);
            if(umlObject!=null && umlObject instanceof UMLBasicObject){
                object=(UMLBasicObject)umlObject;
            }
            if(isBothObjectsExist()){
                return true;
            }
        }
        return false;
    }
    public boolean associateObjects() {
        if(isBothObjectsExist()){
            manager.associateObjects(nowObject,object);
        }
        return initWithPreStatement();
    }
    public boolean compositeObjects() {
        if(isBothObjectsExist()){
            manager.compositeObjects(nowObject,object);
        }
        return initWithPreStatement();
    }
    public boolean generalizeObjects() {
        if(isBothObjectsExist()){
            manager.generalizeObjects(nowObject,object);
        }
        return initWithPreStatement();
    }
    private boolean isBothObjectsExist(){
        return object!=null && nowObject!=object;
    }
    private void init(){
        nowObject=null;
        object=null;
    }
    private boolean initWithPreStatement(){
        boolean result=false;
        if(isBothObjectsExist()){
            result=true;
        }
        init();
        return result;
    }
}
