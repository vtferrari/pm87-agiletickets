package br.com.caelum.agiletickets.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class Reserva {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

<<<<<<< HEAD
=======
	@Column
	private String cadeira;

>>>>>>> 82a2c5162d400ef91f4db4ffca44f2f7eca29716
	@ManyToOne
	private Espetaculo espetaculo;
}
