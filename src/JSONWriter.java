import java.lang.reflect.Field;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

class JSONWriter {
    private Object o;

    public JSONWriter(Object o) {
        this.o = o;
    }

    public String mapToJSON(Map<String, String> jsonFieldMap) {
        String jsonString = jsonFieldMap
            .entrySet()
            .stream()
            .map(entry -> "\"" + entry.getKey() + "\":\"" + entry.getValue() + "\"")
            .collect(Collectors.joining(","));

        return "{" + jsonString + "}";
    }

    public String toString() {
        Map<String, String> jsonFieldMap = new TreeMap<>();
        // TODO:
        // Untuk setiap field di kelas o, periksa apakah memiliki anotasi dengan
        // field.isAnnotationPresent(JSONField.class).
        // Jika ada, tambahkan entry ke jsonFieldMap dengan <key,value> =
        //   key = nama field
        //   value = nilai dari field
        // ...lengkapi di sini
        Field[] f = o.getClass().getDeclaredFields();   //get all fields
        for (Field curr_field : f) {    //loop for each fields and check it
            if (curr_field.isAnnotationPresent(JSONField.class)) {
                try {
                    curr_field.setAccessible(true);
                    String key = curr_field.getName();      //get key
                    String value = curr_field.get(o).toString();    //get value
                    jsonFieldMap.put(key, value);   //add to map
                } catch (Exception e) {
                    //e.printStackTrace();
                }
            }
        }
        return mapToJSON(jsonFieldMap);
    }
}