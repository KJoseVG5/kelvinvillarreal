package br.com.kelvinvillarreal.mybudget.budget;

import java.util.Optional;

public interface BudgetService {

	public Optional<Budget> find(Long id);
	
	public Iterable<Budget> findAll();

	public Budget save(Budget category);

	public void delete(Long id);

}
