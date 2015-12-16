package domain.korting;

import java.lang.reflect.Constructor;
/**
 * 
 * @author Larry & Annelore
 *
 */
public class KortingFactory {
    public Korting createKorting(String code, double amount, String type, int productid) {
		String path = KortingFactory.class.getCanonicalName();
		path = path.substring(0, path.lastIndexOf("."));
		path += ".types." + type;
        try {
            Class<?> kortingClass = Class.forName(path);
            Constructor<?> kortingConstructor;
            Object kortingInstance;
            if (productid != 0) {
                kortingConstructor = kortingClass.getConstructor(String.class, Double.class, Integer.class);
                kortingInstance = kortingConstructor.newInstance(code, amount, productid);
            } else {
                kortingConstructor = kortingClass.getConstructor(String.class, Double.class);
                kortingInstance = kortingConstructor.newInstance(code, amount);
            }
            return (Korting) kortingInstance;
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Invalid data in database");
        } catch (NoSuchMethodException e) {
        	throw new RuntimeException("Invalid dddata in database");
        } catch (Exception e) {
            throw new RuntimeException("Invalid dddata in database");
        }
    }
}
