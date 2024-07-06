import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;

public class ContactController {
    private static String ar = null;

    public static boolean addCustomer(Contact contact) {
        ArrayList<Contact> contactList = ContactDBConnection.getInstance().getCustomerList();
        return contactList.add(contact);
    }

    public static void updateContacts(String id, String name, String conNo, String comoany, double salary, String birthday, int index) {
        Contact contact = getContact(index);
        contact.setName(name);
        contact.setConNo(conNo);
        contact.setSalary(salary);
        contact.setCompany(comoany);
        contact.setBirthday(birthday);
    }

    public static boolean deleteContact(int index) {
        ContactDBConnection.getInstance().getCustomerList().remove(index);
        return true;
    }

    public static boolean deleteContact(Contact contact) {
        return ContactDBConnection.getInstance().getCustomerList().remove(contact);
    }


    public static ArrayList<Contact> viewCustomer() {
        ArrayList<Contact> contactList = ContactDBConnection.getInstance().getCustomerList();
        return contactList;
    }

    public static int getindex(String text) {
        ArrayList<Contact> contactList = ContactDBConnection.getInstance().getCustomerList();
        if (!contactList.isEmpty()) {
            for (int i = 0; i < contactList.size(); i++) {
                Contact contact = contactList.get(i);
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
        ArrayList<Contact> contactList = ContactDBConnection.getInstance().getCustomerList();
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

    public static Contact getContact(int index) {
        ArrayList<Contact> contactList = ContactDBConnection.getInstance().getCustomerList();
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

    public static ArrayList<Contact> nameSort() {
        ArrayList<Contact> contactList = ContactDBConnection.getInstance().getCustomerList();
        contactList.sort(Comparator.comparing(Contact::getName));
        return contactList;
    }

    public static ArrayList<Contact> salarySort() {
        ArrayList<Contact> contactList = ContactDBConnection.getInstance().getCustomerList();
        contactList.sort(Comparator.comparingDouble(Contact::getSalary));
        return contactList;
    }

    public static ArrayList<Contact> birthdaySort() {
        ArrayList<Contact> contactList = ContactDBConnection.getInstance().getCustomerList();
        contactList.sort(Comparator.comparing(Contact::getBirthday));
        return contactList;
    }
}
