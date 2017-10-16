package dom;

import java.io.Serializable;

public class EmpleadoDepto implements Serializable {

	private static final long serialVersionUID = -4248245385569609246L;
	
	private int id;
	private String nombre;
	private Departamento dep;
	private double salario;
	public static long getSerialversionuid() {
		return serialVersionUID;
	}
	public int getId() {
		return id;
	}
	public String getNombre() {
		return nombre;
	}
	public Departamento getDep() {
		return dep;
	}
	public double getSalario() {
		return salario;
	}
	public EmpleadoDepto(int id, String nombre, Departamento dep, double salario) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.dep = dep;
		this.salario = salario;
	}	
}
