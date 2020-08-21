package br.com.kelvinvillarreal.mybudget.core.category;

import java.util.Collection;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.kelvinvillarreal.mybudget.core.event.CategoryCreatedEvent;
import br.com.kelvinvillarreal.mybudget.core.event.EventDispatcher;

@Service
public class CategoryServiceImpl implements CategoryService {

	private CategoryRepository categoryRepository;

	private EventDispatcher eventDispatcher;

	@Autowired
	public CategoryServiceImpl(final CategoryRepository categoryRepository, final EventDispatcher eventDispatcher) {
		this.categoryRepository = categoryRepository;
		this.eventDispatcher = eventDispatcher;
	}

	public Optional<Category> find(Long id) {
		return categoryRepository.findById(id);
	}

	public Iterable<Category> findAll() {
		return categoryRepository.findAll();
	}

	@Override
	public Collection<Category> search(String name) {
		return categoryRepository.findByNameContaining(name);
	}

	public Category save(Category category) {

		categoryRepository.save(category);

		eventDispatcher.send(new CategoryCreatedEvent(category.getId()));

		return category;
	}

	public void delete(Long id) {
		categoryRepository.deleteById(id);
	}

}
