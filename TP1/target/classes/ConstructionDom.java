import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import com.sun.org.apache.xml.internal.serialize.OutputFormat;
import com.sun.org.apache.xml.internal.serialize.XMLSerializer;

public class ConstructionDom {
    public static void main( String[] argv ) {
        try {
        	/* Récupération d'une implantation et construction d'un document */
        	DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
            DocumentBuilder db = dbf.newDocumentBuilder();
            Document doc = db.newDocument();

            /* Création de l'élément racine et ajout au document*/
            Element eAnimaux = doc.createElement("Animaux");
            doc.appendChild(eAnimaux);
            
            /* Création d'un élément Enclos */
            Element eEnclos1 = doc.createElement("Enclos");
            /* Création d'un attribut */
            eEnclos1.setAttribute("nom","Encl1");
            /* Ajout de l'enclos à l'élément racine */
            eAnimaux.appendChild(eEnclos1);                       

            
            /* Création d'un élément Animal et ajout à l'enclos*/
            Element eAnimal1 = doc.createElement("Animal");
            eAnimal1.setAttribute("famille","chat");
            eAnimal1.setAttribute("nom","Tiger");
            /* Création de information sur cet animal (un noeud texte) */
            eAnimal1.appendChild( doc.createTextNode("Agressif !") );
            eEnclos1.appendChild(eAnimal1);

            /* Serialisation du document DOM */           
            OutputFormat    format  = new OutputFormat( doc );   
            StringWriter  stringOut = new StringWriter();        
            XMLSerializer    serial = new XMLSerializer( stringOut, format );
            serial.asDOMSerializer();                            
            serial.serialize( doc.getDocumentElement() );

            System.out.println(stringOut.toString() );             
        } catch ( Exception ex ) {
            ex.printStackTrace();
        }
    }
}

