import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CopyButton extends JButton {
    Mediator med;

    public CopyButton(Mediator med){
        super("Copy");
        this.med = med;
        addActionListener(new CopyListener());
    }

    class CopyListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try {
                med.setState(new CopyState(med) );
                if(med.getSelectedDrawing() != null){
                    med.copy();
                }else if(!med.selectedDrawings.isEmpty()){
                    med.copy();
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
