package ec.edu.ups.controlador;


import java.io.Serializable;

import javax.ejb.EJB;
import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

import ec.edu.ups.ejb.*;
import ec.edu.ups.modelo.*;

@Named
@RequestScoped
public class agregarRegControler implements Serializable {

	
	
	private static final long serialVersionUID = 1L;
	
	@EJB
	private RegistroFacade ejbreg;
	
	@EJB
	private ClienteFacade ejbcli;
	
	@EJB
	private RestauranteFacade ejbres;
	
	
	private String cedula = "";
	private String nombre="";
	private int maxPersonas;
    private String fecha="";
    private String hora="";
    
    
    public String agregarReg() {
    	Cliente cli= null;
    	Restaurante res = null;
    	Registro reg2 = null;
    	
    	try {
    		cli = ejbcli.buscarCedula(cedula);
    		res = ejbres.buscarnombre(nombre);
    		
    		int aux = res.getMaxPersonas();
    		
    		if(cli != null && res != null && maxPersonas <= aux ) {
    			
    			Registro reg = new Registro(0, maxPersonas, fecha, hora, cli, res);
    	    	ejbreg.create(reg);
    	    	
    	    	/*
    	    	Restaurante res2 = new Restaurante();
    	    	res2.setMaxPersonas(maxPersonas);
    	    	ejbres.edit(res2);
    	    	*/
    	    	return "inicioe";
    	    	
    	    	
    		}else {
    			System.out.println("cliente no encontrado");
    			return "agregarR";
    		}
    		
    			
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
	
	
	public int getMaxPersonas() {
		return maxPersonas;
	}

	public void setMaxPersonas(int maxPersonas) {
		this.maxPersonas = maxPersonas;
	}

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getFecha() {
		return fecha;
	}

	public void setFecha(String fecha) {
		this.fecha = fecha;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
}
