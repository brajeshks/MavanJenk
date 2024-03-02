package generics.com;

import java.io.FileInputStream;

import java.io.IOException;
import java.util.Properties;

public class FileLibClass {
public String getPropertyValue(String key,String path) throws IOException
{
	FileInputStream fis = new FileInputStream(path);
	Properties p = new Properties();
	p.load(fis);
	String value = p.getProperty(key);
	return value;
}
}
