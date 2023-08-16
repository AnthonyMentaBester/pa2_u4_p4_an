package com.example.demo.repository;

import java.util.List;

import com.example.demo.repository.modelo.Propietario;

public interface IPropietarioRepository {

	public void insertar(Propietario propietario);
	
	public void actualizar(Propietario propietario);
	
	public Propietario seleccionarPorCedula(String cedula);
	
	public void eliminarPorCedula(String cedula);
	
	public List<Propietario> buscarTodos();
	
	
}
