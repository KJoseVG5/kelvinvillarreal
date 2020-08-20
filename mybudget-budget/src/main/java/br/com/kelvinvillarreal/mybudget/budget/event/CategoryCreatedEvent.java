package br.com.kelvinvillarreal.mybudget.budget.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Setter
@Getter
@ToString
@EqualsAndHashCode
public class CategoryCreatedEvent implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long categoryId;
	

}
