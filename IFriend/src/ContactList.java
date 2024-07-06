import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ContactList extends JFrame {
    private JButton btnListByName;
    private JButton btnListBySalary;
    private JButton btnListByBirthday;
    private JButton btnCancel;

    private ListByName listByName;
    private ListBySalary listBySalary;
    private ListByBirthday listByBirthday;

    ContactList() {
        setSize(500, 500);
        setTitle("Contact List");
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setResizable(false);

        JPanel titlePanale = new JPanel();
        titlePanale.setBounds(0, 0, 500, 60);
        titlePanale.setBackground(new Color(255, 204, 0));
        JLabel titleLabel = new JLabel("CONTACT LIST");
        titleLabel.setFont(new Font("", 1, 35));
        titleLabel.setBounds(0, 10, 400, 40);
        titlePanale.add(titleLabel);
        add(titlePanale);

        JPanel mainPanale = new JPanel();
        mainPanale.setBackground(new Color(255, 255, 255, 255));
        mainPanale.setBounds(0, 0, 500, 500);

        btnListByName = new JButton("List By Name");
        btnListByName.setBounds(100, 100, 300, 80);
        btnListByName.setFont(new Font("", 1, 20));
        btnListByName.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(listByName==null){
                    listByName=new ListByName();
                }
                listByName.setVisible(true);
            }
        });
        add(btnListByName);

        btnListBySalary = new JButton("List By Salary");
        btnListBySalary.setBounds(100, 200, 300, 80);
        btnListBySalary.setFont(new Font("", 1, 20));
        btnListBySalary.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(listBySalary==null){
                    listBySalary=new ListBySalary();
                }
                listBySalary.setVisible(true);
            }
        });
        add(btnListBySalary);

        btnListByBirthday = new JButton("List By Birthday");
        btnListByBirthday.setBounds(100, 300, 300, 80);
        btnListByBirthday.setFont(new Font("", 1, 20));
        btnListByBirthday.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(listByBirthday==null){
                    listByBirthday=new ListByBirthday();
                }
                listByBirthday.setVisible(true);
            }
        });
        add(btnListByBirthday);

        btnCancel = new JButton("Cancel");
        btnCancel.setBounds(350, 400, 100, 30);
        btnCancel.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                ContactList.this.dispose();
            }
        });
        add(btnCancel);

        add(mainPanale);
    }
}
