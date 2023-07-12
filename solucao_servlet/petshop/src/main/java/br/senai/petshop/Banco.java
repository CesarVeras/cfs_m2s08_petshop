package br.senai.petshop;

import java.util.ArrayList;

public class Banco {

    public static ArrayList<Pet> pets = new ArrayList<>();
    public static Long id = 0L;
    
    public static ArrayList<Pet> buscarPets() {
			return pets;
    }
    
    public static void adicionarPet(Pet pet) {
			if (pet == null)  return;
			pet.setId(++id);
			pets.add(pet);    		
			System.out.println("Pet adicionado: " + pet);
    }

	public static void removerPet(Pet pet) {
		pets.remove(pet);
		System.out.println("Pet removido: " + pet);
	}

	public static void editarPet(Pet pet, String nome, String especie, String raca, String cor, String peso,
			String dataNascimento) {
		float pesoF = Float.parseFloat(peso);
		if (nome != null && !nome.equals(pet.getNome())) pet.setNome(nome);
		if (especie != null && !especie.equals(pet.getEspecie())) pet.setEspecie(especie);
		if (raca != null && !raca.equals(pet.getRaca())) pet.setRaca(raca); 
		if (cor != null && !cor.equals(pet.getCor())) pet.setCor(cor);
		if (peso != null && pesoF != pet.getPeso()) pet.setPeso(pesoF);
		if (dataNascimento != null) pet.setDataNascimento(dataNascimento);
		System.out.println(pet);
	}
}
