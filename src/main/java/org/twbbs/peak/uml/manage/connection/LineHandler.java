package org.twbbs.peak.uml.manage.connection;

import org.twbbs.peak.uml.connection.AssociationConnection;
import org.twbbs.peak.uml.connection.CompositionConnection;
import org.twbbs.peak.uml.connection.GeneralizationConnection;
import org.twbbs.peak.uml.connection.UMLConnectPosition;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;
import org.twbbs.peak.uml.util.Point;

public class LineHandler {
    
    public void associateObjects(Point prePoint, UMLBasicObject objectA,
            Point postPoint, UMLBasicObject objectB) {
        UMLConnectPosition[] point = {calcPosition(prePoint,objectA),calcPosition(postPoint, objectB)};    
        objectA.setConnection(new AssociationConnection(objectA, objectB, point[0],point[1]));        
    }
    
    public void compositeObjects(Point prePoint, UMLBasicObject objectA,
            Point postPoint, UMLBasicObject objectB) {
        UMLConnectPosition[] point = {calcPosition(prePoint,objectA),calcPosition(postPoint, objectB)};    
        objectA.setConnection(new CompositionConnection(objectA, objectB, point[0],point[1]));   
    }
    
    public void generalizeObjects(Point prePoint, UMLBasicObject objectA,
            Point postPoint, UMLBasicObject objectB) {
        UMLConnectPosition[] point = {calcPosition(prePoint,objectA),calcPosition(postPoint, objectB)};    
        objectA.setConnection(new GeneralizationConnection(objectA, objectB, point[0],point[1]));   
    }
    
    private UMLConnectPosition calcPosition(Point point,UMLBasicObject object){
        double length=Double.MAX_VALUE;
        int node=0;
        int x=object.getObjectState().getX();
        int y=object.getObjectState().getY();
        int w=object.getObjectState().getSizeW();
        int h=object.getObjectState().getSizeH();
        Point[] nodes = {new Point(x+w/2,y),new Point(x+w,y+h/2),new Point(x+w/2,y+h),new Point(x,y+h/2)};
        for(int i=0;i<=3;i++){
            double len=Math.pow(nodes[i].getX() - point.getX() ,2) + Math.pow(nodes[i].getY() - point.getY(),2);
            if(len < length){
                length=len;
                node=i;
            }
        }
        return UMLConnectPosition.fromValue(node);
    }
}
