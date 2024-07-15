package com.student.management;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StudentDetailsUI extends JFrame {
    private StudentManagementSystem sms;
    private JTextField nameField, courseField, sessionField, rollNoField;
    private JButton addButton, updateButton, deleteButton, addMarksButton, showStudentsButton;

    public StudentDetailsUI(StudentManagementSystem sms) {
        this.sms = sms;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Student Management System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Main panel with padding
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // Form panel
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(10, 10, 10, 10);
        gbc.anchor = GridBagConstraints.WEST;

        // Labels and Fields
        gbc.gridx = 0;
        gbc.gridy = 0;
        formPanel.add(new JLabel("Name:"), gbc);
        nameField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        formPanel.add(new JLabel("Course:"), gbc);
        courseField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(courseField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        formPanel.add(new JLabel("Session:"), gbc);
        sessionField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(sessionField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        formPanel.add(new JLabel("Roll No:"), gbc);
        rollNoField = new JTextField(20);
        gbc.gridx = 1;
        formPanel.add(rollNoField, gbc);

        // Buttons Panel
        JPanel buttonPanel = new JPanel(new GridLayout(1, 5, 10, 10));
        addButton = new JButton("Add");
        updateButton = new JButton("Update");
        deleteButton = new JButton("Delete");
        addMarksButton = new JButton("Add Marks");
        showStudentsButton = new JButton("Show Students");

        buttonPanel.add(addButton);
        buttonPanel.add(updateButton);
        buttonPanel.add(deleteButton);
        buttonPanel.add(addMarksButton);
        buttonPanel.add(showStudentsButton);

        // Adding formPanel and buttonPanel to the mainPanel
        mainPanel.add(formPanel, BorderLayout.CENTER);
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        add(mainPanel);

        // Set the size of the window
        setSize(800, 400);
        setVisible(true);

        // Action Listeners
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name = nameField.getText();
                String course = courseField.getText();
                String session = sessionField.getText();
                String rollNo = rollNoField.getText();
                Student student = new Student(name, course, session, rollNo);
                sms.addStudent(student);
                clearFields();
            }
        });

        updateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID to update:"));
                String name = nameField.getText();
                String course = courseField.getText();
                String session = sessionField.getText();
                String rollNo = rollNoField.getText();
                sms.updateStudent(id, name, course, session, rollNo);
                clearFields();
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID to delete:"));
                sms.deleteStudent(id);
                clearFields();
            }
        });

        addMarksButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int id = Integer.parseInt(JOptionPane.showInputDialog("Enter Student ID to add marks:"));
                new AddMarksUI(sms, id).setVisible(true);
            }
        });

        showStudentsButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new ShowStudentsUI(sms).setVisible(true);
            }
        });
    }

    private void clearFields() {
        nameField.setText("");
        courseField.setText("");
        sessionField.setText("");
        rollNoField.setText("");
    }

    public static void main(String[] args) {
        StudentManagementSystem sms = new StudentManagementSystem();
        SwingUtilities.invokeLater(() -> new StudentDetailsUI(sms).setVisible(true));
    }
}
