package dao.director;

import entity.Food;

import java.io.File;
import java.io.IOException;
import java.util.List;

public interface Command {
    public List<Food> execute(File file) throws IOException;
}
