package ec.edu.ups.controlador;


import java.io.Serializable;

import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.FacesConfig;
import javax.inject.Named;

@FacesConfig(version = FacesConfig.Version.JSF_2_3)
@Named
@RequestScoped
public class inicioController implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	public String redirigir(String pagina) {
		
		return pagina;
	}
}
