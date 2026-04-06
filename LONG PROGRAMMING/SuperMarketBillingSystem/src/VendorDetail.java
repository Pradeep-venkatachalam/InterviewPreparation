public class VendorDetail {
    String VentorName;
    int VendorId;
    String LoginTime;
    String LogoutTime;
    public VendorDetail(){

    }
    VendorDetail(String VentorName,int VendorId,String LoginTime,String LogoutTime){
        this.VentorName=VentorName;
        this.VendorId=VendorId;
        this.LoginTime=LoginTime;
        this.LogoutTime=LogoutTime;
    }

    public String getVentorName() {
        return VentorName;
    }

    public void setVentorName(String ventorName) {
        VentorName = ventorName;
    }

    public int getVendorId() {
        return VendorId;
    }

    public void setVendorId(int vendorId) {
        VendorId = vendorId;
    }

    public String getLoginTime() {
        return LoginTime;
    }

    public void setLoginTime(String loginTime) {
        LoginTime = loginTime;
    }

    public String getLogoutTime() {
        return LogoutTime;
    }

    public void setLogoutTime(String logoutTime) {
        LogoutTime = logoutTime;
    }

    @Override
    public String toString() {
        return "Vendor Id : "+getVendorId()+
                "\nVendor Name : "+getVendorId()+
                "\nLogin Time : "+getLoginTime()+
                "\nLogout Time : "+getLogoutTime();
    }
}
