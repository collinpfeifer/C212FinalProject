package edu.iu.c212.models.Staff;

public class Staff {
    private String fullName;
    private int age;
    private String role;
    private String availability;

    public Staff(String name, int age, String role, String availability){
        this.fullName = name;
        this.age = age;
        this.role = role;
        this.availability = availability;
    }

    public Staff(String name, int age, String role){
        this.fullName = name;
        this.age = age;
        this.role = role;
        this.availability = "M.T.W.TR.F.SAT.SUN";
    }

    public String getName(){
        return fullName;
    }

    public int getAge(){
        return age;
    }

    public String getRole(){
        return role;
    }

    public String getAvailability(){
        return availability;
    }
}
