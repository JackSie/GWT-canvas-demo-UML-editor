package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import org.twbbs.peak.uml.object.UMLObject;

import com.google.gwt.canvas.dom.client.Context2d;

public interface DrawBehavior {
    double SHADOWOFFSETNORMAL=5;
    double SHADOWOFFSETUP=10;
    static String BLUE ="#0000FF";
    static String BLACK = "#000000";
    static String RED = "#FF0000";
    void toDraw(Context2d context);
    void setObject(UMLObject object);
}
