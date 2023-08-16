package com.example.demo.repository;

import java.util.List;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.support.TransactionSynchronizationManager;

import com.example.demo.repository.modelo.Propietario;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.TypedQuery;
import jakarta.transaction.Transactional;
import jakarta.transaction.Transactional.TxType;


@Repository
@Transactional
public class PropietarioRepositoryImpl implements IPropietarioRepository {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void insertar(Propietario propietario) {
		// TODO Auto-generated method stub
		System.out.println(TransactionSynchronizationManager.isActualTransactionActive());
		
		this.entityManager.persist(propietario);
		
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void actualizar(Propietario propietario) {
		// TODO Auto-generated method stub
		this.entityManager.merge(propietario);
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public Propietario seleccionarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		TypedQuery<Propietario> myQuery = this.entityManager.createQuery("SELECT p FROM Propietario p WHERE p.cedula = :datoCedula", Propietario.class);
		myQuery.setParameter("datoCedula", cedula);
		return myQuery.getSingleResult();
	}

	@Override
	@Transactional(value = TxType.MANDATORY)
	public void eliminarPorCedula(String cedula) {
		// TODO Auto-generated method stub
		Propietario propietario = this.seleccionarPorCedula(cedula);
		this.entityManager.remove(propietario);
	}
	
	public List<Propietario> buscarTodos() {
        // TODO Auto-generated method stub

        TypedQuery<Propietario> query = this.entityManager.createQuery("SELECT p FROM Propietario p",
                Propietario.class);
        return query.getResultList();
    }

}
