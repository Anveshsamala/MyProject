package myutilities;

import java.io.FileInputStream;
import java.util.Properties;

public class MyConfigReader {
	static Properties prop;
	
	public static String getpropertyfile(String key)
	{
		try {
			if(prop==null)
			{
				prop=new Properties();
				FileInputStream fis=new FileInputStream("src\\test\\resources\\myconfigproperties\\config.properties");
				prop.load(fis);
			}
			
		} catch (Exception e) {
			 e.printStackTrace();
		}
		return prop.getProperty(key);
		 
	}

}
