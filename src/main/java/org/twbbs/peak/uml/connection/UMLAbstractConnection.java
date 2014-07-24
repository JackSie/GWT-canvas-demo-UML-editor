package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public abstract class UMLAbstractConnection implements UMLConnection{
	private int headPostition;
	private int tailPostition;
	private int type;
	private UMLBasicObject head;
	private UMLBasicObject tail;
	
	public UMLAbstractConnection(UMLBasicObject head,UMLBasicObject tail,int headPostition,int tailPostition,int type) {
		this.setHead(head);
		this.setTail(tail);
		this.setHeadPosition(headPostition);
		this.setTailPostion(tailPostition);
		this.setType(type);
	}
	public int getType() {
		return type;
	}
	public void setType(int type) {
		this.type=type;
	}
	public UMLBasicObject getHead() {
		return head;
	}
	public void setHead(UMLBasicObject object) {
		this.head=object;
	}
	public UMLBasicObject getTail() {
		return tail;
	}
	public void setTail(UMLBasicObject object) {
		this.tail=object;
	}

	public int getHeadPosition() {
		return headPostition;
	}
	public void setHeadPosition(int postion) {
		if(postion<=4 && postion>=0){
			this.headPostition=postion;
		}
	}
	public int getTailPostion() {
		return tailPostition;
	}
	public void setTailPostion(int postion) {
		if(postion<=4 && postion>=0){
			this.tailPostition=postion;
		}
	}
	
}
