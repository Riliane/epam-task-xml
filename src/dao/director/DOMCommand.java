package dao.director;

import dao.parsers.DOMFoodHandler;
import entity.Food;
import org.xml.sax.SAXException;

import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class DOMCommand implements Command{
    @Override
    public List<Food> execute(File file) throws IOException {
        DOMFoodHandler handler = new DOMFoodHandler();
        try {
            List<Food> list = handler.handle(file);
            return list;
        } catch (SAXException e) {
            return null;
        } catch (ParserConfigurationException e){
            return null;
        }

    }

}
