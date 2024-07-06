import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SearchContactForm extends JFrame {
    private JButton btnBackToHome;
    private JButton btnSearch;

    private JTextField txtSearch;

    private JLabel txtId;
    private JLabel txtName;
    private JLabel txtContactNo;
    private JLabel txtCompay;
    private JLabel txtSalary;
    private JLabel txtBirthday;

    private JPanel mainPanale;

    private SearchContactForm searchContactForm;

    public SearchContactForm() {
        searchContactUI();
        setupListener();
        String str = ContactController.getSearch();
        if (str != null && !str.trim().isEmpty()) {
            displaySearch(str);
        }
    }

    public void searchContactUI() {
        setSize(500, 600);
        setTitle("Search Contact Form");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JPanel titlePanale = new JPanel();
        titlePanale.setBounds(0, 0, 500, 60);
        titlePanale.setBackground(new Color(255, 204, 0));
        JLabel titleLabel = new JLabel("SEARCH CONTACT");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setBounds(0, 10, 400, 40);
        titlePanale.add(titleLabel);
        add(titlePanale);

        mainPanale = new JPanel();
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

        JLabel llbName = new JLabel("Name");
        llbName.setFont(new Font("", 1, 18));
        llbName.setBounds(60, 200, 300, 25);
        add(llbName);

        JLabel llbConNO = new JLabel("Contact Number");
        llbConNO.setFont(new Font("", 1, 18));
        llbConNO.setBounds(60, 230, 300, 25);
        add(llbConNO);

        JLabel llbCompany = new JLabel("Company");
        llbCompany.setFont(new Font("", 1, 18));
        llbCompany.setBounds(60, 260, 300, 25);
        add(llbCompany);

        JLabel llbSalary = new JLabel("Salary");
        llbSalary.setFont(new Font("", 1, 18));
        llbSalary.setBounds(60, 290, 300, 25);
        add(llbSalary);

        JLabel llbBirthday = new JLabel("Birthday");
        llbBirthday.setFont(new Font("", 1, 18));
        llbBirthday.setBounds(60, 320, 300, 25);
        add(llbBirthday);

        btnBackToHome = new JButton("Back To Home");
        btnBackToHome.setBounds(200, 500, 250, 30);
        add(btnBackToHome);

        add(mainPanale);

    }

    private void setupListener() {
        btnSearch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                searchMec();
            }
        });
        btnBackToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                txtName.setText("");
                txtContactNo.setText("");
                txtCompay.setText("");
                txtSalary.setText("");
                txtBirthday.setText("");
                dispose();
            }
        });
    }

    private void searchMec() {
        String str = txtSearch.getText();
        if (str == null || str.trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Search text cannot be empty.");
            txtSearch.requestFocus();
            return;
        }

        int index = ContactController.getindex(str);
        if (index != -1) {
            ContactController.storeSearch(str);
            SearchContactForm.this.dispose();
            searchContactForm = new SearchContactForm();
            searchContactForm.setVisible(true);
        } else {
            int option = JOptionPane.showConfirmDialog(null, "Contact does not exist... Do you want to search again?");
            if (option == JOptionPane.YES_OPTION) {
                txtSearch.setText("");
                txtSearch.requestFocus();
            } else if (option == JOptionPane.NO_OPTION) {
                txtSearch.setText("");
                dispose();
            }
        }
    }

    public void displaySearch(String str) {
        int index = ContactController.getindex(str);
        if (index != -1) {
            Contact contactTemp = ContactController.getContact(index);
            txtId = new JLabel(contactTemp.getId());
            txtId.setFont(new Font("", 1, 18));
            txtId.setBounds(250, 170, 300, 25);
            add(txtId);

            txtName = new JLabel(contactTemp.getName());
            txtName.setFont(new Font("", 1, 18));
            txtName.setBounds(250, 200, 300, 25);
            add(txtName);

            txtContactNo = new JLabel(contactTemp.getConNo());
            txtContactNo.setFont(new Font("", 1, 18));
            txtContactNo.setBounds(250, 230, 300, 25);
            add(txtContactNo);

            txtCompay = new JLabel(contactTemp.getCompanyName());
            txtCompay.setFont(new Font("", 1, 18));
            txtCompay.setBounds(250, 260, 300, 25);
            add(txtCompay);

            txtSalary = new JLabel(Double.toString(contactTemp.getSalary()));
            txtSalary.setFont(new Font("", 1, 18));
            txtSalary.setBounds(250, 290, 300, 25);
            add(txtSalary);

            txtBirthday = new JLabel(contactTemp.getBirthday());
            txtBirthday.setFont(new Font("", 1, 18));
            txtBirthday.setBounds(250, 320, 300, 25);
            add(txtBirthday);

            add(mainPanale);
        }
    }

}

