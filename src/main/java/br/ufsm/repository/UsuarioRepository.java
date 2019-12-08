package br.ufsm.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufsm.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, String> {
	
	public Optional<Usuario> findUsuarioByEmailAndSenha(String email, String senha);
	
	public Usuario findByUsuarioId(Integer id);

}
