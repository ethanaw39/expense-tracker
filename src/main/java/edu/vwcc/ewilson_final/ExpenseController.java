package edu.vwcc.ewilson_final;

import java.time.LocalDate;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
// creates the 'ExpenseController' class
public class ExpenseController {

	private final ExpenseRepository expenseRepository;

	// constructor to initialize 'expenseRepository'
	public ExpenseController(ExpenseRepository expenseRepository) {
		this.expenseRepository = expenseRepository;
	}

	// maps GET requests to "/expenses" and filters results based on query
	// parameters
	@GetMapping("/expenses")
	public String viewExpenses(@RequestParam(required = false) String expenseName,
			@RequestParam(required = false) Double minAmount, @RequestParam(required = false) Double maxAmount,
			@RequestParam(required = false) String category,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
			@RequestParam(required = false) @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate,
			Model model) {

		// retrieves filtered expenses based on search criteria
		List<Expense> expenses = expenseRepository.findFiltered(
				expenseName != null && !expenseName.isBlank() ? expenseName : null, minAmount, maxAmount,
				category != null && !category.isBlank() ? category : null, startDate, endDate);
		expenses.sort((e1, e2) -> e2.getDate().compareTo(e1.getDate()));

		model.addAttribute("expenses", expenses);
		return "expenses";
	}

	// maps POST requests to "/expenses" and saves a new expense to the repository
	@PostMapping("/expenses")
	public String addExpense(@ModelAttribute Expense expense) {
		expenseRepository.save(expense);
		return "redirect:/expenses";
	}
}