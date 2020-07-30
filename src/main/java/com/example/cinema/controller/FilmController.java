package com.example.cinema.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cinema.model.ArtisModel;
import com.example.cinema.model.FilmModel;
import com.example.cinema.model.GenreModel;
import com.example.cinema.model.ProduserModel;
import com.example.cinema.service.FilmService;
import com.example.cinema.service.GenreService;
import com.example.cinema.service.ProduserService;
import com.example.cinema.service.ArtisService;

@Controller
@RequestMapping("/film")
public class FilmController {

	@Autowired
	private FilmService filmService;
	
	@Autowired
	private GenreService genreService;
	
	@Autowired
	private ArtisService artisService;
	
	@Autowired
	private ProduserService produserService;
	
	
	@RequestMapping("/home")
	public String getHome() {
		String page = "/film/home";
		return page;
	}
	
	@RequestMapping("/add")
	public String doAdd(Model model) {
		this.doListGenre(model);
		this.doListArtis(model);
		this.doListProduser(model);
		String page ="/film/add";
		return page;
	}
	
	@RequestMapping("/genre")
	public void doListGenre(Model model) {
		List<GenreModel> genreModelList = new ArrayList<>();
		genreModelList = this.genreService.read();
		model.addAttribute("genreModelList", genreModelList);
	}
	
	@RequestMapping("/artis")
	public void doListArtis(Model model) {
		List<ArtisModel> artisModelList = new ArrayList<>();
		artisModelList = this.artisService.read();
		model.addAttribute("artisModelList", artisModelList);
	}
	
	@RequestMapping("/produser")
	public void doListProduser(Model model) {
		List<ProduserModel> produserModelList = new ArrayList<>();
		produserModelList = this.produserService.read();
		model.addAttribute("produserModelList", produserModelList);
	}
	
	@RequestMapping("/create")
	public String doCreate(HttpServletRequest request, Model model)  throws ParseException{
		String kodeFilm =request.getParameter("kodeFilm");
		String namaFilm =request.getParameter("namaFilm");
		String kodeGenre =request.getParameter("kodeGenre");
		String kodeArtis =request.getParameter("kodeArtis");
		String kodeProduser =request.getParameter("kodeProduser");
		int pendapatanFilm =Integer.parseInt(request.getParameter("pendapatanFilm"));
		int nominasiFilm =Integer.parseInt(request.getParameter("nominasiFilm"));
		
		FilmModel filmModel = new FilmModel();
		
		filmModel.setKodeFilm(kodeFilm);
		filmModel.setNamaFilm(namaFilm);
		filmModel.setKodeGenre(kodeGenre);
		filmModel.setKodeArtis(kodeArtis);
		filmModel.setKodeProduser(kodeProduser);
		filmModel.setPendapatanFilm(pendapatanFilm);
		filmModel.setNominasiFilm(nominasiFilm);
		
		this.filmService.create(filmModel);
		this.filmRead(model);
		
		System.out.println(kodeFilm);
		System.out.println(namaFilm);
		System.out.println(kodeGenre);
		System.out.println(kodeArtis);
		System.out.println(kodeProduser);
		System.out.println(pendapatanFilm);
		System.out.println(nominasiFilm);
		
		String page = "/film/home";
		return page;
	}
	
	public void filmRead (Model model) {
		List<FilmModel> filmModelList = new ArrayList<FilmModel>();
		filmModelList = this.filmService.read();
		model.addAttribute("filmModelList", filmModelList);
	}
	
	@RequestMapping("/list")
	public String goList (Model model) {
		this.filmRead(model);
		
		String list ="/film/list";
		return list;
	}
	
	@RequestMapping(value="/detail")
	public String doDetail(HttpServletRequest request, Model model) {
		
		String kodeFilm = request.getParameter("kodeFilm");
		System.out.println(kodeFilm);
		
		FilmModel filmModel = new FilmModel();
		filmModel = this.filmService.search(kodeFilm);
		model.addAttribute("filmModel", filmModel); 
		
		String page = "/film/detail";
		return page;
	}
	
	@RequestMapping("/ubah")
	public String doUbah(HttpServletRequest request, Model model) {
		String kodeFilm = request.getParameter("kodeFilm");
				
		FilmModel filmModel = new FilmModel();
		filmModel = this.filmService.search(kodeFilm);
		model.addAttribute("filmModel", filmModel);
		
		this.doListGenre(model);
		this.doListArtis(model);
		this.doListProduser(model);
		String page = "/film/ubah";
	return page;
	}
	
	@RequestMapping("/update")
	public String doUpdate(HttpServletRequest request, Model model)  throws ParseException{
		String kodeFilm =request.getParameter("kodeFilm");
		String namaFilm =request.getParameter("namaFilm");
		String kodeGenre =request.getParameter("kodeGenre");
		String kodeArtis =request.getParameter("kodeArtis");
		String kodeProduser =request.getParameter("kodeProduser");
		int pendapatanFilm =Integer.parseInt(request.getParameter("pendapatanFilm"));
		int nominasiFilm =Integer.parseInt(request.getParameter("nominasiFilm"));
		
		FilmModel filmModel = new FilmModel();
		
		filmModel.setKodeFilm(kodeFilm);
		filmModel.setNamaFilm(namaFilm);
		filmModel.setKodeGenre(kodeGenre);
		filmModel.setKodeArtis(kodeArtis);
		filmModel.setKodeProduser(kodeProduser);
		filmModel.setPendapatanFilm(pendapatanFilm);
		filmModel.setNominasiFilm(nominasiFilm);
		
		this.filmService.update(filmModel);
		this.filmRead(model);
		
		System.out.println(kodeFilm);
		System.out.println(namaFilm);
		System.out.println(kodeGenre);
		System.out.println(kodeArtis);
		System.out.println(kodeProduser);
		System.out.println(pendapatanFilm);
		System.out.println(nominasiFilm);
		
		String page = "/film/home";
		return page;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		String kodeFilm = request.getParameter("kodeFilm");
		FilmModel filmModel = new FilmModel();
		filmModel = this.filmService.search(kodeFilm);
		this.filmService.delete(filmModel);
		
		String delete ="/film/home";
		return delete;
	}
	
	@RequestMapping(value="/search")
	public String cariNamaFilm(HttpServletRequest request, Model model) {
				
		String namaFilm = request.getParameter("namaFilm");
				
		List<FilmModel> filmModelList = new ArrayList<FilmModel>();
		filmModelList = filmService.searchNamaFilm(namaFilm);
		model.addAttribute("filmModelList", filmModelList);
		String html = "/film/search";
		return html;
	}
}
