public class HendaState extends State {
    Mediator med;

    public HendaState(Mediator med){
        this.med = med;
    }

    @Override
    public void mouseDown(int x, int y) {
        MyHendacagonal henda = new MyHendacagonal(x,y);

        henda.setFillColor(med.getColor());
        henda.setDashed(med.getDashed());
//        henda.setBold(med.getBold());
        henda.setLineWidth(med.getLineWidth());
        henda.setShadow(med.getShadow());
        henda.setStroke(med.getStroke());
        med.addDrawing(henda);
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
        return "Hendacagonal";
    }
}
