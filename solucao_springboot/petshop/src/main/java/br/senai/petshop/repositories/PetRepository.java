package br.senai.petshop.repositories;

import br.senai.petshop.models.Pet;
import br.senai.petshop.models.Tutor;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

@Repository
public class PetRepository {

    private Long id = 0L;
    private List<Pet> pets = new ArrayList<>();

    public List<Pet> getPets() {
        return pets;
    }

    public void addPet(Pet pet) {
        if (pet == null) return;
        if (pets.contains(pet)) return;
        pet.setId(++id);
        pets.add(pet);
    }

    public void updatePet(Pet pet, String nome, String especie, String raca, String cor, float peso, LocalDate dataNascimento) {
        if (nome != null && !nome.equals(pet.getNome())) pet.setNome(nome);
        if (especie != null && !especie.equals(pet.getEspecie())) pet.setEspecie(especie);
        if (raca != null && !raca.equals(pet.getRaca())) pet.setRaca(raca);
        if (cor != null && !cor.equals(pet.getCor())) pet.setCor(cor);
        if (peso > 0 && peso != pet.getPeso()) pet.setPeso(peso);
        if (dataNascimento != null) pet.setDataNascimento(dataNascimento);
    }

    public void removePet(Pet pet) {
        pets.remove(pet);
    }

    public void updateTutor(Pet pet, Tutor tutor) {
        pet.setTutor(tutor);
    }
}
