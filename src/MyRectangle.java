import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class MyRectangle extends MyDrawing {
    public MyRectangle( int xpt, int ypt){
        super();
        setLocation(xpt,ypt);
    }

    public MyRectangle( int xpt, int ypt, int wpt,int hpt) {
        this(xpt,ypt);
        setSize(wpt, hpt);

    }
    public MyRectangle( int xpt, int ypt, int wpt,int hpt,Color c) {
        this(xpt, ypt, wpt, hpt);
        setFillColor(c);
    }


    @Override
    public void setRegion() {
        region=new Rectangle(getX(),getY(),getW(),getH());
    }

    @Override
    public boolean contains(int x, int y) {
        return super.contains(x, y);
    }

    public void draw(Graphics g){
        int x = getX();
        int y = getY();
        int w = getW();
        int h = getH();

        Graphics2D g2 = (Graphics2D) g;

        if(getShadow()){
            g2.setColor(Color.BLACK);
            g2.fillRect(x+shadowOffset,y+shadowOffset,w,h);
            g2.setColor(getLineColor());
            g2.drawRect(x+shadowOffset,y+shadowOffset,w,h);
        }
        g2.setStroke(getStroke());

        g2.setColor(getFillColor());
        g2.fillRect(x,y,w,h);
        g2.setColor(getLineColor());
        g2.drawRect(x,y,w,h);

        if(getSelected()){
            super.draw(g);
        }



    }

    @Override
    public String toString() {
        return "Rectangle";
    }

    private void writeObject(ObjectOutputStream out){

    }

    private void readObject(ObjectInputStream in){
//        region = new Rectangle(getX(),getY(),getW(),getH());
        setRegion();
        setStroke(new BasicStroke(getLineWidth()));

    }
}