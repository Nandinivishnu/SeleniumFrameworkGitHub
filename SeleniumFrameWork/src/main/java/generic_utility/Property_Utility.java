package generic_utility;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Properties;

public class Property_Utility {

	/**
	 * used to launch application
	 * @param key
	 * @return value
	 * @throws thowable
	 * 
	 * 
	 * @author nandini
	 */
	
	
public String getKeyValue(String key) throws Throwable {
	

FileInputStream fis=new FileInputStream("./src/test/resources/PropertyDataFile.properties");
	Properties pro=new Properties();
	pro.load(fis);
	String value=pro.getProperty(key);
	return value;
	
}
}											