package com.example.cinema.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.model.GenreModel;
import com.example.cinema.repository.GenreRepository;

@Service
@Transactional
public class GenreService {

	@Autowired
	private GenreRepository genreRepository;
	
	public void create(GenreModel genreModel) {
		this.genreRepository.save(genreModel);
	}
	
	public List<GenreModel> read() {
		return this.genreRepository.repoRead();
	}
	
	public GenreModel search(String kodeGenre) {
		return this.genreRepository.search(kodeGenre);
	}
	
	public void update(GenreModel genreModel) {
		this.genreRepository.save(genreModel);
	}
	
	public void delete(GenreModel genreModel) {
		this.genreRepository.delete(genreModel);
	}
	
	public List<GenreModel> searchNamaGenre(String namaGenre){
		return this.genreRepository.searchNamaGenre(namaGenre);
	}
}
