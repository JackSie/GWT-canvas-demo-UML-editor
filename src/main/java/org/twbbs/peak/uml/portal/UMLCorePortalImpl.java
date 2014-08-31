package org.twbbs.peak.uml.portal;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.twbbs.peak.uml.modes.UMLModeCallback;
import org.twbbs.peak.uml.modes.UMLModeSeries;
import org.twbbs.peak.uml.modes.UmlMode;

public class UMLCorePortalImpl implements UMLCorePortal,UMLModeHandler,UMLModeSubject,UMLModeCallback{

    private UmlMode nowMode;
    private List<UMLModeObserver> list;
    private Map<UMLModeSeries,UmlMode> modeMap;
    public UMLCorePortalImpl() {
        this.list=new ArrayList<UMLModeObserver>();
        this.modeMap=new HashMap<UMLModeSeries, UmlMode>();
    }    
    public void onClick(int x, int y) {
        nowMode.onClick(x, y);
    }
    public void startDrag(int x, int y) {
        nowMode.startDrag(x, y);
    }
    public void onDrag(int x, int y) {
        nowMode.onDrag(x, y);
    }
    public void stopDrag(int x, int y) {
        nowMode.stopDrag(x, y);
    }
    public void changeName(String name) {
        nowMode.changeName(name);
    }
    public void group(boolean isGroup) {
        nowMode.group(isGroup);
    }
    public void addMode(UMLModeSeries name,UmlMode mode){
        this.modeMap.put(name, mode);
    }
    public void changeMode(UMLModeSeries mode) {
        UmlMode getMode = modeMap.get(mode);
        if(getMode!=null){
            if(nowMode!=null){
                nowMode.modeChanged();
            }
            nowMode=getMode;        
            modifyToChangeMode(mode);
        }
    }
    public void regist(UMLModeObserver observer) {
        list.add(observer);
    }

    public void remove(UMLModeObserver observer) {
        list.remove(observer);        
    }
    
    public void modifyToChaneName(){
        for(UMLModeObserver observer:list){
            observer.changeName();
        }
    }
    public void modifyToChangeMode(UMLModeSeries mode){
        for(UMLModeObserver observer:list){
            observer.modeChanged(mode);
        }
    }
}
