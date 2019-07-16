import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Enumeration;
import java.util.Vector;

public class MyCanvas extends JPanel {
    Mediator mediator;
//    BufferedImage bi = new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);

    public MyCanvas(){
        this.mediator = new Mediator(this);
        setBackground(Color.white);
    }

    public Mediator getMediator(){
        return mediator;
    }

    public void paint( Graphics g) {
        super.paint(g);

        Enumeration<MyDrawing> e = mediator.drawingsElements();
        while (e.hasMoreElements()){
            MyDrawing d = e.nextElement();
            if(d.getSelected()){
                MyDrawing s = d;
            }
            d.draw(g);

        }

//        super.paint(g);
//        for (MyDrawing d : mediator.drawings) {
//            d.draw(g);
//        }



    }
    /*todo Check canvas(old) vs new canvas, import from canvas(old) to mediator
     */

}
