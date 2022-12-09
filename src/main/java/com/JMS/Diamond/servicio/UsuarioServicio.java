package com.JMS.Diamond.servicio;

import java.util.List;

import org.springframework.security.core.userdetails.UserDetailsService;

import com.JMS.Diamond.controlador.dto.UsuarioRegistroDTO;
import com.JMS.Diamond.modelo.Usuario;


public interface UsuarioServicio extends UserDetailsService{

	public Usuario guardar(UsuarioRegistroDTO registroDTO);
	
	public List<Usuario> listarUsuarios();
	
}
