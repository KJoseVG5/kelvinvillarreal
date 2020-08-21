package br.com.kelvinvillarreal.mybudget.core.category;

import java.util.Collection;
import java.util.Optional;

public interface CategoryService {

	public Optional<Category> find(Long id);
	
	public Collection<Category> search(String name);

	public Iterable<Category> findAll();

	public Category save(Category category);

	public void delete(Long id);

}
