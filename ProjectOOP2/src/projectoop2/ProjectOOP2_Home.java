/* ((( Home page )))
Names and ID Numbers:
- Khadijah Alamoudi 2317662
- Latifa Safia 2317641 
- Hassna Alharbi 2314872
 */
package projectoop2;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class ProjectOOP2_Home extends JFrame{
    // Top header
    private ImageIcon image = new ImageIcon("header.PNG");
    private JLabel imageLabel1 = new JLabel(image);
    // Labels
    private JLabel greeting = new JLabel("Welcome to our fun educational program!");                           
    private JLabel choose = new JLabel("Choose the section you would like to learn about today: ");
    private JLabel name = new JLabel("Enter your first name: ");
    private JLabel age = new JLabel("Enter your age: ");
    // TextField
    public static JTextField nameField = new JTextField(15);
    // Slider
    public static JSlider slider = new JSlider(JSlider.HORIZONTAL, 2, 5, 2);
    // Sections list
    static String[] sections = {"Animals", "Fruits", "Colors"};
    static JComboBox sectionsBox = new JComboBox(sections);
    // Down header
    private JLabel imageLabel2 = new JLabel(image);
    // Menu bar
    private JMenuBar menuBar = new JMenuBar();
    private JMenu controlMenu = new JMenu("Control");
    private JMenu moreMenu = new JMenu("More");
    private JMenuItem chooseColorItem = new JMenuItem("Choose color");
    private JMenuItem aboutItem = new JMenuItem("About Us");
    private JMenuItem exitItem = new JMenuItem("Exit");
    static Color color = Color.BLACK;
    // Panels
    private JPanel panel1 = new JPanel(); // for top header
    private JPanel panel2 = new JPanel(); // for greeting
    private JPanel panel3 = new JPanel(); // for name and age
    private JPanel panel4 = new JPanel(); // for sections list
    private JPanel panel5 = new JPanel(); // for greeting + name and age + list
    private JPanel panel6 = new JPanel(); // for down header
    
    //next page
    private ProjectOOP2_Animals animalsPage;
    private ProjectOOP2_Colors colorsPage;
    private ProjectOOP2_Fruits fruitsPage;
    
    // Size
    private final int WIDTH= 700;
    private final int HIGHT = 410;
    
    
    ProjectOOP2_Home(){
    setTitle("Test Home");
    setSize(WIDTH, HIGHT);
    setLayout(new BorderLayout());
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    buildPanel();
    addMenu(); // Add the menu bar here
    setDesign();
    
    sectionsBox.addActionListener(new SelectionBoxListener());
    
    add(panel1, BorderLayout.NORTH);
    add(panel5, BorderLayout.CENTER);
    add(panel6, BorderLayout.SOUTH);
    
    setLocationRelativeTo(null);
    setVisible(true);
}
    private void buildPanel(){
        // panel 1 for top header
        panel1.add(imageLabel1);
        // panel 2 for greeting
        panel2.add(greeting);
        // panel 3
        panel3.add(name);
        panel3.add(nameField);
        panel3.add(age);
        slider.setMajorTickSpacing(1);
        slider.setPaintTicks(true);
        slider.setPaintLabels(true);
        panel3.add(slider);
        // panel 4
        panel4.add(choose);
        panel4.add(sectionsBox);
        // panel 5 for main body
        panel5.setLayout(new BorderLayout());
        panel5.add(panel2, BorderLayout.NORTH);
        panel5.add(panel3, BorderLayout.CENTER);
        panel5.add(panel4, BorderLayout.SOUTH);
        // panel 6 for down header
        panel6.add(imageLabel2);
    }
    // This method Create and add the menu bar
    private void addMenu() {
        // Add action listener for the About Us item
        aboutItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Create a non-editable text area
                JTextArea aboutText = new JTextArea(
                "Our project idea is to provide short quizzes for children about the names and pictures of animals and fruits, as well as introducing them to some colors.\n" +
                "\n" +
                "We present our quizzes in a fun and engaging way for children.\n" +
                "\n" +
                "Developed by software engineers:"
                        + "\n"+"Latifa Safia"
                        + "\n"+"Khadijah Alamoudi"
                        + "\n"+"Hassna ALharbi"
                );
                aboutText.setFont(new Font("Serif", Font.PLAIN, 15));
                aboutText.setEditable(false);
                aboutText.setLineWrap(true);
                aboutText.setWrapStyleWord(true);

                // Put it in a scroll pane
                JScrollPane scrollPane = new JScrollPane(aboutText);
                scrollPane.setPreferredSize(new Dimension(400, 200));

                // Show in dialog
                JOptionPane.showMessageDialog(ProjectOOP2_Home.this, scrollPane);
            }
        });
        exitItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        
        chooseColorItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                color = JColorChooser.showDialog(null, "Choose color for bakgrounds", Color.BLACK);
            }
        });
        
        controlMenu.add(chooseColorItem);
        controlMenu.addSeparator();
        controlMenu.add(exitItem);
        moreMenu.add(aboutItem);
        
        menuBar.add(controlMenu);
        menuBar.add(moreMenu);
        
        setJMenuBar(menuBar);
    }
    private void setDesign(){
        // Font
        greeting.setFont(new Font("Serif", Font.BOLD, 25));
        name.setFont(new Font("Serif", Font.PLAIN, 18));
        age.setFont(new Font("Serif", Font.PLAIN, 18));
        choose.setFont(new Font("Serif", Font.PLAIN, 18));
        sectionsBox.setFont(new Font("Aptos", Font.PLAIN, 15));
        // Borders
        nameField.setBorder(BorderFactory.createLineBorder(Color.ORANGE, 1));
        // Colors
        panel1.setBackground(Color.WHITE);
        panel2.setBackground(Color.WHITE);
        panel3.setBackground(Color.WHITE);
        panel4.setBackground(Color.WHITE);
        panel6.setBackground(Color.WHITE);
        
        greeting.setForeground(Color.BLACK);
        name.setForeground(Color.BLACK);
        age.setForeground(Color.BLACK);
        choose.setForeground(Color.BLACK);
        sectionsBox.setForeground(Color.ORANGE);
        sectionsBox.setBackground(Color.WHITE);
        slider.setForeground(Color.ORANGE); 
        slider.setBackground(Color.WHITE);
        
        menuBar.setBackground(Color.WHITE);
    }
    
    // Exception
    class wrongNameException extends Exception{
        wrongNameException(){
            super("Please enter only your first name, without any symbols or spaces");
        }
    }

    private void checkName(String userName) throws wrongNameException{
        for(int i = 0; i < userName.length(); i++){
            if(!Character.isLetterOrDigit(userName.charAt(i))){
                throw new wrongNameException();
            }
        }   
    }

    // All Listeners
    private class SelectionBoxListener implements ActionListener{
        
            public void actionPerformed(ActionEvent e){

                    if(!nameField.getText().isEmpty()){
                        try{
                            checkName(nameField.getText());
                        }
                        catch(wrongNameException x){
                            JOptionPane.showMessageDialog(null, x.getMessage());
                            return;
                        }
                        //to determine which page to move to
                        String selection = (String)sectionsBox.getSelectedItem();

                        //if the user selected animal move to animal page
                        if(selection.equals(sections[0])){
                            setVisible(false);
                            animalsPage = new ProjectOOP2_Animals();
                        }
                        //if the user selected fruit move to fruit page
                        else if(selection.equals(sections[1])){
                            setVisible(false);
                            fruitsPage = new ProjectOOP2_Fruits();
                        }
                        //if the user selected color move to color page
                        else if(selection.equals(sections[2])){
                            setVisible(false);
                            colorsPage = new ProjectOOP2_Colors();
                        }
                    }
                    else{
                        JOptionPane.showMessageDialog(null, "You must enter your name firstly");
                    }
        }
    }
    
    
    public static void main(String[] args) {
        new ProjectOOP2_Home();
    }
}
    
    
    
 