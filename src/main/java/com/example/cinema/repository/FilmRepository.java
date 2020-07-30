package com.example.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cinema.model.FilmModel;

public interface FilmRepository extends JpaRepository<FilmModel, String>{
	
	@Query("select f from FilmModel f")
	List<FilmModel> repoRead();
	
	@Query("select f from FilmModel f where f.kodeFilm = ?1")
	FilmModel search(String kodeFilm);
	
	@Query("select f from FilmModel f where f.namaFilm like %?1%")
	List<FilmModel> searchNamaFilm(String namaFilm);
}
