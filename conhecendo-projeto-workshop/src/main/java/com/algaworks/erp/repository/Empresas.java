package com.algaworks.erp.repository;

import java.io.Serializable;
import java.util.List;

import javax.inject.Inject;
import javax.persistence.EntityManager;

import com.algaworks.erp.model.Empresa;

public class Empresas implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Inject
	private EntityManager manager;
	
	public Empresa porId(Long id) {
		return manager.find(Empresa.class, id);
	}
	
	public List<Empresa> todas() {
		return manager.createQuery("from Empresa", Empresa.class).getResultList();
	}
	
	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}
	
	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}

}