package edu.vwcc.ewilson_final;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

// creates the 'ExpenseTests' class to test the functionality of the 'Expense' model
public class ExpenseTests {

    // tests the getter and setter for the 'expenseName' variable
    @Test
    public void testExpenseName() {
        Expense expense = new Expense();
        expense.setExpenseName("Groceries");
        assertEquals("Groceries", expense.getExpenseName());
    }

    // tests the getter and setter for the 'amount' variable
    @Test
    public void testAmount() {
        Expense expense = new Expense();
        expense.setAmount(50.00);
        assertEquals(50.00, expense.getAmount());
    }

    // tests the getter and setter for the 'category' variable
    @Test
    public void testCategory() {
        Expense expense = new Expense();
        expense.setCategory("Food & Drink");
        assertEquals("Food & Drink", expense.getCategory());
    }

    // tests the getter and setter for the 'date' variable
    @Test
    public void testDate() {
        Expense expense = new Expense();
        LocalDate date = LocalDate.of(2025, 5, 3);
        expense.setDate(date);
        assertEquals(date, expense.getDate());
    }

    // tests the getter and setter for the 'id' variable
    @Test
    public void testId() {
        Expense expense = new Expense();
        expense.setId(1);
        assertEquals(1, expense.getId());
    }
}