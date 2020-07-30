package com.example.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cinema.model.GenreModel;

public interface GenreRepository extends JpaRepository<GenreModel, String> {

	@Query("select g from GenreModel g")
	List<GenreModel> repoRead();
	
	@Query("select g from GenreModel g where g.kodeGenre = ?1")
	GenreModel search(String kodeGenre);
	
	@Query("select g from GenreModel g where g.namaGenre like %?1%")
	List<GenreModel> searchNamaGenre(String namaGenre);
}
