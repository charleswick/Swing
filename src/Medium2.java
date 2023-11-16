import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Medium2 {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JPanel controlFrame;
    private JMenuBar mb;
    private JMenu file, edit, help, more;
    private JMenuItem cut, copy, paste, selectAll, share;
    private JTextArea ta; //typing area
    private int WIDTH=800;
    private int HEIGHT=700;


    public Medium2() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Medium2 Medium2 = new Medium2();
        Medium2.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(3,3));
        controlFrame = new JPanel();
        controlFrame.setLayout(new BorderLayout());



        //menu at top
//      cut = new JMenuItem("cut");
//        copy = new JMenuItem("copy");
//        paste = new JMenuItem("paste");
//        share = new JMenuItem("share");
//        selectAll = new JMenuItem("selectAll");
//        cut.addActionListener(this);
//        copy.addActionListener(this);
//        paste.addActionListener(this);
//        share.addActionListener(this);
//        selectAll.addActionListener(this);

//        mb = new JMenuBar();
//        file = new JMenu("File");
//        edit = new JMenu("Edit");
//        help = new JMenu("Help");
//        more = new JMenu("More");
//        edit.add(cut);
//        edit.add(copy);
//        edit.add(paste);
//        edit.add(selectAll);
//        more.add(share);
//        mb.add(file);
//        mb.add(edit);
//        mb.add(help);
//        mb.add(more);
//        //end menu at top
//
//        ta = new JTextArea();
//        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
//        mainFrame.add(mb);  //add menu bar


//        mainFrame.add(ta);//add typing area
//        mainFrame.setJMenuBar(mb); //set menu bar
//
//        statusLabel = new JLabel("", JLabel.CENTER);
//        statusLabel.setSize(350, 100);
//            controlPanel = new JPanel();
//            controlPanel.setLayout(new BorderLayout()); //set the layout of the pannel
//
//            mainFrame.add(controlPanel);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
//        controlPanel = new JPanel();
//        controlPanel.setLayout(new FlowLayout()); //set the layout of the pannel
//
//        mainFrame.add(controlPanel);
        //mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton okButton = new JButton("button1");
        JButton submitButton = new JButton("button2");
        JButton cancelButton = new JButton("button3");
        //JButton StopButton = new JButton("Stop");
        JButton button4 = new JButton("button4");
        JButton button5 = new JButton("button5");

        JButton label1 = new JButton("label1");
        JButton label2 = new JButton("label2");
        JButton label3 = new JButton("label3");
        JButton label4 = new JButton("label4");
        JButton label5 = new JButton("label5");

        JButton label6 = new JButton("label6");








//        okButton.setActionCommand("OK");
//        submitButton.setActionCommand("Submit");
//        cancelButton.setActionCommand("Cancel");
//        StopButton.setActionCommand("Stop");
//
//        okButton.addActionListener(new Easy1.ButtonClickListener());
//        submitButton.addActionListener(new Easy1.ButtonClickListener());
//        cancelButton.addActionListener(new Easy1.ButtonClickListener());
//        StopButton.addActionListener(new Easy1.ButtonClickListener());
//
//
//
        mainFrame.add(button4);
        mainFrame.add(button5);
        mainFrame.add(label1);
        mainFrame.add(label2);
        mainFrame.add(controlFrame);
        controlFrame.add(okButton,BorderLayout.WEST);
        controlFrame.add(submitButton, BorderLayout.EAST);
        controlFrame.add(cancelButton,BorderLayout.SOUTH);

        mainFrame.add(label3);
        mainFrame.add(label4);
        mainFrame.add(label5);
        mainFrame.add(label6);


        // mainFrame.add(StopButton);

       // mainFrame.add(label1,BorderLayout.NORTH);
        //mainFrame.add(label2,BorderLayout.SOUTH);
//            controlFrame.add(l,BorderLayout.CENTER);



        //   mainFrame.setVisible(true);


        controlFrame.setVisible(true);
        mainFrame.setVisible(true);

    }

  //  @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == cut)
            ta.cut();
        if (e.getSource() == paste)
            ta.paste();
        if (e.getSource() == copy)
            ta.copy();
        if (e.getSource() == selectAll)
            ta.selectAll();
    }

//    private class ButtonClickListener implements ActionListener {
//        public void actionPerformed(ActionEvent e) {
//            String command = e.getActionCommand();
//
//            if (command.equals("OK")) {
//                statusLabel.setText("Ok Button clicked.");
//            } else if (command.equals("Submit")) {
//                statusLabel.setText("Submit Button clicked.");
//            } else if (command.equals("Cancel")){
//                statusLabel.setText("Cancel Button clicked.");
//            }
//            else if(command.equals("Stop")
//            ) {
//                statusLabel.setText("Stop Button Clicked");
//            }
//        }
//    }
}
