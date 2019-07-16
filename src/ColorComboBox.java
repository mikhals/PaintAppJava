import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ColorComboBox extends JComboBox implements ActionListener {
    Mediator med;
    ColorBoxElement selected;

//    static ColorMenu blue = new ColorMenu("Blue");
//    static ColorMenu green = new ColorMenu("Green");
//    static ColorMenu black = new ColorMenu("Black");
//    static ColorMenu white = new ColorMenu("White");
//    static ColorMenu others = new ColorMenu("Others..");

//    private  ColorMenu[] colors={
//            red,
//            blue
//    };

    public ColorComboBox(Mediator med){
        super();
        this.med = med;
        addActionListener(this);

        SimpleColorMenu red = new SimpleColorMenu("Red", Color.red, med);
        SimpleColorMenu blue = new SimpleColorMenu("Blue", Color.blue, med);
        SimpleColorMenu green = new SimpleColorMenu("Green", Color.green, med);
        SimpleColorMenu black = new SimpleColorMenu("Black", Color.black, med);
        SimpleColorMenu white = new SimpleColorMenu("White", Color.white, med);
        OthersColorMenu others = new OthersColorMenu("Others", med.default_color,med);

        addItem(white);
        addItem(red);
        addItem(blue);
        addItem(green);
        addItem(black);
        addItem(others);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JComboBox comboBox =(JComboBox)e.getSource();
        selected = (ColorBoxElement)comboBox.getSelectedItem();

        selected.setColor();

        med.setFillColor(selected.color);

    }
}