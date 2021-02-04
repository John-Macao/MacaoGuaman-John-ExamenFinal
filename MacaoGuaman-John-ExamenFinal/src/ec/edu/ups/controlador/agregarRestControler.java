package ec.edu.ups.controlador;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.*;
import ec.edu.ups.modelo.*;

@Named
@RequestScoped
public class agregarRestControler implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@EJB
	private RestauranteFacade ejbrest;
	
	private String nombre="";
    private String direccion="";
    private String telefono="";
    private int maxPersonas;
    
    public String agregarRest() {
    	try {
    			Restaurante res = new Restaurante(0, nombre, direccion, telefono, maxPersonas);
    			ejbrest.create(res);
    			return "inicioe";
		} catch (Exception e) {
			return "agregarR";
		}
    }
    
    public String salir() {
    	return "inicioe";
    }
    
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	
	
	public String getDireccion() {
		return direccion;
	}
	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}
	public String getTelefono() {
		return telefono;
	}
	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public int getMaxPersonas() {
		return maxPersonas;
	}

	public void setMaxPersonas(int maxPersonas) {
		this.maxPersonas = maxPersonas;
	}
	
}
