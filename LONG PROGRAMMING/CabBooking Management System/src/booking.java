public class booking {
    int vehicleId;
    int bookingId;


    booking(int vehicleId,int bookingId){
        this.bookingId=bookingId;


    }

    public booking() {

    }



    public int getBookingId() {
        return bookingId;
    }

    public void setBookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }
    public String toString(){
        return "bookingId"+bookingId+"vehicleId"+vehicleId;
    }


}
