package org.twbbs.peak.uml.modes.operation;

import org.twbbs.peak.uml.modes.UMLModeCallback;
import org.twbbs.peak.uml.modes.UmlMode;
import org.twbbs.peak.uml.object.manage.UMLObjectManager;

public class SelectionMode implements UmlMode{
    protected UMLObjectManager manager;
    private UMLModeCallback corePortal;
    private SingleObjectHandler objectHandler;
    private ServeralObjectsHandler serveralObjectsHandler;
    public SelectionMode(UMLObjectManager manager,UMLModeCallback corePortal) {
        this.manager=manager;
        this.corePortal=corePortal;
        this.objectHandler=new SingleObjectHandler(this);
        this.serveralObjectsHandler=new ServeralObjectsHandler(this);
    }
    public void onClick(int x, int y) {
        modeChanged();
        objectHandler.chooseObject(x,y);
    }

    public void startDrag(int x, int y) {
        modeChanged();
        objectHandler.getObjectFromPoint(x, y);
        if(isSingleObjectSelected()){
            objectHandler.prepareDrag(x,y);
        }else{
            serveralObjectsHandler.prepareDrag(x, y);
        }
        updateToObserver();
    }

    public void onDrag(int x, int y) {
        if(isSingleObjectSelected()){
            objectHandler.toDrag(x,y);
        }
    }

    public void stopDrag(int x, int y) {
        if(isSingleObjectSelected()){
            objectHandler.endOfDrag(x,y);
        }else{
            serveralObjectsHandler.endOfDrag(x, y);
        }
        updateToObserver();
    }
    public void modeChanged() {
        unSelectList();
        unSelectObject();
        updateToObserver();
    }
    public void changeName(String name) {
        if(name==null){
            changeNameCheck();
        }else{
            objectHandler.changeName(name);
        }
    }
    public void group(boolean isGroup) {
        if(isGroup){
            serveralObjectsHandler.group();
        }else{
            objectHandler.unGroup();
        }
    }
    
    protected void updateToObserver(){
        manager.update();
    }
    private void changeNameCheck(){
        if(objectHandler.isObjectUMLBasic()){
            corePortal.modifyToChaneName();
        }
    }
    private boolean isSingleObjectSelected(){
        return objectHandler.isObjectSelected();
    }
    private void unSelectList(){
        serveralObjectsHandler.unSelected();
    }
    private void unSelectObject(){
        objectHandler.unSelected();
    }
}
