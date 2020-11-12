package com.habibpadilla;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.habibpadilla.model.Person;
import com.habibpadilla.repo.IPersonaRepo;

@RunWith(SpringRunner.class)
@SpringBootTest
class NucleoFamiliarApplicationTests {

	@Autowired
	private IPersonaRepo repo;
	
	@Test
	public void createPerson() {
		Person per = new Person();
		per.setIdPersona(1);
		per.setNombre("Habib");
		per.setApellido("Padilla");
		per.setCorreo("habibpadilla@hotmail.com");
		Person respuesta=repo.save(per);
		
		assertTrue(respuesta.getNombre().equalsIgnoreCase(per.getNombre()));
	}

}
