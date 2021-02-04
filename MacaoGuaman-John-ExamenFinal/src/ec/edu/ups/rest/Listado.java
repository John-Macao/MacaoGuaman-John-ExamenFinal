package ec.edu.ups.rest;


import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.json.bind.Jsonb;
import javax.json.bind.JsonbBuilder;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.DefaultValue;
import javax.ws.rs.FormParam;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import ec.edu.ups.ejb.ClienteFacade;
import ec.edu.ups.ejb.RegistroFacade;
import ec.edu.ups.ejb.RestauranteFacade;
import ec.edu.ups.modelo.Registro;
import ec.edu.ups.modelo.Restaurante;

import javax.ejb.EJB;

@Path("/listado/")
public class Listado {

	@EJB
	private RegistroFacade ejbreg;
	
	@EJB
	private ClienteFacade ejbcli;
	
	@EJB
	private RestauranteFacade ejbres;
	
	
	@POST
    @Path("/restaurante")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    @Produces(MediaType.TEXT_PLAIN)
    public Response login(@FormParam("nombre") String nombre) throws IOException {
		
		Registro reg = new Registro();
		
		List<Registro> reg2 = new ArrayList<Registro>();
		
		Restaurante res = new Restaurante();
		res = ejbres.buscarnombre(nombre);
		
		
		if(res != null) {
			
			reg2 = ejbreg.buscarPorNombre(res.getId());
			
			System.out.println("Rest encontrado");
			
			
			return Response.ok("Correcto").build();
			//return Response.status(204).entity("" + reg2).build();
			
			
		}else {
			return Response.status(404).entity("Restaurante no encontrado").build();
			
		}
		
    }
	
	
}