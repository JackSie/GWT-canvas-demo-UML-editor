package org.twbbs.peak.uml.object.state;

import org.twbbs.peak.uml.util.Point;


public class ObjectStateImpl implements ObjectState{
    private Point point;
    private int sizeW;
    private int sizeH;
    private boolean isDraged=false;
    private boolean isSelected=false;
    
    public ObjectStateImpl(int x,int y, int sizeW, int sizeH) {
        this.point=new Point(x, y);
        this.sizeW=sizeW;
        this.sizeH=sizeH;
    }
    public ObjectStateImpl(int x,int y) {
        this.point=new Point(x, y);
    }
    
    public int getX() {
        return point.getX();
    }
    public void setX(int x) {
        point.setX(x);
    }
    public int getY() {
        return point.getY();
    }
    public void setY(int y) {
        point.setY(y);
    }
    public int getSizeW() {
        return sizeW;
    }
    public void setSizeW(int sizeW) {
        this.sizeW = sizeW;
    }
    public int getSizeH() {
        return sizeH;
    }
    public void setSizeH(int sizeH) {
        this.sizeH = sizeH;
    }
    public boolean isDraged() {
        return isDraged;
    }
    public void setDraged(boolean isDraged) {
        this.isDraged = isDraged;
    }
    public boolean isSelected() {
        return isSelected;
    }
    public void setSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
