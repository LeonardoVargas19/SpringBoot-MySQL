package com.example.di.dao;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.di.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;


@Repository
@Transactional

public class UsuarioDaoImp implements UsuarioDao {
	
	@PersistenceContext
	private
	 EntityManager entituEntityManager;
	
	@Override
	
	public List<Usuario> getUsuarios() {
		String query = "FROM Usuario";
		
		return getEntituEntityManager().createQuery(query).getResultList();
	}

	public EntityManager getEntituEntityManager() {
		return entituEntityManager;
	}

	public void setEntituEntityManager(EntityManager entituEntityManager) {
		this.entituEntityManager = entituEntityManager;
	}

	@Override
	public void eliminar(long id) {
		Usuario usuario = entituEntityManager.find(Usuario.class, id);
		
		entituEntityManager.remove(usuario);
		
	}

	@Override
	public void registrar(Usuario usuario) {
	entituEntityManager.merge(usuario);
	
	}

	@Override
	public boolean verificarEmail(Usuario usuario) {
	String query = "FROM Usuario WHERE email= :email  ";
		 List<Usuario> lista = entituEntityManager.createQuery(query)
				.setParameter("email", usuario.getEmail())
				.getResultList();
		 if(lista.isEmpty()) {
			 return false;
			 
		 }
		 
		 
		 String passwordhas=lista.get(0).getPassword();
		 
		 
		 Argon2 argon2=Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		
	return  argon2.verify(passwordhas, usuario.getPassword().toCharArray());
		

		
	}


}
