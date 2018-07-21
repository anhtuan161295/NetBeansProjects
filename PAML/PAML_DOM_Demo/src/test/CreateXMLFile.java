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
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

/**
 *
 * @author QQ
 */
public class CreateXMLFile {

    public static void main(String[] args) {
        try {
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            // root element
            Document doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("company");
            doc.appendChild(rootElement);
            // staff element
            Element staff = doc.createElement("Staff");
            rootElement.appendChild(staff);

            Attr attr = doc.createAttribute("id");
            attr.setValue("1");
            staff.setAttributeNode(attr);

            Element firstname = doc.createElement("firstname");
            firstname.appendChild(doc.createTextNode("Barrack"));
            staff.appendChild(firstname);

            // last name element
            Element lastname = doc.createElement("lastname");
            lastname.appendChild(doc.createTextNode("Obama"));
            staff.appendChild(lastname);

            // nick name element
            Element nickname = doc.createElement("nickname");
            nickname.appendChild(doc.createTextNode("Uncle Sam"));
            staff.appendChild(nickname);

            // salary element
            Element salary = doc.createElement("salary");
            salary.appendChild(doc.createTextNode("100000"));
            staff.appendChild(salary);

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();

            Transformer transformer = transformerFactory.newTransformer();
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File("src/test/company.xml"));
            transformer.transform(source, result);
            System.out.println("File saved!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
