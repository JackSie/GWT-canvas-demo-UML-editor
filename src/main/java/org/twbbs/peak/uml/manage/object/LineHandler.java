package org.twbbs.peak.uml.manage.object;

import org.twbbs.peak.uml.connection.AssociationConnection;
import org.twbbs.peak.uml.connection.CompositionConnection;
import org.twbbs.peak.uml.connection.GeneralizationConnection;
import org.twbbs.peak.uml.connection.UMLConnectPosition;
import org.twbbs.peak.uml.object.basic.UMLBasicObject;

public class LineHandler {
    public void associateObjects(UMLBasicObject objectA, UMLBasicObject objectB) {
        UMLConnectPosition[] point = calc(objectA, objectB);        
        objectA.setConnection(new AssociationConnection(objectA, objectB, point[0],point[1]));
    }

    public void compositeObjects(UMLBasicObject objectA, UMLBasicObject objectB) {
        UMLConnectPosition[] point = calc(objectA, objectB);    
        objectA.setConnection(new CompositionConnection(objectA, objectB, point[0],point[1]));
    }

    public void generalizeObjects(UMLBasicObject objectA, UMLBasicObject objectB) {
        UMLConnectPosition[] point = calc(objectA, objectB);    
        objectA.setConnection(new GeneralizationConnection(objectA, objectB, point[0],point[1]));
    }
    private UMLConnectPosition[] calc(UMLBasicObject objectA, UMLBasicObject objectB){
        int ax=objectA.getObjectState().getX();
        int ay=objectA.getObjectState().getY();
        int bx=objectB.getObjectState().getX();
        int by=objectB.getObjectState().getY();
        int aw=objectA.getObjectState().getSizeW();
        int ah=objectA.getObjectState().getSizeH();
        int bw=objectB.getObjectState().getSizeW();
        int bh=objectB.getObjectState().getSizeH();
        
        int ansOne=0,ansTwo=0;
        double length=Double.MAX_VALUE;
        int[] oneX={ax+ aw/2,ax+ aw,ax+ aw/2,ax};
        int[] oneY={ay,ay+ah/2,ay+ah,ay+ah/2};
        int[] twoX={bx+ bw/2,bx+ bw,bx+ bw/2,bx};
        int[] twoY={by,by+bh/2,by+bh,by+bh/2};
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                double len=Math.pow(oneX[i] - twoX[j],2) + Math.pow(oneY[i] - twoY[j],2);
                if(len < length){
                    length=len;
                    ansOne=i;
                    ansTwo=j;
                }
            }
        }
        UMLConnectPosition[] position=new UMLConnectPosition[2];
        position[0]=UMLConnectPosition.fromValue(ansOne);
        position[1]=UMLConnectPosition.fromValue(ansTwo);
        return position;
    }
}
