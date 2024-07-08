package ru.my.Mocito.exceptions;

public class EmployeeStorageIsFullException extends RuntimeException{
    public EmployeeStorageIsFullException(String massage) {
        super(massage);
    }
}
