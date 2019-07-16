import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SelectButton extends JButton {

    Mediator med;

    public SelectButton(Mediator med){
        super("Select");

        addActionListener(new SelectListener());

        this.med = med;
    }

    class SelectListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            med.setState(new SelectState(med));

        }
    }

	/*
	State state;

	public RectButton(State state) {
		super("Rectangle");

		addActionListener(new RectListener());

		this.state = state;
	}

	class RectListener implements ActionListener{
		public void actionPerformed(ActionEvent e) {
			state.setState(State.RECTANGLE);
		}
	}
	 */

}
