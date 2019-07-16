import java.awt.*;

public class SimpleColorMenu extends ColorBoxElement{
    public SimpleColorMenu(String name, Color color, Mediator med){
        this.color=color;
        this.name=name;
        this.med=med;
    }

    public void setColor(){
//        setColor(this.color);
    }

    @Override
    public String toString() {
        return name;
    }
}
