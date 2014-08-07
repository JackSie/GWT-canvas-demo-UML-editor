package org.twbbs.peak.canvastest.client.objects.draw.behavior;

import com.google.gwt.canvas.dom.client.Context2d;


public class SquareDrawHandler {
    public static final int RADIUSINIT=10;
    protected void drawShape(Context2d context, int x, int y, int sizeW,
            int sizeH) {
        int radius=RADIUSINIT;
        if (sizeW < 2 * radius) {
            radius = sizeW / 2;
        }
        if (sizeH < 2 * radius) {
            radius = sizeH / 2;
        }
        context.beginPath();
        context.moveTo(x+radius, y);
        context.arcTo(x+sizeW, y, x+sizeW, y+sizeH, radius);
        context.arcTo(x+sizeW, y+sizeH, x, y+sizeH, radius);
        context.arcTo(x, y+sizeH, x, y, radius);
        context.arcTo(x, y, x+sizeW, y, radius);
        context.fill();
        context.stroke();
        context.closePath();
    }
}
