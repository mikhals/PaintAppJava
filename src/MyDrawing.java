import java.awt.*;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class MyDrawing implements Cloneable, Serializable {
    private int x, y, w, h;
    private Color lineColor, fillColor;
    private int lineWidth;
    //task2-10
    private boolean isDashed = false;
    private boolean isBold = false;
    private boolean isShadow = false;
    int shadowOffset = 5;

    transient private BasicStroke stroke = null;

    boolean isSelected = false;
    transient Shape region;
    final int SIZE = 8;

    Point pivot = new Point();

    public MyDrawing(){
        x = y = 0;
        w = h = 40;
        lineColor = Color.black;
        fillColor = Color.white;
        lineWidth = 1;
        stroke=new MyStroke().getDefaultStroke(getLineWidth());
        setRegion();

    }

    public void draw(Graphics g){
        if(isSelected){
            g.setColor((Color.BLACK));
            g.fillRect(x+w/2 - SIZE/2, y-SIZE/2,SIZE,SIZE);
            g.fillRect(x- SIZE/2, y+h/2 -SIZE/2,SIZE,SIZE);
            g.fillRect(x+w/2 - SIZE/2, y+h-SIZE/2,SIZE,SIZE);
            g.fillRect(x+w - SIZE/2, y+h/2-SIZE/2,SIZE,SIZE);
            g.fillRect(x- SIZE/2, y-SIZE/2,SIZE,SIZE);
            g.fillRect(x+ w - SIZE/2, y-SIZE/2,SIZE,SIZE);
            g.fillRect(x- SIZE/2, y+h-SIZE/2,SIZE,SIZE);
            g.fillRect(x+w - SIZE/2, y+h-SIZE/2,SIZE,SIZE);
            g.fillRect(x+w/2 -SIZE/2, y+h/2-SIZE/2,SIZE,SIZE);

        }

    }



    public boolean getSelected(){
        return isSelected;
    }

    public void setSelected(boolean isSelected){
        this.isSelected = isSelected;
    }

    public boolean contains(int x, int y){
        return region.contains(x,y);
    }

    public void setRegion() {
//        region = new Rectangle(x, y, w, h);
    }

    public void move(int dx, int dy){
        x += dx;
        y += dy;
        setRegion();
    }

    public void setLocation( int x, int y){
        this.x = x;
        this.y = y;
        setRegion();

    }

    public void setSize(int w, int h){
        this.w = w;
        this.h = h;
        setRegion();
    }

    public int getX(){
        return x;
    }
    public int getY(){
        return y;
    }
    public int getW(){
        return w;
    }
    public int getH(){
        return h;
    }



    public Color getLineColor(){ return lineColor; }

    public void setLineColor(Color c){ this.lineColor = c; }

    public Color getFillColor(){ return fillColor; }

    public void setFillColor(Color c){
        this.fillColor = c;
    }

    public int getLineWidth(){
        return lineWidth;
    }

    public void setLineWidth(int lineWidth){
        this.lineWidth=lineWidth;
    }

    public void setDashed(boolean b){
        isDashed = b;
    }

    public boolean getDashed(){
        return isDashed;
    }

    public boolean getBold(){return isBold;}

    public void setBold(boolean b){ isBold = b; }

    public boolean getShadow(){return isShadow;}

    public void setShadow(boolean b){ isShadow = b; }

    public void setStroke(BasicStroke stroke){this.stroke=stroke;}

    public BasicStroke getStroke(){return stroke;}

    public Point getPivot() {
        return pivot;
    }


    public MyDrawing clone() throws CloneNotSupportedException {
        return (MyDrawing) super.clone();
    }

}