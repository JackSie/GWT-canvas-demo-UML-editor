package org.twbbs.peak.uml.object.defaults;


import org.twbbs.peak.uml.object.basic.InterfaceObject;
import org.twbbs.peak.uml.object.state.DefaultInterfaceState;

public class DefaultInterfaceObject extends InterfaceObject{
    public DefaultInterfaceObject(int x,int y) {
        super("unnamed",new DefaultInterfaceState(x, y));
    }
}
