package test;

import org.mini.gui.GCanvas;
import org.mini.gui.GForm;
import org.mini.gui.GGraphics;
import org.mini.gui.GImage;


public final class Game extends GCanvas {
    long timePaint;
    GImage gimg;

    public Game(GForm gForm) {
        super(gForm);
        gimg = GImage.createImageFromJar("/res/test.png");

    }

    public Game(GForm gForm, float v, float v1, float v2, float v3) {
        super(gForm, v, v1, v2, v3);
        gimg = GImage.createImageFromJar("/res/test.png");

    }

    public void paint(final GGraphics g) {
        try {
            //System.out.println("paint");
            final long startTime = System.currentTimeMillis();
            final int screenW = (int)this.getW();
            final int screenH = (int)this.getH();

            g.setClip(0,0,screenW,screenH);

            //g.setColor(0);
            g.fillRect(0, 0, screenW, screenH);
            this.timePaint = System.currentTimeMillis() - startTime;
            final int drawY = screenH;

            g.setColor(0);


            g.drawString("java image",0,0,0);
            g.drawImage(gimg, 0, 20, gimg.getWidth(), gimg.getHeight(), GGraphics.LEFT | GGraphics.TOP);

            g.drawString("java image drawRegion",gimg.getWidth() + 50,0,0);

            int imgw = gimg.getWidth();
            int imgh = gimg.getHeight();
            int gx = gimg.getWidth()+50, gy = 120, fw = imgw / 2, fh = imgh / 2;
            g.drawRegion(gimg, 60, 170, 135, 70, GGraphics.TRANS_NONE, gx, gy, GGraphics.TRANS_NONE);
            g.setColor(0xffff00ff);
            //g.drawRect(gx - 2, gy - 2, 5, 5);


        } catch (Exception e) {
            System.out.println("paint ex:");
        }
    }
    public void cursorPosEvent(final int x, final int y) {

    }

}
