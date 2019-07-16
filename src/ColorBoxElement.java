import java.awt.*;

public class ColorBoxElement {
    String name;
    Color color;
    Mediator med;

    public void setColor(){}

    public void setMed(Mediator med) {
        this.med = med;
    }

    public Mediator getMed() {
        return med;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public Color getColor() {
        return color;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

}
