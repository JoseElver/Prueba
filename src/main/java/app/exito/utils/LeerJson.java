package app.exito.utils;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;
import java.io.File;
import java.io.FileReader;

public class LeerJson {
    private static JSONObject globalJSONObject;

    public static void on(String filePath) {
        try {
            File file = new File(filePath);
            FileReader fileReader = new FileReader(file);
            JSONTokener tokener = new JSONTokener(fileReader);
            JSONArray jsonArray = new JSONArray(tokener);

            for (Object obj : jsonArray) {
                if (obj instanceof JSONObject) {
                    globalJSONObject = (JSONObject) obj;
                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static JSONObject getGlobalJSONObject() {
        return globalJSONObject;
    }
}