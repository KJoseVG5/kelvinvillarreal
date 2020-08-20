package br.com.kelvinvillarreal.mybudget.budget.client;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
@JsonDeserialize(using = CategoryDTODeserializer.class)
public final class CategoryDTO {

	private final String name;
	
    // Empty constructor for JSON/JPA
	CategoryDTO() {
		this.name = null;
    }

}
