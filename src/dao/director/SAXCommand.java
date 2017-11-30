package dao.director;

import dao.parsers.SAXFoodHandler;
import entity.Food;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParser;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class SAXCommand implements Command {
    @Override
    public List<Food> execute(File file) throws IOException{
        try {
            SAXParserFactory factory = SAXParserFactory.newInstance();
            SAXParser parser = factory.newSAXParser();
            SAXFoodHandler handler = new SAXFoodHandler();
            parser.parse(file, handler);
            return handler.getResult();
        } catch (ParserConfigurationException e) {
            return null;
        } catch (SAXException e) {
            return null;
        }
    }
}
