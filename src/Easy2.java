import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Easy2 implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;
    private JMenuBar mb;
    private JMenu file, edit, help, more;
    private JMenuItem cut, copy, paste, selectAll, share;
    private JTextArea ta; //typing area
    private int WIDTH=800;
    private int HEIGHT=700;


    public Easy2() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Easy2 Easy2 = new Easy2();
        Easy2.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new BorderLayout());

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
        mainFrame.add(okButton, BorderLayout.NORTH);
        mainFrame.add(submitButton, BorderLayout.EAST);
        mainFrame.add(cancelButton,BorderLayout.SOUTH);
        // mainFrame.add(StopButton);
        mainFrame.add(button4, BorderLayout.WEST);
        mainFrame.add(button5, BorderLayout.CENTER);

        mainFrame.setVisible(true);
    }

    @Override
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
