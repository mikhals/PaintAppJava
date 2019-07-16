import javax.swing.*;
import java.awt.*;

public class OthersColorMenu extends ColorBoxElement {
    public OthersColorMenu(String name, Color color, Mediator med){
        this.color=color;
        this.name=name;
        this.med=med;
    }

    public void setColor(){
        Color initial = this.color;
        Color new_color = JColorChooser.showDialog(null,"Select Color", initial);
        if(new_color != null ){
            setColor(new_color);
        }
    }

    @Override
    public String toString() {
        return name;
    }
}
