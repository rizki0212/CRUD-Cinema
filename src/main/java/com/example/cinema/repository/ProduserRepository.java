package com.example.cinema.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.cinema.model.ProduserModel;


public interface ProduserRepository extends JpaRepository<ProduserModel, String> {

	@Query("select n from ProduserModel n")
	List<ProduserModel> repoRead();
	
	@Query("select n from ProduserModel n where n.kodeProduser = ?1")
	ProduserModel search(String kodeNegara);
	
	@Query("select n from ProduserModel n where n.kodeProduser like %?1%")
	List<ProduserModel> searchNamaProduser(String namaProduser);
	
}
