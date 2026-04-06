import java.util.*;
import java.util.HashSet;


public class Main{
    public static void main(String[] args){
       HashSet<VendorDetail> vendetails=new HashSet<>();
       HashSet<ProductDetail> prodetails=new HashSet<>();
       HashSet<CustomerDetail> cusDetail=new HashSet<>();
       VendorDetail vd=new VendorDetail();
       CustomerDetail cd=new CustomerDetail();




       Scanner sc=new Scanner(System.in);
       System.out.print("Enter vendor Id : ");
       vd.setVendorId(sc.nextInt());
       sc.nextLine();

       System.out.print("enter VendorName : ");
       vd.setVentorName(sc.nextLine());

       System.out.print("Enter your Login Time : ");
       vd.setLoginTime(sc.nextLine());

       System.out.print("Enter your Logout Time : ");
       vd.setLogoutTime(sc.nextLine());

       vendetails.add(vd);

       while(true) {
          System.out.println("1:Show vendor Detail ");
          System.out.println("2.To store Customer detail  ");
          System.out.println("3.Product  ");
          System.out.println("4.Bill ");
          System.out.print("Enter your Choice : ");
          int choice = sc.nextInt();
          if(choice ==1) {
             System.out.println(vd);
          }else if(choice==2){
             System.out.print("Enter customerID : ");
             cd.setCustomerId(sc.nextInt());
             sc.nextLine();

             System.out.print("Enter customer Name : ");
             cd.setCustomerName(sc.nextLine());

             System.out.print("Enter Customer Phone Number : ");
             cd.setPhoneNumber(sc.nextLong());
             cusDetail.add(cd);

          } else if (choice==3) {
             System.out.print("How many item you need to bill : ");
             int n=sc.nextInt();
             for(int i=1;i<=n;i++){
                ProductDetail pd=new ProductDetail();
                System.out.print("Enter ProductId : ");
                pd.setProductId(sc.nextInt());
                sc.nextLine();

                System.out.print("Enter Product Name : ");
                pd.setProductName(sc.nextLine());

                System.out.print("Enter Product Price : ");
                pd.setProductPrice(sc.nextInt());
                sc.nextLine();
                System.out.println("---------------------------------");
                prodetails.add(pd);
             }

          }else if(choice==4){
             double totalamount=0;
             System.out.println("----------Bill-----------");
             System.out.println(cd);
             System.out.println("----------X----------");
             for(ProductDetail pdd:prodetails){
                System.out.println(pdd);
                System.out.println("---------------------------------");
             }
             System.out.println("----------X----------");
             for(ProductDetail pdd:prodetails){
                totalamount=totalamount+ pdd.getProductPrice();

             }

             System.out.println("Total Amount : "+totalamount);
             System.out.println("Thank you for purchasing and vist Again");

             
          }
       }

    }
}