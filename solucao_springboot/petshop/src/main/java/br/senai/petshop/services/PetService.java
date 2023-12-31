package br.senai.petshop.services;

import br.senai.petshop.models.Tutor;
import br.senai.petshop.models.Pet;
import br.senai.petshop.repositories.PetRepository;
import br.senai.petshop.repositories.TutorRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PetService {

	@Autowired
	private PetRepository repository;

	@Autowired
	private TutorRepository tutorRepository;

	public List<Pet> listarPets() {
		return repository.getPets();
	}

	public void cadastrarPet(Pet pet) {
		if (pet == null)
			return;
		repository.addPet(pet);
	}

	public void editarPet(Pet pet) {
		List<Pet> pets = repository.getPets();

		Pet petParaAlterar = null;

		for (Pet p : pets) {
			if (p.getId().equals(pet.getId())) {
				petParaAlterar = p;
				break;
			}
		}

		if (petParaAlterar == null)
			return;
		repository.updatePet(
				petParaAlterar, pet.getNome(), pet.getEspecie(), pet.getRaca(), pet.getCor(), pet.getPeso(),
				pet.getDataNascimento());
	}

	public void removerPet(Long id) {
		List<Pet> pets = repository.getPets();
		Pet petParaRemover = null;

		for (Pet p : pets) {
			if (p.getId().equals(id)) {
				petParaRemover = p;
				break;
			}
		}
		if (petParaRemover == null)
			return;
		repository.removePet(petParaRemover);
	}

	public List<Pet> listarPetsPorEspecie(String especie) {
		List<Pet> pets = repository.getPets();
		List<Pet> petsFiltrados = new ArrayList<>();

		for (Pet p : pets) {
			if (p.getEspecie().equalsIgnoreCase(especie)) {
				petsFiltrados.add(p);
			}
		}

		return petsFiltrados;
	}

	public void adicionarTutorAoPet(Long idPet, Long idTutor) {
		List<Pet> pets = repository.getPets();
		List<Tutor> tutores = tutorRepository.getTutores();

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

		repository.updateTutor(pet, tutor);
	}
}
