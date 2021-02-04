package ec.edu.ups.controlador;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

import ec.edu.ups.modelo.*;
import ec.edu.ups.ejb.*;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@SessionScoped
public class crearTablas implements Serializable {
	private static final long serialVersionUID = 1L;
	
	@EJB
	private ClienteFacade ejbClienteFacade;
	
	@EJB
	private RestauranteFacade ejbRestauranteFacade;
	
	@EJB
	private RegistroFacade ejbRegistroFacade;
	
	public void crear() {
		Cliente cli = new Cliente(0, "Juan", "0105824478", "juan@gmail.com", "Av. Loja", "0980644260");
		ejbClienteFacade.create(cli);
		
		
		Restaurante res = new Restaurante(0, "Rosita", "Circo Social", "098064432", 20);
		ejbRestauranteFacade.create(res);
		
		
		Registro reg = new Registro(0, 5, "02/10/2020", "13:50", cli, res); 
		ejbRegistroFacade.create(reg);
		
		
	}
	
	
}
