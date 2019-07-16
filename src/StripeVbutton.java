import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StripeVbutton extends JButton {
    Mediator med;

    public StripeVbutton(Mediator med){
        super("Vertical Stripe");

        addActionListener(new StripeVListener());

        this.med = med;
    }

    class StripeVListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            med.setState(new StripeVState(med));
        }
    }
}
