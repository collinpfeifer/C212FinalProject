package edu.iu.c212;

import edu.iu.c212.models.Item;
import edu.iu.c212.models.Staff;

import java.io.IOException;
import java.util.List;

public interface IStore {
    public List<Item> getItemsFromFile();

    public List<Staff> getStaffFromFile();

    public void saveItemsFromFile();

    public void saveStaffFromFile();

    public void takeAction() throws IOException;
}
