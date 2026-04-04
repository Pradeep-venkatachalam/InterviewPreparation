public class user {
    private String name;
    private int userId;
    private long phonenumber;
    private String pickuploc;
    private String destinationloc;
    private int distance;
    private driver assignedDriver;

    public user(){}

    public void setname(String name){
        this.name = name;
    }

    public void setuserId(int userId){
        this.userId = userId;
    }

    public void setphonenumber(long phonenumber){
        this.phonenumber = phonenumber;
    }

    public void setpickuploc(String pickuploc){
        this.pickuploc = pickuploc;
    }

    public void setdestinationloc(String destinationloc){
        this.destinationloc = destinationloc;
    }

    public void setdistance(int distance){
        this.distance = distance;
    }

    public int getuserId(){
        return userId;
    }

    public void setdriver(driver d){
        this.assignedDriver = d;
    }

    public driver getdriver(){
        return assignedDriver;
    }

    public int totalCharge(){
        return distance * 10;
    }

    @Override
    public String toString(){
        return "Name: " + name +
                "\nUser ID: " + userId +
                "\nPhone: " + phonenumber +
                "\nPickup: " + pickuploc +
                "\nDestination: " + destinationloc +
                "\nDistance: " + distance +
                "\n----------------------";
    }
}