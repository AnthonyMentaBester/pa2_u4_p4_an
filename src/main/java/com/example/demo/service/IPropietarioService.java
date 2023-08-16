package com.example.demo.service;

import java.util.List;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioService {

	public void agregar(Propietario propietario);
	
	public void actualizar(Propietario propietario);
	
	public Propietario buscarPorCedula(String cedula);
	
	public void borrarPorCedula(String cedula);
	public List<Propietario> buscarTodos();
	
}
