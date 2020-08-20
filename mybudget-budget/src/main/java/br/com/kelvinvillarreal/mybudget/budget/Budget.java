package br.com.kelvinvillarreal.mybudget.budget;

import java.io.Serializable;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "budget")
public class Budget implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@NotNull
	@Column(name = "ano", nullable = false, unique = false)
	private Integer year;

	@NotNull
	@Column(name = "month", nullable = false, unique = false)
	private Integer month;

	@NotNull
	@Column(name = "value", nullable = false, unique = false)
	private BigDecimal value;

}