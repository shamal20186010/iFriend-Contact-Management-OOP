import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IFriend extends JFrame {
    public static final ArrayList<Customer> customerList=new ArrayList<>();

    private JButton btnAddCustomer;
    private JButton btnSearchCustomer;
    private JButton btnDeleteCustomer;
    private JButton btnUpdateCustomer;
    private JButton btnViewCustomer;
    private JButton btnExit;

    private AddCustomerForm addCustomerForm;
    private ViewCustomerForm viewCustomerForm;

    IFriend(){
        setSize(600,400);
        setTitle("Main Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6,1));


    }
    public static void main(String args[]){

        new CustomerMainForm().setVisible(true);
    }
}
