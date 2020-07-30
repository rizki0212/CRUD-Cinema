package com.example.cinema.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cinema.model.ArtisModel;


public interface ArtisRepository extends JpaRepository<ArtisModel, String> {

	@Query("SELECT A FROM ArtisModel A WHERE A.kodeArtis = ?1")
	ArtisModel searchKodeArtis (String kodeArtis);
	
	@Query("SELECT A FROM ArtisModel A WHERE A.namaArtis LIKE %?1%")
	List<ArtisModel> searchNamaArtis(String namaArtis);
	
}
