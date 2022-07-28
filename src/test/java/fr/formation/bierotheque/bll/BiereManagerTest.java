package fr.formation.bierotheque.bll;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import javax.transaction.Transactional;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import fr.formation.bierotheque.bo.Biere;
import fr.formation.bierotheque.dal.BiereDAO;

@SpringBootTest
class BiereManagerTest {
	@Autowired
	BiereManager manager;
	
	@Autowired
	BiereDAO dao;
	
	@Test
	@Transactional
	void addBiereTest() throws BiereException {
		Biere biere = new Biere("Trompe Souris", "Blonde", "brasserie de la divatte");
		manager.addBiere(biere);
		assertNotNull(biere.getIdBiere());
		
		Biere b1 = new Biere("Stout une histoire","Noire","Brasserie de l'oudon");
		Biere b2 = new Biere("Pinte du Raz","Blonde","Pinte du Raz");
		manager.addBiere(b1,b2);
		assertNotNull(b1.getIdBiere());
		assertNotNull(b2.getIdBiere());
	}
	
	@Test 
	@Transactional
	void getAllBiereTest() {
		long nb = dao.count();
		Biere b1 = new Biere("Stout une histoire","Noire","Brasserie de l'oudon");
		dao.save(b1);
		assertEquals(nb, manager.getAllBieres().size()-1); 
	}
	
	@Test
	void addBiereCT001() {
		Biere b1 = new Biere("Kriek","Fruit","je sais plus mais j'en bois pas");
		assertThrows(BiereException.class, ()->{
			manager.addBiere(b1);			
		});
		
	}
}
