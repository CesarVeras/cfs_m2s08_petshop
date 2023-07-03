package br.senai.petshop;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/pets")
public class MainServlet extends HttpServlet{
	private static final long serialVersionUID = 1L;

	@Override protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			 throws ServletException, IOException {
		PrintWriter writer = resp.getWriter(); 
		ArrayList<Pet> pets = Banco.buscarPets();
		
		writer.print("<ul>");
		for (Pet p : pets) {
			writer.printf("<li>%s</li>", p);
		}
		writer.print("</ul>");
	}
	
	@Override
	protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter(); 
		ControlePets.editarPet(req, resp);
		writer.print("Fez um put!");
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter(); 
		ControlePets.cadastrarPet(req, resp);
		resp.setStatus(201);
		writer.println("Fez um post!");
	}
	
	@Override
	protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter writer = resp.getWriter(); 
		ControlePets.removerPet(Long.parseLong(req.getParameter("id")));
		writer.print("Fez um delete!");
	}
}
