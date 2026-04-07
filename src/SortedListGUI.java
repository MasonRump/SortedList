import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class SortedListGUI extends JFrame {

    private SortedList sortedList;
    private JTextField inputField;
    private JTextArea outputArea;

    public SortedListGUI() {
        sortedList = new SortedList();

        setTitle("Sorted List (Binary Search)");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());

        JPanel topPanel = new JPanel();
        inputField = new JTextField(15);

        JButton addButton = new JButton("Add");
        JButton searchButton = new JButton("Search");

        topPanel.add(new JLabel("Enter String:"));
        topPanel.add(inputField);
        topPanel.add(addButton);
        topPanel.add(searchButton);

        add(topPanel, BorderLayout.NORTH);

        outputArea = new JTextArea();
        outputArea.setEditable(false);
        add(new JScrollPane(outputArea), BorderLayout.CENTER);

        addButton.addActionListener((ActionEvent e) -> {
            String input = inputField.getText();
            if (!input.isEmpty()) {
                sortedList.add(input);
                outputArea.append("Added: " + input + "\n");
                outputArea.append("List:\n" + sortedList.display() + "\n");
                inputField.setText("");
            }
        });

        searchButton.addActionListener((ActionEvent e) -> {
            String input = inputField.getText();
            if (!input.isEmpty()) {
                String result = sortedList.search(input);
                outputArea.append("Search: " + input + "\n");
                outputArea.append(result + "\n\n");
                inputField.setText("");
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new SortedListGUI().setVisible(true);
        });
    }
}
