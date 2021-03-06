package dom;

import java.io.File;
import java.io.IOException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class LeerXMLEmpleados {

	public static void main(String[] args) {
		//creamos una instancia al documentBuilderFactory
		DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();

		try {
			//Creamos un DocumentBuilder para usarlo como parseador.
			DocumentBuilder db = dbf.newDocumentBuilder();
			//recuperamos el documento que vamos a leer.
			Document document = db.parse(new File("empleados.xml"));
			
			//accedemos al nodo raiz --> empleados.
			Node raiz = document.getFirstChild();
			//sacamos por consola el nodo ra�z.
			System.out.println(raiz.getNodeName());
			
			//accedemos a los nodos hijos del nodo ra�z, obtenemos una lista.
			NodeList elementos = raiz.getChildNodes();

			Node nodo, nodo2 = null;
			NodeList hijos, hijos2 = null;
			
			//recorrer la lista de nodos hijos del nodo ra�z
			for (int i = 0; i < elementos.getLength(); i++) {
				//accedemos a los elementos de la lista de 1 en 1
				nodo = elementos.item(i);
				
				//para cada nodo comprobamos que sea de tipo elemento
				if (nodo.getNodeType() == Node.ELEMENT_NODE) {
					//sacamos por consola el nombre de la etiqueta tabul�ndola con respecto al nodo raiz
					System.out.println("\t" + nodo.getNodeName());

					//accedemos a la lista de elementos hijos del nodo que estamos manejando.
					hijos = nodo.getChildNodes();
					//recorrer la lista de nodos hijos del nodo que estamos manejando
					for (int j = 0; j < hijos.getLength(); j++) {
						//accedemnos a los elementos de dicha lista --> id, nombres, departamento y salario.
						nodo2 = hijos.item(j);
						
						//para cada uno de estos nodos comprobamos que sean de tipo elemento
						if (nodo2.getNodeType() == Node.ELEMENT_NODE) {
							//sacamos por consola el nombre de la etiqueta tabulandola
							System.out.println("\t\t" + nodo2.getNodeName());
							//accedemos a la lista de elementos hijos
							hijos2 = nodo2.getChildNodes();

							//System.out.println("----N� de hijos de " + nodo2.getNodeName() + ": " + hijos2.getLength());
							
							//como sabemos que el nodo2 ya contiene texto y por tanto solo tiene un nodo hijo,
							//accedemos dir�ctamente al valor.
							System.out.println("\t\t\t" + hijos2.item(0).getNodeValue());
						}
					}
				}
			}

		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SAXException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
