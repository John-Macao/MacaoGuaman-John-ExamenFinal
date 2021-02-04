package ec.edu.ups.ejb;


import java.util.ArrayList;
import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Registro;

@Stateless
public class RegistroFacade extends AbstractFacade<Registro>{

	
	public RegistroFacade() { 
		super(Registro.class);
	}

	@PersistenceContext(unitName = "MacaoGuaman-John-ExamenFinal")
	private EntityManager em;
	
	@Override
	protected EntityManager getEntityManager() {
		return em;
	}
	
	/**
	public Categoria obtenerCategoriaPorID(Producto producto) {
		String jpql = "SELECT cat FROM Categoria cat WHERE cat.producto.id=" + producto.getId();
		Categoria cat = (Categoria) em.createQuery(jpql).getSingleResult();
		return cat;
	}
	
	public Categoria obtenerCategoriaPorNombre(String nombreProducto) {
		String jpql = "SELECT cat FROM Categoria cat WHERE cat.producto.nombre= '" + nombreProducto + "'";   
		Categoria cat = (Categoria) em.createQuery(jpql).getSingleResult();
		return cat;
	}
	*/
	
	public List<Registro> buscarPorNombre (int id) {
		String jpql = "SELECT reg FROM Registro reg WHERE reg.restaurante.id=" + id;
		List<Registro> registros = em.createQuery(jpql).getResultList();
		return registros;
	}
	
	
}
