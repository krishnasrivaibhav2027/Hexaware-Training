package com.casestudy.financemanagementsystem.Entity;
import java.sql.*;
public class Expenses {
    private int expense_id;
    private int user_id;
    private double amount;
    private int category_id;
    private Date date;
    private String description;
    private static int expenseCount = 0;

    public Expenses(){

    }

    public Expenses(int user_id, double amount, int category_id, Date date, String description) {
        this.expense_id = expenseCount++;
        this.user_id = user_id;
        this.amount = amount;
        this.category_id = category_id;
        this.date = date;
        this.description = description;
    }

    public Expenses(int expenseIdForUpdate, int userIdForUpdate, double newAmount, int newCategoryId, Date newDate, String newDescription) {
        this.expense_id = expenseIdForUpdate;
        this.user_id = userIdForUpdate;
        this.amount = newAmount;
        this.category_id = newCategoryId;
        this.date = newDate;
        this.description = newDescription;
    }

    public int getExpense_id() {
        return expense_id;
    }

    public void setExpense_id(int expense_id) {
        this.expense_id = expense_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
