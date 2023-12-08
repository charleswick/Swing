import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import javax.swing.*;

public class Search implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel urlLabel, keywordLabel;

    private JPanel controlPanel;

    private JMenuBar mb;
    private JMenu file, edit, help, more;
    private JMenuItem cut, copy, paste, selectAll, share;
    private JTextField ta;//typing area
    private JTextField tb;//typing area
    private JTextArea resultsPanel;
    private JScrollPane scroll;
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
        mainFrame.setLayout(new GridLayout(4, 1));

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
        urlLabel = new JLabel("enter URL");
        keywordLabel = new JLabel("enter keyword");


        ta = new JTextField();
        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        tb = new JTextField();
        tb.setBounds(50,5,WIDTH-200, HEIGHT-50);
        resultsPanel = new JTextArea();
        //mainFrame.add(mb);  //add menu bar
        mainFrame.add(urlLabel);
        mainFrame.add(ta);
        mainFrame.add(keywordLabel);//add typing area
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
        mainFrame.add(resultsPanel);
        JScrollPane pane = new JScrollPane(resultsPanel);
        mainFrame.add(pane);
        mainFrame.setVisible(true);
        //TODO make whole UI cleaner
        //TODO make it so same link doesn't print twice --> array?
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
                int endSpot=0;
                int indexSpot=0;
                int beginIndex =0;
                String keyword = tb.getText();

                try {

                    URL url = new URL(ta.getText());
                    BufferedReader reader = new BufferedReader(
                            new InputStreamReader(url.openStream())
                    );
                    String line;
                    while ( (line = reader.readLine()) != null ) {
                        if(line.contains("href=")&&line.contains(keyword.toLowerCase())){
                            //System.out.println("og"+line);
//
                            if (line.contains("https")){
                                beginIndex = line.indexOf("https");
                            }
                            if (line.contains("www")){
                                beginIndex = line.indexOf("www");
                            } else{
                                beginIndex=line.indexOf("href=")+6;
                            }



                            if (line.substring(beginIndex).contains("\'")&&line.substring(beginIndex).contains("/")){
                                endSpot = line.indexOf("\'", beginIndex+1);
                            }
                            if (line.substring(beginIndex).contains("\"")&&line.substring(beginIndex).contains("/")){
                                endSpot = line.indexOf("\"", beginIndex+1);
                            }
                            if (line.substring(beginIndex).contains("\"") && line.substring(beginIndex).contains("\'")&&line.substring(beginIndex).contains("/")){
                                if (line.indexOf("\'") > line.indexOf("\"")&&line.substring(beginIndex).contains("/")){
                                    endSpot = line.indexOf("\"", beginIndex+1);
                                }else{
                                    endSpot = line.indexOf("\'", beginIndex+1);
                                }
                            }
                            resultsPanel.append(line.substring(beginIndex,endSpot)+'\n');

//                     indexSpot = line.indexOf("href=");
//                     if(line.contains("\"")&&line.contains("www")){
//                        int endQuoteSpot =line.indexOf("\"",indexSpot+6);
//                        endSpot = endQuoteSpot;
//                         System.out.println(line.substring(indexSpot+6,endSpot));
//
//
//                      // System.out.println(line.substring(indexSpot+6,endQuoteSpot));
//
//                    }
//                    if(line.substring(indexSpot+6).contains("\'")){
//                        int singleQuoteSpot =line.indexOf("\'",indexSpot+6);
//                        endSpot = singleQuoteSpot;
//
//
//                        //   System.out.println(line.substring(indexSpot+6,singleQuoteSpot));
//
//
//                    }
//                    if(line.substring(indexSpot+6).contains("\'")&&(line.substring(indexSpot+6).contains("\""))){
//                        int singleQuoteSpot =line.indexOf("\'",indexSpot+6);
//                        int endQuoteSpot =line.indexOf("\"",indexSpot+6);
//
//                        if(singleQuoteSpot>endQuoteSpot){
//                           endSpot = endQuoteSpot;
//
//                        }
//                        else{
//                         //   System.out.println(line.substring(indexSpot+6,singleQuoteSpot));
//                             endSpot = singleQuoteSpot;
//
//                        }
//


                            //}






                        }




                    }
                    reader.close();
                } catch(Exception ex) {
                    System.out.println(ex);
                }
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
