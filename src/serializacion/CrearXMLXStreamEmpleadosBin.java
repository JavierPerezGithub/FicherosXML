package serializacion;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

import com.thoughtworks.xstream.XStream;

import dom.Empleado;

public class CrearXMLXStreamEmpleadosBin {

	public static void main(String[] args) {
			
		ObjectInputStream ois = null;
		ListaEmpleados listaEmp= null;
		
			try {
				ois = new ObjectInputStream(new FileInputStream("empleadosObj.dat"));
				Empleado emp = null;
				listaEmp = new ListaEmpleados();
				
				//Recorreremos el fichero con los datos 
				try {
				    while ((emp = (Empleado) ois.readObject()) != null) {
					// añadimos el empleado a la lista
					listaEmp.add(emp);
				    }
			    
			} catch (EOFException e) {
				System.out.println("Final de fichero");
			} 
			
			// Creamos el fichero XML 
			XStream xs = new XStream();
			xs.alias("Empleados", ListaEmpleados.class);
			xs.alias("DatosEmpleado", Empleado.class);
			xs.addImplicitCollection(ListaEmpleados.class, "lista");
			xs.toXML(listaEmp, new FileOutputStream("empleadosXStream.xml"));
			
			}catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}catch (ClassNotFoundException e) {
				e.printStackTrace();
			}
			
	}
}
