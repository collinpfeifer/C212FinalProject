package edu.iu.c212;

import edu.iu.c212.IStore;
import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;
import edu.iu.c212.programs.SawPrimePlanks;
import edu.iu.c212.programs.StaffScheduler;
import edu.iu.c212.programs.StoreMap;
import edu.iu.c212.programs.StoreMapDisplay;
import edu.iu.c212.utils.FileUtils;

import javax.swing.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static edu.iu.c212.utils.FileUtils.*;

public class Store implements IStore {

    public void takeAction() throws IOException {
        ArrayList<String> commands = (ArrayList<String>) readCommandsFromFile();
        ArrayList<Item> inventory = (ArrayList<Item>) getItemsFromFile();
        ArrayList<Staff> staff = (ArrayList<Staff>) getStaffFromFile();
        Scanner in = new Scanner(System.in);
        loop: for(String s: commands){
            switch(s.split(" ")[0]) {
                case "ADD":
                    String name = "'" + s.split("'")[1] + "'";
                    double cost = Double.parseDouble(s.split("\\s+")[3]);
                    int quantity = Integer.parseInt(s.split("\\s+")[4]);
                    int aisleNum = Integer.parseInt(s.split("\\s+")[5]);
                    inventory.add(new Item(name, cost, quantity, aisleNum));
                    writeLineToOutputFile(s.split("'")[1] + " was added to inventory");
                    break;
                case "COST":
                    for (Item i : inventory) {
                        if (i.getName().equals("'" + s.split("'")[1] + "'")) {
                            writeLineToOutputFile(s.split("'")[1] + ": $" + i.getPrice());
                            break;
                        }
                    }
                    break;
                case "EXIT":
                    writeLineToOutputFile("Thank you for visiting High's Hardware and Gardening!");
                    System.out.println("Press enter to continue: ");
                    if(in.nextLine().equals("")){
                       break loop;
                    }
                    break;
                case "FIND":
                    String justa = s.split("'")[1];

                    int aisleNumb = 0;

                    boolean found = false;
                    for (Item item : inventory) {

                        if (item.getName().equals("'" + justa + "'")) {
                            found = true;
                            writeLineToOutputFile("Performing store lookup for " + justa);
                            aisleNumb = item.getAisle();
                        }
                    }
                    if(found){
                        JFrame frame = new JFrame("Store Map Display");
                        frame.setSize(700, 500);
                        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                        StoreMapDisplay.display("High's Hardware Product Lookup: " + justa, aisleNumb);
                    } else {
                        writeLineToOutputFile("ERROR: " + justa + " cannot be found");
                    }
                    break;
                case "FIRE":
                    boolean staffFound = false;
                    Staff foundMember = null;
                    for (Staff st: staff) {
                        if(st.getName().equals(s.split("'")[1])){
                            foundMember = st;
                            staffFound = true;
                            break;
                        }
                    }
                    if(!staffFound){
                        writeLineToOutputFile("ERROR: " + (s.split("'")[1]) + " cannot be found");
                    } else{
                        staff.remove(foundMember);
                        writeLineToOutputFile((s.split("'")[1]) + " was fired");
                    }
                    break;
                case "HIRE":
                    staff.add(new Staff(s.split("'")[1], Integer.parseInt(s.split(" ")[3]), s.split(" ")[4]));
                    writeLineToOutputFile(s.split("'")[1] + " has been hired as a " + s.split(" ")[4]);
                    break;
                case "PROMOTE":
                    for(Staff sp: staff){
                        if(sp.getName().equals(s.split("'")[1])){
                            sp.setRole(s.split(" ")[3]);
                            writeStaffToFile(staff);
                            writeLineToOutputFile(sp.getName() + " was promoted to " + s.split(" ")[3]);
                            break;
                        }
                    }
                    break;
                case "SAW":
                    Item wood = null;
                    int index = 0;
                    for(Item it: inventory){
                        if(it.getName().equals("'Wood'")){
                            wood = it;
                            index = inventory.indexOf(it);
                            break;
                        }
                    }
                    assert wood != null;
                    wood.setName("'Plank-" + Math.sqrt(wood.getPrice()) + "'");
                    wood.setQuantity(SawPrimePlanks.getPlankLengths((int) Math.sqrt(wood.getPrice())).size());
                    inventory.set(index, wood);
                    writeLineToOutputFile("Planks sawed");
                    break;
                case "SCHEDULE":
                    StaffScheduler.scheduleStaff();
                    writeLineToOutputFile("Schedule created");
                    break;
                case "SELL":
                    boolean sellFound = false;
                    for (Item i : inventory) {
                        if (i.getName().equals("'" + s.split("'")[1] + "'") && i.getQuantity() > Integer.parseInt(s.split(" ")[2])) {
                            i.setQuantity(i.getQuantity() - Integer.parseInt(s.split(" ")[2]));
                            sellFound = true;
                            break;
                        }
                    }
                    if(!sellFound){
                        writeLineToOutputFile("ERROR: " + s.split("'")[1] + " could not be sold");
                    } else {
                        writeLineToOutputFile(s.split(" ")[2] + " " + s.split("'")[1] + " was sold");
                    }
                    break;
                case "QUANTITY":
                    for (Item i : inventory) {
                        if (i.getName().equals("'" + s.split("'")[1] + "'")) {
                            writeLineToOutputFile(s.split("'")[1] + ": " + i.getQuantity());
                            break;
                        }
                    }
                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s.split(" ")[0]);
            }
        }
        writeInventoryToFile(inventory);
        writeStaffToFile(staff);
    }
    public Store() throws IOException {
        takeAction();
    }

    @Override
    public List<Item> getItemsFromFile() {
        List<Item> items = null;
        try{
            items = FileUtils.readInventoryFromFile();
        } catch (Exception e){
            System.exit(1);
        }
        return items;
    }

    @Override
    public List<Staff> getStaffFromFile() {
        List<Staff> staff = null;
        try{
            staff = FileUtils.readStaffFromFile();
        } catch (Exception e){
            System.exit(1);
        }
        return staff;
    }

    @Override
    public void saveItemsFromFile() {
        List<Item> items = null;
        try{
            writeInventoryToFile(items);
        } catch (Exception e){
            System.exit(1);
        }
    }

    @Override
    public void saveStaffFromFile() {
        List<Staff> staff = null;
        try{
           writeStaffToFile(staff);
        } catch (Exception e){
            System.exit(1);
        }
    }


}
