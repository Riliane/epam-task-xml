package dao.director;

import dao.parsers.StAXFoodHandler;
import entity.Food;

import javax.xml.stream.XMLStreamException;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class StAXCommand implements Command{
    @Override
    public List<Food> execute(File file) throws IOException {
        StAXFoodHandler handler = new StAXFoodHandler();
        try {
            List<Food> list = handler.handle(file);
            return list;
        } catch (XMLStreamException e) {
            return null;
        }

    }

}
