package edu.iu.c212.utils;

import edu.iu.c212.Models.Item.Item;
import edu.iu.c212.Models.Staff.Staff;


import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static java.lang.System.out;

public class FileUtils {
    private static File inputFile = new File("C:\\Users\\ajalb\\IdeaProjects\\C212FinalProject\\src\\edu\\iu\\c212\\resources\\input.txt");
    private static File outputFile = new File("C:\\Users\\ajalb\\IdeaProjects\\C212FinalProject\\src\\edu\\iu\\c212\\resources\\output.txt");
    private static File inventoryFile = new File("C:\\Users\\ajalb\\IdeaProjects\\C212FinalProject\\src\\edu\\iu\\c212\\resources\\inventory.txt");
    private static File staffFile = new File("C:\\Users\\ajalb\\IdeaProjects\\C212FinalProject\\src\\edu\\iu\\c212\\resources\\staff.txt");
    private static File staffAvailabilityFile = new File("C:\\Users\\ajalb\\IdeaProjects\\C212FinalProject\\src\\edu\\iu\\c212\\resources\\staff_availability_IN.txt");
    private static File shiftSchedulesFile = new File("C:\\Users\\ajalb\\IdeaProjects\\C212FinalProject\\src\\edu\\iu\\c212\\resources\\shift_schedules_IN.txt");
    private static File storeScheduleFile = new File("C:\\Users\\ajalb\\IdeaProjects\\C212FinalProject\\src\\edu\\iu\\c212\\resources\\store_schedule_OUT.txt");

    public static void main(String[] args) throws IOException {
        writeInventoryToFile(readInventoryFromFile());
    }

    public static List<Item> readInventoryFromFile() throws IOException {
        out.println(inventoryFile.toURI().getPath() + "\n" + inventoryFile.exists());
        // depending on your OS, toURI() may need to be used when working with paths
        // TODO
        Scanner input = new Scanner(inventoryFile);
        ArrayList <Item> inventory = new ArrayList();
        while (input.hasNextLine()){
            String line = input.nextLine();
            String name = line.split(" ")[0];
            out.println(line);
            int price = Integer.parseInt(line.split(" ")[1]);
            int quantity = Integer.parseInt(line.split(" ")[2]);
            int aisleNum = Integer.parseInt(line.split(" ")[3]);

            inventory.add(new Item(name,price, quantity, aisleNum));
        }
        return inventory;
    }



    public static List<Staff> readStaffFromFile() throws IOException {
        // TODO

        Scanner input = new Scanner(staffFile);
        ArrayList <Staff> staff = new ArrayList();
        while (input.hasNextLine()){
            String line = input.nextLine();
            String name = line.split(" ")[0] + " " + line.split(" ")[1];
            int age = Integer.parseInt(line.split(" ")[2]);
            String role = line.split(" ")[3];


            staff.add(new Staff(name,age, role));
        }
        return staff;
    }

    public static void writeInventoryToFile(List<Item> items) throws IOException {
        // TODO
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(inventoryFile,true)),true);
        for(Item s: items){
            writer.println("\n" + s.toString());
        }
        out.println(items);
    }

    public void writeStaffToFile(List<Staff> employees) throws IOException {
        // TODO
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(staffFile,true)),true);
        for(Staff s: employees){
            writer.println("\n" + s.toString());
        }
    }

    public static List<String> readCommandsFromFile() throws IOException {
        // TODO
        Scanner input = new Scanner(staffFile);
        ArrayList<String> commands = new ArrayList<>();
        while (input.hasNextLine()){
            String line = input.nextLine();
            commands.add(line);
        }
        return commands;
    }

    public static void writeStoreScheduleToFile(List<String> lines) {
        // TODO
    }

    public static void writeLineToOutputFile(String line) throws IOException {
        // TODO
        PrintWriter writer = new PrintWriter(new BufferedWriter(new FileWriter(outputFile, true)), true);
        writer.println(line);
        switch (line.split(" ")[0]) {
            case "ADD":
                writer.println(line.split(" ")[1] + "was added to inventory");
                break;
            case "COST":
                List<Item> inventory = readInventoryFromFile();
                for(Item i: inventory){
                    if(i.getName().equals(line.split("'")[1])){
                        writer.println(line.split(" ")[1] + ":$" + i.getPrice());
                        break;
                    }
                }
                break;
            case "EXIT":
                writer.println("Thank you for visiting High's Hardware and Gardening!");
                break;
            case "FIND":
                // do this shit later
                writer.println(line.split(" ")[1] + "was added to inventory");
                break;
            case "FIRE":
                List<Staff> staff = readStaffFromFile();
                for(Staff s: staff){
                    if(line.split("'")[1].equals(s.getFullName())){
                        out.print("Found the bitch");
                        break;
                    }
                }
                throw new Error("Dick too big");
                writer.println(line.split(" ")[1] + "was added to inventory");
                break;
            case "HIRE":
                writer.println(line.split(" ")[1] + "was added to inventory");
                break;
            case "PROMOTE":
                writer.println(line.split(" ")[1] + "was added to inventory");
                break;
            case "SAW":
                writer.println(line.split(" ")[1] + "was added to inventory");
                break;
            case "SCHEDULE":
                writer.println(line.split(" ")[1] + "was added to inventory");
                break;
            case "SELL":
                writer.println(line.split(" ")[1] + "was added to inventory");
                break;
            case "QUANTITY":
                writer.println(line.split(" ")[1] + "was added to inventory");
                break;

        }
    }
}
