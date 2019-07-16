import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CutButton extends JButton {
    Mediator med;

    public CutButton(Mediator med){
        super("Cut");
        addActionListener(new CutListener());
        this.med = med;
    }

    class CutListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                med.setState(new CutState(med) );
                if(med.getSelectedDrawing() != null){
                    med.cut();
                }else if(!med.selectedDrawings.isEmpty()){
                    med.cut();
                }
                else{
//                    JOptionPane.showMessageDialog(med.canvas,"Nothing is selected");
                    med.setStatusText("Nothing is selected, please select something!");
                }
            } catch (CloneNotSupportedException ex) {
                ex.printStackTrace();
            }
        }
    }

}
