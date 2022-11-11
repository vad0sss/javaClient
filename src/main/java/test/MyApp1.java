package test;

import org.mini.apploader.GApplication;
import org.mini.gui.*;
import org.mini.gui.event.GActionListener;
import org.mini.layout.UITemplate;
import org.mini.layout.XContainer;
import org.mini.layout.XEventHandler;
import org.mini.layout.XmlExtAssist;

import static org.mini.nanovg.Nanovg.*;

/**
 * @author gust
 */
public class MyApp1 extends GApplication {

    GForm form;
    public GViewPort gameView;
    XEventHandler eventHandler;
    Game mCanvas;

    @Override
    public GForm getForm() {
        if (form != null) {
            return form;
        }
        form = new GForm(null);

        showGame();

        form.setSizeChangeListener((width, height) -> {
            if (mCanvas != null ) {
                mCanvas.setSize(width,height);
                mCanvas.reSize();
                //System.out.println("resize "+width +" "+ height);
            }
        });
        return form;
    }

    public void showGame(){
        final GContainer gcontainer =  getCanvasPanel();
        form.add((GObject)gcontainer);
    }

    public GContainer getCanvasPanel() {
        if(gameView==null){
            final String xmlStr = GToolkit.readFileFromJarAsString("/res/GameCanvas.xml", "utf-8");
            final UITemplate uit = new UITemplate(xmlStr);

            final XContainer xc = (XContainer)XContainer.parseXml(uit.parse(),new XmlExtAssist(form));
            int screenW = GCallBack.getInstance().getDeviceWidth();
            int screenH = GCallBack.getInstance().getDeviceHeight();
            xc.build((int)screenW, (int)screenH, (XEventHandler)eventHandler);

            this.gameView = (GViewPort)xc.getGui();

            System.out.println("-w:"+screenW+" h:"+screenH);

            this.mCanvas = new Game(form, 0, 0, 100, 100);
            this.mCanvas.setSize(gameView.getW(), gameView.getH());
            gameView.add((GObject)this.mCanvas);
        }
        return (GContainer)this.gameView;
    }
    public class eventHandler extends XEventHandler {
        public void action(final GObject gobj) {
        }

    }
}
