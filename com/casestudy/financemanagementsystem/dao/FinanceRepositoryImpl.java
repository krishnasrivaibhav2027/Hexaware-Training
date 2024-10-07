package com.casestudy.financemanagementsystem.dao;
import com.casestudy.financemanagementsystem.Entity.Expenses;
import com.casestudy.financemanagementsystem.Entity.Users;
import com.casestudy.financemanagementsystem.Exceptions.ExpenseNotFoundException;
import com.casestudy.financemanagementsystem.Exceptions.UserNotFoundException;
import com.casestudy.financemanagementsystem.util.DBConnUtil;
import java.util.*;
import java.sql.*;


public class FinanceRepositoryImpl implements IFinanceRepository{
    private Connection connection;
    public FinanceRepositoryImpl(){
        this.connection = DBConnUtil.getConnection();
    }

    @Override
    public boolean createUser(Users user) throws SQLException {
        String query = "INSERT INTO USERS (username,password,email) VALUES (?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setString(1, user.getUsername());
            ps.setString(2, user.getPassword());
            ps.setString(3, user.getEmail());
            return ps.executeUpdate() > 0;
        } catch (SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean createExpense(Expenses expense) throws SQLException {
        String query = "INSERT INTO EXPENSES (user_id, amount, category_id, date, description) VALUES (?,?,?,?,?)";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, expense.getUser_id());
            ps.setDouble(2, expense.getAmount());
            ps.setInt(3,expense.getCategory_id());
            ps.setDate(4, expense.getDate());
            ps.setString(5, expense.getDescription());
            return ps.executeUpdate() > 0;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }

    }

    @Override
    public boolean deleteUser(int user_id) throws SQLException, UserNotFoundException {
        String query = "DELETE FROM USERS WHERE user_id = ?";
        try (PreparedStatement ps = connection.prepareStatement(query)) {
            ps.setInt(1, user_id);
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected == 0) {
                throw new UserNotFoundException("User with ID " + user_id + " not found.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }


    @Override
    public boolean deleteExpense(int expense_id) throws SQLException, ExpenseNotFoundException {
        String query = "DELETE FROM EXPENSES WHERE expense_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, expense_id);
            int rowsAffected = ps.executeUpdate();
            if(rowsAffected == 0){
                throw new ExpenseNotFoundException("Expense with ID: " + expense_id + "not found");
            }
            return true;
        }catch(SQLException e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Expenses> getAllExpenses(int user_id) throws SQLException, UserNotFoundException {
        List<Expenses> expenses = new ArrayList<>();
        String query = "SELECT * FROM EXPENSES WHERE user_id = ?";
        try(PreparedStatement ps = connection.prepareStatement(query)){
            ps.setInt(1, user_id);
            ResultSet rs = ps.executeQuery();
            if(!rs.isBeforeFirst()){
                throw new UserNotFoundException("No expenses found for user with ID: "+ user_id);
            }
            while(rs.next()){
                Expenses expense = new Expenses();
                expense.setExpense_id(rs.getInt("expense_id"));
                expense.setUser_id(rs.getInt("user_id"));
                expense.setAmount(rs.getDouble("amount"));
                expense.setCategory_id(rs.getInt("category_id"));
                expense.setDate(rs.getDate("date"));
                expense.setDescription(rs.getString("description"));
                expenses.add(expense);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return expenses;
    }

    @Override
    public boolean updateExpense(int user_id, Expenses expense) throws SQLException, UserNotFoundException, ExpenseNotFoundException {
        String queryUser = "SELECT 1 FROM EXPENSES WHERE user_id = ?";
        String queryExpense = "UPDATE EXPENSES SET amount = ?, category_id = ?, date = ?, description = ? WHERE user_id = ? AND expense_id = ?";

        try (PreparedStatement psCheckUser = connection.prepareStatement(queryUser)) {

            psCheckUser.setInt(1, user_id);
            ResultSet rs = psCheckUser.executeQuery();
            if (!rs.next()) {

                throw new UserNotFoundException("User with ID " + user_id + " not found in the expenses table.");
            }
        }

        try (PreparedStatement psUpdateExpense = connection.prepareStatement(queryExpense)) {
            psUpdateExpense.setDouble(1, expense.getAmount());
            psUpdateExpense.setInt(2, expense.getCategory_id());
            psUpdateExpense.setDate(3, new java.sql.Date(expense.getDate().getTime()));
            psUpdateExpense.setString(4, expense.getDescription());
            psUpdateExpense.setInt(5, user_id);
            psUpdateExpense.setInt(6, expense.getExpense_id());

            int rowsAffected = psUpdateExpense.executeUpdate();


            if (rowsAffected == 0) {
                throw new ExpenseNotFoundException("Expense with ID " + expense.getExpense_id() + " for user ID " + user_id + " not found.");
            }
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
            throw e;
        }
    }

}
