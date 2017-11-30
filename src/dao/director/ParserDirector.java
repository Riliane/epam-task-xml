package dao.director;

import java.util.HashMap;
import java.util.Map;

public class ParserDirector {
    private Map<String, Command> map = new HashMap<>();
    public ParserDirector(){
        map.put("sax", new SAXCommand());
        map.put("stax", new StAXCommand());
        map.put("dom", new DOMCommand());
    }
    public Command getCommand(String name){
        Command command;
        command = map.get(name);
        return command;
    }
}
