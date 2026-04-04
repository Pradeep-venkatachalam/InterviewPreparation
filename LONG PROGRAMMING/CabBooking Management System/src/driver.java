public class driver {
    private String drivername;
    private int driverId;
    private long drivernum;
    private boolean isAvailable;

    public driver(){}

    public driver(String drivername, int driverId, long drivernum){
        this.drivername = drivername;
        this.driverId = driverId;
        this.drivernum = drivernum;
        this.isAvailable = true;
    }

    public String getdrivername() {
        return drivername;
    }

    public void setdrivername(String drivername) {
        this.drivername = drivername;
    }

    public int getdriverId() {
        return driverId;
    }

    public void setdriverId(int driverId) {
        this.driverId = driverId;
    }

    public long getdrivernum() {
        return drivernum;
    }

    public void setdrivernum(long drivernum) {
        this.drivernum = drivernum;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString(){
        return "Driver Name: " + drivername +
                "\nDriver ID: " + driverId +
                "\nPhone: " + drivernum +
                "\nAvailable: " + isAvailable +
                "\n----------------------";
    }
}