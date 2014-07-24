package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.object.UMLObject;

import com.google.gwt.canvas.dom.client.Context2d;

public class ConnectionDrawBehaviorImpl implements ConnectionDrawBehavior{
	private int x1;
	private int y1;
	private int x2; 
	private int y2;
	private int type;
	public void toDraw(Context2d context) {
		drawConnectionLine(context);
	}

	public void setConnection(UMLConnection connection) {
		x1=calculateX(connection.getHead(), connection.getHeadPosition());
		y1=calculateY(connection.getHead(), connection.getHeadPosition());
		x2=calculateX(connection.getTail(), connection.getTailPostion()); 
		y2=calculateY(connection.getTail(), connection.getTailPostion());
		type=connection.getType();
	}
	
	protected void drawConnectionLine(Context2d context){
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
		 double dist = Math.hypot(x1 - x2, y1 - y2);
			double ratio = 20 / dist;
			int mx, my;
			mx = (int) ((x2 - x1) * (1 - ratio) + x1);
			my = (int) ((y2 - y1) * (1 - ratio) + y1);
			double nx = (mx - x2) / Math.hypot(mx - x2, my - y2);
			double ny = (my - y2) / Math.hypot(mx - x2, my - y2);
			int c1x, c1y, c2x, c2y;
		switch(type){
		case UMLConnection.GENERALIZATION:
			c1x = mx + (int) (ny * 15);
			c1y = my + (int) (-nx * 15);
			c2x = mx + (int) (-ny * 15);
			c2y = my + (int) (nx * 15);
			context.beginPath();
			context.moveTo(x2,y2);
			context.lineTo(c1x, c1y);
			context.lineTo(c2x, c2y);
			context.lineTo(x2,y2);
			context.fill();
			 context.stroke();
			 context.closePath();
			break;
		case UMLConnection.COMPOSITION:
				c1x = (mx + x2)/2 + (int) (ny * 10);
				c1y = (my + y2)/2 + (int) (-nx * 10);
				c2x = (mx + x2)/2 + (int) (-ny * 10);
				c2y = (my + y2)/2 + (int) (nx * 10);
				context.beginPath();
				context.moveTo(c1x, c1y);
				context.lineTo(x2,y2);
				context.lineTo(c2x, c2y);
				context.lineTo(mx, my);
				context.lineTo(c1x, c1y);
				context.fill();
				context.stroke();
				context.closePath();
			break;
		}
		context.restore();
	}
	private int calculateX(UMLObject reader,int position){
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
	private int calculateY(UMLObject reader,int position){
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
}
