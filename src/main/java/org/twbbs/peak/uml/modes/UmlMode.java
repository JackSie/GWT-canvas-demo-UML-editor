package org.twbbs.peak.uml.modes;

public interface UmlMode {
    void onClick(int x, int y);
    void startDrag(int x,int y);
    void onDrag(int x,int y);
    void stopDrag(int x,int y);
    void modeChanged();
    void changeName(String name);
    void group(boolean isGroup);
}
