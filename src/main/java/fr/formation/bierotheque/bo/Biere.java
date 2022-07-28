package fr.formation.bierotheque.bo;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;

import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
public class Biere {
	@Id
	@GeneratedValue
	private Integer idBiere;
	
	@NotBlank
	private String nom;
	private String couleur;
	private String brasserie;
	private LocalDate dtEntree = LocalDate.now();

	public Biere(String nom, String couleur, String brasserie) {
		super();
		this.nom = nom;
		this.couleur = couleur;
		this.brasserie = brasserie;
	}

}
