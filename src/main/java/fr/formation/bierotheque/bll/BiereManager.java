package fr.formation.bierotheque.bll;

import java.util.List;

import javax.validation.Valid;

import fr.formation.bierotheque.bo.Biere;

public interface BiereManager {
	public void addBiere(Biere... lstBieres) throws BiereException;
	public List<Biere> getAllBieres();
	public void delBiereById(Integer id);
	public Biere getBiereById(Integer id);
	public void modBiere(Biere biere) throws BiereException;
}
