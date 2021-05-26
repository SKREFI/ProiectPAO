package com.skrefi.PAOProject.ui;

/*
    Grupa:  241
    Author: Sandu Razvan-Alexandru
    Tema:   Catalog (student, materie, profesor)


    Deadlines:
        Etapa I  : 31 martie 2021
        Etapa II : 28 aprilie 2021
        Etapa III: 26 mai 2021
* */


import com.opencsv.exceptions.CsvDataTypeMismatchException;
import com.opencsv.exceptions.CsvRequiredFieldEmptyException;
import com.skrefi.PAOProject.PaoProjectApplication;
import com.skrefi.PAOProject.data.models.userData.Grupa;
import com.skrefi.PAOProject.data.models.userData.users.Student;
import com.skrefi.PAOProject.data.models.userData.users.Teacher;
import com.skrefi.PAOProject.data.utils.Helper;
import com.skrefi.PAOProject.data.utils.Menu;
import com.skrefi.PAOProject.repo.CSVRepository;
import com.skrefi.PAOProject.repo.DatabaseRepository;
import org.springframework.boot.SpringApplication;

import java.io.IOException;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) throws IOException, SQLException, ClassNotFoundException, CsvRequiredFieldEmptyException, CsvDataTypeMismatchException {
        SpringApplication.run(PaoProjectApplication.class, args);
        DatabaseRepository db = DatabaseRepository.getInstance();

        CSVRepository csvRepository = CSVRepository.getInstance();
        Student student = Helper.getOneStudent();

        Menu menu = Menu.getInstance();
        menu.show();
    }

    private static <T> void print(T object) { Helper.print(object); }
}


