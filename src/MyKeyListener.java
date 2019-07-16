import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Enumeration;

public class MyKeyListener implements KeyListener {
    Mediator med;

    public MyKeyListener(Mediator med){
        this.med = med;
    }

    @Override
    public void keyPressed(KeyEvent e) {

    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {
        if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
            if(!med.selectedDrawings.isEmpty()){
                Enumeration<MyDrawing> enumeration = med.selectedDrawings.elements();
                while(enumeration.hasMoreElements()){
                    med.removeDrawing(enumeration.nextElement());
                }
                med.setStatusText(med.selectedDrawings.toString() + " removed");
            }
            med.removeDrawing(med.getSelectedDrawing());
            med.repaint();
        }
    }
}
