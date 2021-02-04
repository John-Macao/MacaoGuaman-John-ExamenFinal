package ec.edu.ups.modelo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

@Entity
public class Registro implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
    private int numPersonas;
    private String fecha;
    private String hora;
    
    @ManyToOne
    @JoinColumn
    private Cliente cliente;
    
    @ManyToOne
    @JoinColumn
    private Restaurante restaurante;
    
    
    public Registro(int id, int numPersonas, String fecha, String hora, Cliente cliente, Restaurante restaurante) {
		super();
		this.id = id;
		this.numPersonas = numPersonas;
		this.fecha = fecha;
		this.hora = hora;
		this.cliente = cliente;
		this.restaurante = restaurante;
	}
    
    
    public Registro() {
		super();
	}
    
    

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getNumPersonas() {
		return numPersonas;
	}

	public void setNumPersonas(int numPersonas) {
		this.numPersonas = numPersonas;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Restaurante getRestaurante() {
		return restaurante;
	}

	public void setRestaurante(Restaurante restaurante) {
		this.restaurante = restaurante;
	}
    
}
