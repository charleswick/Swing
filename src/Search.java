import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Search implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JPanel controlPanel;

    private JMenuBar mb;
    private JMenu file, edit, help, more;
    private JMenuItem cut, copy, paste, selectAll, share;
    private JTextField ta;//typing area
    private JTextField tb;//typing area

    private int WIDTH=800;
    private int HEIGHT=700;


    public Search() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Search search = new Search();
        search.showEventDemo();
    }

    private void prepareGUI() {
        mainFrame = new JFrame("Java SWING Examples");
        mainFrame.setSize(WIDTH, HEIGHT);
        mainFrame.setLayout(new GridLayout(3, 1));

        //menu at top
        cut = new JMenuItem("cut");
        copy = new JMenuItem("copy");
        paste = new JMenuItem("paste");
        share = new JMenuItem("share");
        selectAll = new JMenuItem("selectAll");
        cut.addActionListener(this);
        copy.addActionListener(this);
        paste.addActionListener(this);
        share.addActionListener(this);
        selectAll.addActionListener(this);

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
        //end menu at top

        ta = new JTextField();
        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        tb = new JTextField();
        tb.setBounds(50,5,WIDTH-200, HEIGHT-50);
        //mainFrame.add(mb);  //add menu bar
        mainFrame.add(ta);//add typing area
        mainFrame.add(tb);
       // mainFrame.setJMenuBar(mb); //set menu bar

        statusLabel = new JLabel("", JLabel.CENTER);
        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout()); //set the layout of the pannel

        mainFrame.add(controlPanel);
        mainFrame.add(statusLabel);
        mainFrame.setVisible(true);
    }

    private void showEventDemo() {

        JButton okButton = new JButton("Search");
        JButton submitButton = new JButton("Submit");
        JButton cancelButton = new JButton("Cancel");
        JButton StopButton = new JButton("Stop");

        okButton.setActionCommand("Search");
        submitButton.setActionCommand("Submit");
        cancelButton.setActionCommand("Cancel");
        StopButton.setActionCommand("Stop");

        okButton.addActionListener(new ButtonClickListener());
        submitButton.addActionListener(new ButtonClickListener());
        cancelButton.addActionListener(new ButtonClickListener());
        StopButton.addActionListener(new ButtonClickListener());



        controlPanel.add(okButton);
//        controlPanel.add(submitButton);
//        controlPanel.add(cancelButton);
//        controlPanel.add(StopButton);

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

    private class ButtonClickListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            if (command.equals("Search")) {
                statusLabel.setText("Search Button clicked.");
            } else if (command.equals("Submit")) {
                statusLabel.setText("Submit Button clicked.");
            } else if (command.equals("Cancel")){
                statusLabel.setText("Cancel Button clicked.");
            }
            else if(command.equals("Stop")
            ) {
                statusLabel.setText("Stop Button Clicked");
            }
        }
    }
}
