package br.com.kelvinvillarreal.mybudget.budget;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BudgetServiceImpl implements BudgetService {

	private BudgetRepository budgetRepository;

	@Autowired
	public BudgetServiceImpl(final BudgetRepository categoryRepository) {
		this.budgetRepository = categoryRepository;
	}

	public Optional<Budget> find(Long id) {
		return budgetRepository.findById(id);
	}

	public Iterable<Budget> findAll() {
		return budgetRepository.findAll();
	}

	public Budget save(Budget category) {
		return budgetRepository.save(category);
	}

	public void delete(Long id) {
		budgetRepository.deleteById(id);
	}

}
