import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.util.Enumeration;

public class MyLineWSpinner extends JSpinner {
    Mediator med;
    int MAX_WIDTH = 10;
    int MIN_WIDTH = 1;

    public MyLineWSpinner(Mediator med){
        super();
        this.med = med;
        SpinnerNumberModel model = new SpinnerNumberModel(med.getLineWidth(),MIN_WIDTH,MAX_WIDTH,1);

        setModel(model);
        addChangeListener(new MyListener());

    }

    class MyListener implements ChangeListener{
        @Override
        public void stateChanged(ChangeEvent e) {


            med.setLineWidth((Integer) ((JSpinner) e.getSource()).getValue()); //complicated, but just to getValue to Integer
            if (med.getSelectedDrawing() != null) {
                med.getSelectedDrawing().setLineWidth((Integer) ((JSpinner) e.getSource()).getValue());
            }
            med.repaint();
        }
    }

}
