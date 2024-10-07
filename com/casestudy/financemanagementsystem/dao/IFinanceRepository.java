package com.casestudy.financemanagementsystem.dao;
import java.sql.SQLException;
import java.util.*;
import com.casestudy.financemanagementsystem.Entity.Expenses;
import com.casestudy.financemanagementsystem.Entity.Users;
import com.casestudy.financemanagementsystem.Exceptions.ExpenseNotFoundException;
import com.casestudy.financemanagementsystem.Exceptions.UserNotFoundException;

public interface IFinanceRepository {
    boolean createUser(Users user) throws SQLException;
    boolean createExpense(Expenses expense) throws SQLException, UserNotFoundException;
    boolean deleteUser(int user_id) throws SQLException, UserNotFoundException;
    boolean deleteExpense(int expense_id) throws SQLException, ExpenseNotFoundException;
    List<Expenses> getAllExpenses(int user_id) throws SQLException, UserNotFoundException;
    boolean updateExpense(int user_id, Expenses expense) throws SQLException, UserNotFoundException, ExpenseNotFoundException;
}
