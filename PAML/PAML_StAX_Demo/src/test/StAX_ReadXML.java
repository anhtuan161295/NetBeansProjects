package test;

import java.io.FileReader;
import java.util.Iterator;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class StAX_ReadXML {

    public static void main(String[] args) {
        boolean bName = false;
        boolean bAge = false;
        boolean bGender = false;
        boolean bRole = false;

        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader("src/test/employees.xml"));
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase("Employee")) {
                            System.out.println("Start Element : Employee ");
                            Iterator<Attribute> attributes = startElement.getAttributes();

                            String id = attributes.next().getValue();
                            System.out.println("ID : " + id);
                        } else if (qName.equalsIgnoreCase("name")) {
                            bName = true;
                        } else if (qName.equalsIgnoreCase("age")) {
                            bAge = true;
                        } else if (qName.equalsIgnoreCase("gender")) {
                            bGender = true;
                        } else if (qName.equalsIgnoreCase("role")) {
                            bRole = true;
                        }
                        break;
                    case XMLStreamConstants.CHARACTERS:
                        Characters characters = event.asCharacters();
                        if (bName) {
                            System.out.println("Name: " + characters.getData());
                            bName = false;
                        }
                        if (bAge) {
                            System.out.println("Age: " + characters.getData());
                            bAge = false;
                        }
                        if (bGender) {
                            System.out.println("Gender: " + characters.getData());
                            bGender = false;
                        }
                        if (bRole) {
                            System.out.println("Role: " + characters.getData());
                            bRole = false;
                        }
                        break;

                    case XMLStreamConstants.END_ELEMENT:
                        EndElement endElement = event.asEndElement();
                        if (endElement.getName().getLocalPart().equalsIgnoreCase("Employee")) {
                            System.out.println("End Element : Employee");
                            System.out.println("");
                        }
                        break;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
