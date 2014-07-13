package org.twbbs.peak.canvastest.client.objects.draw;

import java.util.List;

import org.twbbs.peak.uml.object.UMLObjectReader;
import org.twbbs.peak.uml.portal.UMLCoreObserver;
import org.twbbs.peak.uml.portal.UMLCoreSubject;

import com.google.gwt.canvas.client.Canvas;
import com.google.gwt.canvas.dom.client.Context2d;

public class CanvasCenter implements UMLCoreObserver{
	private Canvas canvas;
	private Canvas bufferedCanvas;
	private Context2d context2d;
	private Context2d bufferedcContext2d;
	private UMLCoreSubject coreSubject;
	private ClassDrawBehavior classDrawBehavior;
	public CanvasCenter(Canvas canvas,Canvas bufferedCanvas,UMLCoreSubject coreSubject) {
		this.canvas=canvas;
		this.bufferedCanvas=bufferedCanvas;
		this.context2d=canvas.getContext2d();
		this.bufferedcContext2d=bufferedCanvas.getContext2d();
		this.coreSubject=coreSubject;
		coreSubject.regist(this);
		
		
		classDrawBehavior=new ClassDrawBehavior(null);
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
			List<UMLObjectReader> list=coreSubject.getObjects(layers[i]);
			for(UMLObjectReader object:list){
				paintObject(object);
			}
		}
		context2d.drawImage(bufferedcContext2d.getCanvas(), 0, 0);
	}
	
	private void paintObject(UMLObjectReader object){
		DrawBehavior drawBehavior=null;
		if(object.getType().equals(UMLObjectReader.CLASS)){
			drawBehavior=classDrawBehavior;
		}
		if(drawBehavior!=null && object!=null){
			drawBehavior.setObject(object);
			drawBehavior.toDraw(bufferedcContext2d);
		}
	}
}
