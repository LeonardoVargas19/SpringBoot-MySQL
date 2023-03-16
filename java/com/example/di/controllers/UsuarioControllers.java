package com.example.di.controllers;




import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.di.dao.UsuarioDao;
import com.example.di.models.Usuario;

import de.mkammerer.argon2.Argon2;
import de.mkammerer.argon2.Argon2Factory;

@RestController
public class UsuarioControllers {
	
	@Autowired
	private UsuarioDao usuarioDao;
	
	
	@GetMapping("/api/usuarioss/{id}")
	public Usuario getUsuario(@PathVariable long id) {
		Usuario usuario= new Usuario();
		usuario.setId(id);
		usuario.setNombre("Rei");
		usuario.setApellido("Ayanami");
		usuario.setEmail("rei.01@gmail.com");
		usuario.setTelefono("554105822");
		
		return usuario;
	}
	
	@GetMapping("/usuarios")
	public List<Usuario> getUsuarios(){
		return usuarioDao.getUsuarios();
	
	}
	@DeleteMapping("usuarios/{id}")
	public void eliminar(@PathVariable long id) {
		usuarioDao.eliminar(id);
		
	}  
	
	/*Registrar usuario
	 * */
	
	@PostMapping("/usuarios/api")
	public void registrarUsuario(@RequestBody Usuario usuario) {
		Argon2 argon2 = Argon2Factory.create(Argon2Factory.Argon2Types.ARGON2id);
		String hash=argon2.hash(1, 1024,1,usuario.getPassword().toCharArray());
		
		usuario.setPassword(hash);
		usuarioDao.registrar(usuario);
		
		
	}
	
	
	
	
}
