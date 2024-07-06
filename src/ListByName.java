import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ListByName extends JFrame {
    private JButton btnBackToHome;

    private JPanel mainPanale;

    private JTable customerDetails;
    private DefaultTableModel dtm;

    ListByName() {
        sortNameUI();
        setListeners();
    }

    private void sortNameUI() {
        setSize(1000, 500);
        setTitle("List Contact By Name");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JPanel titlePanale = new JPanel();
        titlePanale.setBounds(0, 0, 1000, 60);
        titlePanale.setBackground(new Color(255, 204, 0));
        JLabel titleLabel = new JLabel("LIST CONTACT BY NAME");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setBounds(0, 10, 400, 40);
        titlePanale.add(titleLabel);
        add(titlePanale);

        mainPanale = new JPanel();
        mainPanale.setBackground(new Color(255, 255, 255, 255));
        mainPanale.setBounds(0, 0, 1000, 500);

        String[] columnName = {"Contact ID", "Name", "Contact Number", "Company Name", "Salary", "Birthday"};
        dtm = new DefaultTableModel(columnName, 0);
        customerDetails = new JTable(dtm);
        JScrollPane tablePane = new JScrollPane(customerDetails);
        tablePane.setBounds(40, 70, 900, 300);

        for (Contact contact : ContactController.nameSort()) {
            Object[] rowdata = {contact.getId(), contact.getName(), contact.getConNo(), contact.getCompanyName(), contact.getSalary(), contact.getBirthday()};
            dtm.addRow(rowdata);
        }
        add(tablePane);

        btnBackToHome = new JButton("Back To Home");
        btnBackToHome.setBounds(375, 400, 250, 30);
        add(btnBackToHome);
        btnBackToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });

        add(mainPanale);
    }

    private void setListeners() {
        btnBackToHome.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                dispose();
            }
        });
    }
}
