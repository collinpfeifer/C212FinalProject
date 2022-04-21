package edu.iu.c212.Models.Staff;

public class Staff {
    private String fullName;
    private int age;
    private String role;

    public Staff (String name, int age, String role){
        this.fullName = name;
        this.age = age;
        this.role = role;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
}
