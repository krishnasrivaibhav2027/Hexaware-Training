package com.casestudy.financemanagementsystem.Exceptions;

public class ExpenseNotFoundException extends Exception{
    public ExpenseNotFoundException() {
    }

    public ExpenseNotFoundException(String message) {
        super(message);
    }

}
