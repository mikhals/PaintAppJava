import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HendaButton extends JButton {
    Mediator med;

    public HendaButton(Mediator med){
        super("Hendacagonal");
        addActionListener(new HendaListener());
        this.med = med;
    }

    class HendaListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            med.setState(new HendaState(med));
        }
    }

}
