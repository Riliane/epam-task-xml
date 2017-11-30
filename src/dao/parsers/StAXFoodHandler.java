package dao.parsers;

import entity.Food;

import javax.xml.stream.XMLEventReader;
import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.events.Characters;
import javax.xml.stream.events.EndElement;
import javax.xml.stream.events.StartElement;
import javax.xml.stream.events.XMLEvent;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StAXFoodHandler {
    List<Food> foodList;
    String thisElement;
    Food thisFood;

    public List<Food> handle(File file) throws IOException, XMLStreamException{
        XMLInputFactory factory = XMLInputFactory.newInstance();
        XMLEventReader eventReader =
                factory.createXMLEventReader(new FileReader(file));

        while (eventReader.hasNext()) {
            XMLEvent event = eventReader.nextEvent();

            switch (event.getEventType()) {
                case XMLStreamConstants.START_DOCUMENT:{
                    foodList = new ArrayList<>();
                    break;}
                case XMLStreamConstants.START_ELEMENT:
                {
                    StartElement startElement = event.asStartElement();
                    String qName = startElement.getName().getLocalPart();
                    thisElement = qName;
                    if (qName.equals("food")){
                        thisFood = new Food();
                    }
                    break;}
                case XMLStreamConstants.CHARACTERS:
                    {
                    Characters characters = event.asCharacters();
                    if (thisElement.equals("name")){
                        thisFood.setName(characters.getData());
                    }
                    if (thisElement.equals("price")){
                        thisFood.setPrice(characters.getData());
                    }
                    if (thisElement.equals("description")){
                        thisFood.setDescription(thisFood.getDescription()+(characters.getData()));
                    }
                    if (thisElement.equals("calories")){
                        thisFood.setCalories(Integer.parseInt(characters.getData()));
                    }
                    break;}
                case XMLStreamConstants.END_ELEMENT:
                {
                    EndElement endElement = event.asEndElement();
                    if(endElement.getName().getLocalPart().equals("food")) {
                        foodList.add(thisFood);
                    }
                    thisElement = "";
                    break;}
            }
        }
        return foodList;
    }
}