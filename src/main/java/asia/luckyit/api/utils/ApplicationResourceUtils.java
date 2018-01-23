/**
 * 
 */
package asia.luckyit.api.utils;

import java.util.ResourceBundle;

/**
 * @author toint1
 *
 */
public class ApplicationResourceUtils {
	
	private static ResourceBundle rb = ResourceBundle.getBundle("application");
	
	public static String getValue(String key) {
		return rb.getString(key);
	}
	
}
