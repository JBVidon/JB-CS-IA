import java.io.*;
import java.nio.file.*;
import java.util.*;
//hi jose
public class Main { //His JB I just wrote this
    //instance field
    private List<String> names = new ArrayList<String>();
    private ArrayList<String> possibleTimes = new ArrayList<String>();

    //constructor
    Main() {
        possibleTimes.add("1:00");
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
    //get possible times
    ArrayList<String> getPossibleTimes() {
        return possibleTimes;
    }
}
