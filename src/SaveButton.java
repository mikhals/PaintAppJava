import javax.imageio.ImageIO;
import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

public class SaveButton extends JButton {
    Mediator med;

    public SaveButton(Mediator med){
//        super("Save");
        super();
        setMnemonic('s');
        setToolTipText("Save to file (Alt+S)");
        try{
            Image img = ImageIO.read(getClass().getResource("resources/save.png"));
            setIcon(new ImageIcon(img));
        }catch (Exception ex){
            System.out.println(ex);
        }
        this.med = med;
        addActionListener(new SaveListener());

    }

    class SaveListener implements ActionListener{
        @Override
        public void actionPerformed(ActionEvent e) {
            try{
                JFileChooser fc = new JFileChooser();
                fc.setFileFilter(new FileNameExtensionFilter("My Paint Application Save", med.fileExtension));
                int returnVal = fc.showSaveDialog(null);
                if(returnVal == JFileChooser.APPROVE_OPTION){
                    String file = fc.getSelectedFile().getAbsolutePath();
                    if(!file.endsWith("."+med.fileExtension)){
                        file = file+"."+med.fileExtension;
                    }
                    FileOutputStream fout = new FileOutputStream(file);
                    ObjectOutputStream out = new ObjectOutputStream(fout);
                    out.writeObject(med.drawings);
                    out.flush();

                    fout.close();
                    med.setStatusText("Saved to file: "+ file);
                }
            } catch (Exception ex){
                System.out.println(ex);
            }
        }
    }

}
