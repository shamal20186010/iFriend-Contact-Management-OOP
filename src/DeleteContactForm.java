import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteContactForm extends JFrame {
    private JButton btnDelete;
    private JButton btnCancel;
    private JButton btnBackToHome;
    private JButton btnSearch;
    private int index;

    private JTextField txtSearch;

    private JLabel txtId;
    private JLabel txtName;
    private JLabel txtContactNo;
    private JLabel txtCompay;
    private JLabel txtSalary;
    private JLabel txtBirthday;

    DeleteContactForm() {
        deleteContactUI();
        setupListeners();
        String str = ContactController.getSearch();
        if (str != null && !str.trim().isEmpty()) {
            displaySearch(str);
        }
    }

    private void deleteContactUI() {
        setSize(500, 600);
        setTitle("Delete Contact Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JPanel titlePanale = new JPanel();
        titlePanale.setBounds(0, 0, 500, 60);
        titlePanale.setBackground(new Color(255, 204, 0));
        JLabel titleLabel = new JLabel("DELETE CONTACT");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setBounds(0, 10, 400, 40);
        titlePanale.add(titleLabel);
        add(titlePanale);

        JPanel mainPanale = new JPanel();
        mainPanale.setBackground(new Color(255, 255, 255, 255));
        mainPanale.setBounds(0, 0, 500, 600);

        txtSearch = new JTextField(10);
        txtSearch.setBounds(30, 100, 300, 30);
        txtSearch.setFont(new Font("", 1, 20));
        add(txtSearch);

        btnSearch = new JButton("Search");
        btnSearch.setBounds(350, 100, 100, 30);
        add(btnSearch);

        JLabel llbId = new JLabel("Contact ID");
        llbId.setFont(new Font("", 1, 18));
        llbId.setBounds(60, 170, 300, 25);
        add(llbId);

        txtId = new JLabel("");
        txtId.setFont(new Font("", 1, 18));
        txtId.setBounds(250, 170, 300, 25);
        add(txtId);

        JLabel llbName = new JLabel("Name");
        llbName.setFont(new Font("", 1, 18));
        llbName.setBounds(60, 200, 300, 25);
        add(llbName);

        txtName = new JLabel("");
        txtName.setFont(new Font("", 1, 18));
        txtName.setBounds(250, 200, 300, 25);
        add(txtName);

        JLabel llbConNO = new JLabel("Contact Number");
        llbConNO.setFont(new Font("", 1, 18));
        llbConNO.setBounds(60, 230, 300, 25);
        add(llbConNO);

        txtContactNo = new JLabel("");
        txtContactNo.setFont(new Font("", 1, 18));
        txtContactNo.setBounds(250, 230, 300, 25);
        add(txtContactNo);

        JLabel llbCompany = new JLabel("Company");
        llbCompany.setFont(new Font("", 1, 18));
        llbCompany.setBounds(60, 260, 300, 25);
        add(llbCompany);

        txtCompay = new JLabel("");
        txtCompay.setFont(new Font("", 1, 18));
        txtCompay.setBounds(250, 260, 300, 25);
        add(txtCompay);

        JLabel llbSalary = new JLabel("Salary");
        llbSalary.setFont(new Font("", 1, 18));
        llbSalary.setBounds(60, 290, 300, 25);
        add(llbSalary);

        txtSalary = new JLabel("");
        txtSalary.setFont(new Font("", 1, 18));
        txtSalary.setBounds(250, 290, 300, 25);
        add(txtSalary);

        JLabel llbBirthday = new JLabel("Birthday");
        llbBirthday.setFont(new Font("", 1, 18));
        llbBirthday.setBounds(60, 320, 300, 25);
        add(llbBirthday);

        txtBirthday = new JLabel("");
        txtBirthday.setFont(new Font("", 1, 18));
        txtBirthday.setBounds(250, 320, 300, 25);
        add(txtBirthday);

        btnDelete = new JButton("Delete");
        btnDelete.setBounds(200, 450, 125, 30);
        add(btnDelete);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(325, 450, 125, 30);
        add(btnCancel);

        btnBackToHome = new JButton("Back To Home");
        btnBackToHome.setBounds(200, 500, 250, 30);
        add(btnBackToHome);

        add(mainPanale);

    }

    private void setupListeners() {
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchMec();
            }
        });

        btnCancel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtId.setText("");
                txtName.setText("");
                txtContactNo.setText("");
                txtCompay.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
            }
        });
        btnBackToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtId.setText("");
                txtName.setText("");
                txtContactNo.setText("");
                txtCompay.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
                DeleteContactForm.this.dispose();
            }
        });
        btnDelete.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                ContactController.deleteContact(index);
                popup();
            }
        });
    }

    private void popup() {
        int option = JOptionPane.showConfirmDialog(null, "Contact deleted Successfully..Do you want to delete another contact?");
        if (option == JOptionPane.YES_OPTION) {
            txtSearch.setText("");
            txtSearch.requestFocus();
        } else if (option == JOptionPane.NO_OPTION) {
            txtSearch.setText("");
            DeleteContactForm.this.dispose();
        }
    }

    private void searchMec() {
        String str = txtSearch.getText();
        if (str == null || str.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Search text cannot be empty.");
            txtSearch.requestFocus();
            return;
        }
        index = ContactController.getindex(str);
        if (index != -1) {
            displaySearch(str);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Contact does not exist. Do you want to search again?");
            if (option == JOptionPane.YES_OPTION) {
                txtSearch.setText("");
                txtSearch.requestFocus();
            } else if (option == JOptionPane.NO_OPTION) {
                txtSearch.setText("");
                dispose();
            }
        }
    }

    private void displaySearch(String str) {
        Contact temp = ContactController.getContact(index);
        if (temp != null) {
            txtId.setText(temp.getId());
            txtName.setText(temp.getName());
            txtContactNo.setText(temp.getConNo());
            txtCompay.setText(temp.getCompanyName());
            txtSalary.setText(Double.toString(temp.getSalary()));
            txtBirthday.setText(temp.getBirthday());
        }
    }
}
