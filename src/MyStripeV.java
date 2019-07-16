import java.awt.*;
import java.awt.geom.Area;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyStripeV extends MyDrawing {

    public MyStripeV(int xpt, int ypt) {
        super();
        setLocation(xpt, ypt);
    }
    public MyStripeV(int xpt, int ypt, int wpt, int hpt) {
        this(xpt,ypt);
        setSize(wpt, hpt);

    }
    public MyStripeV(int xpt, int ypt, int wpt, int hpt, Color c) {
        this(xpt, ypt, wpt, hpt);
        setFillColor(c);
    }

    @Override
    public void setRegion() {
        region = new Area(new Rectangle(getX(),getY(),getW(),getH()));
    }

    @Override
    public void draw(Graphics g) {
        int x = getX();
        int y = getY();
        int w = getW();
        int h = getH();
        if (w < 0) {
            x += w;
            w *= -1;
        }
        if (h < 0) {
            y += h;
            h *= -1;
        }
        for (int i = 0; i < 10; i++) {

            Graphics2D g2 = (Graphics2D) g;
//            if(getDashed()){
//                if(getStroke() == 0){
//                    g2.setStroke(new MyDashedStroke(getLineWidth()));
//                }else if(getStroke() == 1){
//                    g2.setStroke(new MyDashedStroke2(getLineWidth()));
//                }
//            }
//            else{
//                g2.setStroke(new BasicStroke(getLineWidth()));
//            }
            g2.setStroke(getStroke());
            if(getShadow()){
                g2.setColor(Color.BLACK);
                g2.fillRect(x + (w/10 * i)+shadowOffset, y+shadowOffset, w / 10, h);
                g2.setColor(getLineColor());
                g2.drawRect(x + (w/10 * i)+shadowOffset, y+shadowOffset, w / 10, h);
            }

            g2.setColor(getFillColor());
            g2.fillRect(x + (w/10 * i), y, w / 10, h);
            g2.setColor(getLineColor());
            g2.drawRect(x + (w/10 * i), y, w / 10, h);

        }

        if(getSelected()){
            super.draw(g);
        }


    }

    @Override
    public String toString() {
        return "Vertical Stripe";
    }

    private void writeObject(ObjectOutputStream out){

    }

    private void readObject(ObjectInputStream in){
//        region = new Rectangle(getX(),getY(),getW(),getH());
        setRegion();
        setStroke(new BasicStroke(getLineWidth()));

    }
}
