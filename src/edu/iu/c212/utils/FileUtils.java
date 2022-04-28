package edu.iu.c212.utils;


import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileUtils {
    private static File inputFile = new File("src/resources/input.txt");
    private static File outputFile = new File("src/resources/output.txt");
    private static File inventoryFile = new File("src/resources/inventory.txt");
    private static File staffFile = new File("src/resources/staff.txt");
    private static File staffAvailabilityFile = new File("src/resources/staff_availability_IN.txt");
    private static File shiftSchedulesFile = new File("src/resources/shift_schedules_IN.txt");
    private static File storeScheduleFile = new File("src/resources/store_schedules_IN.txt");


    public static void main(String[] args) throws IOException {
        System.out.println(readCommandsFromFile());

    }

    public static List<Item> readInventoryFromFile() throws IOException {
        System.out.println(inventoryFile/*.toURI()*/.getPath() + "\n" + inventoryFile.exists());
        // depending on your OS, toURI() may need to be used when working with paths
        // TODO
        Scanner myReader = new Scanner(inventoryFile);
        ArrayList<Item> returnList = new ArrayList<>();
        while(myReader.hasNextLine()){
            String data = myReader.nextLine();
            String name = data.split(",")[0];
            System.out.println(name);
            double price = Double.parseDouble(data.split(",")[1]);
            int quantity =  Integer.parseInt(data.split(",")[2]);
            int aisleNum = Integer.parseInt(data.split(",")[3]);

            returnList.add(new Item(name, price, quantity, aisleNum));
        }

        return returnList;
    }

    public static List<Staff> readStaffFromFile() throws IOException {
        // TODO
        Scanner input = new Scanner(staffAvailabilityFile);
        ArrayList <Staff> staff = new ArrayList<>();
        while (input.hasNextLine()){
            String line = input.nextLine();
            String name = line.split(" ")[0] + " " + line.split(" ")[1];
            int age = Integer.parseInt(line.split(" ")[2]);
            String role = line.split(" ")[3];
            String availability = line.split(" ")[4];


            staff.add(new Staff(name,age, role, availability));
        }
        return staff;
    }

    public static void writeInventoryToFile(List<Item> items) throws IOException {
        FileWriter writer = new FileWriter(inventoryFile);
        for(Item item: items){
            //System.out.println(item.getName());
            writer.write(item.getName() + " " + item.getPrice() + " " + item.getAisle() + " " + item.getQuantity() + "\n");
        }
        writer.close();
    }

    public static void writeStaffToFile(List<Staff> employees) throws IOException {
        FileWriter writer = new FileWriter(staffFile);
        for(Staff staffer: employees){
            //System.out.println(item.getName());
            writer.write(staffer.getName() + " " + staffer.getAge() + " " + staffer.getAvailability() + " " + staffer.getRole() + "\n");
        }
        writer.close();
    }

    public static List<String> readCommandsFromFile() throws IOException {
        // TODO
        Scanner input = new Scanner(inputFile);
        ArrayList <String> returnList = new ArrayList<>();
        while (input.hasNextLine()){
            String line = input.nextLine();
            returnList.add(line);

        }
        return returnList;
    }

    public static void writeStoreScheduleToFile(List<String> lines) throws IOException {
        FileWriter writer = new FileWriter(storeScheduleFile);
        for(String line: lines){
            //System.out.println(item.getName());
            writer.write(line + "\n");
        }
        writer.close();
    }

    public static void writeLineToOutputFile(String line) throws IOException {
        FileWriter writer = new FileWriter(outputFile);
        writer.write(line);
        writer.close();
    }

}
