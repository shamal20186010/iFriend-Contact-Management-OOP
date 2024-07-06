import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class CustomerMainForm extends JFrame {
    public static final ArrayList<Customer> customerList=new ArrayList<>();

    private JButton btnAddCustomer;
    private JButton btnSearchCustomer;
    private JButton btnDeleteCustomer;
    private JButton btnUpdateCustomer;
    private JButton btnViewCustomer;
    private JButton btnExit;

    private AddCustomerForm addCustomerForm;
    private ViewCustomerForm viewCustomerForm;
    private UpdateCustomerForm updateCustomerForm;
    private SearchContactForm searchContactForm;
    private DeleteContactForm deleteContactForm;
    private ContactList contactList;


    CustomerMainForm(){
        setTitle("iFRIEND Contact Manager");

        // Set the size of the window
        setSize(800, 600);

        // Set the layout
        setLayout(new GridLayout(1,2));

        // Create a panel for the left side image
        JPanel leftPanel = new JPanel();
        leftPanel.setBackground(new Color(253,250,205));
        leftPanel.setLayout(new FlowLayout(FlowLayout.CENTER));

        JLabel iFriendLabel1 = new JLabel("iFRIEND", SwingConstants.CENTER);
        iFriendLabel1.setFont(new Font("Arial", Font.BOLD, 55));
        leftPanel.add(iFriendLabel1);

        JLabel iFriendLabel2 = new JLabel("Contact Manager", SwingConstants.CENTER);
        iFriendLabel2.setFont(new Font("Arial", Font.BOLD, 40));
        leftPanel.add(iFriendLabel2);

        // Load and resize the image
        ImageIcon originalIcon = new ImageIcon("images/Picture2.jpg"); // Change to the path of your image
        Image originalImage = originalIcon.getImage();
        Image resizedImage = originalImage.getScaledInstance(200, 300, Image.SCALE_SMOOTH); // Resize to desired dimensions
        ImageIcon resizedIcon = new ImageIcon(resizedImage);

        JLabel imageLabel = new JLabel(resizedIcon);
        //add(imageLabel);


        // Create a panel for the right side buttons
        JPanel rightPanelMain = new JPanel();
        rightPanelMain.setLayout(new BorderLayout());

        JPanel rightPanel = new JPanel();
        rightPanel.setBackground(new Color(255,204,0)); // Light blue color
        rightPanel.setLayout(new GridLayout(7, 1, 10, 10));
        rightPanelMain.add(rightPanel);
        JLabel homePageLabel = new JLabel("Home Page", SwingConstants.CENTER);
        homePageLabel.setFont(new Font("Arial", Font.BOLD, 44));
        rightPanel.add(homePageLabel);

        JButton addNewContactButton = new JButton("Add New Contact");
        JButton updateContactButton = new JButton("Update Contact");
        JButton searchContactButton = new JButton("Search Contact");
        JButton deleteContactButton = new JButton("Delete Contact");
        JButton viewContactButton = new JButton("View Contact");
        JButton exitButton = new JButton("EXIT");


        // add customer form
        addNewContactButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(addCustomerForm==null){
                    addCustomerForm=new AddCustomerForm();
                }
                addCustomerForm.setVisible(true);
            }
        });
        addNewContactButton.setBackground(new Color(179,217,102));
        addNewContactButton.setBounds(50,100,95,30);
        addNewContactButton.setFont(new Font("", Font.BOLD, 24));
        rightPanel.add(addNewContactButton);

        updateContactButton.setBackground(new Color(179,217,102));
        updateContactButton.setFont(new Font("", Font.BOLD, 24));
        updateContactButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(updateCustomerForm==null){
                    updateCustomerForm=new UpdateCustomerForm();
                }
                updateCustomerForm.setVisible(true);
            }
        });
        rightPanel.add(updateContactButton);

        searchContactButton.setBackground(new Color(179,217,102));
        searchContactButton.setFont(new Font("", Font.BOLD, 24));
        searchContactButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(searchContactForm==null){
                    searchContactForm=new SearchContactForm();
                }
                searchContactForm.setVisible(true);
            }
        });
        rightPanel.add(searchContactButton);

        deleteContactButton.setBackground(new Color(179,217,102));
        deleteContactButton.setFont(new Font("", Font.BOLD, 24));
        deleteContactButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(deleteContactForm==null){
                    deleteContactForm=new DeleteContactForm();
                }
                deleteContactForm.setVisible(true);
            }
        });
        rightPanel.add(deleteContactButton);

        viewContactButton.setBackground(new Color(179,217,102));
        viewContactButton.setFont(new Font("", Font.BOLD, 24));
        viewContactButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                if(contactList==null){
                    contactList=new ContactList();
                }
                contactList.setVisible(true);
            }
        });
        rightPanel.add(viewContactButton);

        exitButton.setBackground(new Color(179,217,102));
        exitButton.setFont(new Font("", Font.BOLD, 24));
        exitButton.addActionListener(new ActionListener(){
            public void actionPerformed(ActionEvent evt){
                System.exit(0);
            }
        });

        rightPanel.add(exitButton);

        add(leftPanel);
        add(rightPanelMain);

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); // Center the frame
    }
}
