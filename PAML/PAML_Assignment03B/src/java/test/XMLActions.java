package test;

import java.io.File;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Document;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLActions {

    public boolean modify(String path, String code, String[] update) {
        try {
            String filepath = path;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            boolean found = false;
            NodeList books = doc.getElementsByTagName("Book");
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                NamedNodeMap attr = book.getAttributes();
                if (attr.getNamedItem("code").getNodeValue().equalsIgnoreCase(code)) {
                    found = true;
                    NodeList list = book.getChildNodes();
                    for (int j = 0; j < list.getLength(); j++) {
                        Node node = list.item(j);
                        if ("Title".equals(node.getNodeName())) {
                            node.setTextContent(update[0]);
                        }
                        if ("Price".equals(node.getNodeName())) {
                            node.setTextContent(update[1]);
                        }
                        if ("Author".equals(node.getNodeName())) {
                            node.setTextContent(update[2]);
                        }
                        if ("Edition".equals(node.getNodeName())) {
                            node.setTextContent(update[3]);
                        }
                    }
                    break;
                }
            }
            if (!found) {
                return false;
            }
            // write the content into the xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Create xml with line break and indent
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            //
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public boolean remove(String path, String code) {
        try {
            String filepath = path;
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(filepath);

            //Get the root element
            Node store = doc.getDocumentElement();
            boolean found = false;
            NodeList books = doc.getElementsByTagName("Book");
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                NamedNodeMap attr = book.getAttributes();
                if (attr.getNamedItem("code").getNodeValue().equalsIgnoreCase(code)) {
                    found = true;
                    store.removeChild(book);
                }
            }
            if (!found) {
                return false;
            }
            // write the content into the xml file
            TransformerFactory transformerFactory = TransformerFactory.newInstance();
            Transformer transformer = transformerFactory.newTransformer();
            // Create xml with line break and indent
            transformer.setOutputProperty(OutputKeys.ENCODING, "UTF-8");
            transformer.setOutputProperty(OutputKeys.INDENT, "yes");
            transformer.setOutputProperty("{http://xml.apache.org/xslt}indent-amount", "4");
            //
            DOMSource source = new DOMSource(doc);
            StreamResult result = new StreamResult(new File(filepath));
            transformer.transform(source, result);

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }

    public NodeList read(String path) {
        NodeList nList = null;
        try {
            File file = new File(path);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();
            nList = doc.getElementsByTagName("Book");

        } catch (Exception e) {
            e.printStackTrace();
        }
        return nList;
    }

    public NodeList get(String path, String code) {
        NodeList nList = null;
        try {
            File file = new File(path);
            DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
            Document doc = docBuilder.parse(file);
            doc.getDocumentElement().normalize();
            NodeList books = doc.getElementsByTagName("Book");
            for (int i = 0; i < books.getLength(); i++) {
                Node book = books.item(i);
                NamedNodeMap attr = book.getAttributes();
                if (attr.getNamedItem("code").getNodeValue().equalsIgnoreCase(code)) {
                    nList = book.getChildNodes();
                    break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nList;
    }
}
