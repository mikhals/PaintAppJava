import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class StrokeComboBox extends JComboBox {
    Mediator med;
    MyStroke myStroke = new MyStroke();
    public StrokeComboBox(Mediator med){
        super();
        addItem("Default Stroke");
        addItem("Stroke 1");
        addItem("Stroke 2");
        setSelectedIndex(0);
        addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                JComboBox cb = (JComboBox)e.getSource();
//                if(cb.getSelectedItem() == "Stroke 1"){
//                    myStroke.setStroke(myStroke.getDashedStroke(med.getLineWidth()));
//                    med.setStroke(myStroke.getStroke());
//                }
//                else if(cb.getSelectedItem() == "Stroke 2"){
//
//                    myStroke.setStroke(myStroke.getDashedStroke2(med.getLineWidth()));
//                    med.setStroke(myStroke.getStroke());
//                }
//                else if(cb.getSelectedItem() == "Default Stroke"){
//
//                    myStroke.setStroke(myStroke.getDefaultStroke(med.getLineWidth()));
//                    med.setStroke(myStroke.getStroke());
//                }
//                else{}

            }
        });

    }
}
