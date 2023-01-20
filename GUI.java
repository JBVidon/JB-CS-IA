

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.text.*;
import java.util.*;

public class GUI extends Main {
    //instance field
    JFrame frame1, frameTimes;//create frame varaible
    JPanel panel1, panelTimes;//create panel variable
    JTextArea instructions;//create instruction variable
    JTextArea escapetitle;//create instruction variable
    JFormattedTextField dateInput;//create input for the date
    JTextField input;//create input variable
    JButton submit;
    JComboBox<String> openTimes, openDays;
    DateFormat df;



    //constructor
    GUI(){
        df = new SimpleDateFormat("MM/dd/yyyy");
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
                setName(inputName);
                input.setText("");
                frame1.dispose();
                chooseTimes();
            }
        });
        
        frame1.add(panel1);
        panel1.setLayout( new GridBagLayout());
        panel1.add(escapetitle, setConstraints(0, 0, 0.5, 3));
        panel1.add(instructions, setConstraints(0, 1, 0.5, 1));
        panel1.add(input, setConstraints(2, 1, 0.5, 2));

        frame1.setSize(520,600);
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
        dateInput = new JFormattedTextField(df);
        dateInput.setSize(100,300);

        dateInput.setEditable(true);


        submit.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentName = getName();
                String selectedDay = (String) openDays.getSelectedItem();
                String selectedTime = (String) openTimes.getSelectedItem();
                setEvent(currentName, selectedDay, selectedTime);
                System.out.println("Submitted");
                removeTime(selectedTime, selectedDay);
                frameTimes.dispose();
                createScheduleGUI();
            }
        });

        frameTimes.setSize(520,600);
        frameTimes.add(panelTimes);
        panelTimes.setLayout( new GridBagLayout());
        panelTimes.add(new JTextArea("Please enter the day you would like to attend:"), setConstraints(0, 0, 0.5, 1));
        panelTimes.add(submit, setConstraints(3, 2, 0.5, 3));
        panelTimes.add(instructions, setConstraints(0, 1, 0.5, 1));
        frameTimes.setVisible(true);
        String[] days = listForDate(getPossibleDays());
        openDays = new JComboBox<String>(days);
        openDays.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //do the update
                System.out.println("it should be changing");
                String[] times = copyArrayList(getPossibleTimes((String) openDays.getSelectedItem()));
                panelTimes.remove(openTimes);
                openTimes = new JComboBox<String>(times);
                panelTimes.add(openTimes, setConstraints(1, 1, 0.5, 1));
                panelTimes.revalidate();
            }
        });
        panelTimes.add(openDays, setConstraints(1, 0, 0.5, 2));
        //String[] times = copyArrayList(getPossibleTimes((String) openDays.getSelectedItem()));
        openTimes = new JComboBox<String>();
        panelTimes.add(openTimes, setConstraints(1, 1, 0.5, 1));
    }

    public GridBagConstraints setConstraints(int gridx, int gridy, double weight, int width){
        GridBagConstraints c = new GridBagConstraints();
        c.gridx = gridx;
        c.weightx = weight;
        c.gridy = gridy;
        c.gridwidth = width;
        return c;
    }

    public String[] copyArrayList(ArrayList<?> arrayList) {
        String[] copyArray = new String[arrayList.size()];
        for (int i = 0; i < copyArray.length; i++) {
            copyArray[i] = (String) arrayList.get(i);
        }
        return copyArray;
    }

    public String[] listForDate(ArrayList<?> arrayList) {
        String[] copyArray = new String[arrayList.size() + 1];
        copyArray[0] = "...";
        for (int i = 1; i < copyArray.length; i++) {
            copyArray[i] = (String) arrayList.get(i-1);
        }
        return copyArray;
    }
}