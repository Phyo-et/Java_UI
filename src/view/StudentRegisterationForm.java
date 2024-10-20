package view;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentRegisterationForm extends JFrame implements ActionListener {

    private JTextField nameField,emailField,phoneField;
    private JLabel nameLabel,emailLabel , phoneLabel,genderLabel,courseLabel;
    private JRadioButton maleRadio,femaleRadio;
    private JCheckBox termCheckbox;
    private JComboBox<String> courseBox;
    private JButton submitBtn;
    private ButtonGroup genderGroup;
    private JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));

    public StudentRegisterationForm(){
        this.initializeUIComponent();
        this.addUIComponent();
        this.setVisible(true);
    }

    private void addUIComponent() {
        this.add(nameLabel);
        this.add(nameField);
        this.add(emailLabel);
        this.add(emailField);
        this.add(phoneLabel);
        this.add(phoneField);
        this.add(genderLabel);

        this.genderPanel.add(this.maleRadio);
        this.genderPanel.add(this.femaleRadio);
        this.add(genderPanel);

        this.add(courseLabel);
        this.add(courseBox);

        this.add(termCheckbox);
        this.add(new JLabel());

        this.add(submitBtn);
    }

    private void initializeUIComponent() {
        this.setTitle("Student Registeration Form");
        this.setSize(400,400);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(new GridLayout(7,2,5,5));

        this.nameLabel = new JLabel("Name");
        this.nameField = new JTextField();

        this.emailLabel = new JLabel("Email");
        this.emailField = new JTextField();

        this.phoneLabel = new JLabel("Phone No");
        this.phoneField= new JTextField();

        this.genderLabel = new JLabel("Gender");
        this.maleRadio= new JRadioButton("Male");
        this.femaleRadio = new JRadioButton("Female");

        this.genderGroup = new ButtonGroup();
        genderGroup.add(this.maleRadio);
        genderGroup.add(this.femaleRadio);

        this.courseLabel = new JLabel("Courses");
        String[] courses ={"Python","Java","other"};
        this.courseBox = new JComboBox<>(courses);

        this.termCheckbox = new JCheckBox("Agree to the Terms and Conditions");

        this.submitBtn = new JButton("Submit");
        this.submitBtn.addActionListener(this);


    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == this.submitBtn){
           // JOptionPane.showMessageDialog(this.submitBtn,"Submit");
            //System.out.println("Clicked Submit Btn!!!");
            this.submitActionTask();
        }
    }

    private void submitActionTask() {
        String name = this.nameField.getText();
        String email =  this.emailField.getText();
        String phone = this.phoneField.getText();
        String gender = this.maleRadio.isSelected() ? "Male" : this.femaleRadio.isSelected() ? "Female" : "";
        String course = (String) courseBox.getSelectedItem();
        boolean termAccept = this.termCheckbox.isSelected();

        if(name.isEmpty() || email.isEmpty() || phone.isEmpty() || gender.isEmpty()|| !termAccept){
            JOptionPane.showMessageDialog(this, "Please Fill All Fields and Acept term and Conditions.","Error",JOptionPane.ERROR_MESSAGE);
        }else{
            String message = String.format("Name : %s \n Email : %s \n Phone : %s \n Gender : %s \n Course : %s \n ",name,email,phone,gender,course);
            JOptionPane.showMessageDialog(this, message, "Register Sucess ", JOptionPane.INFORMATION_MESSAGE);
        }
    }
}
