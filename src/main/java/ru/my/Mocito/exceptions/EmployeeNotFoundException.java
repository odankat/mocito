package ru.my.Mocito.exceptions;

public class EmployeeNotFoundException extends RuntimeException{
    public EmployeeNotFoundException(String massage) {
        super(massage);
    }
}
