package org.twbbs.peak.uml.manage.connection;

import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public class UMLConnectionManagerImpl implements UMLConnectionManager{
    protected UMLObjectManager manager;
    protected UMLBasicObject preObject;
    protected UMLBasicObject postObject;
    public UMLConnectionManagerImpl(UMLObjectManager manager) {
        this.manager=manager;
    }
    
    public void connectStart(int x, int y) {
        preObject=manager.getUMLBasicObject(x, y);      
    }    
    public boolean connectEnd(int x, int y) {
        if(preObject!=null){
            postObject=manager.getUMLBasicObject(x, y);
            if(isBothObjectsExist()){
                return true;
            }
        }
        return false;
    }
    public boolean associateObjects() {
        if(isBothObjectsExist()){
            manager.associateObjects(preObject,postObject);
        }
        return initWithPreStatement();
    }
    public boolean compositeObjects() {
        if(isBothObjectsExist()){
            manager.compositeObjects(preObject,postObject);
        }
        return initWithPreStatement();
    }
    public boolean generalizeObjects() {
        if(isBothObjectsExist()){
            manager.generalizeObjects(preObject,postObject);
        }
        return initWithPreStatement();
    }
    private boolean isBothObjectsExist(){
        return postObject!=null && preObject!=postObject;
    }
    
    private void init(){
        preObject=null;
        postObject=null;
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
