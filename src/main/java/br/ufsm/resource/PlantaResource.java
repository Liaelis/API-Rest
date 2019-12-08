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
import br.ufsm.model.Plantadto;
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
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Planta> listaPlanta( ) {
		Iterable<Planta> listaPlanta = plantaRespository.findAll();
		return listaPlanta;
	}
	@PostMapping("/savep")
	public Usuario cadastraPlanta(@RequestBody @Valid Plantadto  plantadto) {
		Integer id = plantadto.getIdUser();
		System.out.println(plantadto.getNomePopular());
		System.out.println(id);
		Optional<Usuario> upp = usuarioRepository.findById(id);
		Usuario user = upp.get();	
		Planta planta = new Planta();
		planta.setUsuario(user);
		System.out.println("Usuario que achou"+user.getNome());
		planta.setNomeCientifico(plantadto.getNomeCientifico());
		planta.setNomePopular(plantadto.getNomePopular());
		planta.setValor(plantadto.getValor());
		System.out.println("plantaaaa");
		System.out.println(planta.getNomePopular());
		plantaRespository.save(planta);
		return user;
	}
	


}
