package com.example.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cinema.model.NegaraModel;

public interface NegaraRepository extends JpaRepository<NegaraModel, String> {

	@Query("select n from NegaraModel n")
	List<NegaraModel> repoRead();
	
	@Query("select n from NegaraModel n where n.kodeNegara = ?1")
	NegaraModel search(String kodeNegara);
	
	@Query("select n from NegaraModel n where n.namaNegara like %?1%")
	List<NegaraModel> searchNamaNegara(String namaNegara);
}
