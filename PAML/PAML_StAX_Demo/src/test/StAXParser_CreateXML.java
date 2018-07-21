package test;

import java.io.FileOutputStream;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import javax.xml.stream.XMLEventFactory;
import javax.xml.stream.XMLEventWriter;
import javax.xml.stream.XMLOutputFactory;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartDocument;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAXParser_CreateXML {

    public static void main(String[] args) {
        String filename = "src/test/employee2.xml";
        String rootElement = "Employee";
        StAXParser_CreateXML xmlWriter = new StAXParser_CreateXML();
        Map<String, String> elementsMap = new HashMap<>();

        elementsMap.put("name", "Tam");
        elementsMap.put("age", "23");
        elementsMap.put("role", "Java Developer");
        elementsMap.put("gender", "Male");
        
        xmlWriter.writeXML(filename, rootElement, elementsMap);

    }

    public static void createNode(XMLEventWriter eventWriter, String element, String value) throws XMLStreamException {
        XMLEventFactory xmlEventFactory = XMLEventFactory.newFactory();
        XMLEvent end = xmlEventFactory.createDTD("\n");
        XMLEvent tab = xmlEventFactory.createDTD("\t");
        // Create Start node
        StartElement sElement = xmlEventFactory.createStartElement("", "", element);
        eventWriter.add(tab);
        eventWriter.add(sElement);
        // Create content
        Characters characters = xmlEventFactory.createCharacters(value);
        eventWriter.add(characters);
        // Create End node
        EndElement eElement = xmlEventFactory.createEndElement("", "", element);
        eventWriter.add(eElement);
        eventWriter.add(end);

    }

    public static void writeXML(String filename, String rootElement, Map<String, String> elementMap) {
        XMLOutputFactory xmlOutputFactory = XMLOutputFactory.newFactory();
        try {
            XMLEventWriter xmlEventWriter = xmlOutputFactory.createXMLEventWriter(new FileOutputStream(filename), "UTF-8");
            XMLEventFactory eventFactory = XMLEventFactory.newFactory();
            XMLEvent end = eventFactory.createDTD("\n");
            StartDocument startDocument = eventFactory.createStartDocument();
            xmlEventWriter.add(startDocument);
            xmlEventWriter.add(end);
            StartElement configStartElement = eventFactory.createStartElement("", "", rootElement);
            xmlEventWriter.add(configStartElement);
            xmlEventWriter.add(end);
            // Write the element nodes
            Set<String> elementNodes = elementMap.keySet();
            for (String key : elementNodes) {
                createNode(xmlEventWriter, key, elementMap.get(key));
            }

            xmlEventWriter.add(eventFactory.createEndElement("", "", rootElement));
            xmlEventWriter.add(end);
            xmlEventWriter.add(eventFactory.createEndDocument());
            xmlEventWriter.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
