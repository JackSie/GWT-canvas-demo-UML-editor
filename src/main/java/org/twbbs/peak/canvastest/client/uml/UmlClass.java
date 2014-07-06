package org.twbbs.peak.canvastest.client.uml;


import org.twbbs.peak.uml.object.ClassObject;
import org.twbbs.peak.uml.object.DefaultClassObject;

import com.google.gwt.canvas.dom.client.Context2d;

public class UmlClass extends DrawableDragableUMLObject{
	private ClassObject classObject;

	public UmlClass(int x,int y) {
		this(x,y,new DefaultClassObject());
	}
	
	public UmlClass(int x,int y,ClassObject classObject) {
		super(x,y);
		this.classObject=classObject;
	}
	

	public ClassObject getClassObject() {
		return classObject;
	}
	public void setClassObject(ClassObject classObject) {
		this.classObject = classObject;
	}
	
	public void draw(Context2d context) {
		context.save();
		
		if(isSelected()){
			context.setStrokeStyle(red);
		}else{
			context.setStrokeStyle(black);
		}
		
		context.strokeText("ClassA", x+5, y+5);
		
		context.strokeRect(x, y, 20, 50);
		context.restore();
	}
}
