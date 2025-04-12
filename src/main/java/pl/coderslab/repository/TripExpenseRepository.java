package pl.coderslab.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.coderslab.entity.TripExpense;

public interface TripExpenseRepository extends JpaRepository<TripExpense, Long> {
}
