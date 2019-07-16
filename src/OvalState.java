import javax.print.attribute.standard.Media;

import static java.lang.Math.abs;
import static java.lang.Math.min;

public class OvalState extends State {
    Mediator med;

    public OvalState(Mediator med){
        this.med = med;
    }

    public void mouseDown(int x, int y){
        MyOval oval = new MyOval(x,y);
        oval.getPivot().setLocation(x,y);
        oval.setFillColor(med.getColor());
//        oval.setDashed(med.getDashed());
////        oval.setBold(med.getBold());
        oval.setLineWidth(med.getLineWidth());
        oval.setShadow(med.getShadow());
        oval.setStroke(med.getStroke());
        med.addDrawing(oval);


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
        return "Oval";
    }
}
