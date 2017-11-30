package dao;

import dao.director.ParserDirector;
import entity.Food;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;

public class DAOImpl {
    URL url = getClass().getResource("/../../food.xml");
    File file = new File(url.getPath());
    public List<Food> getParsedData (String method) throws IOException{
        ParserDirector director = new ParserDirector();
        List<Food> list = director.getCommand(method).execute(file);
        return list;
    }
}
