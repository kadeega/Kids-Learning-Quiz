/* ((( Fruits page )))
Names and ID Numbers:
- Khadijah Alamoudi 2317662
- Latifa Safia 2317641 
- Hassna Alharbi 2314872
 */
package projectoop2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ProjectOOP2_Fruits extends JFrame{
        
    // The quastion
    private JLabel q2 = new JLabel("What fruits are in these pictures? ");
    
    // choices
    // Choices for section 1
    private JRadioButton qOneC1 = new JRadioButton("Mango");
    private JRadioButton qOneC2 = new JRadioButton("Apple");
    private JRadioButton qOneC3 = new JRadioButton("Banana");
    // Choices for section 2
    private JRadioButton qTwoC1 = new JRadioButton("Grapes");
    private JRadioButton qTwoC2 = new JRadioButton("Orange");
    private JRadioButton qTwoC3 = new JRadioButton("Strawberry");
    // Choices for section 3
    private JRadioButton qThreeC1 = new JRadioButton("Cherry");
    private JRadioButton qThreeC2 = new JRadioButton("Kiwi");
    private JRadioButton qThreeC3 = new JRadioButton("Pineapple");
    // Choices for section 4
    private JRadioButton qFourC1 = new JRadioButton("Pomegranate");
    private JRadioButton qFourC2 = new JRadioButton("Apricot");
    private JRadioButton qFourC3 = new JRadioButton("Lemon");
    // Choices for section 5
    private JRadioButton qFiveC1 = new JRadioButton("Watermelon");
    private JRadioButton qFiveC2 = new JRadioButton("Avocado");
    private JRadioButton qFiveC3 = new JRadioButton("Dates");
    // Choices for section 6
    private JRadioButton qSixC1 = new JRadioButton("Grapefruit");
    private JRadioButton qSixC2 = new JRadioButton("Fig");
    private JRadioButton qSixC3 = new JRadioButton("Pears");
    
    // ButtonGroup objects
    ButtonGroup group1 = new ButtonGroup();
    ButtonGroup group2 = new ButtonGroup();
    ButtonGroup group3 = new ButtonGroup();
    ButtonGroup group4 = new ButtonGroup();
    ButtonGroup group5 = new ButtonGroup();
    ButtonGroup group6 = new ButtonGroup();
    
    // Images
    // Image 1
    private ImageIcon image1 = new ImageIcon("Mango.JPG");
    private JLabel imageLabel1 = new JLabel(image1);
    // Image 2
    private ImageIcon image2 = new ImageIcon("Strawberry.JPG");
    private JLabel imageLabel2 = new JLabel(image2);
    // Image 3
    private ImageIcon image3 = new ImageIcon("Kiwi.JPG");
    private JLabel imageLabel3 = new JLabel(image3);
    // Image 4
    private ImageIcon image4 = new ImageIcon("Pomegranate.JPG");
    private JLabel imageLabel4 = new JLabel(image4);
    // Image 5
    private ImageIcon image5 = new ImageIcon("Watermelon.JPG");
    private JLabel imageLabel5 = new JLabel(image5);
    // Image 6
    private ImageIcon image6 = new ImageIcon("Pears.JPG");
    private JLabel imageLabel6 = new JLabel(image6);
    
    // Needed buttons
    private JButton check = new JButton("Submit and check Answers");
    private JButton toFinal = new JButton("Go to final page");
    
    // Panels
    private JPanel panel1 = new JPanel(); // for quastion
    private JPanel panel2 = new JPanel(); // RadioButtons 1
    private JPanel panel3 = new JPanel(new BorderLayout()); // image 1 + RadioButtons 1
    private JPanel panel4 = new JPanel(); // RadioButtons 2
    private JPanel panel5 = new JPanel(new BorderLayout()); // image 2 + RadioButtons 2
    private JPanel panel6 = new JPanel(); // RadioButtons 3
    private JPanel panel7 = new JPanel(new BorderLayout()); // image 3 + RadioButtons 3
    private JPanel panel8 = new JPanel(); // RadioButtons 4
    private JPanel panel9 = new JPanel(new BorderLayout()); // image 4 + RadioButtons 4
    private JPanel panel10 = new JPanel(); // RadioButtons 5
    private JPanel panel11 = new JPanel(new BorderLayout()); // image 5 + RadioButtons 5
    private JPanel panel12 = new JPanel(); // RadioButtons 6
    private JPanel panel13 = new JPanel(new BorderLayout()); // image 6 + RadioButtons 6
    private JPanel panel14 = new JPanel(new GridLayout(2, 3)); // GridePanel for all quastions
    private JPanel panel15 = new JPanel(new GridLayout(1,2)); // for buttons (Check and Exit)

    // actionListener variables
    static int rightAnswers = 0;
    static int wrongAnswers = 0;
    static String input1;
    static String input2;
    static String input3;
    static String input4;
    static String input5;
    static String input6;
    
    //final page
    private ProjectOOP2_FinalPage finalPage;
    private ProjectOOP2_Home homePage;
    
    // constuctor
    public ProjectOOP2_Fruits(){
        setTitle("Questions about fruits");
        setLayout(new BorderLayout());
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        buildPanel();
        setDesign();
        
        add(panel1, BorderLayout.NORTH);
        add(panel14, BorderLayout.CENTER);
        add(panel15, BorderLayout.SOUTH);
        
        check.addActionListener(new CheckButtonListener());
        toFinal.addActionListener(new ToFinalListener());

        pack();
        setLocationRelativeTo(null);
        setVisible(true);  
    }
    private void buildPanel(){
        // RadioButtons 1
        group1.add(qOneC1);
        group1.add(qOneC2);
        group1.add(qOneC3);
        // RadioButtons 2
        group2.add(qTwoC1);
        group2.add(qTwoC2);
        group2.add(qTwoC3);
        // RadioButtons 3
        group3.add(qThreeC1);
        group3.add(qThreeC2);
        group3.add(qThreeC3);
        // RadioButtons 4
        group4.add(qFourC1);
        group4.add(qFourC2);
        group4.add(qFourC3);
        // RadioButtons 5
        group5.add(qFiveC1);
        group5.add(qFiveC2);
        group5.add(qFiveC3);
        // RadioButtons 6
        group6.add(qSixC1);
        group6.add(qSixC2);
        group6.add(qSixC3);
        
        // Panel for the quastion
        panel1.add(q2);
        
        // Panels for each sections
        // Section One
        // Panel for RadioButtons 1
        panel2.add(qOneC1);
        panel2.add(qOneC2);
        panel2.add(qOneC3);
        // for picture and RadioButtons 1
        panel3.add(imageLabel1, BorderLayout.NORTH);
        panel3.add(panel2, BorderLayout.CENTER);
        
        // Section Two
        // Panel for RadioButtons 2
        panel4.add(qTwoC1);
        panel4.add(qTwoC2);
        panel4.add(qTwoC3);
        // for picture and RadioButtons 2
        panel5.add(imageLabel2, BorderLayout.NORTH);
        panel5.add(panel4);
        
        // Section Three
        // Panel for RadioButtons 3
        panel6.add(qThreeC1);
        panel6.add(qThreeC2);
        panel6.add(qThreeC3);
        // for picture and RadioButtons 3
        panel7.add(imageLabel3, BorderLayout.NORTH);
        panel7.add(panel6, BorderLayout.CENTER);
        
        // Section Four
        // Panel for RadioButtons 4
        panel8.add(qFourC1);
        panel8.add(qFourC2);
        panel8.add(qFourC3);
        // for picture and RadioButtons 4
        panel9.add(imageLabel4, BorderLayout.NORTH);
        panel9.add(panel8, BorderLayout.CENTER);
        
        // Section Five
        // Panel for RadioButtons 5
        panel10.add(qFiveC1);
        panel10.add(qFiveC2);
        panel10.add(qFiveC3);
        // for picture and RadioButtons 5
        panel11.add(imageLabel5, BorderLayout.NORTH);
        panel11.add(panel10, BorderLayout.CENTER);
        
        // Section Six
        // Panel for RadioButtons 6
        panel12.add(qSixC1);
        panel12.add(qSixC2);
        panel12.add(qSixC3);
        // for picture and RadioButtons 6
        panel13.add(imageLabel6, BorderLayout.NORTH);
        panel13.add(panel12, BorderLayout.CENTER);
        
        // Panel for all sections
        panel14.add(panel3);
        panel14.add(panel5);
        panel14.add(panel7);
        panel14.add(panel9);
        panel14.add(panel11);
        panel14.add(panel13);
        
        // Panel for all bottons
        panel15.add(check, BorderLayout.CENTER);
        panel15.add(toFinal, BorderLayout.EAST);
    }
    private void setDesign(){
        // Font
        q2.setFont(new Font("Serif", Font.BOLD, 24));
        qOneC1.setFont(new Font("Aptos", Font.BOLD, 15));
        qOneC2.setFont(new Font("Aptos", Font.BOLD, 15));
        qOneC3.setFont(new Font("Aptos", Font.BOLD, 15));
        qTwoC1.setFont(new Font("Aptos", Font.BOLD, 15));
        qTwoC2.setFont(new Font("Aptos", Font.BOLD, 15));
        qTwoC3.setFont(new Font("Aptos", Font.BOLD, 15));
        qThreeC1.setFont(new Font("Aptos", Font.BOLD, 15));
        qThreeC2.setFont(new Font("Aptos", Font.BOLD, 15));
        qThreeC3.setFont(new Font("Aptos", Font.BOLD, 15));
        qFourC1.setFont(new Font("Aptos", Font.BOLD, 15));
        qFourC2.setFont(new Font("Aptos", Font.BOLD, 15));
        qFourC3.setFont(new Font("Aptos", Font.BOLD, 15));
        qFiveC1.setFont(new Font("Aptos", Font.BOLD, 15));
        qFiveC2.setFont(new Font("Aptos", Font.BOLD, 15));
        qFiveC3.setFont(new Font("Aptos", Font.BOLD, 15));
        qSixC1.setFont(new Font("Aptos", Font.BOLD, 15));
        qSixC2.setFont(new Font("Aptos", Font.BOLD, 15));
        qSixC2.setFont(new Font("Aptos", Font.BOLD, 15));
        qSixC3.setFont(new Font("Aptos", Font.BOLD, 15));
        check.setFont(new Font("Aptos", Font.BOLD, 12));
        toFinal.setFont(new Font("Aptos", Font.BOLD, 12));

        // set Borders
        panel3.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel5.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel7.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel9.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel11.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        panel13.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        
        // set Colors
        panel1.setBackground(ProjectOOP2_Home.color);
        panel2.setBackground(Color.WHITE);
        panel3.setBackground(Color.LIGHT_GRAY);
        panel4.setBackground(Color.WHITE);
        panel5.setBackground(Color.LIGHT_GRAY);
        panel6.setBackground(Color.WHITE);
        panel7.setBackground(Color.LIGHT_GRAY);
        panel8.setBackground(Color.WHITE);
        panel9.setBackground(Color.LIGHT_GRAY);
        panel10.setBackground(Color.WHITE);
        panel11.setBackground(Color.LIGHT_GRAY);
        panel12.setBackground(Color.WHITE);
        panel13.setBackground(Color.LIGHT_GRAY);
        panel15.setBackground(Color.BLACK);
        
        q2.setForeground(Color.WHITE);
        check.setBackground(ProjectOOP2_Home.color);
        check.setForeground(Color.WHITE); 
        toFinal.setBackground(ProjectOOP2_Home.color);
        toFinal.setForeground(Color.WHITE);
    }
    
    private class CheckButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e){
            JRadioButton[] qOneC = {qOneC1, qOneC2, qOneC3}; 
            JRadioButton[] qTwoC = {qTwoC1, qTwoC2, qTwoC3}; 
            JRadioButton[] qThreeC = {qThreeC1, qThreeC2, qThreeC3}; 
            JRadioButton[] qFourC = {qFourC1, qFourC2, qFourC3}; 
            JRadioButton[] qFiveC = {qFiveC1, qFiveC2, qFiveC3}; 
            JRadioButton[] qSixC = {qSixC1, qSixC2, qSixC3}; 
            for(int i = 0; i < 3; i++){
                if (qOneC[i].isSelected()){
                    input1 = qOneC[i].getActionCommand();
                    if(i == 0){
                        rightAnswers++;
                        qOneC[i].setBackground(Color.GREEN);
                    }
                    else{
                        qOneC[i].setBackground(Color.RED);
                    }
                }
                
                if (qTwoC[i].isSelected()){
                    input2 = qTwoC[i].getActionCommand();
                    if(i == 2){
                        rightAnswers++;
                        qTwoC[i].setBackground(Color.GREEN);
                    }
                    else{
                        qTwoC[i].setBackground(Color.RED);
                    }
                }
                
                if (qThreeC[i].isSelected()){
                    input3 = qThreeC[i].getActionCommand();
                    if(i == 1){
                        rightAnswers++;
                        qThreeC[i].setBackground(Color.GREEN);
                    }
                    else{
                        qThreeC[i].setBackground(Color.RED);
                    }
                }
                
                if (qFourC[i].isSelected()){
                    input4 = qFourC[i].getActionCommand();
                    if(i == 0){
                        rightAnswers++;
                        qFourC[i].setBackground(Color.GREEN);
                    }
                    else{
                        qFourC[i].setBackground(Color.RED);
                    }
                }
                
                if (qFiveC[i].isSelected()){
                    input5 = qFiveC[i].getActionCommand();
                    if(i == 0){
                        rightAnswers++;
                        qFiveC[i].setBackground(Color.GREEN);
                    }
                    else{
                        qFiveC[i].setBackground(Color.RED);
                    }
                }
                
                if (qSixC[i].isSelected()){
                    input6 = qSixC[i].getActionCommand();
                    if(i == 2){
                        rightAnswers++;
                        qSixC[i].setBackground(Color.GREEN);
                    }
                    else{
                        qSixC[i].setBackground(Color.RED);
                    }
                }
            }
            check.setEnabled(false); 
            wrongAnswers = 6 - rightAnswers;
        }  
    }
    
    private class ToFinalListener implements ActionListener{
            public void actionPerformed(ActionEvent e){
                setVisible(false);
                finalPage = new ProjectOOP2_FinalPage();
            }
        }

    
}

