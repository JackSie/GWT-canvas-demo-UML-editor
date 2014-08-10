package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import org.twbbs.peak.uml.connection.UMLConnectPosition;
import org.twbbs.peak.uml.connection.UMLConnection;
import org.twbbs.peak.uml.connection.UMLConnectionType;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;

import com.google.gwt.canvas.dom.client.Context2d;

public class ConnectionDrawBehaviorImpl implements ConnectionDrawBehavior{
    private int x1;
    private int y1;
    private int x2; 
    private int y2;
    private UMLConnectionType type;
    public void toDraw(Context2d context) {
        drawConnectionLine(context);
    }

    public void setConnection(UMLConnection connection) {
        x1=calculateX((UMLBasicObject)connection.getHead(), connection.getHeadPosition());
        y1=calculateY((UMLBasicObject)connection.getHead(), connection.getHeadPosition());
        x2=calculateX((UMLBasicObject)connection.getTail(), connection.getTailPostion()); 
        y2=calculateY((UMLBasicObject)connection.getTail(), connection.getTailPostion());
        type=connection.getType();
    }
    
    protected void drawConnectionLine(Context2d context){
        context.save();
        drawLine(context);        
        drawArrow(context);
        context.restore();
    }
    private void drawArrow(Context2d context){
        if(type==UMLConnectionType.ASSOCIATION){
            return;
        }
            double dist = Math.hypot(x1 - x2, y1 - y2);
            double ratio = 20 / dist;
            int mx, my;
            mx = (int) ((x2 - x1) * (1 - ratio) + x1);
            my = (int) ((y2 - y1) * (1 - ratio) + y1);
            double nx = (mx - x2) / Math.hypot(mx - x2, my - y2);
            double ny = (my - y2) / Math.hypot(mx - x2, my - y2);
        if(type== UMLConnectionType.GENERALIZATION){
            drawGeneralizationArrow(context,mx,my,nx,ny);
        }else if(type == UMLConnectionType.COMPOSITION){
            drawCompositionArrow(context,mx,my,nx,ny);
        }
    }
    private void drawCompositionArrow(Context2d context,int mx,int my,double nx,double ny){
        int c1x = (mx + x2)/2 + (int) (ny * 10);
        int c1y = (my + y2)/2 + (int) (-nx * 10);
        int c2x = (mx + x2)/2 + (int) (-ny * 10);
        int c2y = (my + y2)/2 + (int) (nx * 10);
        context.beginPath();
        context.moveTo(c1x, c1y);
        context.lineTo(x2,y2);
        context.lineTo(c2x, c2y);
        context.lineTo(mx, my);
        context.lineTo(c1x, c1y);
        context.fill();
        context.stroke();
        context.closePath();
    }
    private void drawGeneralizationArrow(Context2d context,int mx,int my,double nx,double ny){
        int c1x = mx + (int) (ny * 15);
        int c1y = my + (int) (-nx * 15);
        int c2x = mx + (int) (-ny * 15);
        int c2y = my + (int) (nx * 15);
        context.beginPath();
        context.moveTo(x2,y2);
        context.lineTo(c1x, c1y);
        context.lineTo(c2x, c2y);
        context.lineTo(x2,y2);
        context.fill();
         context.stroke();
         context.closePath();
    }
    private void drawLine(Context2d context){
        context.setStrokeStyle("#000000");
        context.setFillStyle("#FFFFFF");
        context.setLineWidth(2);
        
        context.moveTo(x1,y1);
        context.lineTo(x2,y2);
        context.stroke();
    }
    private int calculateX(UMLObject reader,UMLConnectPosition position){
        int x=reader.getObjectState().getX();        
        int wide=reader.getObjectState().getSizeW();        
        int newX=0;
        switch (position) {
        case WEST:
            newX=x;
            break;
        case NORTH:
            newX=x+wide/2;
            break;
        case EAST:
            newX=x+wide;
            break;
        case SOUTH:
            newX=x+wide/2;
            break;
        default:
            break;
        }
        return newX;
    }
    private int calculateY(UMLObject reader,UMLConnectPosition position){
        int y=reader.getObjectState().getY();
        int height=reader.getObjectState().getSizeH();
        int newY=0;
        switch (position) {
        case WEST:
            newY=y+height/2;
            break;
        case NORTH:
            newY=y;
            break;
        case EAST:
            newY=y+height/2;
            break;
        case SOUTH:
            newY=y+height;
            break;
        default:
            break;
        }
        return newY;
    }
}
