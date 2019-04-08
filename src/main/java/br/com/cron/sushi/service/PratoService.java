package br.com.cron.sushi.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.cron.sushi.model.Prato;
import br.com.cron.sushi.repository.PratoRepository;

@Service
public class PratoService {

	@Autowired
	private PratoRepository repo;
	
	public void salvar(Prato prato) {
		repo.save(prato);
	}

	
}
