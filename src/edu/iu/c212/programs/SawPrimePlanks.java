package edu.iu.c212.programs;
import java.util.ArrayList;
import java.util.List;

public class SawPrimePlanks {
    public static List<Integer> getPlankLengths(int longPlankLength){
        ArrayList<Integer> planks = new ArrayList<>();
        int length = sawPlank(longPlankLength);
        for(int i = 0; i < longPlankLength/length; i++){
            planks.add(length);
        }
        return planks;
    }

    public static int sawPlank(int plankLength){
        int length = plankLength;
        for(int i = 0; i < length; i++){
            if(isPrime(i)){
                if(length%i==0){
                    length = length/i;
                    sawPlank(length);
                }
            }
        }
        return length;
    }

    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; i < n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

}
