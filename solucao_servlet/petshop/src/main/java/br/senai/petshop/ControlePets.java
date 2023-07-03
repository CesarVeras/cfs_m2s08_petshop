package br.senai.petshop;

import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class ControlePets {

	public static void cadastrarPet(HttpServletRequest req,HttpServletResponse resp) {
		Pet p = petFromRequest(req);
		Banco.adicionarPet(p);
	}
	
	public static void editarPet(HttpServletRequest req,HttpServletResponse resp) {
		ArrayList<Pet> pets = Banco.buscarPets();
		
		Long id = Long.parseLong(req.getParameter("id"));
		Pet petParaAlterar = null;
		
		for (Pet p : pets) {
			if (p.getId() == id) {
				petParaAlterar = p;
				break;
			}
		}
		
		if (petParaAlterar == null) return;
		
		String nome = req.getParameter("nome");
		String especie = req.getParameter("especie");
		String raca = req.getParameter("raca");
		String cor = req.getParameter("cor");
		String peso = req.getParameter("peso");
		String dataNascimento = req.getParameter("dataNascimento");
		
		Banco.editarPet(petParaAlterar, nome, especie, raca, cor, peso, dataNascimento);
	}
	
	private static Pet petFromRequest(HttpServletRequest req) {
		Pet p = new Pet();
		
		p.setNome(req.getParameter("nome"));
		p.setEspecie(req.getParameter("especie"));
		p.setRaca(req.getParameter("raca"));
		p.setCor(req.getParameter("cor"));
		p.setPeso(Float.parseFloat(req.getParameter("peso")));
		p.setDataNascimento(req.getParameter("dataNascimento"));
		return p;
	}

	public static void removerPet(Long id) {
		ArrayList<Pet> pets = Banco.buscarPets();
		Pet petParaRemover = null;
		
		for (Pet p : pets) {
			if (p.getId() == id) {
				petParaRemover = p;
				break;
			}
		}
		if (petParaRemover == null) return;
		Banco.removerPet(petParaRemover);
	}
	
}
