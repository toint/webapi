/**
 * 
 */
package asia.luckyit.api.flow;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.json.JSONObject;

import asia.luckyit.api.utils.ApplicationResourceUtils;

/**
 * @author toint1
 *
 */
public class WebFlowAction {
	
	public JSONObject process(Map<String, String> config) {
		JSONObject json = new JSONObject();
		
		final String className = ApplicationResourceUtils.getValue(config.get("fnc"));
		final String params = config.get("data");
		JSONObject obj = new JSONObject(params);
		try {
			Class<?> clazz = Class.forName(className);
			Object t = clazz.newInstance();
			
			Method method = t.getClass().getMethod(String.valueOf(config.get("fnc")), String.class);
			
			List<String> parameter = new ArrayList<String>();
			Set<String> keys = obj.keySet();
			for (String s : keys) {
				parameter.add(String.valueOf(obj.get(s)));
			}
			
			Object result = method.invoke(t, parameter.toArray());
			
			
			System.out.println(result.toString());
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (InstantiationException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		} catch (NoSuchMethodException e) {
			e.printStackTrace();
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (InvocationTargetException e) {
			e.printStackTrace();
		}
		
		
		
		
		
		return json;
	}
	
}
