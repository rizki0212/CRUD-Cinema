package com.example.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cinema.model.GenreModel;
import com.example.cinema.service.GenreService;

@Controller
@RequestMapping("/genre")
public class GenreController {

	@Autowired GenreService genreService;
	
	@RequestMapping("/home")
	public String getHome() {
		String page ="/genre/home";
		return page;
	}
	
	@RequestMapping("/add")
	public String doAdd() {
		String page ="/genre/add";
		return page;
	}
	
	@RequestMapping("/create")
	public String doCreate(HttpServletRequest request, Model model) {
		String kodeGenre =request.getParameter("kodeGenre");
		String namaGenre =request.getParameter("namaGenre");
		
		GenreModel genreModel = new GenreModel();
		
		genreModel.setKodeGenre(kodeGenre);
		genreModel.setNamaGenre(namaGenre);
		
		this.genreService.create(genreModel);
		this.genreRead(model);
		
		System.out.println(kodeGenre);
		System.out.println(namaGenre);
		
		String page ="/genre/home";
		return page;
	}
	
	public void genreRead (Model model) {
		List<GenreModel> genreModelList = new ArrayList<GenreModel>();
		genreModelList = this.genreService.read();
		model.addAttribute("genreModelList", genreModelList);
	}
	
	@RequestMapping("/list")
	public String goList (Model model) {
		this.genreRead(model);
		
		String list ="/genre/list";
		return list;
	}
	
	@RequestMapping(value="/detail")
	public String doDetail(HttpServletRequest request, Model model) {
		
		String kodeGenre = request.getParameter("kodeGenre");
		System.out.println(kodeGenre);
		
		GenreModel genreModel = new GenreModel();
		genreModel = this.genreService.search(kodeGenre);
		model.addAttribute("genreModel", genreModel); 
		
		String page = "/genre/detail";
		return page;
	}
	
	@RequestMapping("/ubah")
	public String doUbah(HttpServletRequest request, Model model) {
		String kodeGenre = request.getParameter("kodeGenre");
				
		GenreModel genreModel = new GenreModel();
		genreModel = this.genreService.search(kodeGenre);
		model.addAttribute("genreModel", genreModel);
		
		String page = "/genre/ubah";
	return page;
	}
	
	@RequestMapping("/update")
	public String doUpdate(HttpServletRequest request, Model model) {
		String kodeGenre =request.getParameter("kodeGenre");
		String namaGenre =request.getParameter("namaGenre");
		
		GenreModel genreModel = new GenreModel();
		
		genreModel.setKodeGenre(kodeGenre);
		genreModel.setNamaGenre(namaGenre);
		
		this.genreService.create(genreModel);
		this.genreRead(model);
		
		System.out.println(kodeGenre);
		System.out.println(namaGenre);
		
		String page ="/genre/home";
		return page;
	}
	
	@RequestMapping("/delete")
	public String delete(HttpServletRequest request, Model model) {
		String kodeGenre = request.getParameter("kodeGenre");
		GenreModel genreModel = new GenreModel();
		genreModel = this.genreService.search(kodeGenre);
		this.genreService.delete(genreModel);
		
		String delete ="/genre/home";
		return delete;
	}
	
	@RequestMapping(value="/search")
	public String cariNamaGenre(HttpServletRequest request, Model model) {
				
		String namaGenre = request.getParameter("namaGenre");
				
		List<GenreModel> genreModelList = new ArrayList<GenreModel>();
		genreModelList = genreService.searchNamaGenre(namaGenre);
		model.addAttribute("genreModelList", genreModelList);
		String html = "/genre/search";
		return html;
	}
}
