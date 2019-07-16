public class CopyState extends SelectState {
    public CopyState(Mediator med){
        super(med);

    }

    @Override
    public void mouseDown(int x, int y) {
        if (med.buffer != null) {
            med.paste(x - med.buffer.getW(), y - med.buffer.getH());
        }
        if(!med.buffers.isEmpty()){
            med.paste(x, y);
        }
    }

    @Override
    public void mouseDrag(int x, int y) {
//        super.mouseDrag(x, y);
    }

    @Override
    public void mouseUp(int x, int y) {

    }

    @Override
    public String toString() {
        return "Copy";
    }
}
