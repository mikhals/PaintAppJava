import java.awt.*;
import java.awt.geom.Area;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyHendacagonal extends MyDrawing {
    public MyHendacagonal(int xpt, int ypt){
        super();
        setLocation(xpt,ypt);
    }
    public MyHendacagonal(int xpt, int ypt, int wpt, int hpt) {
        this(xpt,ypt);
        setSize(wpt, hpt);

    }
    public MyHendacagonal(int xpt, int ypt, int wpt, int hpt, Color c) {
        this(xpt, ypt, wpt, hpt);
        setFillColor(c);
    }

    @Override
    public void setRegion() {
        int x = getX();
        int y = getY();
        int w = getW();
        int h = getH();

        int[] x_arr=new int[11];
        int[] y_arr=new int[11];
        for(int i=0;i<11;i++) {//get hendacagonal points
            x_arr[i] = x+(w/2)+(int)(w/2*Math.sin(Math.toRadians(360/11*(i+1))));
            y_arr[i] = y+(h/2)+(int)(h/2*Math.cos(Math.toRadians(360/11*(i+1))));

        }
        region = new Area(new Polygon(x_arr,y_arr,11));
    }

    public void draw(Graphics g){
        int x = getX();
        int y = getY();
        int w = getW();
        int h = getH();

        if(w<0){
            x += w;
            w *= -1;
        }
        if (h < 0) {
            y += h;
            h *= -1;
        }

        //double[] x_arr=new double[11];
        int[] x_arr=new int[11];
        int[] y_arr=new int[11];

        for(int i=0;i<11;i++) {//get hendacagonal points
            x_arr[i] = x+(w/2)+(int)(w/2*Math.sin(Math.toRadians(360/11*(i+1))));
            y_arr[i] = y+(h/2)+(int)(h/2*Math.cos(Math.toRadians(360/11*(i+1))));

        }

        Graphics2D g2 = (Graphics2D)g;

        g2.setStroke(getStroke());

        if(getShadow()){
            int[] x_shadow=new int[11];
            System.arraycopy(x_arr,0,x_shadow,0,x_arr.length);
            for(int i=0; i<x_shadow.length;i++){
                x_shadow[i]+=shadowOffset;
            }
            int[] y_shadow=new int[11];
            System.arraycopy(y_arr,0,y_shadow,0,y_arr.length);
            for(int i=0; i<y_shadow.length;i++){
                y_shadow[i]+=shadowOffset;
            }
            g2.setColor(Color.BLACK);
            g2.fillPolygon(x_shadow,y_shadow,11);
            g2.setColor(getLineColor());
            g2.drawPolygon(x_shadow,y_shadow,11);
        }

        g2.setColor(getFillColor());
        g2.fillPolygon(x_arr,y_arr,11);
        g2.setColor(getLineColor());
        g2.drawPolygon(x_arr,y_arr,11);

        if(getSelected()){
            super.draw(g);
        }


    }

    @Override
    public String toString() {
        return "Hendacagonal";
    }

    private void writeObject(ObjectOutputStream out){

    }

    private void readObject(ObjectInputStream in){
//        region = new Rectangle(getX(),getY(),getW(),getH());
        setRegion();
        setStroke(new BasicStroke(getLineWidth()));

    }

}