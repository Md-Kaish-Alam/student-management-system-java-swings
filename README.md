# Student Management Application

The Student Management Application is a Java-based desktop application that allows users to manage student details, including adding, updating, deleting student information, adding semester marks, and viewing all student details. The application uses Java Swing for the graphical user interface and basic data structures for storing and managing data.

## Features

1. **Add Student**: Add student details such as Name, Course, Session, and Roll No. The ID is generated automatically.
2. **Update Student**: Update existing student details using the student ID.
3. **Delete Student**: Delete student details using the student ID.
4. **Add Semester Marks**: Add semester marks for a student and automatically update the total marks.
5. **View Students**: View all student details in a table. Search for a student by ID or Roll No.

## Prerequisites

- Java Development Kit (JDK) 8 or higher
- Apache Maven (optional, if you want to use Maven for dependency management)

## Steps to Download and Run the Project

### Step 1: Clone the Repository

```bash
git clone https://github.com/your-username/student-management-application.git
cd student-management-application
```

### Step 2: Compile the Project

If you are using an IDE like IntelliJ IDEA, Eclipse, or NetBeans, open the project in your IDE and build the project.

If you prefer to use the command line, navigate to the project directory and run:
```bash
javac -d bin -sourcepath src src/com/student/management/*.java
```

### Step 3: Run the Application

If you are using an IDE, run the `StudentDetailsUI` class.

To run from the command line, navigate to the `bin` directory and execute:
```bash
cd bin
java com.student.management.StudentDetailsUI
```

## Project Structure

```bash
student-management-application/
│
├── src/
│   └── com/student/management/
│       ├── AddMarksUI.java
│       ├── ShowStudentsUI.java
│       ├── Student.java
│       ├── StudentDetailsUI.java
│       ├── StudentManagementSystem.java
│       └── StudentTableModel.java
│
├── bin/
│
├── README.md
│
└── .gitignore
```

## Usage

1. **Add Student**: Fill in the details in the form and click "Add" to add a new student.
2. **Update Student**: Enter the student ID, update the details in the form, and click "Update".
3. **Delete Student**: Enter the student ID and click "Delete".
4. **Add Semester Marks**: Enter the student ID and click "Add Marks". Fill in the semester and marks, then click "Add".
5. **View Students**: Click "Show Students" to view all student details. Use the search functionality to find a student by ID or Roll No.

## Application Screenshots:

![Screenshot 2024-07-15 203903](https://github.com/user-attachments/assets/de82bfdf-ef5c-4444-a98f-4863e7fe0acf)
![Screenshot 2024-07-15 203947](https://github.com/user-attachments/assets/d12feefb-f760-4256-8d80-8f1138474a5d)
![Screenshot 2024-07-15 204015](https://github.com/user-attachments/assets/7aca3b59-8168-43e6-97e2-3a059bce94b7)
![Screenshot 2024-07-15 204037](https://github.com/user-attachments/assets/4dffd8a7-023c-494a-b541-3f6a3fba890d)
![Screenshot 2024-07-15 204053](https://github.com/user-attachments/assets/d55a4d7f-d864-4e47-9c2f-4393ee7a458b)
![Screenshot 2024-07-15 204111](https://github.com/user-attachments/assets/63936fcb-d1a3-4c33-a85c-a4f9b926ae94)
![Screenshot 2024-07-15 204142](https://github.com/user-attachments/assets/440f1f35-126e-47b5-9182-00471d3455db)


