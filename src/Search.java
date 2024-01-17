import java.awt.*;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.ArrayList;
import java.util.*;
import javax.swing.*;

public class Search implements ActionListener {
    private JFrame mainFrame;
    private JLabel statusLabel;
    private JLabel urlLabel, keywordLabel;

    private JPanel controlPanel,urlPanel, keywordPanel, resultsArea, upperPanel,lowerPanel;

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
        mainFrame.setLayout(new GridLayout(2, 1));

        upperPanel=new JPanel();
        upperPanel.setLayout(new GridLayout(1,2));
        lowerPanel=new JPanel();
        lowerPanel.setLayout(new BorderLayout());
        mainFrame.add(upperPanel);
        mainFrame.add(lowerPanel);

        urlPanel= new JPanel();
        urlPanel.setLayout(new BorderLayout());
        upperPanel.add(urlPanel);
        keywordPanel= new JPanel();
        keywordPanel.setLayout(new BorderLayout());
        upperPanel.add(keywordPanel);
//
        urlLabel = new JLabel("enter URL");
        keywordLabel = new JLabel("enter keyword");
        keywordPanel.add(keywordLabel,BorderLayout.NORTH);
        urlPanel.add(urlLabel,BorderLayout.NORTH);


        ta = new JTextField();
        ta.setBounds(50, 5, WIDTH-100, HEIGHT-50);
        tb = new JTextField();
        urlPanel.add(ta,BorderLayout.CENTER);
        keywordPanel.add(tb,BorderLayout.CENTER);
        tb.setBounds(50,5,WIDTH-200, HEIGHT-50);
        resultsPanel = new JTextArea();

      

        //mainFrame.add(mb);  //add menu bar
//      mainFrame.add(urlLabel);
//      //  mainFrame.add(ta);
//        mainFrame.add(keywordLabel);//add typing area
     //   mainFrame.add(tb);
       // mainFrame.setJMenuBar(mb); //set menu bar

//        statusLabel = new JLabel("", JLabel.CENTER);
//        statusLabel.setSize(350, 100);

        mainFrame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
//        controlPanel = new JPanel();
//        controlPanel.setLayout(new BorderLayout()); //set the layout of the pannel

        JButton okButton = new JButton("Search");


        okButton.addActionListener(new ButtonClickListener());


//        mainFrame.add(okButton);
        lowerPanel.add(okButton,BorderLayout.NORTH);
        lowerPanel.add(resultsPanel,BorderLayout.CENTER);
//        mainFrame.add(controlPanel);
//        controlPanel.add(ta,BorderLayout.WEST);
//        controlPanel.add(tb,BorderLayout.EAST);
       // mainFrame.add(statusLabel);
       // mainFrame.add(resultsPanel);
        JScrollPane pane = new JScrollPane(resultsPanel);
        lowerPanel.add(pane);
        mainFrame.setVisible(true);
       
    }

    private void showEventDemo() {





        //controlPanel.add(okButton);
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
            ArrayList<String> links = new ArrayList<String>();
            ArrayList<String> newList = new ArrayList<String>();
            String command = e.getActionCommand();

            if (command.equals("Search")) {

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
                        while(line.contains("href=")&&line.contains(keyword.toLowerCase())){
                            System.out.println("og"+line);
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
                            links.add(line.substring(beginIndex,endSpot)+'\n');


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





                            line = line.substring(beginIndex);
                        }




                    }
                    reader.close();
                } catch(Exception ex) {
                    System.out.println(ex);
                    resultsPanel.append(ex.toString());
                    resultsPanel.setBackground(Color.red);
                }

                for(int i = 0; i <links.size();i++){



                    // Traverse through the first list
                    for (int z = 0; z <links.size();z++) {

                        // If this element is not present in newList
                        // then add it
                        if (!newList.contains(links.get(z))) {

                            newList.add(links.get(z));
                        }
                    }




                }
                for(int b = 0; b< newList.size();b++){
                    resultsPanel.append(newList.get(b));
                }
            }


            else if (command.equals("Submit")) {
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
