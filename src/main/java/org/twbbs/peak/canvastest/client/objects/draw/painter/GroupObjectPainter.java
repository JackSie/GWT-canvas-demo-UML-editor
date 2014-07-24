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
		if(object!=null && object instanceof GroupObject){
			groupDrawBehavior.setObject(object);
			groupDrawBehavior.toDraw(context2d);
			GroupObject groupObject=(GroupObject)object;
			List<UMLObject> list =groupObject.getObjectList();
			for(UMLObject object2:list){
				paint(object2, context2d);
			}
		}else if(object!=null && object instanceof UMLBasicObject){
			basicObjectPainter.paint(object, context2d);
		}
	}
}
