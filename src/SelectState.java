import java.awt.*;
import java.util.Enumeration;

public class SelectState extends State {
    Mediator med;
    int x,y;
    Rectangle selectRect = new Rectangle(0,0,0,0);
    float[] selectPattern = {10, 15};
    MyDrawing selectRectDrawing = new SelectRectDrawing(0,0,0,0);
    boolean selectedDrawingClick;



    public SelectState(Mediator med){
        this.med = med;
    }
    public void mouseDown(int x, int y){
        this.x=x;
        this.y=y;
        if(selectedDrawingsClicked(x,y)){
            selectedDrawingClick=true;

        }else{
            selectedDrawingClick=false;
            med.addDrawing(selectRectDrawing);
            med.setSelected(x,y);
            med.repaint();

        }
        med.setStatusText("Selected drawings: "+ med.selectedDrawings);

    }

    @Override
    public void mouseDrag(int x, int y) {
        if(selectedDrawingClick == false){
            int w = Math.abs(x - this.x);
            int h = Math.abs(y - this.y);
            selectRect.setRect(Math.min(this.x,x),Math.min(this.y,y),w,h);
            med.setSelected(selectRect);
            refreshSelector();
            med.repaint();
        }else{
            int dx, dy;
            dx = x - this.x;
            dy = y - this.y;
            this.x += dx;//what is this??
            this.y += dy;
            med.move(dx, dy);
            med.repaint();
        }
        med.setStatusText("Selected drawings: "+ med.selectedDrawings);

    }

    @Override
    public void mouseUp(int x, int y) {
        if((x == this.x) && (y == this.y)){//mouseDown && mouseUp combination, same place
            if(!selectedDrawingsClicked(x, y)){
                med.setSelected(x,y);
            }
        }
        else{//different start and end point (dragged)
            selectedDrawingClick=false;
            int w = Math.abs(x - this.x);
            int h = Math.abs(y - this.y);
//            selectRect.setRect(this.x,this.y,w,h);
            selectRect.setRect(Math.min(this.x,x),Math.min(this.y,y),w,h);
            med.setSelected(selectRect);
            selectRectDrawing.setSize(0,0);
        }
        med.removeDrawing(selectRectDrawing);
        med.repaint();

    }

    public void refreshSelector(){
        selectRectDrawing.setLocation(selectRect.x,selectRect.y);
        selectRectDrawing.setSize(selectRect.width,selectRect.height);
    }

    public boolean selectedDrawingsClicked(int x,int y){
        Enumeration<MyDrawing> e = med.selectedDrawings.elements();
        while(e.hasMoreElements()){
            MyDrawing d = e.nextElement();
            if(d.contains(x,y)){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Select";
    }
}
