import javax.print.attribute.standard.Media;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class RectState extends State {
    //Mediator med;
    Mediator med;



    public RectState(Mediator med){
        this.med = med;
    }
    public void mouseDown(int x, int y){
        /*
        MyRectangle rect = new MyRectangle(x,y);
        rect.setDashed(med.getDashed());
        med.addDrawing(rect);//for click

         */
        MyRectangle rect = new MyRectangle(x,y);
        rect.pivot.setLocation(x,y);
        rect.setFillColor(med.getColor());
//        rect.setDashed(med.getDashed());
        rect.setLineWidth(med.getLineWidth());
//        rect.setBold(med.getBold());
        rect.setShadow(med.getShadow());
        rect.setStroke(med.getStroke());
        med.addDrawing(rect);




    }

    @Override
    public void mouseDrag(int x, int y) {

        int _x = med.getLastDrawing().getPivot().x;
        int _y = med.getLastDrawing().getPivot().y;
        int _w = abs(x -_x);
        int _h = abs(y - _y);

//        System.out.printf("%d %d %d %d\n",_x,_y,_w,_h);

        med.getLastDrawing().setLocation(min(x,_x),min(y,_y));
        med.getLastDrawing().setSize(_w,_h);
        med.setStatusText(toString()+"(Width:"+_w+",Height:"+_h+")");
    }


    @Override
    public String toString() {
        return "Rectangle";
    }
}
