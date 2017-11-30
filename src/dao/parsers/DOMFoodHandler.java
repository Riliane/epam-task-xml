package dao.parsers;

import entity.Food;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class DOMFoodHandler {

    public List<Food> handle(File file) throws IOException, SAXException, ParserConfigurationException{
        List<Food> foodList = new ArrayList<>();
        Food thisFood;

        DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nList = doc.getElementsByTagName("food");
        for (int i = 0; i < nList.getLength(); i++){
            Node node = nList.item(i);
            if (node.getNodeType() == Node.ELEMENT_NODE) {
                Element element = (Element) node;
                thisFood = new Food();
                thisFood.setName(element.getElementsByTagName("name").item(0).getTextContent());
                thisFood.setPrice(element.getElementsByTagName("price").item(0).getTextContent());
                thisFood.setDescription(element.getElementsByTagName("description").item(0).getTextContent());
                thisFood.setCalories(Integer.parseInt(element.getElementsByTagName("calories").item(0).getTextContent()));
                foodList.add(thisFood);
            }
        }
        return foodList;
    }
}
