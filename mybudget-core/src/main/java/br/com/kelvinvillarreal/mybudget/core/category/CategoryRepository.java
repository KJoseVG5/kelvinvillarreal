package br.com.kelvinvillarreal.mybudget.core.category;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

public interface CategoryRepository extends CrudRepository<Category, Long> {
	
	List<Category> findByNameContaining(String name);

}
