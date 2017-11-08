package dom;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

public class GeneradorDOM {

	private Document document;
	
	public GeneradorDOM(Document document) {
		
		//instancio con documentBuilderFactory
		DocumentBuilderFactory factoria = DocumentBuilderFactory.newInstance();
		//El que me permita instanciar el objeto document.
		DocumentBuilder builder;
		try {
			builder = factoria.newDocumentBuilder();
			//creo el documento con nexDocument
			document = builder.newDocument();
		} catch (ParserConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
	}
	public void generarDocument() {
		
		//nodos de tipo element y uso el constructor document y lo llamo productos
		Element productos = document.createElement("Productos");
		
		//hijo directo de document o sea la raiz
		document.appendChild(productos);
		
		//nodo de tipo element llamado producto
		Element producto = document.createElement("Producto");
		
		//producto nodohijo(producto)que estaría dentro de productos.
		productos.appendChild(producto);
		
		//atributo de producto llamado codigo y con texto 1
		producto.setAttribute("codigo", "1");
		
		//nodo de tipo Element nombre que esta dentro de producto
		Element nombre = document.createElement("nombre");
		
		//
		nombre.appendChild(document.createTextNode("teclado"));
		producto.appendChild(nombre);
	}
	
	public void generarXml() {
		
		try {
			TransformerFactory factoria = TransformerFactory.newInstance();
			Transformer transformer = factoria.newTransformer();
			Source source = new DOMSource(document);
			
			try {
				File file = new File("productos.xml");
				FileWriter fw = new FileWriter(file);
				PrintWriter pw = new PrintWriter(fw);
				Result result = new StreamResult (pw);
				transformer.transform(source, result);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (TransformerException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (TransformerConfigurationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
