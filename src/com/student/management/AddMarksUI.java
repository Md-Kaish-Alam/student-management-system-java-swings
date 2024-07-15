package com.student.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddMarksUI extends JFrame {
    private StudentManagementSystem sms;
    private int studentId;
    private JTextField semesterField, marksField;

    public AddMarksUI(StudentManagementSystem sms, int studentId) {
        this.sms = sms;
        this.studentId = studentId;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Add Semester Marks");
        setSize(400, 200);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(3, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(new JLabel("Semester:"));
        semesterField = new JTextField();
        mainPanel.add(semesterField);

        mainPanel.add(new JLabel("Marks:"));
        marksField = new JTextField();
        mainPanel.add(marksField);

        JButton addButton = new JButton("Add Marks");
        mainPanel.add(addButton);

        add(mainPanel);

        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int semester = Integer.parseInt(semesterField.getText());
                int marks = Integer.parseInt(marksField.getText());
                Student student = sms.getStudentById(studentId);
                if (student != null) {
                    student.addSemesterMarks(semester, marks);
                    JOptionPane.showMessageDialog(AddMarksUI.this, "Marks added successfully!");
                    dispose();
                } else {
                    JOptionPane.showMessageDialog(AddMarksUI.this, "Student not found!");
                }
            }
        });
    }
}
