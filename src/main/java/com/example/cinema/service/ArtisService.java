package com.example.cinema.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.cinema.model.ArtisModel;
import com.example.cinema.repository.ArtisRepository;

@Service
@Transactional
public class ArtisService {

	@Autowired
	private ArtisRepository artisRepository;
	
	// method untuk service create
		public void create(ArtisModel artisModel) {
			this.artisRepository.save(artisModel);
		}
	// method list/untuk menampilkan semua data fakultas
		public List<ArtisModel> read(){
			return this.artisRepository.findAll(); 
		}
	
	// method search berdasarkan kodeFakultas
		public ArtisModel searchKodeArtis(String kodeArtis){
			return this.artisRepository.searchKodeArtis(kodeArtis);
		}
		
	// method untuk service update
		public void update(ArtisModel artisModel) {
			this.artisRepository.save(artisModel);
		}
		
	// method untuk service delete
		public void delete(ArtisModel artisModel) {
		this.artisRepository.delete(artisModel);
		}

	// method untuk search nama
		public List<ArtisModel> searchNamaArtis(String namaArtis){
			return this.artisRepository.searchNamaArtis(namaArtis);
		}
	
}
