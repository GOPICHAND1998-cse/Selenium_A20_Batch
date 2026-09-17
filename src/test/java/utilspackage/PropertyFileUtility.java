package utilspackage;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility
{
    FileInputStream fis;

    public String getData(String key) throws Exception
    {
        fis = new FileInputStream("./src/test/resources/CommonData/Config.properties");

        Properties properties = new Properties();

        properties.load(fis);

        return properties.getProperty(key);
    }
}
