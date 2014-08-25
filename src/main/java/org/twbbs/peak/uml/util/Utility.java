package org.twbbs.peak.uml.util;

import org.twbbs.peak.uml.object.state.ObjectState;

public class Utility {
    private Utility() {
    }
    public static boolean isInit(int x,int y,ObjectState classState){
        int nowX=classState.getX();
        int nowY=classState.getY();
        int sizeW=classState.getSizeW();
        int sizeH=classState.getSizeH();
        return x>=nowX&&x<=nowX+sizeW && y>=nowY&&y<=nowY+sizeH;
    }
}
