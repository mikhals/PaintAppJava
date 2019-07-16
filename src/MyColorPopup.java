import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyColorPopup extends JButton {
    Color color = Color.white;
//    Mediator med;

    public MyColorPopup(Mediator med){
        super("Color");
        addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(null,"popup", Color.BLUE);

                if(color != null){
                    setBackground(color);
                    med.setColor(color);
                }
            }
        });
        //this.med = med;
    }

    public Color getColor(){
        return color;
    }
}
