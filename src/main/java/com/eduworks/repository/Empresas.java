package com.eduworks.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.eduworks.model.Empresa;

public class Empresas {

	private EntityManager manager;

	public Empresas() {

	}

	public Empresas(EntityManager manager) {
		this.manager = manager;
	}

	public Empresa porId(Long id) {
		return this.manager.find(Empresa.class, id);
	}

	public List<Empresa> pesquisar(String nome) {
		TypedQuery<Empresa> query = manager.createQuery("from Empresa where nomeFantasia like :nomeFantasia",
				Empresa.class);
		query.setParameter("nomeFantasia", nome + "%");
		return query.getResultList();
	}

	public Empresa guardar(Empresa empresa) {
		return manager.merge(empresa);
	}

	public void remover(Empresa empresa) {
		empresa = porId(empresa.getId());
		manager.remove(empresa);
	}

}
