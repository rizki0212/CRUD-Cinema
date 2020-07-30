package com.example.cinema.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.cinema.model.ArtisModel;
import com.example.cinema.model.NegaraModel;
import com.example.cinema.service.ArtisService;
import com.example.cinema.service.NegaraService;

@Controller
@RequestMapping("/artis") //manggil folder
public class ArtisController {

	@Autowired
	private ArtisService artisService; 
	
	@Autowired
	private NegaraService negaraService;
	
	//url ke halaman home.html
	@RequestMapping("/home") 
	public String doHome() {
		String page = "/artis/home";
		return page;
	}
	
	//url ke halaman add.html
	@RequestMapping("/tambah") 
	public String doAdd(Model model) {
		this.doListNegara(model);
		String page = "/artis/add";
		return page;
	}
	
	@RequestMapping("/negara")
	public void doListNegara(Model model) {
		List<NegaraModel> negaraModelList = new ArrayList<>();
		negaraModelList = this.negaraService.read();
		model.addAttribute("negaraModelList", negaraModelList);

	}
	
	// create atau insert data ke database
		@RequestMapping("/create")
		public String doCreate(HttpServletRequest request, Model model) {
			String kodeArtis = request.getParameter("kodeArtis");
			String namaArtis = request.getParameter("namaArtis");
			String jenisKelamin = request.getParameter("jenisKelamin");
			int bayaran = Integer.parseInt(request.getParameter("bayaran"));
			int award = Integer.parseInt(request.getParameter("award"));
			String negara = request.getParameter("negara");
			System.out.println(kodeArtis);
			System.out.println(namaArtis);
			System.out.println(jenisKelamin);
			System.out.println(bayaran);
			System.out.println(award);
			System.out.println(negara);
			
			ArtisModel artisModel = new ArtisModel();
			
			artisModel.setKodeArtis(kodeArtis);
			artisModel.setNamaArtis(namaArtis);
			artisModel.setJenisKelamin(jenisKelamin);
			artisModel.setBayaran(bayaran);
			artisModel.setAward(award);
			artisModel.setKodeNegara(negara);
			
			this.artisService.create(artisModel);
			this.artisRead(model);
			
			String page = "/artis/home";
			return page;
		}
		
		// url untuk ke list.html
		@RequestMapping(value="/data")
		public String list(Model model) {
			this.artisRead(model);
			
			String list = "/artis/list";
			return list;
		}
		
		// tampilkan semua data/list data yang ada ditable
		public void artisRead(Model model) {
			List<ArtisModel> artisModelList = new ArrayList<ArtisModel>();
			artisModelList = artisService.read();
			model.addAttribute("artisModelList", artisModelList);
		}
		
		//lihat detail data
		@RequestMapping(value="/detail")
		public String doDetail(HttpServletRequest request, Model model) {
			
			String kodeArtis = request.getParameter("kodeArtis");
			System.out.println(kodeArtis);
			
			ArtisModel artisModel = new ArtisModel();
			artisModel = this.artisService.searchKodeArtis(kodeArtis);
			model.addAttribute("artisModel", artisModel); 
			
			String page = "/artis/detail";
			return page;
		}
		
		// untuk button ubah agar ke ubah.html dan menampilkan data di text field yg ada di form ubah data
		@RequestMapping("/ubah")
		public String doUbah(HttpServletRequest request, Model model) {
			String kodeArtis = request.getParameter("kodeArtis");
					
			ArtisModel artisModel = new ArtisModel();
			artisModel = this.artisService.searchKodeArtis(kodeArtis);
			model.addAttribute("artisModel", artisModel);
			
			this.doListNegara(model);
			String page = "/artis/ubah";
		return page;
		}
				
				
		// update atau ubah data ke database
		@RequestMapping("/update")
		public String doUpdate(HttpServletRequest request, Model model) {
			String kodeArtis = request.getParameter("kodeArtis");
			String namaArtis = request.getParameter("namaArtis");
			String jenisKelamin = request.getParameter("jenisKelamin");
			int bayaran = Integer.parseInt(request.getParameter("bayaran"));
			int award = Integer.parseInt(request.getParameter("award"));
			String negara = request.getParameter("negara");
			System.out.println(kodeArtis);
			System.out.println(namaArtis);
			System.out.println(jenisKelamin);
			System.out.println(bayaran);
			System.out.println(award);
			System.out.println(negara);
					
			ArtisModel artisModel = new ArtisModel();
			artisModel.setKodeArtis(kodeArtis);
			artisModel.setNamaArtis(namaArtis);
			artisModel.setJenisKelamin(jenisKelamin);
			artisModel.setBayaran(bayaran);
			artisModel.setAward(award);
			artisModel.setKodeNegara(negara);
					
			this.artisService.update(artisModel);
			this.artisRead(model);
					
			String page = "/artis/home";
			return page;
		}
		
		//search nama artis
		@RequestMapping(value="/search")
		public String cariNamaArtis(HttpServletRequest request, Model model) {
					
			String namaArtis = request.getParameter("namaArtis");
					
			List<ArtisModel> artisModelList = new ArrayList<ArtisModel>();
			artisModelList = artisService.searchNamaArtis(namaArtis);
			model.addAttribute("artisModelList", artisModelList);
			String html = "/artis/search";
			return html;
		}
		
		//url ke halaman hapus.html
		@RequestMapping("/hapus") //url ke halaman hapus.html
		public String doHapus(HttpServletRequest request, Model model) {
			String kodeArtis = request.getParameter("kodeArtis");
			
			ArtisModel artisModel = new ArtisModel();
			artisModel = this.artisService.searchKodeArtis(kodeArtis);
			model.addAttribute("artisModel", artisModel);
			String page = "/artis/hapus";
			return page;
		}
		
		// method agar data bisa terhapus
		@RequestMapping("/delete")
		public String doDelete(HttpServletRequest request, Model model) {
			String kodeArtis = request.getParameter("kodeArtis");
							
			ArtisModel artisModel = new ArtisModel();
			artisModel = this.artisService.searchKodeArtis(kodeArtis);
							
			this.artisService.delete(artisModel);
							
			String page = "/artis/home";
			return page;
		}
	
}
