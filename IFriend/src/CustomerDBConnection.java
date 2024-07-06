import java.util.ArrayList;

public class CustomerDBConnection {
    private ArrayList<Customer> customerList;
    private static CustomerDBConnection customerDBConnection;
    private CustomerDBConnection(){
        customerList=new ArrayList<>();
    }
    public static CustomerDBConnection getInstance(){
        if(customerDBConnection==null){
            customerDBConnection=new CustomerDBConnection();
        }
        return customerDBConnection;
    }
    public ArrayList<Customer>getCustomerList(){
        return customerList;
    }
}
