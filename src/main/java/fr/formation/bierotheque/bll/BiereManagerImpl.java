package fr.formation.bierotheque.bll;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import fr.formation.bierotheque.bo.Biere;
import fr.formation.bierotheque.dal.BiereDAO;

@Service
public class BiereManagerImpl implements BiereManager {
	@Autowired
	private BiereDAO dao;
	
	@Override
	@Transactional
	public void addBiere(Biere... lstBieres) throws BiereException {
		for (Biere biere : lstBieres) {
			addOrModBiere(biere);
		}
	}

	@Override
	public List<Biere> getAllBieres() {
		return (List<Biere>) dao.findAll();
	}

	@Override
	public void delBiereById(Integer id) {
		dao.deleteById(id);
	}

	@Override
	public Biere getBiereById(Integer id) {
		return dao.findById(id).orElse(null);
	}

	@Override
	public void modBiere(Biere biere) throws BiereException {
		this.addOrModBiere(biere);
	}

	private void addOrModBiere(Biere biere) throws BiereException {
		if("Fruit".equals(biere.getCouleur())){
			throw new BiereException("Pas de bières aux fruits");
		}
		dao.save(biere);
	}

}
