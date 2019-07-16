import javax.swing.*;
import java.awt.*;
import java.util.Enumeration;
import java.util.Vector;


public class Mediator {
    Vector<MyDrawing> drawings;
    MyCanvas canvas;
    MyDrawing selectedDrawing = null;
    Vector<MyDrawing> selectedDrawings = new Vector<>();
    Color default_color = Color.white;
    JLabel statusLabel = null;

    State s = null;
    boolean isDashed = false;
    boolean isBold = false;
    boolean isShadow = false;
    Color color = Color.white;
    int lineWidth = 1;
    String fileExtension = "paint";


    MyStroke myStroke = new MyStroke();
    BasicStroke stroke = myStroke.getDefaultStroke(lineWidth);
    ColorBoxElement cbe = null;

    MyDrawing buffer = null;
    Vector<MyDrawing> buffers = new Vector<>();

    public Mediator(MyCanvas canvas) {
        this.canvas = canvas;
        drawings = new Vector<MyDrawing>();

    }

    public Enumeration<MyDrawing> drawingsElements() {
        return drawings.elements();
    }

    public void addDrawing(MyDrawing d) {
        drawings.add(d);
//        setSelectedDrawing(d);
        repaint();
    }

    public void removeDrawing(MyDrawing d) {
        drawings.remove(d);
        repaint();
    }

    public void setSelectedDrawing(MyDrawing d) {
        selectedDrawing = d;
    }

    public void addSelectedDrawings(MyDrawing d){ selectedDrawings.add(d);}

    public MyDrawing getSelectedDrawing() {
        return selectedDrawing;
    }

    public void move(int dx, int dy) {
        if (!selectedDrawings.isEmpty()){
            Enumeration<MyDrawing> e = selectedDrawings.elements();
            while (e.hasMoreElements()){
                MyDrawing d = e.nextElement();
                d.move(dx,dy);

            }

        }

    }

    public void repaint() {
        canvas.repaint();
    }

    public void setSelected(int x, int y) {
        Enumeration<MyDrawing> e = drawingsElements();
        MyDrawing last_selected = null;
        selectedDrawings.clear();
        while (e.hasMoreElements()) {
            MyDrawing d = e.nextElement();
            if (d.contains(x, y)) {
                if (last_selected != null) {
                    last_selected.setSelected(false);
                    selectedDrawings.remove(last_selected);
                }

                d.setSelected(true); //new implementation
                setSelectedDrawing(d);

                if(!selectedDrawings.contains(d)){
                    if(d.getClass() != SelectRectDrawing.class){
                        selectedDrawings.add(d);
                        d.setSelected(true);
                    }
                }

                last_selected = d;
            } else {
                d.setSelected(false);
                selectedDrawings.remove(d);

            }

            if(last_selected == null){
                setSelectedDrawing(null);
                selectedDrawings.clear();
            }
        }
        if(selectedDrawings.isEmpty()){
            setStatusText("Nothing is selected. Please drag to select");
            selectedDrawings.clear();
        }
//        setSelected(int x, int y)メソッドは、点(x, y)にある図形を選択状態にするためのものです。 drawingsに図形を追加する順番と表示される順番を考慮して、点(x, y)を含む図形が複数ある場合は一番手前にある図形を選択状態にできるように注意して実装する必要があるでしょう。

    }

    public void setSelected(Rectangle rect){
        Enumeration<MyDrawing> e = drawingsElements();
        while (e.hasMoreElements()) {
            MyDrawing d = e.nextElement();
            if (rect.contains(d.region.getBounds())) {

                if(!selectedDrawings.contains(d)){
                    if(d.getClass() != SelectRectDrawing.class){
                        selectedDrawings.add(d);
                        d.setSelected(true);
                    }
                }
                //debug

            } else {
                selectedDrawings.remove(d);
                d.setSelected(false);
            }

        }
        //debug
    }//  region type Shape class


    ///////////////////////////
    public void setState(State s) {
        statusLabel.setText(s.toString());
        this.s = s;
    }

    public void mouseDown(int x, int y) {
        if (s != null) {
            s.mouseDown(x, y);

        }


    }

    public void mouseUp(int x, int y) {
        if (s != null) {
            s.mouseUp(x, y);

        }
    }

    public void mouseDrag(int x, int y) {
        if (s != null) {
            s.mouseDrag(x, y);
        }

    }

    public MyDrawing getLastDrawing() {
        return drawings.lastElement();
    }

    public boolean getDashed() {
        return isDashed;
    }

    public void setDashed(boolean b) {
        isDashed = b;
    }

    public boolean getBold() {
        return isBold;
    }

    public void setBold(boolean b) {
        isBold = b;
    }

    public boolean getShadow() {
        return isShadow;
    }

    public void setShadow(boolean b) {
        isShadow = b;
    }

    public void setColor(Color color) {
        this.color = color;

    }

    public Color getColor() {
        return color;
    }

    public void setStroke(BasicStroke stroke) {
        this.stroke = stroke;

    }
//
    public BasicStroke getStroke() {
        BasicStroke stroke = new BasicStroke(getLineWidth());
        return stroke;
    }

    public void setLineWidth(int lineWidth) {

        this.lineWidth = lineWidth;

        if(!selectedDrawings.isEmpty()){
            Enumeration<MyDrawing> e = selectedDrawings.elements();
            while(e.hasMoreElements()){
                MyDrawing d = e.nextElement();
                d.setLineWidth(lineWidth);
                d.setStroke(getStroke());
            }
        }
        repaint();

//        this.setStroke(myStroke.getStroke());
//


    }

    public int getLineWidth() {
        return lineWidth;
    }

    public void setCbe(ColorBoxElement cbe) {
        this.cbe = cbe;
    }

    public void setFillColor(Color color){
        setColor(color);

//        if(selectedDrawing != null){
//            selectedDrawing.setFillColor(color);
//            repaint();
//        }
        if(!selectedDrawings.isEmpty()){
            Enumeration<MyDrawing> e = selectedDrawings.elements();
            while(e.hasMoreElements()){
                e.nextElement().setFillColor(color);
            }
        }
        repaint();
    }

    public void clearBuffer(){
        buffer = null;
        buffers.clear();
    }

    public void copy() throws CloneNotSupportedException {
        if(selectedDrawing!=null){
            clearBuffer();
            buffer = selectedDrawing.clone();
            buffer.setSelected(false);
            setStatusText("Copied to buffer. Ready to be paste");
        }

        if(!selectedDrawings.isEmpty()){
            clearBuffer();
            buffers = (Vector<MyDrawing>)selectedDrawings.clone();
            setStatusText("Copied to buffer. Ready to be paste");
        }

    }

    public void cut() throws CloneNotSupportedException {
        if (selectedDrawing != null) {
            clearBuffer();
            buffer = selectedDrawing.clone();
            buffer.setSelected(false);
            removeDrawing(selectedDrawing);
            setStatusText("Cut to buffer. Ready to be paste");
        }
        if(!selectedDrawings.isEmpty()){
            clearBuffer();
            copy();
            Enumeration<MyDrawing> e = selectedDrawings.elements();
            while (e.hasMoreElements()){
                drawings.remove(e.nextElement());
            }
            repaint();
            setStatusText("Cut to buffer. Ready to be paste");
        }
    }

    public void paste(int x,int y){
        try {
            if(buffer != null){
                MyDrawing clone = (MyDrawing)buffer.clone();
                clone.setLocation(x,y);
                addDrawing(clone);
                repaint();
            }
            if(!buffers.isEmpty()){
                Point upleft = new Point(Integer.MAX_VALUE,Integer.MAX_VALUE);//topleft coordinate
                Point downright = new Point(0,0);//downright coordinate

                Vector<MyDrawing> tmp_vector = (Vector<MyDrawing>)buffers.clone();
                Enumeration<MyDrawing> tmp_enumeration = tmp_vector.elements();
                while (tmp_enumeration.hasMoreElements()){//to get the position of upleft and downright coordinate of clone
                    Point upleft_tmp = (Point)upleft.clone();
                    Point downright_tmp = (Point)downright.clone();
                    MyDrawing d = tmp_enumeration.nextElement().clone();
                    upleft.setLocation(Math.min(upleft_tmp.getX(),d.getX()),Math.min(upleft_tmp.getY(),d.getY()));
                    downright.setLocation(Math.max(downright_tmp.getX(),d.getX()+d.getW()),Math.max(downright_tmp.getY(),d.getY()+d.getH()));
                }

                Vector<MyDrawing> clone = (Vector<MyDrawing>)buffers.clone();
                Enumeration<MyDrawing> e = clone.elements();
                while (e.hasMoreElements()){
                    MyDrawing d = e.nextElement().clone();
                    d.setSelected(false);
                    int xoffset = d.getX() - (int)downright.getX();
                    int yoffset = d.getY() - (int)downright.getY();
                    d.setLocation( x + xoffset,y + yoffset);
                    addDrawing(d);
                }
            }
            repaint();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String toString() {
        if(s==null){
            return "Status Bar";
        }
        else{
            return s.toString();
        }
    }

    public JLabel getStatusLabel() {
        return statusLabel;
    }

    public void setStatusLabel(JLabel statusLabel) {
        this.statusLabel = statusLabel;
    }

    public void setStatusText(String text){
        statusLabel.setText(text);
    }

}
