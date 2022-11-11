package test;

import org.mini.gui.GCanvas;

import org.mini.gui.GForm;

import org.mini.gui.GGraphics;

import org.mini.gui.GImage;

public final class Game extends GCanvas {

    long timePaint;

    private long[] curTime;

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

            g.setColor(0);

            g.fillRect(0, 0, screenW, screenH);

            this.timePaint = System.currentTimeMillis() - startTime;

            final int drawY = screenH;

            g.setColor(16777215);

            g.drawString("TEST",0,0,36);

            g.drawImage(gimg, 0, 0, gimg.getWidth(), gimg.getHeight(), GGraphics.LEFT | GGraphics.TOP);

        } catch (Exception e) {

            System.out.println("paint ex:");

        }

    }

    public void cursorPosEvent(final int x, final int y) {

        System.out.println("cursorPosEvent");

    }

    private boolean isDelayed(final int waitFor, final byte type) {

        if (this.curTime[type] + waitFor > System.currentTimeMillis()) {

            return false;

        }

        this.curTime[type] = 0L;

        return true;

    }

}

