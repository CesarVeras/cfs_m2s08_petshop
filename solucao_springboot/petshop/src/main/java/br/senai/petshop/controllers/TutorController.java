package br.senai.petshop.controllers;

import br.senai.petshop.models.Tutor;
import br.senai.petshop.services.TutorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/tutores")
public class TutorController {

	@Autowired
	private final TutorService tutorService;

	public TutorController(TutorService tutorService) {
		this.tutorService = tutorService;
	}

	@GetMapping
	public List<Tutor> getTutor() {
		return TutorService.listarTutores();
	}

	@GetMapping("/{idTutor}")
	public Tutor getTutor(@PathVariable("idTutor") Long id) {
		List<Tutor> tutores = getTutor();
		Tutor tutor = null;

		for (Tutor t : tutores) {
			if (t.getId().equals(id)) {
				tutor = t;
				break;
			}
		}
		return tutor;
	}

	@PostMapping
	public void addTutor(@RequestBody Tutor tutor) {
		TutorService.cadastrarTutor(tutor);
	}

	@PutMapping("/{id}")
	public void updateTutor(@PathVariable Long id, @RequestBody Tutor tutor) {
		TutorService.editarTutor(tutor);
	}

	@DeleteMapping("/{id}")
	public void deleteTutor(@PathVariable Long id) {
		TutorService.removerTutor(id);
	}
}
