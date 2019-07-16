public class StripeHState extends State {
    Mediator med;



    public StripeHState(Mediator med){
        this.med = med;
    }
    public void mouseDown(int x, int y){
        /*
        MyRectangle rect = new MyRectangle(x,y);
        rect.setDashed(med.getDashed());
        med.addDrawing(rect);//for click

         */

        MyStripeH stripeH = new MyStripeH(x,y);
        stripeH.setFillColor(med.getColor());
        stripeH.setDashed(med.getDashed());
//        stripeH.setBold(med.getBold());
        stripeH.setLineWidth(med.getLineWidth());
        stripeH.setShadow(med.getShadow());
        stripeH.setStroke(med.getStroke());
        med.addDrawing(stripeH);


    }

    @Override
    public void mouseDrag(int x, int y) {

        int _x = med.getLastDrawing().getX();
        int _y = med.getLastDrawing().getY();
        int _w = x -_x;
        int _h = y - _y;
        med.getLastDrawing().setSize(_w,_h);
        int tmpw = _w;if(tmpw<0){tmpw*=-1;}
        int tmph = _h;if(tmph<0){tmph*=-1;}
        med.setStatusText(toString()+"(Width:"+tmpw+",Height:"+tmph+")");
    }

    @Override
    public String toString() {
        return "Horizontal Stripe";
    }
}
