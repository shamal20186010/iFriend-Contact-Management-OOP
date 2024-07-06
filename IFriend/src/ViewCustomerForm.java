import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ViewCustomerForm extends JFrame{
    private JButton btnReload;
    private JTable tblCustomerDetails;
    private DefaultTableModel dtm;

    ViewCustomerForm(){
        setSize(400,300);
        setTitle("View Customer Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JLabel titleLabel=new JLabel("View Customer Form");
        titleLabel.setFont(new Font("",1,30));
        titleLabel.setHorizontalAlignment(JLabel.CENTER);
        add("North",titleLabel);

        JPanel buttonPanel=new JPanel(new FlowLayout(FlowLayout.CENTER));
        btnReload=new JButton("Reload");
        btnReload.setFont(new Font("",1,20));
        buttonPanel.add(btnReload);
        btnReload.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                dtm.setRowCount(0);
                ArrayList<Customer> customersList = CustomerController.viewCustomer();
                for (int i = 0; i < customersList.size(); i++){
                    Customer customer=customersList.get(i);
                    Object[] rowData={customer.getId(), customer.getName(),customer.getConNo(),customer.getCompanyName(),customer.getSalary(),customer.getBirthday()};
                    dtm.addRow(rowData);
                }
            }
        });
        add("South",buttonPanel);

        //----------------------------------------------
        String[] columnName={"Customer ID", "Name","Contact No","Company","Salary","Birthday"};
        dtm=new DefaultTableModel(columnName,10);
        tblCustomerDetails=new JTable(dtm);
        JScrollPane tablePane=new JScrollPane(tblCustomerDetails);
        add("Center",tablePane);
    }
}
