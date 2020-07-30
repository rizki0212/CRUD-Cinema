package com.example.cinema.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.model.FilmModel;
import com.example.cinema.repository.FilmRepository;

@Service
@Transactional
public class FilmService {

	@Autowired
	private FilmRepository filmRepository;
	
	public void create(FilmModel filmModel) {
		this.filmRepository.save(filmModel);
	}
	
	public List<FilmModel> read() {
		return this.filmRepository.repoRead();
	}
	
	public FilmModel search(String kodeFilm) {
		return this.filmRepository.search(kodeFilm);
	}
	
	public void update(FilmModel filmModel) {
		this.filmRepository.save(filmModel);
	}
	
	public void delete(FilmModel filmModel) {
		this.filmRepository.delete(filmModel);
	}
	
	public List<FilmModel> searchNamaFilm(String namaFilm){
		return this.filmRepository.searchNamaFilm(namaFilm);
	}
}
