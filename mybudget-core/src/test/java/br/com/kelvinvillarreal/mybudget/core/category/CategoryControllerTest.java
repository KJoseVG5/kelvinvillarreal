package br.com.kelvinvillarreal.mybudget.core.category;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.json.JacksonTester;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@WebMvcTest(CategoryController.class)
public class CategoryControllerTest {

	@MockBean
	private CategoryService categoryService;

	@Autowired
	private MockMvc mvc;

	// This object will be initialized by the initFields method below.
	// These objects will be magically initialized by the initFields method below.
	private JacksonTester<Category> jsonResultAttempt;

	@Before
	public void setup() {
		JacksonTester.initFields(this, new ObjectMapper());
	}

	@Test
	public void saveTest() throws Exception {
		Category category = new Category();
		category.setId(1l);
		category.setName("Housing");

		given(categoryService.save(any(Category.class))).willReturn(category);

		// when
		MockHttpServletResponse response = mvc.perform(post("/categories").contentType(MediaType.APPLICATION_JSON)
				.content(jsonResultAttempt.write(category).getJson())).andReturn().getResponse();

		// then
		assertThat(response.getStatus()).isEqualTo(HttpStatus.OK.value());
		assertThat(response.getContentAsString()).isEqualTo(jsonResultAttempt.write(category).getJson());

	}

}
