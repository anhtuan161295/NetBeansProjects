package test;

import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.events.Attribute;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;

public class XMLActions {

    public List<Employee> readXML(String filepath) {
        List<Employee> list = new ArrayList<>();

        boolean bName = false;
        boolean bAge = false;
        boolean bGender = false;
        boolean bRole = false;

        try {
            XMLInputFactory factory = XMLInputFactory.newFactory();
            XMLEventReader eventReader = factory.createXMLEventReader(new FileReader(filepath));
            Employee emp = new Employee();
            while (eventReader.hasNext()) {
                XMLEvent event = eventReader.nextEvent();
                // Create a model and add to list
                
                switch (event.getEventType()) {
                    case XMLStreamConstants.START_ELEMENT:
                        StartElement startElement = event.asStartElement();
                        String qName = startElement.getName().getLocalPart();
                        if (qName.equalsIgnoreCase("Employee")) {
//                            System.out.println("Start Element : Employee ");
                            Iterator<Attribute> attributes = startElement.getAttributes();

                            String id = attributes.next().getValue();
                            emp.setId(id);
                            System.out.println("ID : " + id);
                            System.out.println("ID : " + emp.getId());
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
//                            System.out.println("Name: " + characters.getData());
                            emp.setName(characters.getData());
                            bName = false;
                        }
                        if (bAge) {
//                            System.out.println("Age: " + characters.getData());
                            emp.setAge(characters.getData());
                            bAge = false;
                        }
                        if (bGender) {
//                            System.out.println("Gender: " + characters.getData());
                            emp.setGender(characters.getData());
                            bGender = false;
                        }
                        if (bRole) {
//                            System.out.println("Role: " + characters.getData());
                            emp.setRole(characters.getData());
                            bRole = false;
                            list.add(emp);
                            emp = new Employee();
//                            System.out.println(list);
                        }
                        break;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (Employee e : list) {
//            System.out.println(e.getId());
        }

        return list;
    }
}
