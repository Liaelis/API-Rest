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

import br.ufsm.model.Usuario;
import br.ufsm.model.UsuarioAutenticavel;
import br.ufsm.repository.UsuarioRepository;

@RestController
@RequestMapping("/usuario")
public class UsuarioResource {

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@PostMapping("/save")
	public Usuario cadastraUsuario(@RequestBody @Valid Usuario usuario) {
		
		return usuarioRepository.save(usuario);
	}
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Usuario> listaUsuario( ) {
		Iterable<Usuario> listaUsuario = usuarioRepository.findAll();
		return listaUsuario;
	}
	
	@PostMapping("/autentica")
	public Usuario autentica(@RequestBody @Valid UsuarioAutenticavel user) {
		
 		Optional<Usuario> opUsuario = usuarioRepository.findUsuarioByEmailAndSenha(user.getEmail(),user.getSenha());
		if(opUsuario.isPresent()) {
			Usuario usuario = opUsuario.get();
			System.out.println("achou usuario lindo");
			return usuario;
			
		}else {
			System.out.println("ta vaziio essa porra");
			return null;
		}	
	
	}
}
