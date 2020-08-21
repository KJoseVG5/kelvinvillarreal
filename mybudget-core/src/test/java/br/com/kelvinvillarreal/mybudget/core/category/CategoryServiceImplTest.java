package br.com.kelvinvillarreal.mybudget.core.category;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import br.com.kelvinvillarreal.mybudget.core.event.EventDispatcher;

public class CategoryServiceImplTest {

	private CategoryService categoryService;

	@Mock
	private EventDispatcher eventDispatcher;

	@Mock
	private CategoryRepository categoryRepository;

	@Before
	public void setUp() {
		// With this call to initMocks we tell Mockito to process the annotations
		MockitoAnnotations.initMocks(this);

		this.categoryService = new CategoryServiceImpl(categoryRepository, eventDispatcher);
	}

	@Test
	public void saveTes() {
		// when
		Category category = new Category();
		category.setName("Housing");
		categoryService.save(category);

		// then
		assertThat(category.getName()).isEqualTo("Housing");
	}
}
