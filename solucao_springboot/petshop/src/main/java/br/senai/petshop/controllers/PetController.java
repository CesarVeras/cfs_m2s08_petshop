package br.senai.petshop.controllers;

import br.senai.petshop.models.Pet;
import br.senai.petshop.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pets")
public class PetController {

    @Autowired
    private final PetService petService;

    public PetController(PetService petService) {
        this.petService = petService;
    }

    @GetMapping
    public List<Pet> getPets(@RequestParam(required = false) String especie) {
        if (especie != null && especie.length() > 0) {
            return PetService.listarPetsPorEspecie(especie);
        } else {
            return PetService.listarPets();
        }
    }

    @GetMapping("/{idPet}")
    public Pet getPet(@PathVariable("idPet") Long id) {
        List<Pet> pets = PetService.listarPets();
        Pet pet = null;

        for (Pet p : pets) {
            if (p.getId().equals(id)) {
                pet = p;
                break;
            }
        }

        return pet;
    }

    @PostMapping
    public void addPet(@RequestBody Pet pet) {
        PetService.cadastrarPet(pet);
    }

    @PutMapping("/{id}")
    public void updatePet(@RequestBody Pet pet) {
        PetService.editarPet(pet);
    }

    @DeleteMapping("/{id}")
    public String deletePet(@PathVariable Long id) {
        PetService.removerPet(id);
        return "Pet removido!";
    }

    @PutMapping("/{idPet}/tutor/{idTutor}")
    public void addTutorToPet(@PathVariable Long idPet, @PathVariable Long idTutor) {
        PetService.adicionarTutorAoPet(idPet, idTutor);
    }
}
