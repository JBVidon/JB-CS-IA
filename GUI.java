import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI extends Main {
    //instance field
    JFrame frame1, frameTimes;//create frame varaible
    JPanel panel1, panelTimes;//create panel variable
    JTextArea instructions;//create instruction variable
    JTextArea escapetitle;//create instruction variable
    JTextField input;//create input variable
    JButton submit;
    JComboBox<String> openTimes;


    //constructor
    GUI(){
    }
    public void createScheduleGUI() {
        frame1 = new JFrame("Escape 1 2 3");//this is the window
        panel1 = new JPanel();//this is the panel that will pop up
        panel1.setBackground(new Color(209,229,235));
        escapetitle = new JTextArea("Escape 1 2 3");//text field with no border
        escapetitle.setEditable(false);//make instructions not be able to edit
        instructions = new JTextArea("Enter your name: ");//text field with no border
        instructions.setEditable(false);//make instructions not be able to edit
        input = new JTextField(15);//text field with little border
        input.setEditable(true);//make input editable
        //input.setForeground(Color.black);
        //input.setBackground(new Color(150, 176, 183));
        input.addActionListener( new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //get their name
                String inputName = input.getText();
                System.out.println(inputName);
                addPeople(inputName);
                input.setText("");
                frame1.dispose();
                chooseTimes();
            }
        });
        //button.addActionListener( new ad; {public void actionPerformed(ActionEvent e) {})})
        frame1.add(panel1);
        panel1.setLayout( new GridBagLayout());
        panel1.add(escapetitle, setConstraints(0, 0, 0.5, 3));
        panel1.add(instructions, setConstraints(0, 1, 0.5, 1));
        panel1.add(input, setConstraints(2, 1, 0.5, 2));

        frame1.setSize(400,500);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void chooseTimes() {
        frameTimes = new JFrame("Chose your times");
        panelTimes = new JPanel();
        panelTimes.setBackground(new Color(209,229,235));
        submit = new JButton("Submit!");
        submit.setForeground(Color.black);
        submit.setBackground(new Color(150, 176, 183));
        instructions = new JTextArea("Enter the time you want:");
        instructions.setEditable(false);
        instructions.setForeground(Color.black);
        instructions.setBackground(new Color(150, 176, 183));

        submit.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //do something
                System.out.println("Submitted");
            }
        });

        String[] times = copyArrayList(getPossibleTimes());
        openTimes = new JComboBox<String>(times);

        frameTimes.setSize(500,600);
        frameTimes.add(panelTimes);
        panelTimes.setLayout( new GridBagLayout());
        panelTimes.add(instructions, setConstraints(0, 0, 0.5, 1));
        panelTimes.add(openTimes, setConstraints(1, 0, 0.5, 1));
        panelTimes.add(submit, setConstraints(2, 0, 0.5, 1));

        frameTimes.setVisible(true);
    }

    public GridBagConstraints setConstraints(int gridx, int gridy, double weight, int width){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.weightx = weight;
        c.gridy = gridy;
        c.gridwidth = width;
        return c;
    }

    public String[] copyArrayList(ArrayList<String> arrayList) {
        String[] copyArray = new String[arrayList.size()];
        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] = arrayList.get(i);
        }
        return copyArray;
    }
}