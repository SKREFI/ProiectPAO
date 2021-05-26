package com.skrefi.PAOProject.repo;

import com.opencsv.CSVWriter;
import com.opencsv.bean.StatefulBeanToCsv;
import com.opencsv.bean.StatefulBeanToCsvBuilder;
import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.skrefi.PAOProject.data.models.Course;
import com.skrefi.PAOProject.data.models.userData.users.Student;
import com.skrefi.PAOProject.data.models.userData.users.Teacher;

import java.io.FileWriter;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;

import static com.skrefi.PAOProject.data.utils.Constants.*;

public class CSVRepository {
    private static CSVRepository instance = null;

    public static CSVRepository getInstance() throws IOException {
        return instance == null ? new CSVRepository() : instance;
    }

    StatefulBeanToCsv<Course> coursesSbc = new StatefulBeanToCsvBuilder<Course>(new FileWriter(COURSES_CSV_PATH))
            .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
            .build();

    StatefulBeanToCsv<Teacher> teachersSbc = new StatefulBeanToCsvBuilder<Teacher>(new FileWriter(TEACHERS_CSV_PATH))
            .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
            .build();

    StatefulBeanToCsv<Student> studentsSbc = new StatefulBeanToCsvBuilder<Student>(new FileWriter(STUDENTS_CSV_PATH))
            .withSeparator(CSVWriter.DEFAULT_SEPARATOR)
            .build();

    public CSVRepository() throws IOException {
    }

    public void writeToCsv(Student student) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        studentsSbc.write(student);
    }

    public void writeToCsv(Teacher teacher) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        teachersSbc.write(teacher);
    }

    public void writeToCsv(Course course) throws CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        coursesSbc.write(course);
    }
}
