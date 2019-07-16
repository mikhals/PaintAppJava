import java.awt.*;
import java.awt.geom.Area;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyStripeH extends MyDrawing {

    public MyStripeH(int xpt, int ypt) {
        super();
        setLocation(xpt, ypt);
    }
    public MyStripeH(int xpt, int ypt, int wpt, int hpt) {
        this(xpt,ypt);
        setSize(wpt, hpt);
    }

    @Override
    public void setRegion() {
        region = new Area(new Rectangle(getX(),getY(),getW(),getH()));
    }

    public MyStripeH(int xpt, int ypt, int wpt, int hpt, Color c) {
        this(xpt, ypt, wpt, hpt);
        setFillColor(c);
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

//            if (getBold()){
//                setLineWidth(2);
//            }

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
                g2.fillRect(x+shadowOffset, y + (h/10 * i)+shadowOffset, w, h/10);
                g2.setColor(getLineColor());
                g2.drawRect(x+shadowOffset, y + (h/10 * i)+shadowOffset, w , h/10);
            }

            g2.setColor(getFillColor());
            g2.fillRect(x, y + (h/10 * i), w, h/10);
            g2.setColor(getLineColor());
            g2.drawRect(x, y + (h/10 * i), w , h/10);

            if(getSelected()){
                super.draw(g);
            }

        }
    }

    @Override
    public String toString() {
        return "Horizontal Stripe";
    }

    private void writeObject(ObjectOutputStream out){

    }

    private void readObject(ObjectInputStream in){
//        region = new Rectangle(getX(),getY(),getW(),getH());
        setRegion();
        setStroke(new BasicStroke(getLineWidth()));

    }
}
