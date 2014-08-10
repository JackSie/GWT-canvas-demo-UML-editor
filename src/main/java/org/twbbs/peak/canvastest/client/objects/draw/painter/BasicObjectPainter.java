package org.twbbs.peak.canvastest.client.objects.draw.painter;

import org.twbbs.peak.canvastest.client.objects.draw.behavior.ClassDrawBehavior;
import org.twbbs.peak.canvastest.client.objects.draw.behavior.DrawBehavior;
import org.twbbs.peak.canvastest.client.objects.draw.behavior.UseCaseDrawBehavior;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.series.UMLObjectType;

import com.google.gwt.canvas.dom.client.Context2d;

public class BasicObjectPainter implements ObjectPainter{
    private ClassDrawBehavior classDrawBehavior;
    private UseCaseDrawBehavior useCaseDrawBehavior;
    public BasicObjectPainter() {
        classDrawBehavior=new ClassDrawBehavior(null);
        useCaseDrawBehavior=new UseCaseDrawBehavior(null);
    }
    public void paint(UMLObject object, Context2d context2d) {
        if(!isObjectNull(object)){
            DrawBehavior drawBehavior=chooseDrawBehavior(object.getType());
            if(drawBehavior!=null){
                drawObject(drawBehavior,object,context2d);
            }
        }
    }
    private void drawObject(DrawBehavior drawBehavior,UMLObject object, Context2d context2d){
        drawBehavior.setObject((UMLBasicObject)object);
        drawBehavior.toDraw(context2d);
    }
    private boolean isObjectNull(UMLObject object){
        return object==null;
    }
    private DrawBehavior chooseDrawBehavior(UMLObjectType type){
        DrawBehavior drawBehavior=null;
        if(type.equals(UMLObjectType.CLASS)){
            drawBehavior=classDrawBehavior;
        }else if(type.equals(UMLObjectType.INTERFACE)){
            drawBehavior=useCaseDrawBehavior;
        }
        return drawBehavior;
    }
}
