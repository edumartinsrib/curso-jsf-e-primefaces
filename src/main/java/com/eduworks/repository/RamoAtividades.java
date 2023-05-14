package com.eduworks.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import com.eduworks.model.RamoAtividade;

public class RamoAtividades {

	private EntityManager manager;

	public RamoAtividades() {

	}
	
	public RamoAtividades(EntityManager manager) {
		this.manager = manager;
	}

	public RamoAtividade porId(Long id) {
		return this.manager.find(RamoAtividade.class, id);
	}

	public List<RamoAtividade> pesquisar(String descricao) {
		CriteriaBuilder criteriaBuilder = manager.getCriteriaBuilder();
		CriteriaQuery<RamoAtividade> criteriaQuery = criteriaBuilder.createQuery(RamoAtividade.class);
		Root<RamoAtividade> root = criteriaQuery.from(RamoAtividade.class);
		criteriaQuery.select(root);
		criteriaQuery.where(criteriaBuilder.like(root.<String>get("descricao"), descricao + "%"));
		TypedQuery<RamoAtividade> query = manager.createQuery(criteriaQuery);
		return query.getResultList();
	}

	public RamoAtividade guardar(RamoAtividade RamoAtividade) {
		return manager.merge(RamoAtividade);
	}

	public void remover(RamoAtividade RamoAtividade) {
		RamoAtividade = porId(RamoAtividade.getId());
		manager.remove(RamoAtividade);
	}

}
