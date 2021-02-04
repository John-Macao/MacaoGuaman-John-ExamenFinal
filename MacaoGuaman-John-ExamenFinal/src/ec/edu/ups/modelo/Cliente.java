package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Cliente implements Serializable {
	
	

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String nombre;
	private String cedula;
    private String correo;
    private String direccion;
    private String telefono;
    
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cliente")
    private List<Registro> registrosCli= new ArrayList<Registro>();

    
    public Cliente(int id, String nombre, String cedula, String correo, String direccion, String telefono
			) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.cedula = cedula;
		this.correo = correo;
		this.direccion = direccion;
		this.telefono = telefono;
	}
    
    public Cliente() {
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

	public String getCedula() {
		return cedula;
	}

	public void setCedula(String cedula) {
		this.cedula = cedula;
	}

	public String getCorreo() {
		return correo;
	}

	public void setCorreo(String correo) {
		this.correo = correo;
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

	public List<Registro> getRegistrosCli() {
		return registrosCli;
	}

	public void setRegistrosCli(List<Registro> registrosCli) {
		this.registrosCli = registrosCli;
	}
    
    
    
    
    
}
