package edu.iu.c212;

import edu.iu.c212.IStore;
import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;
import edu.iu.c212.programs.SawPrimePlanks;
import edu.iu.c212.programs.StaffScheduler;
import edu.iu.c212.programs.StoreMap;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import static edu.iu.c212.utils.FileUtils.*;

public class Store implements IStore {

    public void takeAction() throws IOException {
        ArrayList<String> commands = (ArrayList<String>) readCommandsFromFile();
        ArrayList<Item> inventory = (ArrayList<Item>) readInventoryFromFile();
        ArrayList<Staff> staff = (ArrayList<Staff>) readStaffFromFile();
        Scanner in = new Scanner(System.in);
        loop: for(String s: commands){
            switch(s.split(" ")[0]) {
                case "ADD":
                    String name = s.split("‘")[1];
                    double cost = Double.parseDouble(s.split(" ")[3]);
                    int quantity = Integer.parseInt(s.split(" ")[4]);
                    int aisleNum = Integer.parseInt(s.split(" ")[5]);
                    inventory.add(new Item(name, cost, quantity, aisleNum));
                    writeLineToOutputFile(name + " was added to inventory");
                    break;
                case "COST":
                    for (Item i : inventory) {
                        if (i.getName().equals(s.split("‘")[1])) {
                            writeLineToOutputFile("$" + i.getPrice());
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
                    // do this shit later
                    StoreMap map = new StoreMap(8);
                    break;
                case "FIRE":
                    //wtf is this
                    boolean found = false;
                    for (Staff st: staff) {
                        if(st.getName().equals(s.split("‘")[1])){
                            staff.remove(st);
                            found = true;
                        }
                    }
                    if(!found){
                        writeLineToOutputFile("ERROR: " + (s.split("‘")[1]) + " cannot be found");
                    } else{
                        writeLineToOutputFile((s.split("‘")[1]) + " was fired");
                    }
                    break;
                case "HIRE":
                    staff.add(new Staff(s.split("‘")[1], Integer.parseInt(s.split(" ")[3]), s.split(" ")[4]));
                    writeLineToOutputFile(s.split("‘")[1] + " has been hired as a " + s.split(" ")[4]);
                    break;
                case "PROMOTE":
                    for(Staff sp: staff){
                        if(sp.getName().equals(s.split("‘")[1])){
                            sp.setRole(s.split(" ")[3]);
                            writeStaffToFile(staff);
                            writeLineToOutputFile(sp.getName() + " was promoted to " + s.split(" ")[3]);
                            break;
                        }
                    }
                    break;
                case "SAW":
                    for(Item it: inventory){
                        if(it.getName().equals("Wood")){
                            it.setName("Plank-" + Math.sqrt(it.getPrice()));
                            it.setQuantity(SawPrimePlanks.getPlankLengths((int) Math.sqrt(it.getPrice())).size());
                        }
                        writeLineToOutputFile("Planks sawed");
                    }
                    break;
                case "SCHEDULE":
                    StaffScheduler.scheduleStaff();
                    writeLineToOutputFile("Schedule created");
                    break;
                case "SELL":

                    break;
                case "QUANTITY":

                    break;
                default:
                    throw new IllegalStateException("Unexpected value: " + s.split(" ")[0]);
            }
        }
    }
    public Store(){

    }

    @Override
    public List<Item> getItemsFromFile() {
        return null;
    }

    @Override
    public List<Staff> getStaffFromFile() {
        return null;
    }

    @Override
    public void saveItemsFromFIle() {

    }

    @Override
    public void saveStaffFromFile() {

    }


}
