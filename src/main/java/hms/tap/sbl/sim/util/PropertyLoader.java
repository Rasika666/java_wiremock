package hms.tap.sbl.sim.util;

import java.io.IOException;
import java.util.Map;
import java.util.Properties;

public class PropertyLoader {
    public  static Properties load(String fileName) {

        Properties in = new Properties();
        Properties out = new Properties();

        try {

            ClassLoader loader = PropertyLoader.class.getClassLoader();
            in.load(loader.getResourceAsStream(fileName));

            for (Map.Entry<Object, Object> entry : in.entrySet()) {
                Object key = entry.getKey();
                Object value = entry.getValue();

                out.put(key, value);

                if (value instanceof String) {
                    String variableKey = (String) value;
                    if (variableKey.startsWith("${") && variableKey.endsWith("}")) {
                        String variableValue = in.getProperty(variableKey.replaceAll("\\$\\{|\\}", "").trim());
                        if (variableValue != null) {
                            out.put(key, variableValue);
                        } else {
                            throw new IllegalStateException("Unable to find value for key " + variableKey + " from file " + fileName);
                        }
                    }
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return out;
    }
}
