/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package test;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author QQ
 */
public class XMLActions {

    //<editor-fold defaultstate="collapsed" desc="getElement">
    public Node getElement(Document doc, String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="getCustomer">
    public Node getCustomer(Document doc, Customer cus) {
        Element customer = null;
        try {
            customer = doc.createElement("Customer");
            customer.appendChild(getElement(doc, "ID", cus.getId()));
            customer.appendChild(getElement(doc, "Password", cus.getPassword()));
            customer.appendChild(getElement(doc, "Name", cus.getName()));
            customer.appendChild(getElement(doc, "Balance", cus.getBalance()));

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return customer;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Read">
    public List<Customer> read(String path) {
        List<Customer> list = new ArrayList<>();
        NodeList nList = null;
        try {
            File file = new File(path);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("Customer");

            for (int i = 0; i < nList.getLength(); i++) {
                Element emp = (Element) nList.item(i);
                String id = emp.getElementsByTagName("ID").item(0).getTextContent();
                String password = emp.getElementsByTagName("Password").item(0).getTextContent();
                String name = emp.getElementsByTagName("Name").item(0).getTextContent();
                String balance = emp.getElementsByTagName("Balance").item(0).getTextContent();

                Customer e = new Customer(id, password, name, balance);
                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Add">
    public boolean add(String path, Customer cus) {
        boolean ok = false;
        try {
            File file = new File(path);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();
            // Root element
            Element rootElement = doc.getDocumentElement();
            // Create new node
            rootElement.appendChild(getCustomer(doc, cus));

            // write the content into xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Create xml with line break and indent
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            // Set source and set file to write data
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(file);
            // Write data to file
            transformer.transform(source, result);
//            System.out.println("XML File Created!");
            ok = true;

        } catch (Exception e) {
            e.printStackTrace();
            ok = false;
        }
        return ok;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Get">
    public Customer get(String path, String id) {
        Customer customer = null;

        List<Customer> list = read(path);
        for (Customer cus : list) {
            if (cus.getId().equals(id)) {
                customer = cus;
            }
        }

        return customer;
    }
//</editor-fold>
}
