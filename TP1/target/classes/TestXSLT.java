    import java.io.*;
    import javax.xml.transform.*;
    import javax.xml.transform.stream.*;
    
    public class TestXSLT {
 
    	public static void main(String args []) {
            try {
                TransformerFactory factory = TransformerFactory.newInstance();
                Templates template = factory.newTemplates(new StreamSource(
                    new FileInputStream("animaux.xsl")));

                Transformer xformer = template.newTransformer();
    
                Source XMLinput = new StreamSource(new FileInputStream("animaux.xml"));
                Result XMLoutput = new StreamResult(new FileOutputStream("new-animaux.xml"));
    
                xformer.transform(XMLinput, XMLoutput);              
                
            } catch (FileNotFoundException e) {
            } catch (TransformerConfigurationException e) {
                // An error occurred in the XSL file
            } catch (TransformerException e) {
            
        }
    }
}