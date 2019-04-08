package br.com.cron.sushi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.cron.sushi.model.Prato;

@Repository
public interface PratoRepository extends JpaRepository<Prato, Integer>{

}
