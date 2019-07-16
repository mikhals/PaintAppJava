import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StripeHButton extends JButton {
    Mediator med;

    public StripeHButton(Mediator med) {
        super("Horizontal Stripe");

        addActionListener(new StripeH());

        this.med = med;
    }

    class StripeH implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            med.setState(new StripeHState(med));
        }
    }
}
