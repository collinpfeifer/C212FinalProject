package edu.iu.c212.IStore;

import edu.iu.c212.Models.Item.Item;
import edu.iu.c212.Models.Staff.Staff;

import java.io.IOException;
import java.util.List;

public interface IStore {
    public List<Item> getItemsFromFile();

    public List<Staff> getStaffFromFile();

    public void saveItemsFromFIle();

    public void saveStaffFromFile();

    public void takeAction() throws IOException;

}