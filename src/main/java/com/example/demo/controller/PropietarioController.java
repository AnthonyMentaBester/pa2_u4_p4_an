package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.repository.modelo.Propietario;
import com.example.demo.service.IPropietarioService;



//anotacion adisional para controlar peticiones de la web 
@Controller
//siempre debe estar en plural
//hay diferentes tipos de request o metodos http 
@RequestMapping("/propietarios")
public class PropietarioController {
	
	@Autowired
	private IPropietarioService iPropietarioService;
	@GetMapping("/buscar")
	//es para saber que dato serria
	public String buscarTodos(Model modelo) {
		List<Propietario> lista = this.iPropietarioService.buscarTodos();
		modelo.addAttribute("propietarios",modelo);
		return "vistaListaPropietarios";
	}

}
