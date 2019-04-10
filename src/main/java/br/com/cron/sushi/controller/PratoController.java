package br.com.cron.sushi.controller;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import br.com.cron.sushi.model.Prato;
import br.com.cron.sushi.service.PratoService;

@Controller
@RequestMapping("prato")
public class PratoController {

	@Autowired
	private PratoService service;
	
	@GetMapping("/cadastrar")
	public String cadastrar(Prato prato) {
		return "prato/cadastro";
	}
	
	@PostMapping("/salvar")
	private String salvar(Prato prato) {
		File file = convert(prato.getFile());
		prato.setFoto(file.getName());
		service.salvar(prato);
		return "redirect:/prato/cadastrar";
	}	
	
	private File convert(MultipartFile multipartFile) {
		File file = new File("C:\\Users\\Alex Oliveira\\Documents\\fotos\\" + UUID.randomUUID().toString().replace("-", "") + ".png");
		try {
			file.createNewFile();
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(multipartFile.getBytes());
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return file;
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
