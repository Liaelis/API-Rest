package br.ufsm.resource;

import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.ufsm.model.Planta;
import br.ufsm.model.Usuario;
import br.ufsm.repository.PlantaRepository;
import br.ufsm.repository.UsuarioRepository;

@RestController
@RequestMapping("/planta")
public class PlantaResource {
	
	@Autowired
	PlantaRepository plantaRespository;
	@Autowired
	UsuarioRepository usuarioRepository;
	
	@PostMapping("/save")
	public Usuario cadastraPlanta(@RequestBody @Valid Planta  planta) {
		Integer id = planta.getUsuario().getId();
		Usuario user = usuarioRepository.findByUsuarioId(id);
		planta.setUsuario(user);
		Planta plan = plantaRespository.save(planta);
		return user;
	}
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Planta> listaPlanta( ) {
		Iterable<Planta> listaPlanta = plantaRespository.findAll();
		return listaPlanta;
	}

}
