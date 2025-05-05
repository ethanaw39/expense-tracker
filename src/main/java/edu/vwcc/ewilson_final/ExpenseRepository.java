package edu.vwcc.ewilson_final;

import java.time.LocalDate;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.jpa.repository.JpaRepository;

// creates the 'ExpenseRepository' interface which extends JpaRepository
public interface ExpenseRepository extends JpaRepository<Expense, Long> {

	// defines a custom query to filter expenses based on multiple criteria
	@Query("""
			    SELECT e FROM Expense e
			    WHERE (:expenseName IS NULL OR LOWER(e.expenseName) LIKE LOWER(CONCAT('%', :expenseName, '%')))
			      AND (:minAmount IS NULL OR e.amount >= :minAmount)
			      AND (:maxAmount IS NULL OR e.amount <= :maxAmount)
			      AND (:category IS NULL OR e.category = :category)
			      AND (:startDate IS NULL OR e.date >= :startDate)
			      AND (:endDate IS NULL OR e.date <= :endDate)
			      ORDER BY e.date DESC
			""")
	// declares the 'findFiltered' method for filtering expenses with parameters
	List<Expense> findFiltered(@Param("expenseName") String expenseName, @Param("minAmount") Double minAmount,
			@Param("maxAmount") Double maxAmount, @Param("category") String category,
			@Param("startDate") LocalDate startDate, @Param("endDate") LocalDate endDate);
}