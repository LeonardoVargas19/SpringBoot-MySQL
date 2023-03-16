package com.example.di.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.di.dao.UsuarioDao;
import com.example.di.models.Usuario;
@RestController
public class AuthController {
	@Autowired
	private UsuarioDao usuarioDao;
	
	@PostMapping("/login")
	public String login(@RequestBody  Usuario usuario){
	 if(usuarioDao.verificarEmail(usuario)) {
		 return"OK";
	 }else{
		  return "FAIL";
	 }

  } 
	
}
