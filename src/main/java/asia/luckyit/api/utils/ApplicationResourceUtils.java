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
	
	private static ResourceBundle rb = ResourceBundle.getBundle("asia.luckyit.api.utils.Functions");
	
	public static String getValue(String key) {
		return rb.getString(key);
	}
	
}
