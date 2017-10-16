package sax;

import java.io.IOException;

import org.xml.sax.InputSource;
import org.xml.sax.SAXException;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.XMLReaderFactory;

public class LeerEmpleadosXMLXSax {

	public static void main(String[] args) {
		
	
  			try {
				XMLReader procXML = XMLReaderFactory.createXMLReader();
				GestionContenido gestor = new GestionContenido();
				procXML.setContentHandler(gestor);
				InputSource fileXML = new InputSource("empleados.xml");
				procXML.parse(fileXML);
			} catch (SAXException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
}
