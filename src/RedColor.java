import java.awt.*;

public class RedColor extends ColorBoxElement{
    public RedColor(String name){
        setName(name);
        setColor(Color.red);
    }

    @Override
    public String toString() {
        return name;
    }
}
