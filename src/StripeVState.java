public class StripeVState extends State {
    Mediator med;

    public StripeVState(Mediator med){
        this.med = med;
    }

    @Override
    public void mouseDown(int x, int y) {
        MyStripeV stripeV = new MyStripeV(x,y);
        stripeV.setFillColor(med.getColor());
        stripeV.setDashed(med.getDashed());
//        stripeV.setBold(med.getBold());
        stripeV.setLineWidth(med.getLineWidth());
        stripeV.setShadow(med.getShadow());
        stripeV.setStroke(med.getStroke());
        med.addDrawing(stripeV);
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
        return "Vertical Stripe";
    }
}
