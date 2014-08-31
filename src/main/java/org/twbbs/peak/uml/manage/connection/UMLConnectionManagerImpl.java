package org.twbbs.peak.uml.manage.connection;

import org.twbbs.peak.uml.connection.UMLConnectionType;
import org.twbbs.peak.uml.manage.object.UMLObjectManager;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.util.Point;

public class UMLConnectionManagerImpl implements UMLConnectionManager{
    protected UMLObjectManager manager;
    private LineHandler lineHandler;
    protected UMLBasicObject preObject;
    protected UMLBasicObject postObject;
    protected Point prePoint;
    protected Point postPoint;
    public UMLConnectionManagerImpl(UMLObjectManager manager) {
        this.manager=manager;
        this.lineHandler=new LineHandler();
    }
    
    public void connectStart(int x, int y) {
        preObject=manager.getUMLBasicObject(x, y);
        prePoint=new Point(x, y);
    }    
    public boolean connectEnd(int x, int y) {
        if(preObject!=null){
            postObject=manager.getUMLBasicObject(x, y);
            postPoint=new Point(x, y);
            if(isBothObjectsExist()){
                return true;
            }
        }
        return false;
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

    public boolean connectObjects(UMLConnectionType type) {
        if(isBothObjectsExist()){
            lineHandler.connectObjects(type,prePoint, preObject, postPoint, postObject);
            manager.update();
        }
        return initWithPreStatement();
    }    
}
