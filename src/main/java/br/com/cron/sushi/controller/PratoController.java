package br.com.cron.sushi.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
