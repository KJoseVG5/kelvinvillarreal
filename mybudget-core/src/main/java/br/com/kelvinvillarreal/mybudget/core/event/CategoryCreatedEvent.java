package br.com.kelvinvillarreal.mybudget.core.event;

import java.io.Serializable;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@RequiredArgsConstructor
@Getter
@ToString
@EqualsAndHashCode
public class CategoryCreatedEvent implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private final Long categoryId;

}
