package edu.iu.c212.Store;

import edu.iu.c212.IStore.IStore;
import edu.iu.c212.Models.Item.Item;
import edu.iu.c212.Models.Staff.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static edu.iu.c212.utils.FileUtils.readCommandsFromFile;
import static edu.iu.c212.utils.FileUtils.writeLineToOutputFile;

public class Store implements IStore {
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

    public void takeAction() throws IOException {
        ArrayList<String> commands = new ArrayList<>();
        for(String s : commands){
            writeLineToOutputFile(s);
        }
    }

    public Store() {
    }


}
