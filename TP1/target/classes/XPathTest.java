import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;

import org.w3c.dom.NodeList;
import org.xml.sax.InputSource;

public class XPathTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		//		 1. Instantiate an XPathFactory.
		  javax.xml.xpath.XPathFactory factory = 
		                    javax.xml.xpath.XPathFactory.newInstance();
		  
		  // 2. Use the XPathFactory to create a new XPath object
		  javax.xml.xpath.XPath xpath = factory.newXPath();
		  
		  // 3. Compile an XPath string into an XPathExpression
		  javax.xml.xpath.XPathExpression expression=null;
		try {
			expression = xpath.compile("//Animal[@nom='brutus']/@famille");
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		  
		  // 4. Evaluate the XPath expression on an input document
		 try {
			String result = expression.evaluate(new org.xml.sax.InputSource("animaux.xml"));			
			System.out.println("Brutus est un "+result);
			
			NodeList chats = (NodeList) xpath.evaluate("//Animal[@famille='Chat']", new
					 InputSource("animaux.xml"), XPathConstants.NODESET);
			
			System.out.println("Il y a "+chats.getLength()+" chat(s).");
			
		} catch (XPathExpressionException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
