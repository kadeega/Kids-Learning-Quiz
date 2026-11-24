/* ((( Saved results page )))
Names and ID Numbers:
- Khadijah Alamoudi 2317662
- Latifa Safia 2317641 
- Hassna Alharbi 2314872
*/

package projectoop2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class ProjectOOP2_SavedResults extends JFrame {
    //Variables 
    private JTextArea resultArea;
    private JButton exitButton;
    private JLabel titleLabel;
    private JPanel titlePanel, textPanel, buttonPanel;

    private ProjectOOP2_Home homePage;
    private String result = "";

    private Font titleFont;
    private Font buttonFont;
    private Font textFont;

    private Color titleBgColor;
    private Color buttonRed;
    private Color white;
    private Color black;

    //Constructor
    public ProjectOOP2_SavedResults() {
        setTitle("Final Results");
        setSize(450, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        loadStyles();      // Method for colors and font
        loadResults();     // Read Result

        buildUI();         // Method for bulding GUI
        exitButton.addActionListener(new ExitListener()); // Add Listeners

        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    //Load Fonts + Colors
    private void loadStyles() {
        titleFont = new Font("Serif", Font.BOLD, 22);
        buttonFont = new Font("Serif", Font.BOLD, 14);
        textFont = new Font("Serif", Font.PLAIN, 14);

        titleBgColor = ProjectOOP2_Home.color;
        buttonRed = Color.RED;
        white = Color.WHITE;
        black = Color.BLACK;
    }

    //Build UI in a separate method
    private void buildUI() {
        getContentPane().setBackground(black);

        // ---------- Title panel ----------
        titlePanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        titlePanel.setBackground(titleBgColor);
        titleLabel = new JLabel("Previous Result");
        titleLabel.setFont(titleFont);
        titleLabel.setForeground(white);
        titlePanel.add(titleLabel);

        // ---------- Text area ----------
        textPanel = new JPanel(new BorderLayout());

        resultArea = new JTextArea(10, 30);
        resultArea.setEditable(false);
        resultArea.setFont(textFont);
        resultArea.setText(result);

        textPanel.add(new JScrollPane(resultArea), BorderLayout.CENTER);

        // ---------- Buttons ----------
        buttonPanel = new JPanel(new GridLayout(1,0));
        
        exitButton = new JButton("Exit");
        exitButton.setFont(buttonFont);
        exitButton.setBackground(buttonRed);
        exitButton.setForeground(white);
        buttonPanel.add(exitButton);

        add(titlePanel, BorderLayout.NORTH);
        add(textPanel, BorderLayout.CENTER);
        add(buttonPanel, BorderLayout.SOUTH);
    }

    //Load Results From File
    private void loadResults() {
        try {
            String fileName = homePage.nameField.getText() + ".dat";

            FileInputStream file = new FileInputStream(fileName);
            DataInputStream resultFile = new DataInputStream(file);

            while (true) {
                try {
                    result += resultFile.readUTF();
                } catch (EOFException e) {
                    break;
                }
            }
            resultFile.close();
            
        } catch (FileNotFoundException e) {
            result = "No results found!\nPlease complete a quiz first.";
        } catch (Exception e) {
            result = "Error loading results:\n" + e.getMessage();
        }
    }

    //INNER CLASS: Exit Button Listener 
    private class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            System.exit(0);
        }
    }

}
