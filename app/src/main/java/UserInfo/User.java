package UserInfo;

public class User {
    // User instance variables
    private boolean newUser;
    private String name;
    private double height;
    private double weight;
    private boolean inches;
    private boolean cm;
    private boolean pounds;
    private boolean kg;

    // Default Constructor
    public User() {
    }

    // Overloaded constructor to store user information
    public User(String name, double height, double weight){
        this.name = name;
        this.height = height;
        this.weight = weight;
        this.inches = false;
        this.cm = false;
        this.pounds = false;
        this.kg = false;
    }


    // Getters and setters
    public boolean isNewUser() {
        return newUser;
    }

    public void setNewUser(boolean newUser) {
        this.newUser = newUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getHeight() {
        return height;
    }

    public void setHeight(double height) {
        this.height = height;
    }

    public double getWeight() {
        return weight;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public boolean isInches() {
        return inches;
    }

    public void setInches(boolean inches) {
        this.inches = inches;
    }

    public boolean isCm() {
        return cm;
    }

    public void setCm(boolean cm) {
        this.cm = cm;
    }

    public boolean isPounds() {
        return pounds;
    }

    public void setPounds(boolean pounds) {
        this.pounds = pounds;
    }

    public boolean isKg() {
        return kg;
    }

    public void setKg(boolean kg) {
        this.kg = kg;
    }
}
