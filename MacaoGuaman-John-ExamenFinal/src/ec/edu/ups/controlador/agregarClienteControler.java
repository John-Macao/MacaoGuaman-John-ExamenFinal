package ec.edu.ups.controlador;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.*;
import ec.edu.ups.modelo.*;

@Named
@RequestScoped
public class agregarClienteControler implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacade ejbcliente;
	
	private String nombre="";
	private String cedula="";
    private String correo="";
    private String direccion="";
    private String telefono="";
    
    public String agregarCliente() {
    	try {
    			Cliente cli = new Cliente(0, nombre, cedula, correo, direccion, telefono);
    			ejbcliente.create(cli);
    			return "inicioe";
		} catch (Exception e) {
			return "agregarc";
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
	
	public String getCedula() {
		return cedula;
	}
	public void setCedula(String cedula) {
		this.cedula = cedula;
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
	public String getCorreo() {
		return correo;
	}
	public void setCorreo(String correo) {
		this.correo = correo;
	}
	
    
    
	
}