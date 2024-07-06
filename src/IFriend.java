import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class IFriend extends JFrame {
    public static final ArrayList<Contact> CONTACT_LIST = new ArrayList<>();

    IFriend() {
        setSize(600, 400);
        setTitle("Main Form");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(6, 1));
    }

    public static void main(String args[]) {
        new ContactMainForm().setVisible(true);
    }
}
