import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class CustomerController {
    private static String ar = null;

    public static boolean addCustomer(Customer customer) {
        ArrayList<Customer> customerList = CustomerDBConnection.getInstance().getCustomerList();
        return customerList.add(customer);
    }

    public static void updateContacts(String id, String name, String conNo, String comoany, double salary, String birthday, int index) {
        Customer contact = getContact(index);
        contact.setName(name);
        contact.setConNo(conNo);
        contact.setSalary(salary);
        contact.setCompany(comoany);
        contact.setBirthday(birthday);
    }

    public static boolean deleteContact(int index) {
        CustomerDBConnection.getInstance().getCustomerList().remove(index);
        return true;
    }

    public static boolean deleteContact(Customer customer) {
        return CustomerDBConnection.getInstance().getCustomerList().remove(customer);
    }


    public static ArrayList<Customer> viewCustomer() {
        ArrayList<Customer> customerList = CustomerDBConnection.getInstance().getCustomerList();
        return customerList;
    }

    public static int getindex(String text) {
        ArrayList<Customer> contactList = CustomerDBConnection.getInstance().getCustomerList();
        if (!contactList.isEmpty()) {
            for (int i = 0; i < contactList.size(); i++) {
                Customer contact = contactList.get(i);
                if (text.equalsIgnoreCase(contact.getName()) || text.equalsIgnoreCase(contact.getConNo())) {
                    return i;
                }
            }
        }
        return -1;
    }

    //---------------------------SEARCH METHOD--------------------------
    public static void storeSearch(String a) {
        ar = a;
    }

    public static String getSearch() {
        return ar;
    }

    public static String generateId() {
        ArrayList<Customer> contactList = CustomerDBConnection.getInstance().getCustomerList();
        if (contactList.size() + 1 == 0) {
            return "C0001";
        } else {
            return String.format("C%04d", contactList.size() + 1);
        }

    }

    //------------------------VALIDATE PHONENUMBER---------------------------
    public static boolean isValidPhoneNumber(String phoneNumber) {
        if (phoneNumber.length() == 10 && phoneNumber.charAt(0) == '0') {
            for (int i = 1; i < phoneNumber.length(); i++) {
                if (!Character.isDigit(phoneNumber.charAt(i))) {
                    return false;
                }
            }
            return true;
        }
        return false;
    }

    public static Customer getContact(int index) {
        ArrayList<Customer> contactList = CustomerDBConnection.getInstance().getCustomerList();
        return contactList.get(index);
    }

    //-------------------VALIDATE SALARY----------------------
    public static boolean isValidSalary(double salary) {
        return salary > 0;
    }

    // -------------------BIRTHDAY VALIDATION----------------
    public static boolean isValidBirthday(String birthday) {
        String y = birthday.substring(0, 4);
        int year = Integer.parseInt(y);
        String m = birthday.substring(5, 7);
        int month = Integer.parseInt(m);
        String d = birthday.substring(8, 10);
        int day = Integer.parseInt(d);
        LocalDate currentDate = LocalDate.now();
        int currentMonthValue = currentDate.getMonthValue();
        int currentYear = currentDate.getYear();
        int currentMonthDate = currentDate.getDayOfMonth();

        if ((year % 400 == 0 || year % 4 != 0) & month == 2) {
            if (day > 28) {
                return false;
            } else {
                return true;
            }
        }
        if ((year % 400 == 0 || year % 4 == 0) & month == 2) {
            if (day > 29) {
                return false;
            } else {
                return true;
            }
        }
        if (month == 4 || month == 6 || month == 9 || month == 11) {
            if (day > 30) {
                return false;
            }
        }
        if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
            if (day > 31) {
                return false;
            }
        }
        if (month > 12) {
            return false;
        }
        if (year < currentYear) {
            return true;
        } else if (year == currentYear) {

            if (month > currentMonthValue) {
                return true;
            } else if (month == currentMonthValue) {

                if (day <= currentMonthDate) {
                    return true;
                }
            }
        }
        return false;
    }
    public static  ArrayList<Customer>nameSort(){
        ArrayList<Customer>contactList=CustomerDBConnection.getInstance().getCustomerList();
        contactList.sort(Comparator.comparing(Customer::getName));
        return contactList;
    }
    public static  ArrayList<Customer>salarySort(){
        ArrayList<Customer>contactList=CustomerDBConnection.getInstance().getCustomerList();
        contactList.sort(Comparator.comparingDouble(Customer::getSalary));
        return contactList;
    }
    public static  ArrayList<Customer>birthdaySort(){
        ArrayList<Customer>contactList=CustomerDBConnection.getInstance().getCustomerList();
        contactList.sort(Comparator.comparing(Customer::getBirthday));
        return contactList;
    }
}
