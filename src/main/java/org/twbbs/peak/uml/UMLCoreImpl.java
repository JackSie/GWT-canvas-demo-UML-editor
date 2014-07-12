package org.twbbs.peak.uml;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.commons.lang3.ArrayUtils;
import org.twbbs.peak.uml.object.UMLObject;
import org.twbbs.peak.uml.object.UMLObjectReader;
import org.twbbs.peak.uml.object.state.ObjectState;
import org.twbbs.peak.uml.portal.UMLCoreObserver;
import org.twbbs.peak.uml.portal.UMLCoreSubject;
import org.twbbs.peak.uml.portal.UMLModeObserver;
import org.twbbs.peak.uml.portal.UMLModeSubject;

public class UMLCoreImpl implements UMLCore,UMLCoreSubject{
	final static int DEPTH=99;
	List<UMLCoreObserver> observersList;
	Map<Integer,List<UMLObject>> objectLayers;
	int nowDepth=DEPTH;
	
	public void regist(UMLCoreObserver observer) {
		observersList.add(observer);
	}
	
	public void remove(UMLCoreObserver observer) {
		observersList.remove(observer);
	}

	public List<UMLObjectReader> getObjects(int layer) {
		return (List<UMLObjectReader>)(List) objectLayers.get(layer);
	}

	public int[] getNotEmptyLayers() {
		Set<Integer> set=objectLayers.keySet();
		Integer[] array =set.toArray(new Integer[set.size()]);
		int [] intArray=ArrayUtils.toPrimitive(array);
		return intArray;
	}

	public void addUMLObject(UMLObject umlObject) {
		int layer=getNextLayer();
		List<UMLObject> list=null;
		if(objectLayers.containsKey(layer)){
			list = objectLayers.get(layer);
			if(list==null){
				list=new ArrayList<UMLObject>();
				objectLayers.put(layer, list);
			}
		}else{
			list=new ArrayList<UMLObject>();
			objectLayers.put(layer, list);
		}
		list.add(umlObject);
		update();
	}
	private int getNextLayer(){
		if(nowDepth>0){
			return --nowDepth;
		}else{
			return nowDepth;
		}
	}
	private int calucateLayer(){
		Set<Integer> set=objectLayers.keySet();
		int size=set.size();
		if(size==0){
			return DEPTH;
		}else{
			int lastDepth=(Integer) set.toArray()[size+1];
			lastDepth-=1;
			if(lastDepth>=0){
				return lastDepth;
			}else{
				return 0;
			}
		}
	}

	public void update(){
		for(UMLCoreObserver observer:observersList){
			observer.update();
		}
	}

	public UMLObject getUmlObject(int x, int y) {
		int [] keys=getNotEmptyLayers();
		for(int key:keys){
			List<UMLObject> list=objectLayers.get(key);
			for(UMLObject object:list){
				if(isInit(x,y, object.getObjectState()))
					return object;
			}
		}
		return null;
	}
	private boolean isInit(int x,int y,ObjectState classState){
		int nowX=classState.getX();
		int nowY=classState.getY();
		int sizeW=classState.getSizeW();
		int sizeH=classState.getSizeH();
		if(x>=nowX&&x<=nowX+sizeW && y>=nowY&&y<=nowY+sizeH){
			System.out.println("inin");
			return true;
		}
		return false;
	}
}
