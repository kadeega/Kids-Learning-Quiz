/* ((( Final page )))
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

public class ProjectOOP2_FinalPage extends JFrame{
    
    //panel for the background image
    private JPanel gifPanel = new JPanel();
    
    //label to display the image
    private JLabel gifLabel;
    
    //create an image icon
    private ImageIcon goodJobIcon = new ImageIcon("goodjob.png");
    
    //panel for buttons
    private JPanel btnPanel = new JPanel();
    
    //panel to display the results
    private JPanel resultPanel = new JPanel();
    
    //label to display the results
    private JLabel result = new JLabel();;

    //button to save the result file
    private JButton saveFileBtn = new JButton("Save my new results");;
    //button to show the preivous result
    private JButton showResultBtn = new JButton("Show preivous results");;
    
    //objects 
    private ProjectOOP2_Home homePage;
    private ProjectOOP2_SavedResults resultPage;
    
    //to store the results
    private static String resultStr = "";
    private static String inputResultStr = "";

    public ProjectOOP2_FinalPage(){
        setTitle("Final page");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(5,10));
        getContentPane().setBackground(Color.WHITE);

        buildButtonsPanel();
        
        buildImagePanel();
   
        setResult();
        buildResultPanel();
                 
        add(resultPanel);
        add(gifPanel,BorderLayout.NORTH);
        add(btnPanel,BorderLayout.SOUTH);
     
        pack();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
    //method to build the buttons panel
    public void buildButtonsPanel(){
        //set the panel layout to BorderLayout
        btnPanel.setLayout(new GridLayout(1,2));
     
        //set a tool tip
        saveFileBtn.setToolTipText("click if you want to save your current result.");
        
        //set the buttons background to black
        saveFileBtn.setBackground(ProjectOOP2_Home.color);
        showResultBtn.setBackground(ProjectOOP2_Home.color);
        
        //set the buttons foreground to white
        saveFileBtn.setForeground(Color.WHITE);
        showResultBtn.setForeground(Color.WHITE);
        
        //register the buttons with an Event Listener
        showResultBtn.addActionListener(new ShowResultListener());
        saveFileBtn.addActionListener(new SaveButtonListener());
        
        //adds the components to the panel
        btnPanel.add(saveFileBtn);
        btnPanel.add(showResultBtn);
    }
    
    //method to build the image panel
    public void buildImagePanel(){
        //adds the image to the label
        gifLabel = new JLabel(goodJobIcon);
        
        //set the panel background to white
        gifPanel.setBackground(Color.WHITE);
        
        //adds the component to the panel
        gifPanel.add(gifLabel);
    }
    
    //method to build the result panel
    public void buildResultPanel(){
        //set the foreground to red
        result.setForeground(Color.red);
        
        //change the font type and style and size
        result.setFont(new Font("Serif",Font.BOLD,24));
        
        //set the panel background to white
        resultPanel.setBackground(Color.WHITE);
        
        //adds the component to the panel
        resultPanel.add(result);
    }
    
    //method to set the results
    public void setResult(){
        String selectedValue = (String)homePage.sectionsBox.getSelectedItem();
        
        //variables to store the results
        int rightAnswers = 0;
        int wrongAnswers = 0;
        String input1 = "";
        String input2 = "";
        String input3 = "";
        String input4 = "";
        String input5 = "";
        String input6 = "";
        
        //if the user selected the animals quiz 
        if(selectedValue.equals(homePage.sections[0])){
            rightAnswers = ProjectOOP2_Animals.rightAnswers;
            wrongAnswers = ProjectOOP2_Animals.wrongAnswers;
            input1 = ProjectOOP2_Animals.input1;
            input2 = ProjectOOP2_Animals.input2;
            input3 = ProjectOOP2_Animals.input3;
            input4 = ProjectOOP2_Animals.input4;
            input5 = ProjectOOP2_Animals.input5;
            input6 = ProjectOOP2_Animals.input6;
        }
        
        //if the user selected the fruits quiz 
        else if(selectedValue.equals(homePage.sections[1])){
            rightAnswers = ProjectOOP2_Fruits.rightAnswers;
            wrongAnswers = ProjectOOP2_Fruits.wrongAnswers;
            input1 = ProjectOOP2_Fruits.input1;
            input2 = ProjectOOP2_Fruits.input2;
            input3 = ProjectOOP2_Fruits.input3;
            input4 = ProjectOOP2_Fruits.input4;
            input5 = ProjectOOP2_Fruits.input5;
            input6 = ProjectOOP2_Fruits.input6;
        }
        
        //if the user selected the colors quiz 
        else if(selectedValue.equals(homePage.sections[2])){
            rightAnswers = ProjectOOP2_Colors.rightAnswers;
            wrongAnswers = ProjectOOP2_Colors.wrongAnswers;
            input1 = ProjectOOP2_Colors.input1;
            input2 = ProjectOOP2_Colors.input2;
            input3 = ProjectOOP2_Colors.input3;
            input4 = ProjectOOP2_Colors.input4;
            input5 = ProjectOOP2_Colors.input5;
            input6 = ProjectOOP2_Colors.input6;
        }
        
        //to store every question result
        inputResultStr = "Q1: " + input1 + "\n" + "Q2: " + input2 + "\n"+"Q3: " + input3 + "\n"+"Q4: " + input4 + "\n" +
                "Q5: " + input5 + "\n" + "Q6: " +input6 + "\n";
        
        //to display the result in the result label
        resultStr = "You answerd "+rightAnswers+" questions correctly and "+wrongAnswers+" questions incorrectly";
        
        //display the result
        result.setText(resultStr);

    }

    private class SaveButtonListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            //take the name of the user to create a unique file with the user name
            String fileName = homePage.nameField.getText()+".dat";
            try {
                //create a file with the user name
                FileOutputStream file = new FileOutputStream(fileName, true);
                DataOutputStream resultFile = new DataOutputStream(file);
                
                //create the string to be displayed in the file
                String results = "Name: " + homePage.nameField.getText() + " | age: " + homePage.slider.getValue() +
                        "\n" + inputResultStr + "\n" + resultStr + "\n---------------------------------\n";
                
                //display the result in the file
                resultFile.writeUTF(results);
                
                // close the file
                resultFile.close();
            }
            catch (IOException ex) {
                JOptionPane.showMessageDialog(null, ex.getMessage());
            }
            saveFileBtn.setEnabled(false);
        }
    }

    private class ShowResultListener implements ActionListener{
        
        public void actionPerformed(ActionEvent e){
            //checks if the file exists or not
            String fileName = homePage.nameField.getText()+".dat";
            File f = new File(fileName);
            
            //if the file dosent exists tell the user to save the file first
            if(!f.exists()){
                JOptionPane.showMessageDialog(null, "You should save your result firstly");
            }
            //else if the file exists move to the results page
            else{   
                setVisible(false);
                new ProjectOOP2_SavedResults();
            }
        }
    }

}
