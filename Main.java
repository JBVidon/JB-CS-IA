import java.io.*;
import java.nio.file.*;
import java.util.*;

public class Main {
    //instance field
    ArrayList<String[]> events = new ArrayList<String[]>();
    ArrayList<String> possibleTimes = new ArrayList<String>();
    Map<String, ArrayList<String>> possibleDays = new HashMap<String, ArrayList<String>>();

    String tempValue;

    //constructor
    Main() {
        String[] times = {"10pm","11pm","12pm","1pm", "2pm","3pm","4pm","5pm","6pm"};
        populateTimes(times);
        String[] dates = {"1/9/2023","1/10/2023","1/11/2023","1/12/2023","1/13/2023","1/14/2023","1/15/2023"};
        populateDays(dates);
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
            adminReader.close();
        } catch (Exception q) {
            System.out.println(q);
        }
        return false;
    }
    //write data
    public void write(String inputToWrite) {
        try {
            File myFile = new File("Reservations.txt");
            myFile.createNewFile();
            FileWriter writer = new FileWriter("Reservations.txt", true);
            writer.write(inputToWrite + "\n");
            writer.close();
        } catch (IOException e) {
            System.out.println(e);
        }
    }

    void setEvent(String name, String day, String time) {
        String[] arr = new String[3];
        arr[0] = name;
        arr[1] = day;
        arr[2] = time;
        events.add(arr);
        String stringToWrite = name + "," + time + "," + day;
        write(stringToWrite);
    }
    //add times to the list
    void addTime(String time) {
        possibleTimes.add(time);
    }
    //add date to the list
    void addDate(String date) {
        possibleDays.put(date, new ArrayList<String>(getPossibleDays()));
    }
    void setName(String name) {
        tempValue = name;
    }
    //get possible times
    ArrayList<String> getPossibleTimes(String day) {
        return possibleDays.get(day);
    }
    //get possible days
    ArrayList<String> getPossibleDays() {
        return new ArrayList<String>(possibleDays.keySet());
    }
    //get name
    String getName() {
        return tempValue;
    }
    //populaters
    //populate possible times
    public void populateTimes(String[] arr) {
        for (int p = 0; p < arr.length; p++) {
            addTime(arr[p]);
        }
    }
    //populate possible Days
    public void populateDays(String[] arr) {
        for (int o = 0; o < arr.length; o++) {
            addDate(arr[o]);
        }
    }
    //removers
    public void removeTime(String time, String date) {
        ArrayList<String> times = new ArrayList<String>(possibleDays.get(date));
        possibleDays.remove(date);
        int index = times.indexOf(time);
        times.remove(index);
        possibleDays.put(date, times);
    }
}
