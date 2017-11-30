package dao.parsers;
import entity.Food;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import java.util.ArrayList;
import java.util.List;

public class SAXFoodHandler extends DefaultHandler{
    List<Food> foodList;
    String thisElement;
    Food thisFood;
    @Override
    public void startDocument() throws SAXException {
        foodList = new ArrayList<>();
    }
    @Override
    public void startElement(String namespaceURI, String localName, String qName, Attributes atts) throws SAXException {
        thisElement = qName;
        if (qName.equals("food")){
            thisFood = new Food();
        }
    }
    @Override
    public void characters(char[] ch, int start, int length) throws SAXException {
        if (thisElement.equals("name")){
            thisFood.setName(new String(ch, start, length));
        }
        if (thisElement.equals("price")){
            thisFood.setPrice(new String(ch, start, length));
        }
        if (thisElement.equals("description")){
            thisFood.setDescription(thisFood.getDescription()+(new String(ch, start, length)));
        }
        if (thisElement.equals("calories")){
            thisFood.setCalories(Integer.parseInt(new String(ch, start, length)));
        }
    }
    @Override
    public void endElement(String namespaceURI, String localName, String qName) throws SAXException {
        if (qName.equals("food")){
            foodList.add(thisFood);
        }
        thisElement = "";
    }
    @Override
    public void endDocument() {
    }

    public List<Food> getResult(){
        return foodList;
    }

}
