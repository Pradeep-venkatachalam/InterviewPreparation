public class payment {
    int bookingId;
    int price;
    public payment(){

    }
    payment(int bookingId,int price){
        this.bookingId=bookingId;
        this.price=price;
    }
    public int getbookingId() {
        return bookingId;
    }

    public void setbookingId(int bookingId) {
        this.bookingId = bookingId;
    }

    public int getprice() {
        return price;
    }

    public void setprice(int price) {
        this.price = price;
    }


//    int payable(int bookingId,int distance) {
//
//    }


}


