package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;


import com.example.demo.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Repository
@Transactional
public class PropietarioRepoImpl implements IPropietarioRepo {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.persist(propietario);
	}

	@Override
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(propietario);
	}

	@Override
	public Propietario buscarId(Integer id) {
		// TODO Auto-generated method stub
		return this.entityManager.find(Propietario.class, id);
	}

	@Override
	public void eliminar(Integer id) {
		// TODO Auto-generated method stub
		this.entityManager.remove(this.buscarId(id));
	}

	@Override
	//@Transactional(value = TxType.NOT_SUPPORTED)
	@Transactional(value = TxType.NOT_SUPPORTED)
	public List<Propietario> buscarTodos() {
		// TODO Auto-generated method stub

		TypedQuery<Propietario> query = this.entityManager.createQuery("SELECT p FROM Propietario p",
				Propietario.class);
		return query.getResultList();
	}

}
