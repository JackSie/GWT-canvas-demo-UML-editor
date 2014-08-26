package org.twbbs.peak.uml.object.state;


public class StateUtility {
    private StateUtility() {
    }
    public static boolean isInit(int x,int y,ObjectState classState){
        int nowX=classState.getX();
        int nowY=classState.getY();
        int sizeW=classState.getSizeW();
        int sizeH=classState.getSizeH();
        return x>=nowX&&x<=nowX+sizeW && y>=nowY&&y<=nowY+sizeH;
    }
}
