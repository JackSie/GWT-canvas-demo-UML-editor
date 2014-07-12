package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.UMLObject;

public abstract class UMLAbstractConnection implements UMLConnection{
	private int headPostition;
	private int tailPostition;
	private int type;
	private UMLObject head;
	private UMLObject tail;
	
	public UMLAbstractConnection(UMLObject head,UMLObject tail,int headPostition,int tailPostition,int type) {
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
	public UMLObject getHead() {
		return head;
	}
	public void setHead(UMLObject object) {
		this.head=object;
	}
	public UMLObject getTail() {
		return tail;
	}
	public void setTail(UMLObject object) {
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
