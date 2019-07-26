import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Enumeration;


class MyApplication extends JFrame{

//    private JMenuBar menuBar;
//    private JMenu colorMenu;
//    private JMenuItem redItem, blueItem, greenItem;


    //    StateManager med;
    MyCanvas canvas;
    Mediator med;

    public MyApplication() {
        super("My Paint Application");

//        menuBar = new JMenuBar();
//        setJMenuBar(menuBar);
//
//        colorMenu = new JMenu("Color");
//        redItem = new JMenuItem("Red");
//        blueItem = new JMenuItem("Blue");
//        greenItem = new JMenuItem("Green");
//        colorMenu.add(redItem);
//        colorMenu.add(blueItem);
//        colorMenu.add(greenItem);
//        redItem.addActionListener(this);
//        blueItem.addActionListener(this);
//        greenItem.addActionListener(this);
//
//        menuBar.add(colorMenu);




        canvas = new MyCanvas();
        canvas.setFocusable(true);
//        canvas.setBackground(Color.white);

        JPanel jp = new JPanel();
//        JFrame jp = new JFrame();
        jp.setLayout(new FlowLayout());

        med = canvas.getMediator();
//        med = new Mediator(canvas);
//        med = new StateManager(canvas);

//        JLabel stateText = new JLabel("Hello");
//        jp.add(stateText);

        SelectButton selectButton = new SelectButton(med);
        jp.add(selectButton);

        RectButton rectButton = new RectButton(med);
        jp.add(rectButton);

        OvalButton ovalButton = new OvalButton(med);
        jp.add(ovalButton);


        StripeHButton stripeHButton = new StripeHButton(med);
        jp.add(stripeHButton);

        StripeVbutton stripeVbutton = new StripeVbutton(med);
        jp.add(stripeVbutton);

        HendaButton hendaButton = new HendaButton(med);
        jp.add(hendaButton);
//
//        MyColorPopup ColorButton = new MyColorPopup(med);
//        jp.add(ColorButton);
        jp.add(new JLabel("Shape Color:"));
        jp.add(new ColorComboBox(med));

        jp.add(new CopyButton(med));

        jp.add(new CutButton(med));

        jp.add(new JLabel("Line Width:"));
        jp.add(new MyLineWSpinner(med));

        jp.add(new SaveButton(med));

        jp.add(new LoadButton(med));


        JCheckBox shadowCheck = new JCheckBox("Shadow");
        shadowCheck.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {//todo Change checkbox according med.selectedDrawing.getShadow
                int state = e.getStateChange();
                if (state == ItemEvent.SELECTED) {
                    med.setShadow(true);
                    if(!med.selectedDrawings.isEmpty()){
                        Enumeration<MyDrawing> enumeration = med.selectedDrawings.elements();
                        while(enumeration.hasMoreElements()){
                            enumeration.nextElement().setShadow(med.isShadow);
                        }
                    }
                    if(med.getSelectedDrawing()!=null){
                        med.selectedDrawing.setShadow(true);
                    }

                } else {
                    med.setShadow(false);
                    if(!med.selectedDrawings.isEmpty()){
                        Enumeration<MyDrawing> enumeration = med.selectedDrawings.elements();
                        while(enumeration.hasMoreElements()){
                            enumeration.nextElement().setShadow(med.isShadow);
                        }
                    }
                    if(med.getSelectedDrawing()!=null){
                        med.selectedDrawing.setShadow(false);
                    }

                }
                med.repaint();
            }
        });
        jp.add(shadowCheck);


        getContentPane().setLayout(new BorderLayout());
        jp.setPreferredSize(new Dimension(canvas.getWidth(),80));
        getContentPane().add(jp, BorderLayout.NORTH);

        getContentPane().add(canvas, BorderLayout.CENTER);

        JPanel statusPanel = new JPanel();
        statusPanel.setPreferredSize(new Dimension(canvas.getWidth(),20));
        statusPanel.setLayout(new BoxLayout(statusPanel,BoxLayout.X_AXIS));
        JLabel statusLabel = new JLabel(med.toString());
        statusLabel.setHorizontalAlignment(SwingConstants.LEFT);
        statusPanel.add(statusLabel);
        getContentPane().add(statusPanel,BorderLayout.SOUTH);
        med.setStatusLabel(statusLabel);



        canvas.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                canvas.requestFocusInWindow();


                med.mouseDown(e.getX(), e.getY());

            }

            @Override
            public void mouseReleased(MouseEvent e) {

                med.mouseUp(e.getX(),e.getY());
            }
        });

        canvas.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {


                med.mouseDrag(e.getX(), e.getY());
                med.repaint();
            }

            @Override
            public void mouseMoved(MouseEvent e) {

            }
        });


        this.addWindowListener(
                new WindowAdapter() {
                    @Override
                    public void windowClosing(WindowEvent e) {
                        super.windowClosing(e);
                        System.exit(1);
                    }
                }
        );

        canvas.addKeyListener(new MyKeyListener(med));

//        //////////////////
//        JColorChooser chooser = new JColorChooser();
//        jp.add(chooser);





    }

    public static void centerWindow(Window frame) {
        Dimension dimension = Toolkit.getDefaultToolkit().getScreenSize();
        int x = (int) ((dimension.getWidth() - frame.getWidth()) / 2);
        int y = (int) ((dimension.getHeight() - frame.getHeight()) / 2);
        frame.setLocation(x, y);
    }


    public Dimension getPreferredSize() {
        return new Dimension(1200, 500);
    }

    public static void main(String[] args) {
        MyApplication app = new MyApplication();
        app.pack();
        centerWindow(app);
        app.setVisible(true);
    }

//    @Override
//    public void actionPerformed(ActionEvent e) {
//        if(e.getSource() == redItem){
//            med.setColor(Color.red);
//
//        }else if(e.getSource() == blueItem){
//            med.setColor(Color.blue);
//        }else if(e.getSource() == greenItem){
//            med.setColor(Color.green);
//        }
//    }
}