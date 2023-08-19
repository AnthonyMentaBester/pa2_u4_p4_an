package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.modelo.Propietario;
import com.example.demo.service.IPropietarioService;

@Controller
@RequestMapping("/propietarios")
public class PropietarioController {
	
	@Autowired
	private IPropietarioService iPropietarioService;
	
	
	//http://localhost:8080/concesionario/propietarios/reporte
	@GetMapping("/reporte")
	public String buscarTodos(Model model){
		List<Propietario> lista= this.iPropietarioService.reporte();
		model.addAttribute("propietarios",lista);
		return "vistaListaPropietarios";
	}
	@GetMapping("/buscarPorID/{idPropietario}")
    public String buscarPorId(@PathVariable("idPropietario") Integer id, Model model) {

        Propietario pro =this.iPropietarioService.encontrarId(id);
        model.addAttribute("propietario", pro);
        return "vistaPropietario";
    }
	@PutMapping("/actualizar/{idPropietario}")
	public String actualizarPropietario(Integer id, Propietario propietario) {
		this.iPropietarioService.modificar(propietario);
		return "redirect:/propietarios/reporte";
	}
	

}
