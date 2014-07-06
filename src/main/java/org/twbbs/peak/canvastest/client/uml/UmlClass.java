package org.twbbs.peak.canvastest.client.uml;


import org.twbbs.peak.canvastest.client.objects.ClassState;
import org.twbbs.peak.canvastest.client.objects.draw.ClassDrawBehavior;
import org.twbbs.peak.canvastest.client.objects.draw.DrawBehavior;
import org.twbbs.peak.uml.object.ClassObject;
import org.twbbs.peak.uml.object.DefaultClassObject;

import com.google.gwt.canvas.dom.client.Context2d;

public class UmlClass extends DrawableDragableUMLObject{
	private ClassState classState;
	private DrawBehavior drawBehavior;
	
	public UmlClass(int x,int y) {
		this(x,y,new DefaultClassObject());
	}
	
	
	public UmlClass(int x,int y,ClassObject classObject) {
		this(x,y,new ClassState(x, y, classObject));
	}
	
	public UmlClass(int x,int y,ClassState classState) {
		super(classState);
		calculateSize();
		//TODO change to factory
		//TODO useStateObject
		drawBehavior= new ClassDrawBehavior(classState);
		this.classState=classState;
	}
	
	public void draw(Context2d context) {
		drawBehavior.toDraw(context);
	}
	

	@Override
	protected void calculateSize() {
		//TODO temperately not needed
	}
	

}
