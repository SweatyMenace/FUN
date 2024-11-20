import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class InboxGUI extends JFrame {
    private JTextArea inboxArea;
    private RideSharePage parent; // Reference to the RideSharePage

    public InboxGUI(RideSharePage parent) {
        this.parent = parent;
        initializeGUI();
    }

    private void initializeGUI() {
        setTitle("Inbox");
        setSize(400, 300);
        setLayout(new BorderLayout());

        inboxArea = new JTextArea("You have no new messages."); // Placeholder text
        inboxArea.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(inboxArea);
        add(scrollPane, BorderLayout.CENTER);

        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                parent.setVisible(true); // Make the RideSharePage visible again
            }
        });

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // Ensure the window is disposed when closed
        setLocationRelativeTo(null); // Center on screen
        setVisible(true);
    }

    // Optionally, methods to update the inbox content could be added here
}
