import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddContactForm extends JFrame {
    private JButton btnAddCustomer;
    private JButton btnCancel;
    private JButton btnBackToHome;

    private JLabel txtId;
    private JTextField txtName;
    private JTextField txtContactNo;
    private JTextField txtCompay;
    private JTextField txtSalary;
    private JTextField txtBirthday;

    private AddContactForm addContactForm;
    AddContactForm(){

        setSize(500, 600);
        setTitle("Add Contact Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JPanel titlePanale = new JPanel();
        titlePanale.setBounds(0, 0, 500, 60);
        titlePanale.setBackground(new Color(255, 204, 0));
        JLabel titleLabel = new JLabel("ADD CONTACT");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setBounds(0, 10, 400, 40);
        titlePanale.add(titleLabel);
        add(titlePanale);

        JPanel mainPanale = new JPanel();
        mainPanale.setBackground(new Color(255, 255, 255, 255));
        mainPanale.setBounds(0, 0, 500, 600);

        btnAddCustomer = new JButton("Add");
        btnAddCustomer.setBounds(200, 450, 125, 30);
        add(btnAddCustomer);
        btnAddCustomer.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                try {
                    String id = txtId.getText();
                    String name = txtName.getText();
                    String conNo = txtContactNo.getText();
                    String company = txtCompay.getText();
                    double salary = Double.parseDouble(txtSalary.getText());
                    String birthday = txtBirthday.getText();
                    Contact contact = new Contact(id, name, conNo, company, salary, birthday);

                    boolean isValidPhoneNumber = ContactController.isValidPhoneNumber(conNo);
                    boolean isValidSalary = ContactController.isValidSalary(salary);
                    boolean isValidBirthday = ContactController.isValidBirthday(birthday);

                    if (!isValidPhoneNumber) {
                        int option = JOptionPane.showConfirmDialog(null, "Invalid phone number...Do you want to input phone number again");
                        if (option == JOptionPane.YES_OPTION) {
                            txtContactNo.setText("");
                            txtContactNo.requestFocus();
                        } else if (option == JOptionPane.NO_OPTION) {
                            txtId.setText(ContactController.generateId());
                            txtName.setText("");
                            txtContactNo.setText("");
                            txtCompay.setText("");
                            txtSalary.setText("");
                            txtBirthday.setText("");
                            dispose();
                        }

                    } else if (!isValidSalary) {
                        int option = JOptionPane.showConfirmDialog(null, "Invalid Salary...Do you want to input Salary again");
                        if (option == JOptionPane.YES_OPTION) {
                            txtSalary.setText("");
                            txtSalary.requestFocus();
                        } else if (option == JOptionPane.NO_OPTION) {
                            txtId.setText(ContactController.generateId());
                            txtName.setText("");
                            txtContactNo.setText("");
                            txtCompay.setText("");
                            txtSalary.setText("");
                            txtBirthday.setText("");
                            dispose();
                        }
                    } else if (!isValidBirthday) {
                        int option = JOptionPane.showConfirmDialog(null, "Invalid Birthday...Do you want to input Birthday again");
                        if (option == JOptionPane.YES_OPTION) {
                            txtBirthday.setText("");
                            txtBirthday.requestFocus();
                        } else if (option == JOptionPane.NO_OPTION) {
                            txtId.setText(ContactController.generateId());
                            txtName.setText("");
                            txtContactNo.setText("");
                            txtCompay.setText("");
                            txtSalary.setText("");
                            txtBirthday.setText("");
                            dispose();
                        }
                    } else{
                        ArrayList<Contact> contactList= ContactDBConnection.getInstance().getCustomerList();
                        int y=contactList.size();
                        contactList.add(contact);
                        if(contactList.size()==++y){
                            int option=JOptionPane.showConfirmDialog(null,"Contact has been Added...Do you want to add another Contact?");
                            if(option==JOptionPane.YES_OPTION){
                                txtId.setText(ContactController.generateId());
                                txtName.setText("");
                                txtContactNo.setText("");
                                txtCompay.setText("");
                                txtSalary.setText("");
                                txtBirthday.setText("");
                                txtName.requestFocus();
                            }else if(option==JOptionPane.NO_OPTION){
                                AddContactForm.this.dispose();
                            }
                        }
                    }
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        });
        add(btnAddCustomer);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(325, 450, 125, 30);
        add(btnCancel);
        btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                txtName.setText("");
                txtContactNo.setText("");
                txtCompay.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
            }
        });
        add(btnCancel);

        btnBackToHome = new JButton("Back To Home");
        btnBackToHome.setBounds(200, 500, 250, 30);
        add(btnBackToHome);
        btnBackToHome.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                txtName.setText("");
                txtContactNo.setText("");
                txtCompay.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
                dispose();
            }
        });
        add(btnBackToHome);

        JLabel llbId =new JLabel("Contact ID");
        llbId.setFont(new Font("",1,18));
        llbId.setBounds(60,170,300,25);
        add(llbId);

        JLabel llbName =new JLabel("Name");
        llbName.setFont(new Font("",1,18));
        llbName.setBounds(60,200,300,25);
        add(llbName);

        JLabel llbConNO =new JLabel("Contact Number");
        llbConNO.setFont(new Font("",1,18));
        llbConNO.setBounds(60,230,300,25);
        add(llbConNO);

        JLabel llbCompany =new JLabel("Company");
        llbCompany.setFont(new Font("",1,18));
        llbCompany.setBounds(60,260,300,25);
        add(llbCompany);

        JLabel llbSalary =new JLabel("Salary");
        llbSalary.setFont(new Font("",1,18));
        llbSalary.setBounds(60,290,300,25);
        add(llbSalary);

        JLabel llbBirthday =new JLabel("Birthday");
        llbBirthday.setFont(new Font("",1,18));
        llbBirthday.setBounds(60,320,300,25);
        add(llbBirthday);

        txtId = new JLabel("");
        txtId.setFont(new Font("", 1, 18));
        txtId.setBounds(250, 170, 300, 25);
        txtId.setText(ContactController.generateId());
        add(txtId);

        txtName=new JTextField(10);
        txtName.setFont(new Font("",1,20));
        add(txtName);

        txtName = new JTextField("");
        txtName.setFont(new Font("", 1, 18));
        txtName.setBounds(250, 202, 150, 25);
        add(txtName);

        txtContactNo = new JTextField("");
        txtContactNo.setFont(new Font("", 1, 18));
        txtContactNo.setBounds(250, 232, 150, 25);
        add(txtContactNo);

        txtCompay = new JTextField("");
        txtCompay.setFont(new Font("", 1, 18));
        txtCompay.setBounds(250, 262, 150, 25);
        add(txtCompay);

        txtSalary = new JTextField("");
        txtSalary.setFont(new Font("", 1, 18));
        txtSalary.setBounds(250, 292, 150, 25);
        add(txtSalary);


        txtBirthday = new JTextField("");
        txtBirthday.setFont(new Font("", 1, 18));
        txtBirthday.setBounds(250, 322, 150, 25);
        add(txtBirthday);

        add(mainPanale);

    }
}
