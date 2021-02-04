package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Registro;

@Stateless
public class ClienteFacade extends AbstractFacade<Cliente>{

	
	public ClienteFacade() { 
		super(Cliente.class);
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
	
	*/
	
	public Cliente buscarCedula(String cedula) {
		try {
			
			String jpql = "SELECT cli FROM Cliente cli WHERE cli.cedula= '" + cedula + "'";   
			Cliente cli = (Cliente) em.createQuery(jpql).getSingleResult();
			return cli;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
	
}
