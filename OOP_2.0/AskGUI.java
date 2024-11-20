import javax.swing.*;
import javax.swing.event.ListSelectionEvent;

import java.awt.*;
import java.awt.event.*;

public class AskGUI extends JFrame {
    private JComboBox<String> locationComboBox;
    private JButton checkButton;
    private JList<String> offerList;
    private DefaultListModel<String> listModel;
    private JTextArea detailsArea;
    private RideSharePage parent;  // Reference to the RideSharePage

    public AskGUI(RideSharePage parent) {
        this.parent = parent;
        setTitle("Ask for a Ride");
        setSize(500, 400);
        setLayout(new BorderLayout());

        // Top panel with location combobox and check button
        JPanel topPanel = new JPanel(new FlowLayout()); // Ensures that components are laid out left to right
        String[] locations = {"Abu Dhabi", "Dubai", "Sharjah", "Ajman", "Umm Al Quwain", "Ras Al Khaimah", "Fujairah"};
        locationComboBox = new JComboBox<>(locations);
        locationComboBox.setPreferredSize(new Dimension(150, 20));  // Set the preferred size of the dropdown
        checkButton = new JButton("Check");
        checkButton.addActionListener(this::fetchOffers); // Ensure ActionListener is correctly set
        topPanel.add(locationComboBox);
        topPanel.add(checkButton); // Check this is added

        // Ensure that components are actually added to topPanel
        getContentPane().add(topPanel, BorderLayout.NORTH);

        // Setup list model and list to display offers
        listModel = new DefaultListModel<>();
        offerList = new JList<>(listModel);
        offerList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        offerList.addListSelectionListener(this::displayOfferDetails);
        JScrollPane listScrollPane = new JScrollPane(offerList);

        // Details area to display full offer information
        detailsArea = new JTextArea();
        detailsArea.setEditable(false);

        add(listScrollPane, BorderLayout.CENTER);
        add(new JScrollPane(detailsArea), BorderLayout.SOUTH);

        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void fetchOffers(ActionEvent e) {
        String location = (String) locationComboBox.getSelectedItem();
        updateOfferList(location);
    }

    private void updateOfferList(String location) {
        java.util.List<Offer> offers = OfferManager.getOffersByLocation(location);
        listModel.clear();
        for (Offer offer : offers) {
            listModel.addElement(offer.getUsername() + " - " + offer.getLocation() + " - $" + offer.getFarePerMeter());
        }
    }

    private void displayOfferDetails(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && !offerList.isSelectionEmpty()) {
            Offer selectedOffer = OfferManager.getOffersByLocation((String) locationComboBox.getSelectedItem()).get(offerList.getSelectedIndex());
            detailsArea.setText("Car Type: " + selectedOffer.getCarType() +
                                   "\nSeats: " + selectedOffer.getNumberOfSeats() +
                                   "\nFare: $" + selectedOffer.getFarePerMeter() +
                                   "\nMobile: " + selectedOffer.getMobileNumber() +
                                   "\n\nDo you want to reserve a seat?");
        }
    }
}
