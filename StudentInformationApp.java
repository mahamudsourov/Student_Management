package javaapplication4;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;
class Student {
    private String name;
    private int age;
    private String grade;
    private String fatherBloodGroup;
    private String motherBloodGroup;
    public Student(String name, int age, String grade, String fatherBloodGroup, String motherBloodGroup) {
        this.name = name;
        this.age = age;
        this.grade = grade;
        this.fatherBloodGroup = fatherBloodGroup;
        this.motherBloodGroup = motherBloodGroup;
    }
    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getGrade() {
        return grade;
    }

    public String getFatherBloodGroup() {
        return fatherBloodGroup;
    }

    public String getMotherBloodGroup() {
        return motherBloodGroup;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public void setFatherBloodGroup(String fatherBloodGroup) {
        this.fatherBloodGroup = fatherBloodGroup;
    }

    public void setMotherBloodGroup(String motherBloodGroup) {
        this.motherBloodGroup = motherBloodGroup;
    }

    @Override
    public String toString() {
        return "Name: " + name + ", Age: " + age + ", Grade: " + grade +
                ", Father's Blood Group: " + fatherBloodGroup +
                ", Mother's Blood Group: " + motherBloodGroup;
    }
}

public class StudentInformationApp extends JFrame {
    private JLabel nameLabel, ageLabel, gradeLabel, fatherBloodGroupLabel, motherBloodGroupLabel;
    private JTextField nameField, ageField, gradeField, fatherBloodGroupField, motherBloodGroupField;
    private JButton addButton, displayButton, searchButton;
    private JTextArea displayArea;
    private List<Student> studentList;

    public StudentInformationApp() {
        // Set up the UI components
        nameLabel = new JLabel("Name:");
        nameField = new JTextField(20);
        ageLabel = new JLabel("Age:");
        ageField = new JTextField(10);
        gradeLabel = new JLabel("Grade:");
        gradeField = new JTextField(5);
        fatherBloodGroupLabel = new JLabel("Father's Blood Group:");
        fatherBloodGroupField = new JTextField(5);
        motherBloodGroupLabel = new JLabel("Mother's Blood Group:");
        motherBloodGroupField = new JTextField(5);
        addButton = new JButton("Add Student");
        displayButton = new JButton("Display Students");
        searchButton = new JButton("Search Student");
        displayArea = new JTextArea(10, 30);
        studentList = new ArrayList<>();
        // Set up the layout
        setLayout(new FlowLayout());
        add(nameLabel);
        add(nameField);
        add(ageLabel);
        add(ageField);
        add(gradeLabel);
        add(gradeField);
        add(fatherBloodGroupLabel);
        add(fatherBloodGroupField);
        add(motherBloodGroupLabel);
        add(motherBloodGroupField);
        add(addButton);
        add(displayButton);
        add(searchButton);
        add(new JScrollPane(displayArea));

        // Add action listeners to buttons
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                addStudent();
            }
        });

        displayButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                displayStudents();
            }
        });

        searchButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                searchStudent();
            }
        });
    }

    // Add a student to the list
    private void addStudent() {
        String name = nameField.getText();
        int age = Integer.parseInt(ageField.getText());
        String grade = gradeField.getText();
        String fatherBloodGroup = fatherBloodGroupField.getText();
        String motherBloodGroup = motherBloodGroupField.getText();

        Student student = new Student(name, age, grade, fatherBloodGroup, motherBloodGroup);
        studentList.add(student);

        nameField.setText("");
        ageField.setText("");
        gradeField.setText("");
        fatherBloodGroupField.setText("");
        motherBloodGroupField.setText("");

        JOptionPane.showMessageDialog(this, "Student added successfully!");
    }

    // Display all students in the list
    private void displayStudents() {
        if (studentList.isEmpty()) {
            JOptionPane.showMessageDialog(this, "No students to display.");
            return;
        }

        displayArea.setText("");
        for (Student student : studentList) {
            displayArea.append(student.toString() + "\n");
        }
    }

    // Search for a student by name
    private void searchStudent() {
        String searchName = JOptionPane.showInputDialog(this, "Enter student name:");

        if (searchName != null) {
            boolean found = false;
            displayArea.setText("");

            for (Student student : studentList) {
                if (student.getName().equalsIgnoreCase(searchName)) {
                    displayArea.append(student.toString() + "\n");
                    found = true;
                }
            }

            if (!found) {
                JOptionPane.showMessageDialog(this, "Student not found.");
            }
        }
    }

    public static void main(String[] args) {
        StudentInformationApp app = new StudentInformationApp();
        app.setSize(400, 400);
        app.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        app.setVisible(true);
    }
}

