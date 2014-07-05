package org.twbbs.peak.uml.connection;

import org.twbbs.peak.uml.object.UMLObject;

public abstract class UMLAbstractConnection implements UMLConnection{
	private int postition;
	private int type;
	private UMLObject head;
	private UMLObject tail;
	
	public UMLAbstractConnection(UMLObject head,UMLObject tail,int postion,int type) {
		this.setHead(head);
		this.setTail(tail);
		this.setPosition(postion);
		this.setType(type);
	}
	
	public int getPosition() {
		return postition;
	}
	public void setPosition(int postion) {
		if(postion<=4 && postion>=0){
			this.postition=postion;
		}
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
	
}
