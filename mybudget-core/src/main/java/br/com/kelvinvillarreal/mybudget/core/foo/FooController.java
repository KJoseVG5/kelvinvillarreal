package br.com.kelvinvillarreal.mybudget.core.foo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.kelvinvillarreal.mybudget.core.category.Category;

/**
 * This class provides a REST API to POST the attempts from users.
 */
@RestController
@CrossOrigin
final class FooController {

	@Autowired
	FooController() {
	}

	@GetMapping("/foo")
	ResponseEntity<Category> foo() {
		Category category = new Category();
		category.setName("foo");
		return ResponseEntity.ok(category);
	}

}
