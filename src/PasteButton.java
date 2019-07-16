import javax.swing.*;

public class PasteButton extends JButton {
    Mediator med;

    public PasteButton(Mediator med){
        super("paste");
        this.med=med;
    }
}
