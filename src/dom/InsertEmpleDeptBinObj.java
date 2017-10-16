package dom;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class InsertEmpleDeptBinObj {

	public static void main(String[] args) {
		
		String[] nombres = {"Alberto", "Guillermo", "Alejandro", "Ana", "Patricia"};
     	int[] departamentos = {10, 20, 30, 20, 10};
     	String [] nomDep = {"Marketing","contabilidad","comercial","Marketing","contabilidad"};
     	String [] locDep = {"Madrid","Valladolid","Madrid","Valladolid"};
     	double[] salarios = {2000.00, 1500.50, 3000.40, 2300.60, 1900.10};   
     	
     	ObjectOutputStream oos = null;
     	
     	try {
			oos = new ObjectOutputStream(new FileOutputStream("empleadosDepObj.dat"));
			
			EmpleadoDepto emp = null;
			Departamento dep = null;
			
			for (int i = 0; i < salarios.length; i++) {
				dep = new Departamento(departamentos[i], nomDep[i], locDep[i]);
				emp = new EmpleadoDepto(i+1, nombres[i], dep, salarios[i]);
				oos.writeObject(emp);
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			if(oos !=null) {
				try {
					oos.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}

	}

}
