package ec.edu.ups.ejb;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import ec.edu.ups.modelo.Restaurante;
import ec.edu.ups.modelo.Cliente;
import ec.edu.ups.modelo.Registro;

@Stateless
public class RestauranteFacade extends AbstractFacade<Restaurante>{

	
	public RestauranteFacade() { 
		super(Restaurante.class);
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
	
	public Restaurante buscarnombre(String nombre) {
		try {
			
			String jpql = "SELECT res FROM Restaurante res WHERE res.nombre= '" + nombre + "'";   
			Restaurante res = (Restaurante) em.createQuery(jpql).getSingleResult();
			return res;
			
		} catch (Exception e) {
			return null;
		}
		
	}
	
	
}
