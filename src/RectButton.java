import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RectButton extends JButton {

	Mediator med;

	public RectButton(Mediator med){
		super("Rectangle");

		addActionListener(new RectListener());

		this.med = med;
	}

	class RectListener implements ActionListener{
		public void actionPerformed(ActionEvent e){
			med.setState(new RectState(med));

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
