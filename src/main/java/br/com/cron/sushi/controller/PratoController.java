package br.com.cron.sushi.controller;

import java.io.File;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import antlr.StringUtils;
import br.com.cron.sushi.Util.Disco;
import br.com.cron.sushi.model.Prato;
import br.com.cron.sushi.service.PratoService;

@Controller
@RequestMapping("prato")
public class PratoController {

	@Autowired
	private PratoService service;
	
	@Autowired
	private Disco disco;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Prato prato) {
		return "prato/cadastro";
	}
	
	@PostMapping("/salvar")
	private String salvar(Prato prato) {
		disco.salvarFoto(prato.getFile());
		prato.setFoto(prato.getFile().getOriginalFilename());
		service.salvar(prato);
		return "redirect:/prato/cadastrar";
	}
	
	//id baseado em UUID
	private String retornaUUID() {
		return UUID.randomUUID().toString();
	}
	
	//id baseado na quantidade de arquivos de uma pasta 
	private String retornaQtdArquivosPasta() {
		return String.valueOf(new File("C:/Users/Alex Oliveira/Documents/fotos").list().length);
	}
	
	//id baseado em timestamp
	private String getTimestamp() {
		return String.valueOf(System.currentTimeMillis());
	}
	
	
}


//@PostMapping("/salvar")
//public String salvar(@Valid Departamento departamento, BindingResult result, RedirectAttributes attr) {
//
//	if (result.hasErrors()) {
//		return "departamento/cadastro";
//	}
//
//	service.salvar(departamento);
//	attr.addFlashAttribute("success", "Departamento inserido com sucesso.");
//	return "redirect:/departamentos/cadastrar";
//}
