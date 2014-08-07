package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.state.ObjectState;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;

public class GroupDrawBehavior implements DrawBehavior{
    public static final int RADIUSINIT=2;
    protected GroupObject groupObject;
    
    public void toDraw(Context2d context) {
        ObjectState state=groupObject.getObjectState();
        context.save();
        drawShape(context,state.getX(),state.getY(),state.getSizeW(),state.getSizeH());
        context.restore();
    }

    public void setObject(UMLObject object) {
        this.groupObject=(GroupObject)object;
    }
    
    protected void drawShape(Context2d context, int x, int y, int sizeW,
            int sizeH) {
        CanvasGradient canvasGradient= context.createLinearGradient(0, y, 0, y+sizeH);
        canvasGradient.addColorStop(0, "#fff");
        canvasGradient.addColorStop(1, "#ff0");
        context.setFillStyle(canvasGradient);

        if(groupObject.getObjectState().isSelected()){
            context.setStrokeStyle(RED);
        }
        int radius=RADIUSINIT;
        if (sizeW < 2 * radius){
            radius = sizeW / 2;
        }
        if (sizeH < 2 * radius){
            radius = sizeH / 2;
        }
        context.beginPath();
        context.moveTo(x+radius, y);
        context.arcTo(x+sizeW, y, x+sizeW, y+sizeH, radius);
        context.arcTo(x+sizeW, y+sizeH, x, y+sizeH, radius);
        context.arcTo(x, y+sizeH, x, y, radius);
        context.arcTo(x, y, x+sizeW, y, radius);
        context.fill();
        context.stroke();
        context.closePath();
    }

}
