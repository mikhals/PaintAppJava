import java.awt.*;

public class SelectRectDrawing extends MyDrawing {

    public SelectRectDrawing(int xpt, int ypt){
        super();
        setLocation(xpt,ypt);
    }

    public SelectRectDrawing(int xpt, int ypt, int wpt, int hpt) {
        this(xpt,ypt);
        setSize(wpt, hpt);

    }
    public SelectRectDrawing(int xpt, int ypt, int wpt, int hpt, Color c) {
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
        MyStroke stroke = new MyStroke();
        g2.setStroke(stroke.getDashedStroke(getLineWidth()));
        g2.setColor(getLineColor());
        g2.drawRect(x,y,w,h);

    }
}