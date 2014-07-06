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
		calculateSize();
	}
	

	public ClassObject getClassObject() {
		return classObject;
	}
	public void setClassObject(ClassObject classObject) {
		this.classObject = classObject;
		calculateSize();
	}

	
	public void draw(Context2d context) {
		context.save();
		
		if(isDraged()){
			context.setStrokeStyle(red);
			context.setFillStyle(red);
		}else{
			context.setStrokeStyle(black);
			context.setFillStyle(black);
		}
		
		context.setFont("normal lighter 12px serif");
		context.fillText(classObject.getName(), x+20, y+20);
		
		drawMember(context);
		drawMethod(context);
		
		context.strokeRect(x, y, sizeW, siezH);
		
		if(isDraged()||isSelected()){  //TODO change to only Selected
			drawSpot(context);
		}
		
		context.restore();
	}
	private void drawMember(Context2d context){
		//TODO not finished just prototype
		drawLine(context,40);
	}
	
	private void drawMethod(Context2d context){
		drawLine(context,80);
	}
	
	private void drawLine(Context2d context,int fromtop){
		context.save();
		context.beginPath();
	    context.moveTo(x, y+fromtop);
	    context.lineTo(x+sizeW, y+fromtop);
	    context.setLineWidth(2);
	    context.stroke();
	    context.restore();
	}
	private void drawSpot(Context2d context){
		context.save();
		context.setFillStyle(blue);
		context.fillRect(x-8, y+siezH/2, 10 , 10);
		context.fillRect(x+sizeW/2-5, y-8, 10 , 10);
		context.fillRect(x+sizeW/2-5, y+siezH, 10 , 10);
		context.fillRect(x+sizeW, y+siezH/2, 10 , 10);
		
		context.restore();
	}
	

	@Override
	protected void calculateSize() {
		//TODO temperately not needed
	}
	

}
