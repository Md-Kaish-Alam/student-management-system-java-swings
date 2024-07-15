package com.student.management;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;

public class ShowStudentsUI extends JFrame {
    private StudentManagementSystem sms;
    private JTable studentTable;
    private DefaultTableModel tableModel;
    private JTextField searchField;

    public ShowStudentsUI(StudentManagementSystem sms) {
        this.sms = sms;
        initializeUI();
    }

    private void initializeUI() {
        setTitle("Student Details");
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Search Panel
        JPanel searchPanel = new JPanel(new GridLayout(1, 3, 10, 10));
        searchPanel.add(new JLabel("Search by ID or Roll No:"));
        searchField = new JTextField();
        searchPanel.add(searchField);
        JButton searchButton = new JButton("Search");
        searchPanel.add(searchButton);

        mainPanel.add(searchPanel, BorderLayout.NORTH);

        // Table
        String[] columnNames = {"ID", "Name", "Course", "Session", "Roll No", "Semester Marks", "Total Marks"};
        tableModel = new DefaultTableModel(columnNames, 0);
        studentTable = new JTable(tableModel);
        refreshTable();

        JScrollPane scrollPane = new JScrollPane(studentTable);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        add(mainPanel);

        searchButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String searchText = searchField.getText();
                if (!searchText.isEmpty()) {
                    try {
                        int id = Integer.parseInt(searchText);
                        Student student = sms.getStudentById(id);
                        if (student != null) {
                            new StudentDetailsPopupUI(student).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(ShowStudentsUI.this, "Student not found!");
                        }
                    } catch (NumberFormatException ex) {
                        Student student = sms.getStudentByRollNo(searchText);
                        if (student != null) {
                            new StudentDetailsPopupUI(student).setVisible(true);
                        } else {
                            JOptionPane.showMessageDialog(ShowStudentsUI.this, "Student not found!");
                        }
                    }
                }
            }
        });
    }

    private void refreshTable() {
        tableModel.setRowCount(0);
        for (Student student : sms.getAllStudents()) {
            StringBuilder semesterMarksString = new StringBuilder();
            for (Map.Entry<Integer, Integer> entry : student.getSemesterMarks().entrySet()) {
                semesterMarksString.append("Sem ").append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
            }
            tableModel.addRow(new Object[]{student.getId(), student.getName(), student.getCourse(), student.getSession(), student.getRollNo(), semesterMarksString.toString(), student.getTotalMarks()});
        }
    }
}

class StudentDetailsPopupUI extends JFrame {
    public StudentDetailsPopupUI(Student student) {
        setTitle("Student Details");
        setSize(400, 300);
        setLocationRelativeTo(null);

        JPanel mainPanel = new JPanel(new GridLayout(7, 2, 10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        mainPanel.add(new JLabel("ID:"));
        mainPanel.add(new JLabel(String.valueOf(student.getId())));

        mainPanel.add(new JLabel("Name:"));
        mainPanel.add(new JLabel(student.getName()));

        mainPanel.add(new JLabel("Course:"));
        mainPanel.add(new JLabel(student.getCourse()));

        mainPanel.add(new JLabel("Session:"));
        mainPanel.add(new JLabel(student.getSession()));

        mainPanel.add(new JLabel("Roll No:"));
        mainPanel.add(new JLabel(student.getRollNo()));

        StringBuilder semesterMarksString = new StringBuilder();
        for (Map.Entry<Integer, Integer> entry : student.getSemesterMarks().entrySet()) {
            semesterMarksString.append("Sem ").append(entry.getKey()).append(": ").append(entry.getValue()).append(", ");
        }
        mainPanel.add(new JLabel("Semester Marks:"));
        mainPanel.add(new JLabel(semesterMarksString.toString()));

        mainPanel.add(new JLabel("Total Marks:"));
        mainPanel.add(new JLabel(String.valueOf(student.getTotalMarks())));

        add(mainPanel);
    }
}
