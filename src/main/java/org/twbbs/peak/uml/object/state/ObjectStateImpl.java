package org.twbbs.peak.uml.object.state;


public class ObjectStateImpl implements ObjectState{
    private int x;
    private int y;
    private int sizeW;
    private int sizeH;
    private boolean isDraged=false;
    private boolean isSelected=false;
    
    public ObjectStateImpl(int x,int y, int sizeW, int sizeH) {
        this.x=x;
        this.y=y;
        this.sizeW=sizeW;
        this.sizeH=sizeH;
    }
    public ObjectStateImpl(int x,int y) {
        this.x=x;
        this.y=y;
    }
    
    public int getX() {
        return x;
    }
    public void setX(int x) {
        this.x = x;
    }
    public int getY() {
        return y;
    }
    public void setY(int y) {
        this.y = y;
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
