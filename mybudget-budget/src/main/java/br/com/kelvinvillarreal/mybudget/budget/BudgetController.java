package br.com.kelvinvillarreal.mybudget.budget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class BudgetController {

	private BudgetService budgetService;

	@Autowired
	public BudgetController(final BudgetService budgetService) {
		this.budgetService = budgetService;
	}

	@GetMapping("/budgets")
	ResponseEntity<Iterable<Budget>> findAll() {
		return ResponseEntity.ok(budgetService.findAll());
	}

	@GetMapping("/budgets/{id}")
	ResponseEntity<Budget> find(final @PathVariable("id") Long id) {
		return budgetService.find(id).map(budget -> ResponseEntity.ok(budget))
				.orElseGet(() -> ResponseEntity.notFound().build());
	}

	@PostMapping("/budgets")
	ResponseEntity<Budget> save(@RequestBody Budget budget) {
		return ResponseEntity.ok(budgetService.save(budget));
	}

	@PutMapping("/budgets")
	ResponseEntity<Budget> update(@RequestBody Budget budget) {
		return ResponseEntity.ok(budgetService.save(budget));
	}

	@DeleteMapping("/budgets/{id}")
	void delete(final @PathVariable("id") Long id) {
		budgetService.delete(id);
	}

}
