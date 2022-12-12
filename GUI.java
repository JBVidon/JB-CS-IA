import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class GUI extends Main {
    //instance field
    JFrame frame1, frameTimes;//create frame varaible
    JPanel panel1, panelTimes;//create panel variable
    JTextArea instructions;//create instruction variable
    JTextField input;//create input variable
    JButton submit;
    JComboBox<String> openTimes;

    //constructor
    GUI(){
    }
    public void createScheduleGUI() {
        frame1 = new JFrame("Escape Room Reservation");//this is the window
        panel1 = new JPanel();//this is the panel that will pop up
        instructions = new JTextArea("Enter your name: ");//text field with no border
        instructions.setEditable(false);//make instructions not be able to edit
        input = new JTextField(10);//text field with little border
        input.setEditable(true);//make input editable
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
        panel1.add(instructions);
        panel1.add(input);

        frame1.setSize(400,500);
        frame1.setVisible(true);
        frame1.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void chooseTimes() {
        frameTimes = new JFrame("Chose your times");
        panelTimes = new JPanel();
        submit = new JButton("Submit!");
        instructions = new JTextArea("Enter the time you want:");
        instructions.setEditable(false);

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
        panelTimes.add(instructions);
        panelTimes.add(submit);
        panelTimes.add(openTimes);

        frameTimes.setVisible(true);
    }

    public String[] copyArrayList(ArrayList<String> arrayList) {
        String[] copyArray = new String[arrayList.size()];
        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] = arrayList.get(i);
        }
        return copyArray;
    }
}