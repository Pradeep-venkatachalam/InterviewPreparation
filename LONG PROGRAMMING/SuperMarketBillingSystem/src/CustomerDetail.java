public class CustomerDetail {
    String CustomerName;
    int CustomerId;
    long PhoneNumber;
    public CustomerDetail(){

    }
    CustomerDetail(String CustomerName,int CustomerId,long PhoneNumber){
        this.CustomerId=CustomerId;
        this.CustomerName=CustomerName;
        this.PhoneNumber=PhoneNumber;
    }

    public String getCustomerName() {
        return CustomerName;
    }

    public void setCustomerName(String customerName) {
        CustomerName = customerName;
    }

    public int getCustomerId() {
        return CustomerId;
    }

    public void setCustomerId(int customerId) {
        CustomerId = customerId;
    }

    public long getPhoneNumber() {
        return PhoneNumber;
    }

    public void setPhoneNumber(long phoneNumber) {
        PhoneNumber = phoneNumber;
    }
    @Override
    public String toString(){
        return "Customer ID : "+getCustomerId()+
                "\nCustomer Name : "+getCustomerName()+
                "\nCustomer mobile Number : "+getPhoneNumber();
    }
}
