import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class BMICalculator extends JFrame implements ActionListener {

    // UI components
    private JTextField heightField, weightField, resultField;
    private JButton calcButton, clearButton;

    public BMICalculator() {
        // Frame setup
        setTitle("BMI Calculator");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new GridLayout(5, 2, 10, 10));
        setLocationRelativeTo(null); // Center on screen

        // Create components
        JLabel heightLabel = new JLabel("Height (in meters):");
        JLabel weightLabel = new JLabel("Weight (in kg):");
        JLabel resultLabel = new JLabel("Your BMI:");
        
        heightField = new JTextField();
        weightField = new JTextField();
        resultField = new JTextField();
        resultField.setEditable(false);

        calcButton = new JButton("Calculate");
        clearButton = new JButton("Clear");

        // Add ActionListeners
        calcButton.addActionListener(this);
        clearButton.addActionListener(this);

        // Add components to frame
        add(heightLabel);
        add(heightField);
        add(weightLabel);
        add(weightField);
        add(resultLabel);
        add(resultField);
        add(calcButton);
        add(clearButton);

        // Styling (optional)
        Font font = new Font("Arial", Font.PLAIN, 16);
        heightLabel.setFont(font);
        weightLabel.setFont(font);
        resultLabel.setFont(font);
        heightField.setFont(font);
        weightField.setFont(font);
        resultField.setFont(font);
        calcButton.setFont(font);
        clearButton.setFont(font);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calcButton) {
            try {
                double height = Double.parseDouble(heightField.getText());
                double weight = Double.parseDouble(weightField.getText());

                double bmi = weight / (height * height);
                String category;

                if (bmi < 18.5) {
                    category = "Underweight";
                } else if (bmi < 24.9) {
                    category = "Normal weight";
                } else if (bmi < 29.9) {
                    category = "Overweight";
                } else {
                    category = "Obese";
                }

                resultField.setText(String.format("%.2f (%s)", bmi, category));

            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(this, 
                    "Please enter valid numbers for height and weight.",
                    "Input Error", JOptionPane.ERROR_MESSAGE);
            }
        } else if (e.getSource() == clearButton) {
            heightField.setText("");
            weightField.setText("");
            resultField.setText("");
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(BMICalculator::new);
    }
}
