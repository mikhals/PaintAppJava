import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.Vector;

public class LoadButton extends JButton {
    Mediator med;

    public LoadButton(Mediator med){
        super();
        setMnemonic('l');
        setToolTipText("Load save file (Alt+L)");
        try{
            Image img = ImageIO.read(getClass().getResource("resources/load.png"));
            setIcon(new ImageIcon(img));
        }catch (Exception ex){
            System.out.println(ex);
        }
        this.med = med;
        addActionListener(new LoadListener());

    }

    class LoadListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileNameExtensionFilter("My Paint Application Save", med.fileExtension));
                int returnVal = fc.showOpenDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    File file = fc.getSelectedFile();
                    FileInputStream fin = new FileInputStream(file);
                    ObjectInputStream in = new ObjectInputStream(fin);
                    med.drawings = (Vector<MyDrawing>)in.readObject();
                    fin.close();
                    med.setStatusText("Loaded from file: " + file);
                }

            } catch (Exception ex){
                System.out.println(ex);
            }
//            med.setStroke(med.getStroke());
            med.repaint();
        }
    }
}
