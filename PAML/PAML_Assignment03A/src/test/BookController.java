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
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class BookController {

    private Document doc;
    private String filepath;
    File file;
    DocumentBuilderFactory docFactory;
    DocumentBuilder docBuilder;

    //<editor-fold defaultstate="collapsed" desc="getter setter constructor">
    public BookController() {
        try {
            filepath = "src/test/bookStore.xml";
            file = new File(filepath);
            docFactory = DocumentBuilderFactory.newInstance();
            docBuilder = docFactory.newDocumentBuilder();

            createXML();
            doc = docBuilder.parse(file);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public Document getDoc() {
        return doc;
    }

    public void setDoc(Document doc) {
        this.doc = doc;
    }

    public String getFilepath() {
        return filepath;
    }

    public void setFilepath(String filepath) {
        this.filepath = filepath;
    }
//</editor-fold>

    // Simple create element
    //<editor-fold defaultstate="collapsed" desc="comment">
    public Node getBookElements(String name, String value) {
        Element node = doc.createElement(name);
        node.appendChild(doc.createTextNode(value));
        return node;
    }
//</editor-fold>

    // Simple create element Book
    //<editor-fold defaultstate="collapsed" desc="comment">
    public Node getBook(String code, String title, String price, String author, String edition) {
        Element book = null;
        try {
            book = doc.createElement("Book");
            book.setAttribute("code", code);
            book.appendChild(getBookElements("Title", title));
            book.appendChild(getBookElements("Price", price));
            book.appendChild(getBookElements("Author", author));
            book.appendChild(getBookElements("Edition", edition));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return book;

    }
//</editor-fold>

    // Create XML
    //<editor-fold defaultstate="collapsed" desc="comment">
    public void createXML() {
        try {

            // root element
            doc = docBuilder.newDocument();
            Element rootElement = doc.createElement("BookStore");
            doc.appendChild(rootElement);

            // appent child elements Book to root element
            rootElement.appendChild(getBook("111", "Java Programming", "200", "Mr. Tom", "2"));
            rootElement.appendChild(getBook("112", "C# Programming", "300", "Mr. Teo", "1"));
            rootElement.appendChild(getBook("113", "Web Design", "400", "Angela", "3"));
            rootElement.appendChild(getBook("114", "Game Development", "500", "Obama", "2"));

            // write the content into xml file
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
            System.out.println("XML File Created!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//</editor-fold>

    // Read XML
    //<editor-fold defaultstate="collapsed" desc="comment">
    public void readXML() {
        try {

            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("Book");
            System.out.println("-----------------------------");
            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element : " + nNode.getNodeName());
                if (nNode.getNodeType() == Node.ELEMENT_NODE) {
                    Element eElement = (Element) nNode;
                    System.out.println("Code : " + eElement.getAttribute("code"));

                    NodeList propList = nNode.getChildNodes();
                    for (int i = 0; i < propList.getLength(); i++) {
                        Node prop = propList.item(i);
                        if (prop.getNodeType() == Node.ELEMENT_NODE) {
                            System.out.println(prop.getNodeName() + " : " + prop.getTextContent());
                        }
                    }

//                    System.out.println("Title : " + eElement.getElementsByTagName("Title").item(0).getTextContent());
//                    System.out.println("Price : " + eElement.getElementsByTagName("Price").item(0).getTextContent());
//                    System.out.println("Author : " + eElement.getElementsByTagName("Author").item(0).getTextContent());
//                    System.out.println("Edition : " + eElement.getElementsByTagName("Edition").item(0).getTextContent());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
//</editor-fold>

    // Get Book Info
    //<editor-fold defaultstate="collapsed" desc="comment">
    public Node getBookInfo(String code) {
        Node bk = null;
        try {
            doc.getDocumentElement().normalize();
            // array of books, 1 node = 1 book
            NodeList bookList = doc.getElementsByTagName("Book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Element book = (Element) bookList.item(i);
                // Loop for each book
                if (book.getAttribute("code").equals(code)) {
                    bk = book;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }
//</editor-fold>

    // Update XML
    //<editor-fold defaultstate="collapsed" desc="comment">
    public void updateXML(Node bookUpdate) {
        try {
            doc.getDocumentElement().normalize();
            // List = node list, node convert to element
            // Array of books
            NodeList bookList = doc.getElementsByTagName("Book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node nBook = bookList.item(i);
                Element book = (Element) bookList.item(i);
                Element updatedBook = (Element) bookUpdate;
                // Loop for each book
                if (book.getAttribute("code").equals(updatedBook.getAttribute("code"))) {
                    book.getElementsByTagName("Title").item(0).setTextContent(updatedBook.getElementsByTagName("Title").item(0).getTextContent());
                    book.getElementsByTagName("Price").item(0).setTextContent(updatedBook.getElementsByTagName("Price").item(0).getTextContent());
                    book.getElementsByTagName("Author").item(0).setTextContent(updatedBook.getElementsByTagName("Author").item(0).getTextContent());
                    book.getElementsByTagName("Edition").item(0).setTextContent(updatedBook.getElementsByTagName("Edition").item(0).getTextContent());
                }
            }

            // write the content into xml file
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
//            System.out.println("XML File Updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
//</editor-fold>

    // Add node
    //<editor-fold defaultstate="collapsed" desc="comment">
    public boolean addNode(String name, String value) {
        boolean bk = false;
        try {
            doc.getDocumentElement().normalize();
            // List = node list, node convert to element
            // Array of books
            NodeList bookList = doc.getElementsByTagName("Book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node nBook = bookList.item(i);
                Element book = (Element) bookList.item(i);
                // Loop for each book
                Node node = getBookElements(name, value);
                if (book.getElementsByTagName(name).item(0) == null) {
                    book.appendChild(node);
                    bk = true;
                } else {
                    // do nothing
                }
            }

            // write the content into xml file
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
//            System.out.println("XML File Updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }
//</editor-fold>

    // Remove node
    //<editor-fold defaultstate="collapsed" desc="comment">
    public boolean removeNode(String name) {
        boolean bk = false;
        try {
            doc.getDocumentElement().normalize();
            // List = node list, node convert to element
            // Array of books
            NodeList bookList = doc.getElementsByTagName("Book");
            for (int i = 0; i < bookList.getLength(); i++) {
                Node nBook = bookList.item(i);
                Element book = (Element) bookList.item(i);
                // Loop for each book
                Node node = book.getElementsByTagName(name).item(0);
                if (node != null) {
                    book.removeChild(node);
                    bk = true;
                } else {
                    // do nothing
                }
            }

            // write the content into xml file
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
//            System.out.println("XML File Updated!");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bk;
    }
//</editor-fold>

}
