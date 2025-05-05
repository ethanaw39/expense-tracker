package edu.vwcc.ewilson_final;

import java.time.LocalDate;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

// marks this class as a JPA entity
@Entity
public class Expense {

	// specifies the primary key field generates unique values for each new expense
	// record
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	// declares 5 variables
	private long id;
	private String expenseName;
	private double amount;
	private String category;
	private LocalDate date;

	// getter method for the 'id' field
	public long getId() {
		return id;
	}

	// setter method for the 'id' field
	public void setId(long id) {
		this.id = id;
	}

	// getter method for the 'expenseName' field
	public String getExpenseName() {
		return expenseName;
	}

	// setter method for the 'expenseName' field
	public void setExpenseName(String expenseName) {
		this.expenseName = expenseName;
	}

	// getter method for the 'amount' field
	public double getAmount() {
		return amount;
	}

	// setter method for the 'amount' field
	public void setAmount(double amount) {
		this.amount = amount;
	}

	// getter method for the 'category' field
	public String getCategory() {
		return category;
	}

	// setter method for the 'category' field
	public void setCategory(String category) {
		this.category = category;
	}

	// getter method for the 'date' field
	public LocalDate getDate() {
		return date;
	}

	// setter method for the 'date' field
	public void setDate(LocalDate date) {
		this.date = date;
	}
}
