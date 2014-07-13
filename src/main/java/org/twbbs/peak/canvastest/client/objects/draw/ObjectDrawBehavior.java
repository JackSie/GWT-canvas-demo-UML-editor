package org.twbbs.peak.canvastest.client.objects.draw;


import java.util.List;

import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.UMLObjectReader;

import com.google.gwt.canvas.dom.client.Context2d;

public abstract class ObjectDrawBehavior implements DrawBehavior{
	protected UMLObjectReader umlObjectReader;
	public ObjectDrawBehavior(UMLObjectReader umlObjectReader) {
		this.umlObjectReader=umlObjectReader;
	}
	public final void toDraw(Context2d context) {
		context.save();
		drawBlackground(context);
		drawName(context);
		drawLine(context,40);
		cumstomDraw(context);
		drawConnections(context);
		context.restore();
	}
	protected void drawName(Context2d context){
		String name=umlObjectReader.getName();
		int x=umlObjectReader.getObjectState().getX();
		int y=umlObjectReader.getObjectState().getY();
		int sizeW=umlObjectReader.getObjectState().getSizeW();
		int sizeH=umlObjectReader.getObjectState().getSizeH();
		int nameSize=name.length();
		context.setFillStyle(black);
		context.setFont("normal lighter 12px serif");
		context.fillText(name, x+sizeW/2-nameSize*4, y+20);
	}
	protected void drawLine(Context2d context,int fromtop){
		int x=umlObjectReader.getObjectState().getX();
		int y=umlObjectReader.getObjectState().getY();
		int sizeW=umlObjectReader.getObjectState().getSizeW();
		context.save();
		context.beginPath();
	    context.moveTo(x, y+fromtop);
	    context.lineTo(x+sizeW, y+fromtop);
	    context.setLineWidth(2);
	    context.stroke();
	    context.restore();
	}
	protected void drawSpot(Context2d context,String blue){
		int x=umlObjectReader.getObjectState().getX();
		int y=umlObjectReader.getObjectState().getY();
		int sizeW=umlObjectReader.getObjectState().getSizeW();
		int sizeH=umlObjectReader.getObjectState().getSizeH();
		context.save();
		context.setFillStyle(blue);
		context.fillRect(x-8, y+sizeH/2, 10 , 10);
		context.fillRect(x+sizeW/2-5, y-8, 10 , 10);
		context.fillRect(x+sizeW/2-5, y+sizeH, 10 , 10);
		context.fillRect(x+sizeW, y+sizeH/2, 10 , 10);
		
		context.restore();
	}
	private void drawConnections(Context2d context) {
		List<UMLConnection> list =umlObjectReader.getConnections();
		if(list ==null || list.size()==0){
			return;
		}
		for(UMLConnection connection:list){
			drawConnectionLine(calculateX(connection.getHead(), connection.getHeadPosition()), calculateY(connection.getHead(), connection.getHeadPosition()),
					calculateX(connection.getTail(), connection.getTailPostion()), calculateY(connection.getTail(), connection.getTailPostion()), connection.getType(),context);
		}
	}
	
	private int calculateX(UMLObjectReader reader,int position){
		int x=reader.getObjectState().getX();		
		int wide=reader.getObjectState().getSizeW();		
		int newX=0;
		switch (position) {
		case UMLConnection.WEST:
			newX=x;break;
		case UMLConnection.NORTH:
			newX=x+wide/2;break;
		case UMLConnection.EAST:
			newX=x+wide;break;
		case UMLConnection.SOUTH:
			newX=x+wide/2;break;
		default:
			break;
		}
		return newX;
	}
	private int calculateY(UMLObjectReader reader,int position){
		int y=reader.getObjectState().getY();
		int height=reader.getObjectState().getSizeH();
		int newY=0;
		switch (position) {
		case UMLConnection.WEST:
			newY=y+height/2;break;
		case UMLConnection.NORTH:
			newY=y;break;
		case UMLConnection.EAST:
			newY=y+height/2;break;
		case UMLConnection.SOUTH:
			newY=y+height;break;
		default:
			break;
		}
		return newY;
	}
	
	private void drawConnectionLine(int x1,int y1,int x2, int y2,int type,Context2d context){
		context.save();
		context.setStrokeStyle("#000000");
		context.setFillStyle("#FFFFFF");
		context.setLineWidth(2);
		
		context.moveTo(x1,y1);
		context.lineTo(x2,y2);
		context.stroke();
		if(type==UMLConnection.ASSOCIATION){
			return;
		}
		int dx = x2-x1;
		 int dy = y2-x1;
		 
		 double length = Math.sqrt(dx * dx + dy * dy);
		 double unitDx = dx / length;
		 double unitDy = dy / length;
		 // increase this to get a larger arrow head
		 int arrowHeadSize = 15;
		 
		 double arrowX1=x2 - unitDx * arrowHeadSize - unitDy * arrowHeadSize;
		 double arrowY1=y2 - unitDy * arrowHeadSize + unitDx * arrowHeadSize;
		 double arrowX2=x2 - unitDx * arrowHeadSize + unitDy * arrowHeadSize;
		 double arrowY2=y2 - unitDy * arrowHeadSize - unitDx * arrowHeadSize;
		switch(type){
		case UMLConnection.GENERALIZATION:
			 
			        
			context.beginPath();
			 context.moveTo(x2,y2);
			 context.lineTo(arrowX1,arrowY1);
			 context.lineTo(arrowX2,arrowY2);
			 context.lineTo(x2,y2);
			 context.fill();
			 context.stroke();
			 context.closePath();
			

			break;
		case UMLConnection.COMPOSITION:
			context.beginPath();
			 context.moveTo(x2,y2);
			 context.lineTo(arrowX1,arrowY1);
			 context.lineTo(arrowX2,arrowY2);
			 context.lineTo(x2,y2);
			 context.fill();
			 context.stroke();
			 context.closePath();
			 double arrowX3=x2* (length - arrowHeadSize*2) /length;
			 double arrowY3=y2* (length - arrowHeadSize*2) /length;
			 context.beginPath();
			 context.moveTo(arrowX1,arrowY1);
			 context.lineTo(arrowX2,arrowY2);
			 context.lineTo(arrowX3,arrowY3);
			 context.lineTo(arrowX1,arrowY1);
			 context.fill();
			 context.stroke();
			 context.closePath();
			break;
		}
		context.restore();
	}
	
	
	public void setObject(UMLObjectReader object){
		this.umlObjectReader=object;
	}
	
	protected abstract void drawBlackground(Context2d context);
	protected void cumstomDraw(Context2d context){};
}
