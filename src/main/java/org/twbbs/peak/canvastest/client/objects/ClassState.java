package org.twbbs.peak.canvastest.client.objects;

import org.twbbs.peak.uml.object.ClassObject;

public class ClassState implements ObjectState{
	int x;
	int y;
	int sizeW;
	int sizeH;
	ClassObject classObject;
	boolean isDraged=false;
	boolean isSelected=false;
	
	public ClassState(int x,int y, int sizeW, int sizeH,ClassObject classObject) {
		this.x=x;
		this.y=y;
		this.sizeW=sizeW;
		this.sizeH=sizeH;
		this.classObject=classObject;
	}
	public ClassState(int x,int y,ClassObject classObject) {
		this.x=x;
		this.y=y;
		this.classObject=classObject;
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
	public ClassObject getClassObject() {
		return classObject;
	}
	public void setClassObject(ClassObject classObject) {
		this.classObject = classObject;
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
