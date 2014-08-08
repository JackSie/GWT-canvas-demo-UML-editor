package org.twbbs.peak.canvastest.client.objects.draw;

import java.util.List;

import org.twbbs.peak.canvastest.client.objects.draw.painter.ObjectPainter;
import org.twbbs.peak.canvastest.client.objects.draw.painter.ObjectPainterImpl;
import org.twbbs.peak.uml.UMLCoreObserver;
import org.twbbs.peak.uml.UMLCoreSubject;
import org.twbbs.peak.uml.object.UMLObject;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;

public class CanvasCenter implements UMLCoreObserver{
    private Context2d context2d;
    private Context2d bufferedcContext2d;
    private UMLCoreSubject coreSubject;
    private ObjectPainter objectPainter;
    
    public CanvasCenter(Canvas canvas,Canvas bufferedCanvas,UMLCoreSubject coreSubject) {
        this.context2d=canvas.getContext2d();
        this.bufferedcContext2d=bufferedCanvas.getContext2d();
        this.coreSubject=coreSubject;
        this.objectPainter=new ObjectPainterImpl();
        coreSubject.regist(this);        
    }
    
    private void canvasInit(){
        bufferedcContext2d.setFillStyle("#FFFFFF");
        bufferedcContext2d.fillRect(0, 0, 1024, 768);
        bufferedcContext2d.strokeRect(0, 0, 1024, 768);
    }
    
    public void update() {
        canvasInit();
        int[] layers=coreSubject.getNotEmptyLayers();
        for(int i=0;i<layers.length;i++){
            List<UMLObject> list=coreSubject.getObjects(layers[i]);
            for(UMLObject object:list){
                paintObject(object);
            }
        }
        context2d.drawImage(bufferedcContext2d.getCanvas(), 0, 0);
    }
    
    private void paintObject(UMLObject object){
        objectPainter.paint(object, bufferedcContext2d);
    }
}
