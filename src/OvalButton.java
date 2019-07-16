import javax.print.attribute.standard.Media;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


public class OvalButton extends JButton {
    Mediator med;

    public OvalButton(Mediator med){
        super("Oval");
        addActionListener(new OvalListener());
        this.med = med;
    }

    class OvalListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            med.setState(new OvalState(med));
        }
    }

}