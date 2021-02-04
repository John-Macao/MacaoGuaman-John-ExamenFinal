package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Restaurante implements Serializable {

	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
    private String direccion;
    private String telefono;
    private int maxPersonas;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurante")
    private List<Registro> resgistrosRes = new ArrayList<Registro>();

    
    
    public Restaurante(int id, String nombre, String direccion, String telefono, int maxPersonas
			) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.direccion = direccion;
		this.telefono = telefono;
		this.maxPersonas = maxPersonas;
	}
    
    
    public Restaurante() {
		super();
	}
    
    
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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

	public List<Registro> getResgistrosRes() {
		return resgistrosRes;
	}

	public void setResgistrosRes(List<Registro> resgistrosRes) {
		this.resgistrosRes = resgistrosRes;
	}
    
}
