package edu.iu.c212.programs;

import edu.iu.c212.models.Staff;

import java.io.IOException;
import java.util.ArrayList;


import static edu.iu.c212.utils.FileUtils.readStaffFromFile;

public class StaffScheduler {

    public static void main(String[] args) throws IOException {
        scheduleStaff();
    }

    public static void scheduleStaff() throws IOException {
        ArrayList<Staff> staff = (ArrayList<Staff>) readStaffFromFile();
        ArrayList<Double> hours = new ArrayList<>();
        ArrayList<String> schedule = new ArrayList<>();
        ArrayList<ArrayList<String>> days = new ArrayList<>(7);
        for(int i = 0; i < 7; i++){
            days.add(new ArrayList<>());
        }
        for(Staff s: staff){
            hours.add(0.0);
        }
        // when the person who has worked the least amoutn of hours has fufilled their avaiability
        loop: while(true) {
            ArrayList<Staff> canWork = new ArrayList<>();
            int min = Integer.MIN_VALUE;
            ArrayList<String> minDay = new ArrayList<>();
            for (ArrayList<String> a : days) {
                if (a.size() < min) {
                    min = a.size();
                    minDay = a;
                }
            }
            double hoursToWork = 0;
            for (Staff s : staff) {
                String available = s.getAvailability();
                int index = days.indexOf(minDay);
                String day = "";
                switch (index) {
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
                if (available.contains(day)) {
                    canWork.add(s);
                } else {
                    canWork.add(null);
                }
            }
            double minHours = Integer.MAX_VALUE;
            int minIndex = 0;
            for (int i = 0; i < canWork.size(); i++) {
                if (canWork.get(i) == null) {
                } else if (hours.get(i) < minHours) {
                    minHours = hours.get(i);
                    minIndex = i;
                }
            }
            if(days.get(days.indexOf(minDay)).contains(staff.get(minIndex).getName())){
                break loop;
            }
            days.get(days.indexOf(minDay)).add(staff.get(minIndex).getName());
            hours.set(minIndex, hoursToWork);
            System.out.println(hours);
        }
    }
}
