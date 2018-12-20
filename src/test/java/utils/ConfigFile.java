package utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFile {
  private static Properties prop;

  static {
    try {
      prop = new Properties();
      FileInputStream fis = new FileInputStream("src/test/resources/configs/config.properties");
      prop.load(fis);
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  public static String getBrowserName() {
    return prop.getProperty("browser");
  }

}
