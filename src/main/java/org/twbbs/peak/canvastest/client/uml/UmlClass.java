package org.twbbs.peak.canvastest.client.uml;


import org.twbbs.peak.uml.object.ClassObject;
import org.twbbs.peak.uml.object.DefaultClassObject;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;

public class UmlClass extends DrawableDragableUMLObject{
	private ClassObject classObject;
	double shadowOffsetNormal=5;
	double shadowOffsetUp=10;
	
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
		
		drawBlackground(context);
		
		context.setFont("normal lighter 12px serif");
		context.fillText(classObject.getName(), x+20, y+20);
		
		drawMember(context);
		drawMethod(context);
		
		
		
		
		if(isDraged()||isSelected()){  //TODO change to only Selected
			drawSpot(context);
		}
		
		context.restore();
	}
	
	private void drawBlackground(Context2d context){
		double offset=shadowOffsetNormal;
		if(isDraged()||isSelected()){
			offset=shadowOffsetUp;
		}
		
		
		context.save();
		context.setShadowOffsetX(offset);
		context.setShadowOffsetY(offset);
		context.setShadowColor("black");
		context.setShadowBlur(4);
		
		context.setLineWidth(1);
		
		CanvasGradient canvasGradient= context.createLinearGradient(0, y, 0, y+siezH);
		canvasGradient.addColorStop(0, "#fff");
		canvasGradient.addColorStop(1, "#66CC00");
		context.setFillStyle(canvasGradient);
		
		
//		context.fillRect(x, y, sizeW, siezH);
//		context.strokeRect(x, y, sizeW, siezH);
		
		int r = 10;
		
		if (sizeW < 2 * r) r = sizeW / 2;
		if (siezH < 2 * r) r = siezH / 2;
		context.beginPath();
		context.moveTo(x+r, y);
		context.arcTo(x+sizeW, y, x+sizeW, y+siezH, r);
		context.arcTo(x+sizeW, y+siezH, x, y+siezH, r);
		context.arcTo(x, y+siezH, x, y, r);
		context.arcTo(x, y, x+sizeW, y, r);
		// this.arcTo(x+r, y);
		context.fill();
		context.stroke();
		context.closePath();
		
		
		
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
