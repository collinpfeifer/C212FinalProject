package edu.iu.c212.programs;

import edu.iu.c212.models.Staff;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;


import static edu.iu.c212.utils.FileUtils.readStaffFromFile;

public class StaffScheduler {

    public static void main(String[] args) throws IOException {
        scheduleStaff();
    }

    public static void scheduleStaff() throws IOException {
        ArrayList<Staff> staff = (ArrayList<Staff>) readStaffFromFile();
        ArrayList<Double> hours = new ArrayList<>();
        ArrayList<String> schedule = new ArrayList<>();
        ArrayList<ArrayList<String>> days = new ArrayList<>(Arrays.asList(new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>(), new ArrayList<>()));
        for(Staff s: staff) hours.add(0.0);

       while(true) {
           // check which day has the least amount of people working
           int min = Integer.MAX_VALUE;
           ArrayList<String> minDay = new ArrayList<>();
           for (ArrayList<String> a : days) {
                if (a.size() < min) {
                    min = a.size();
                    minDay = a;
                }
           }

           // figure out which day that is and the hours that needs to be worked
           double hoursToWork = 0;
           ArrayList<Staff> canWork = new ArrayList<>();
           String day = "";
           switch (days.indexOf(minDay)) {
               case 0:
                   day = "M";
                   hoursToWork = 9;
                   break;
               case 1:
                   day = "T";
                   hoursToWork = 9;
                   break;
               case 2:
                   day = "W";
                   hoursToWork = 9;
                   break;
               case 3:
                   day = "TR";
                   hoursToWork = 9;
                   break;
               case 4:
                   day = "F";
                   hoursToWork = 9;
                   break;
               case 5:
                   day = "SAT";
                   hoursToWork = 12.5;
                   break;
               case 6:
                   day = "SUN";
                   hoursToWork = 12.5;
                   break;
           }

           // for each staff member check if they are available to work on that day
            for (Staff s : staff) {
                String available = s.getAvailability();
                // if they are available to work then add them to canWork
                // else then we add null
                if (available.contains(day)) {
                    canWork.add(s);
                } else {
                    canWork.add(null);
                }
            }

            // figure out who out of the people who can work, has the lowest amount of hours worked
           int minIndex = 0;
           double minHours = Integer.MAX_VALUE;
            for (int i = 0; i < canWork.size(); i++) {
                if (!(canWork.get(i) == null) && hours.get(i) < minHours) {
                    minHours = hours.get(i);
                    minIndex = i;
                }
            }

            // checking if this person who can work and has the lowest amount of hours already exists in the day
            // that we are trying to schedule, if so then break the loop as we will start repeating people
            if(days.get(days.indexOf(minDay)).contains(staff.get(minIndex).getName())){
                break;
                // else then adding the person to the work schedule and their hours into the hours they work
            } else {
                days.get(days.indexOf(minDay)).add(staff.get(minIndex).getName());
                hours.set(minIndex, hoursToWork + hours.get(minIndex));
            }
        }
        System.out.println(hours);
        System.out.println(days);
    }
}
