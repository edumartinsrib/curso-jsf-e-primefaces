package com.eduworks.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

import com.eduworks.model.Empresa;

public class SchemaGeneration {

	public static void main(String[] args) {
		EntityManagerFactory enf = Persistence.createEntityManagerFactory("EduWorksPU");
		
		EntityManager em = enf.createEntityManager();
		
		List<Empresa> lista = em.createQuery("from Empresa", Empresa.class).getResultList();
		
		System.out.println(lista);
		em.close();
		enf.close();
	}
}
