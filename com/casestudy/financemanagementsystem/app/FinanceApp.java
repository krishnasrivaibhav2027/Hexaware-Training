package com.casestudy.financemanagementsystem.app;
import java.sql.Date;
import java.util.*;
import java.sql.*;
import java.time.*;

import com.casestudy.financemanagementsystem.Entity.Expenses;
import com.casestudy.financemanagementsystem.Entity.Users;
import com.casestudy.financemanagementsystem.Exceptions.UserNotFoundException;
import com.casestudy.financemanagementsystem.Exceptions.ExpenseNotFoundException;
import com.casestudy.financemanagementsystem.dao.FinanceRepositoryImpl;

public class FinanceApp {
    public static void main(String[] args) {
        FinanceRepositoryImpl financeRepository = new FinanceRepositoryImpl();
        Scanner scanner = new Scanner(System.in);
        boolean exit = false;

        while (!exit) {
            System.out.println("Select an operation:");
            System.out.println("1. Add User");
            System.out.println("2. Add Expense");
            System.out.println("3. Delete User");
            System.out.println("4. Delete Expense");
            System.out.println("5. Update Expense");
            System.out.println("6. Get All Expenses for User");
            System.out.println("7. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String username = scanner.nextLine();
                    System.out.print("Enter password: ");
                    String password = scanner.nextLine();
                    System.out.print("Enter email: ");
                    String email = scanner.nextLine();

                    Users newUser = new Users(username, password, email);
                    try {
                        boolean success = financeRepository.createUser(newUser);
                        if (success) {
                            System.out.println("User added successfully.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error adding user: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.print("Enter user ID: ");
                    int userId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter amount: ");
                    double amount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter category ID: ");
                    int categoryId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter date (YYYY-MM-DD): ");
                    String dateStr = scanner.nextLine();
                    System.out.print("Enter description: ");
                    String description = scanner.nextLine();

                    Date date = Date.valueOf(dateStr);
                    Expenses newExpense = new Expenses(userId, amount, categoryId, date, description);

                    try {
                        boolean success = financeRepository.createExpense(newExpense);
                        if (success) {
                            System.out.println("Expense added successfully.");
                        }
                    } catch (SQLException e) {
                        System.out.println("Error adding expense: " + e.getMessage());
                    }
                    break;

                case 3:
                    System.out.print("Enter user ID to delete: ");
                    int userIdToDelete = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        boolean success = financeRepository.deleteUser(userIdToDelete);
                        if (success) {
                            System.out.println("User deleted successfully.");
                        }
                    } catch (SQLException | UserNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 4:
                    System.out.print("Enter expense ID to delete: ");
                    int expenseIdToDelete = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        boolean success = financeRepository.deleteExpense(expenseIdToDelete);
                        if (success) {
                            System.out.println("Expense deleted successfully.");
                        }
                    } catch (SQLException | ExpenseNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 5:
                    System.out.print("Enter user ID: ");
                    int userIdForUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter expense ID: ");
                    int expenseIdForUpdate = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new amount: ");
                    double newAmount = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Enter new category ID: ");
                    int newCategoryId = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter new date (YYYY-MM-DD): ");
                    String newDateStr = scanner.nextLine();
                    System.out.print("Enter new description: ");
                    String newDescription = scanner.nextLine();

                    java.sql.Date newDate = java.sql.Date.valueOf(newDateStr);
                    Expenses updatedExpense = new Expenses(expenseIdForUpdate, userIdForUpdate, newAmount, newCategoryId, newDate, newDescription);

                    try {
                        boolean success = financeRepository.updateExpense(userIdForUpdate, updatedExpense);
                        if (success) {
                            System.out.println("Expense updated successfully.");
                        }
                    } catch (SQLException | UserNotFoundException | ExpenseNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 6:
                    System.out.print("Enter user ID to fetch expenses: ");
                    int userIdForExpenses = scanner.nextInt();
                    scanner.nextLine();

                    try {
                        List<Expenses> expenses = financeRepository.getAllExpenses(userIdForExpenses);
                        if (expenses.isEmpty()) {
                            System.out.println("No expenses found for user ID " + userIdForExpenses);
                        } else {
                            expenses.forEach(exp -> System.out.println("Expense ID: " + exp.getExpense_id()+", Category ID: "+exp.getCategory_id()+", User ID: "+exp.getUser_id()+", Amount spent: "+exp.getAmount()+", Date: "+exp.getDate()+", Description: "+exp.getDescription()));
                        }
                    } catch (SQLException | UserNotFoundException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 7:
                    exit = true;
                    System.out.println("Exiting....");
                    break;

                default:
                    System.out.println("Invalid option, please try again.");
            }
        }

        scanner.close();
    }
}