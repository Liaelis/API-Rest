package br.ufsm.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.ufsm.model.Planta;

public interface PlantaRepository extends JpaRepository<Planta, Integer> {

	List<Planta> findPlantaByUsuarioId(Integer id);
}
