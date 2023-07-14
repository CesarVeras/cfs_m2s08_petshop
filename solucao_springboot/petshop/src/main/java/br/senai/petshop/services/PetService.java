package br.senai.petshop.services;

import br.senai.petshop.models.Tutor;
import br.senai.petshop.repositories.PetRepository;
import br.senai.petshop.models.Pet;
import br.senai.petshop.repositories.TutorRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

	public List<Pet> listarPets() {
		return PetRepository.getPets();
	}

	public void cadastrarPet(Pet pet) {
		if (pet == null)
			return;
		PetRepository.addPet(pet);
	}

	public void editarPet(Pet pet) {
		List<Pet> pets = PetRepository.getPets();

		Pet petParaAlterar = null;

		for (Pet p : pets) {
			if (p.getId().equals(pet.getId())) {
				petParaAlterar = p;
				break;
			}
		}

		if (petParaAlterar == null)
			return;
		PetRepository.updatePet(
				petParaAlterar, pet.getNome(), pet.getEspecie(), pet.getRaca(), pet.getCor(), pet.getPeso(),
				pet.getDataNascimento());
	}

	public void removerPet(Long id) {
		List<Pet> pets = PetRepository.getPets();
		Pet petParaRemover = null;

		for (Pet p : pets) {
			if (p.getId().equals(id)) {
				petParaRemover = p;
				break;
			}
		}
		if (petParaRemover == null)
			return;
		PetRepository.removePet(petParaRemover);
	}

	public List<Pet> listarPetsPorEspecie(String especie) {
		List<Pet> pets = PetRepository.getPets();
		List<Pet> petsFiltrados = new ArrayList<>();

		for (Pet p : pets) {
			if (p.getEspecie().equalsIgnoreCase(especie)) {
				petsFiltrados.add(p);
			}
		}

		return petsFiltrados;
	}

	public void adicionarTutorAoPet(Long idPet, Long idTutor) {
		List<Pet> pets = PetRepository.getPets();
		List<Tutor> tutores = TutorRepository.getTutores();

		Pet pet = null;
		Tutor tutor = null;

		for (Pet p : pets) {
			if (p.getId().equals(idPet)) {
				pet = p;
				break;
			}
		}

		if (pet == null)
			return;

		for (Tutor t : tutores) {
			if (t.getId().equals(idTutor)) {
				tutor = t;
				break;
			}
		}

		if (tutor == null)
			return;

		PetRepository.updateTutor(pet, tutor);
	}
}
