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

    //<editor-fold defaultstate="collapsed" desc="getEmployee">
    public Node getEmployee(Document doc, Employee emp) {
        Element book = null;
        try {
            book = doc.createElement("Employee");
            book.setAttribute("id", emp.getId());
            book.appendChild(getElement(doc, "password", emp.getPassword()));
            book.appendChild(getElement(doc, "name", emp.getName()));
            book.appendChild(getElement(doc, "age", emp.getAge()));
            book.appendChild(getElement(doc, "gender", emp.getGender()));
            book.appendChild(getElement(doc, "role", emp.getRole()));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Read">
    public List<Employee> read(String path) {
        List<Employee> list = new ArrayList<>();
        NodeList nList = null;
        try {
            File file = new File(path);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("Employee");

            for (int i = 0; i < nList.getLength(); i++) {
                Element emp = (Element) nList.item(i);
                String id = emp.getAttribute("id");
                String password = emp.getElementsByTagName("password").item(0).getTextContent();
                String name = emp.getElementsByTagName("name").item(0).getTextContent();
                String age = emp.getElementsByTagName("age").item(0).getTextContent();
                String gender = emp.getElementsByTagName("gender").item(0).getTextContent();
                String role = emp.getElementsByTagName("role").item(0).getTextContent();
                Employee e = new Employee(id, password, name, age, gender, role);
                list.add(e);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Get">
    public Employee get(String path, String id) {
        Employee employee = null;

        List<Employee> list = read(path);
        for (Employee emp : list) {
            if (emp.getId().equals(id)) {
                employee = emp;
            }
        }

        return employee;
    }
//</editor-fold>

    //<editor-fold defaultstate="collapsed" desc="Add">
    public boolean add(String path, Employee employee) {
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
            rootElement.appendChild(getEmployee(doc, employee));

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

    //<editor-fold defaultstate="collapsed" desc="Update">
    public boolean update(String path, Employee updateEmp) {
        boolean ok = false;
        NodeList nList = null;
        try {
            File file = new File(path);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();

            // List of all employees
            nList = doc.getElementsByTagName("Employee");
            for (int i = 0; i < nList.getLength(); i++) {
                Element emp = (Element) nList.item(i);
                String id = emp.getAttribute("id");
                if (id.equals(updateEmp.getId())) {
                    emp.getElementsByTagName("password").item(0).setTextContent(updateEmp.getPassword());
                    emp.getElementsByTagName("name").item(0).setTextContent(updateEmp.getName());
                    emp.getElementsByTagName("age").item(0).setTextContent(updateEmp.getAge());
                    emp.getElementsByTagName("gender").item(0).setTextContent(updateEmp.getGender());
                    emp.getElementsByTagName("role").item(0).setTextContent(updateEmp.getRole());
                }
            }
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

    //<editor-fold defaultstate="collapsed" desc="Delete">
    public boolean delete(String path, String id) {
        boolean ok = false;
        NodeList nList = null;
        try {
            File file = new File(path);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();
            // Root element
            Element rootElement = doc.getDocumentElement();

            // List of all employees
            nList = doc.getElementsByTagName("Employee");
            for (int i = 0; i < nList.getLength(); i++) {
                Element emp = (Element) nList.item(i);
                String empId = emp.getAttribute("id");
                if (empId.equals(id)) {
                    rootElement.removeChild(emp);
                }
            }
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

}
