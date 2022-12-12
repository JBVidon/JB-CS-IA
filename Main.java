import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    //instance field
    private List<String> names = new ArrayList<String>();
    private ArrayList<String> possibleTimes = new ArrayList<String>();

    //constructor
    Main() {
        possibleTimes.add("8am");
        possibleTimes.add("9am");
        possibleTimes.add("10am");
        possibleTimes.add("11am");
        possibleTimes.add("12am");
        possibleTimes.add("1pm");
        possibleTimes.add("2pm");
        possibleTimes.add("3pm");
        possibleTimes.add("4pm");
        possibleTimes.add("5pm");
        possibleTimes.add("6pm");

    }
    public static void main(String[] args) throws Exception {
        Main main = new Main();
        GUI guiCreater = new GUI();
        guiCreater.createScheduleGUI();
    }
    //read whether or not it is in admin mode
    public static boolean isAdmin() {
        try {
            FileReader adminReader = new FileReader("ADMIN-SETTINGS.txt");
            adminReader.read();
        } catch (Exception q) {
            System.out.println(q);
        }
        return false;
    }
    //write data
    public void write(String inputToWrite) {
        try {
            File myFile = new File("names.txt");
            myFile.createNewFile();
            FileWriter writer = new FileWriter("names.txt", true);
            writer.write(inputToWrite + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }
    //add people to the list
    void addPeople(String person) {
        names.add(person);
    }
    //add times to the list
    void addTime(String time) {
        possibleTimes.add(time);
    }
    //get possible times
    ArrayList<String> getPossibleTimes() {
        return possibleTimes;
    }
}
