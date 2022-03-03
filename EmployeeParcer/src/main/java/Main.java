import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static java.nio.file.Paths.get;

public class Main {

    public static void main(String[] args) {

        String data = GetDataFromFile( "data/staff.json" );

        JSONParser parser = new JSONParser();
        JSONArray array = null;

        try {
            array = (JSONArray) parser.parse( data );
        } catch (ParseException e) {
            e.printStackTrace();
        }
        for (Object item : array) {
            JSONObject jsonObject = (JSONObject) item;
            System.out.println( jsonObject.get( "name" ) + "; Дата начала работы: "+jsonObject.get("workStart") );
        }
    }

    public static String GetDataFromFile(String path) {

        StringBuilder builder = new StringBuilder();
        try {
            List<String> lines = Files.readAllLines( get( path ) );
            for (String line : lines) {
                builder.append( line );
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return builder.toString();

    }
}
