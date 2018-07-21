/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author QQ
 */
public class ModifyXMLFile {

    public static void main(String[] args) {
        try {
            String filepath = "D:\\employees.xml";
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();

            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);
            //Get the root element
            Node employee = doc.getFirstChild();

            Node staff = doc.getElementsByTagName("Employee").item(0);

            // update staff attribute
            NamedNodeMap attr = staff.getAttributes();
            Node nodeAttr = attr.getNamedItem("id");
            nodeAttr.setNodeValue("111");
            // append a new node to staff
            Element email = doc.createElement("email");
            email.appendChild(doc.createTextNode("obama@whitehouse.us"));
            staff.appendChild(email);
            //loop the staff child node
            NodeList list = staff.getChildNodes();
            for (int i = 0; i < list.getLength(); i++) {
                Node node = list.item(i);
                //get the age element, and update the value
                if ("age".equals(node.getNodeName())) {
                    node.setTextContent("50");
                }
                //remove name
                if ("name".equals(node.getNodeName())) {
                    staff.removeChild(node);
                }
            }
            //write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);
            System.out.println("File modified!");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
