package feces.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import feces.model.Namirnica;
import feces.repository.NamirnicaRepository;
import feces.service.NamirnicaService;

@Service
@Transactional
public class JpaNamirnicaService implements NamirnicaService {
	@Autowired
	private NamirnicaRepository namirnicaRepository;
	@Override
	public Namirnica findOne(Long id) {
		return namirnicaRepository.findOne(id);
	}
	@Override
	public Page<Namirnica> findByName(String name, int page, int number) {
		return namirnicaRepository.findByNameLike("%" + name + "%", (new PageRequest(page, number)));
		}
	@Override
	public List<Namirnica> findAll() {
		return namirnicaRepository.findAll();
	}
	@Override
	public Namirnica save(Namirnica namirnica) {
		return namirnicaRepository.save(namirnica);
	}
	@Override
	public List<Namirnica> save(List<Namirnica> namirnice) {
		return namirnicaRepository.save(namirnice);
	}
	@Override
	public Namirnica delete(Long id) {
		Namirnica namirnica = namirnicaRepository.findOne(id);
		if(namirnica==null){
			throw new IllegalArgumentException(
					"Removing nonexistant activity");
		}
		namirnicaRepository.delete(namirnica);
		return namirnica;
	}
	@Override
	public void remove(List<Namirnica> ids) {
		for(Namirnica id : ids){
			namirnicaRepository.delete(id);
		}
	}
	@Override
	public List<Namirnica> findByName(String name) {
		return namirnicaRepository.findByName(name);
	}
	@Override
	public Page<Namirnica> findAll(int page, int number) {
		return namirnicaRepository.findAll(new PageRequest(page, number));
	}
}