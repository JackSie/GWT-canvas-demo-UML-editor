package org.twbbs.peak.canvastest.client.objects.draw.painter;

import java.util.List;

import org.twbbs.peak.canvastest.client.objects.draw.behavior.GroupDrawBehavior;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.object.composite.GroupObject;

import com.google.gwt.canvas.dom.client.Context2d;

public class GroupObjectPainter implements ObjectPainter{
    private BasicObjectPainter basicObjectPainter;
    private GroupDrawBehavior groupDrawBehavior;
    public GroupObjectPainter(BasicObjectPainter basicObjectPainter) {
        this.basicObjectPainter=basicObjectPainter;
        groupDrawBehavior=new GroupDrawBehavior();
    }

    public void paint(UMLObject object, Context2d context2d) {
        if(isGroupObject(object)){
            drawGroupObjectShape(object,context2d);
            drawGroupObjectChildren(object,context2d);
        }else if(isBasicObject(object)){
            drawBasicObject(object,context2d);
        }
    }
    private void drawGroupObjectShape(UMLObject object, Context2d context2d){
        groupDrawBehavior.setObject(object);
        groupDrawBehavior.toDraw(context2d);
    }
    private void drawGroupObjectChildren(UMLObject object, Context2d context2d){
        List<UMLObject> list =((GroupObject)object).getObjectList();
        for(UMLObject object2:list){
            paint(object2, context2d);
        }
    }
    private void drawBasicObject(UMLObject object, Context2d context2d){
        basicObjectPainter.paint(object, context2d);
    }
    private boolean isGroupObject(UMLObject object){
        return object!=null && object instanceof GroupObject;
    }
    private boolean isBasicObject(UMLObject object){
        return object!=null && object instanceof UMLBasicObject;
    }
}
