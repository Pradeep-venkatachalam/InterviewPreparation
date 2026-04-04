import java.util.*;

public class Main {

    public static driver autoAssignDriver(HashSet<driver> drivers){
        List<driver> availableDrivers = new ArrayList<>();

        for(driver d : drivers){
            if(d.isAvailable()){
                availableDrivers.add(d);
            }
        }

        if(availableDrivers.isEmpty()){
            return null;
        }

        Random rand = new Random();
        return availableDrivers.get(rand.nextInt(availableDrivers.size()));
    }

    public static void main(String[] args){
        HashSet<driver> drivers = new HashSet<>();
        HashSet<user> users = new HashSet<>();

        Scanner sc = new Scanner(System.in);

        drivers.add(new driver("suresh",101,9080990139L));
        drivers.add(new driver("ramesh",102,908094321L));
        drivers.add(new driver("gojo",103,876290139L));
        drivers.add(new driver("Selva",104,9870990139L));
        drivers.add(new driver("Kowshik",105,63690990139L));

        while(true){
            System.out.println("1.Cab Booking");
            System.out.println("2.User Detail");
            System.out.println("3.User Payment");
            System.out.println("4.Exit");

            int option = sc.nextInt();
            sc.nextLine();

            if(option == 1){
                user obj = new user();

                System.out.print("Enter Name: ");
                obj.setname(sc.nextLine());

                System.out.print("Enter User ID: ");

                if (sc.hasNextInt()){
                    obj.setuserId(sc.nextInt());

                }else{
                    System.out.println("Not valid");
                    return;
                }

                sc.nextLine();

                System.out.print("Enter Phone: ");
                obj.setphonenumber(sc.nextLong());
                sc.nextLine();

                System.out.print("Enter Pickup: ");
                obj.setpickuploc(sc.nextLine());

                System.out.print("Enter Destination: ");
                obj.setdestinationloc(sc.nextLine());

                System.out.print("Enter Distance: ");
                obj.setdistance(sc.nextInt());

                driver assignedDriver = autoAssignDriver(drivers);

                if(assignedDriver == null){
                    System.out.println("❌ No drivers available!");
                    continue;
                }

                obj.setdriver(assignedDriver);
                assignedDriver.setAvailable(false);

                users.add(obj);

                System.out.println("✅ Booking Successful!");
                System.out.println("Driver Assigned: " + assignedDriver.getdrivername());
                System.out.println(obj);

            }
            else if(option == 2){
                System.out.print("Enter User ID: ");
                int id = sc.nextInt();

                boolean found = false;

                for(user u : users){
                    if(u.getuserId() == id){
                        System.out.println(u);
                        System.out.println("Driver: " + u.getdriver().getdrivername());
                        found = true;
                        break;
                    }
                }

                if(!found){
                    System.out.println("User not found!");
                }
            }
            else if(option == 3){
                System.out.print("Enter User ID: ");
                int id = sc.nextInt();

                for(user u : users){
                    if(u.getuserId() == id){
                        System.out.println();
                        System.out.println("Total Payment: " + u.totalCharge());
                    }
                }
            }
            else if(option == 4){
                System.out.println("Thank you for come And please come Again4");
                break;
            }
        }
    }
}