package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.composite.GroupObject;
import org.twbbs.peak.uml.object.state.ObjectState;

import com.google.gwt.canvas.dom.client.CanvasGradient;
import com.google.gwt.canvas.dom.client.Context2d;

public class GroupDrawBehavior implements DrawBehavior{
    public static final int RADIUSINIT=2;
    protected GroupObject groupObject;
    private SquareDrawHandler squareDrawHandler;
    public GroupDrawBehavior() {
        this.squareDrawHandler=new SquareDrawHandler();
    }
    
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
        canvasGradient.addColorStop(0, "rgba(255,255,0,0.3)");
        canvasGradient.addColorStop(1, "rgba(255,255,0,0.1)");
        context.setFillStyle(canvasGradient);

        if(groupObject.getObjectState().isSelected()){
            context.setStrokeStyle(DrawColor.RED);
        }
        squareDrawHandler.drawShape(context, x, y, sizeW, sizeH);
    }

}
