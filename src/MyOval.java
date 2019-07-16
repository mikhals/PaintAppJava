import java.awt.*;
import java.awt.geom.Area;
import java.awt.geom.Ellipse2D;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyOval extends MyDrawing{

    public MyOval( int xpt, int ypt){
        super();
        setLocation(xpt,ypt);
    }

    public MyOval(int xpt, int ypt, int wpt, int hpt) {
        this(xpt,ypt);
        setSize(wpt, hpt);

    }
    public MyOval(int xpt, int ypt, int wpt, int hpt, Color c) {
        this(xpt, ypt, wpt, hpt);
        setFillColor(c);
    }

    @Override
    public boolean contains(int x, int y) {
        return super.contains(x, y);
    }

    @Override
    public void setRegion() {
        region = new Area(new Ellipse2D.Double(getX(),getY(),getW(),getH()));
    }

    public void draw(Graphics g){
        int x = getX();
        int y = getY();
        int w = getW();
        int h = getH();

//        System.out.printf("%d %d %d %d\n",x,y,w,h);

        if(w<0){
            x += w;
            w *= -1;
        }

        if( h < 0 ){
            y += h;
            h *= -1;
        }

        Graphics2D g2 = (Graphics2D) g;


//        if (getBold()){
//            setLineWidth(2);
//        }
//
//        if(getDashed()){
//            if(getStroke() == 0){
//                g2.setStroke(new MyDashedStroke(getLineWidth()));
//            }else if(getStroke() == 1){
//                g2.setStroke(new MyDashedStroke2(getLineWidth()));
//            }
//        }
//        else{
//            g2.setStroke(new BasicStroke(getLineWidth()));
//        }
//
        if(getShadow()){
            g2.setColor(Color.BLACK);
            g2.fillOval(x+shadowOffset,y+shadowOffset,w,h);
            g2.setColor(getLineColor());
            g2.drawOval(x+shadowOffset,y+shadowOffset,w,h);
        }

        g2.setStroke(getStroke());
        g2.setColor(getFillColor());
        g2.fillOval(x,y,w,h);
        g2.setColor(getLineColor());
        g2.drawOval(x,y,w,h);


        if(getSelected()){
            super.draw(g);
        }


    }

    @Override
    public String toString() {
        return "Oval";
    }

    private void writeObject(ObjectOutputStream out){

    }

    private void readObject(ObjectInputStream in){
//        region = new Rectangle(getX(),getY(),getW(),getH());
        setRegion();
        setStroke(new BasicStroke(getLineWidth()));

    }
}
