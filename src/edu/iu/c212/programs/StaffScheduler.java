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
        for(Staff s: staff){
            hours.add(0.0);
        }
        // when the person who has worked the least amoutn of hours has fufilled their avaiability
       while(true) {
            ArrayList<Staff> canWork = new ArrayList<>();
           ArrayList<String> minDay = new ArrayList<>();
           int min = Integer.MAX_VALUE;
           double hoursToWork = 0;
           double minHours = Integer.MAX_VALUE;
           int minIndex = 0;


           for (ArrayList<String> a : days) {
                if (a.size() < min) {
                    min = a.size();
                    minDay = a;
                }
            }
            for (Staff s : staff) {
                String available = s.getAvailability();
                int index = days.indexOf(minDay);
                String day = "";
                switch (index) {
                    case 0 -> {
                        day = "M";
                        hoursToWork = 9;
                    }
                    case 1 -> {
                        day = "T";
                        hoursToWork = 9;
                    }
                    case 2 -> {
                        day = "W";
                        hoursToWork = 9;
                    }
                    case 3 -> {
                        day = "TR";
                        hoursToWork = 9;
                    }
                    case 4 -> {
                        day = "F";
                        hoursToWork = 9;
                    }
                    case 5 -> {
                        day = "SAT";
                        hoursToWork = 12.5;
                    }
                    case 6 -> {
                        day = "SUN";
                        hoursToWork = 12.5;
                    }
                }
                if (available.contains(day)) {
                    canWork.add(s);
                } else {
                    canWork.add(null);
                }
            }

            for (int i = 0; i < canWork.size(); i++) {
                if (!(canWork.get(i) == null) && hours.get(i) < minHours) {
                    minHours = hours.get(i);
                    minIndex = i;
                }
            }

            if(days.get(days.indexOf(minDay)).contains(staff.get(minIndex).getName())){
                break;
            }

            days.get(days.indexOf(minDay)).add(staff.get(minIndex).getName());
            hours.set(minIndex, hoursToWork + hours.get(minIndex));
            System.out.println(hours);
           System.out.println(days);
        }
    }
}
