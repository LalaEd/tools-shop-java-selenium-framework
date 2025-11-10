package utils;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import java.io.FileReader;

public class JsonDataReader {

    public static JSONObject getTestData(String key) {
        JSONParser parser = new JSONParser();
        try {
            FileReader reader = new FileReader("src/test/resources/testdata/testData.json");
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            return (JSONObject) jsonObject.get(key);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
