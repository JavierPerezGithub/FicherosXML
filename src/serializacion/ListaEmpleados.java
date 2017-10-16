package serializacion;

import java.util.ArrayList;
import dom.Empleado;

public class ListaEmpleados {
	private ArrayList<Empleado> lista;
  	
	public ListaEmpleados() {
		lista = new ArrayList<Empleado>();
      }
  	
	public ArrayList<Empleado> getLista(){
              return lista;
      }
	
	public void add(Empleado emp) {
		lista.add(emp);
	}

}
