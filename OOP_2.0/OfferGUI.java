import javax.swing.*;
import java.awt.*;

public class OfferGUI extends JFrame {
    private JTextField carNameField, seatsField, fareField, mobileNumberField;
    private JComboBox<String> emirateComboBox, mobilePrefixComboBox;
    private JButton submitButton, cancelButton;
    private RideSharePage parent;

    public OfferGUI(RideSharePage parent) {
        this.parent = parent;
        setTitle("Offer a Ride");
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setSize(450, 450);  // Adjusted size for better layout
        setLayout(new GridLayout(7, 2, 10, 10));  // Updated to 7 rows to include cancel button

        // Initialize input fields
        carNameField = new JTextField();
        seatsField = new JTextField();
        fareField = new JTextField();
        mobileNumberField = new JTextField(10);  // Increased size for mobile number field

        // ComboBox for emirates
        String[] emirates = {"(Select)", "Abu Dhabi", "Dubai", "Sharjah", "Ajman", "Umm Al Quwain", "Ras Al Khaimah", "Fujairah"};
        emirateComboBox = new JComboBox<>(emirates);

        // ComboBox for mobile prefixes
        String[] mobileOptions = {"XXX", "050", "052", "053", "054", "055", "056", "058", "057"};
        mobilePrefixComboBox = new JComboBox<>(mobileOptions);

        // Setup labels and input fields layout
        add(new JLabel("Car Name:"));
        add(carNameField);
        add(new JLabel("Number of Seats:"));
        add(seatsField);
        add(new JLabel("Fare per Meter:"));
        add(fareField);
        add(new JLabel("Emirate:"));
        add(emirateComboBox);
        add(new JLabel("Mobile Number:"));
        JPanel mobilePanel = new JPanel(new FlowLayout());
        mobilePanel.add(mobilePrefixComboBox);
        mobilePanel.add(mobileNumberField);
        add(mobilePanel);

        // Setup submit button
        submitButton = new JButton("Submit");
        submitButton.addActionListener(e -> submitOffer());
        add(submitButton);

        // Setup cancel button
        cancelButton = new JButton("Cancel");
        cancelButton.addActionListener(e -> {
            this.dispose();
            parent.setVisible(true); // Make RideSharePage visible again
        });
        
        add(cancelButton);

        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void submitOffer() {
        // Validate and process the input
        if (carNameField.getText().isEmpty() || 
            seatsField.getText().isEmpty() || 
            fareField.getText().isEmpty() ||
            emirateComboBox.getSelectedIndex() == 0 ||  // Check if default or 'Select' is chosen
            mobilePrefixComboBox.getSelectedIndex() == 0 ||
            mobileNumberField.getText().length() != 7) {

            JOptionPane.showMessageDialog(this, "Please complete all fields correctly!", "Error", JOptionPane.ERROR_MESSAGE);
        } else {
            // Assume functionality to save or process the offer details
            System.out.println("Offer details: " + getOfferDetails());
            this.dispose();  // Close the window after successful submission
            parent.setVisible(true);
        }
    }

    private String getOfferDetails() {
        return String.format("Car Type: %s, Seats: %d, Fare: %.2f, Location: %s, Mobile: %s",
                             carNameField.getText(),
                             Integer.parseInt(seatsField.getText()),
                             Double.parseDouble(fareField.getText()),
                             (String) emirateComboBox.getSelectedItem(),
                             mobilePrefixComboBox.getSelectedItem() + mobileNumberField.getText());
    }
}
