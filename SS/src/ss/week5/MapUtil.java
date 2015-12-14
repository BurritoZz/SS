package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
	/**
	 * 
	 * @param map
	 * @return
	 */
	//@ requires map != null;
	//@ ensures \result instanceOf boolean;
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
    	Object[] keys = map.keySet().toArray(new Object[map.size()]);
    	Object[] values = new Object[map.size()];
    	
    	for (int i = 0; i < keys.length; i++) {
    		for (int i2 = 0; i2 < map.size(); i2++) {
    			if (values[i2] != null && values[i2].equals(map.get(keys[i]))) {
    				return false;
    			}
    		}
   			values[i] = map.get(keys[i]);
    	}
        return true;
    }
    
    //@ requires map != null;
    //@ requires range != null;
    public static <K, V> boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
    	Object[] values = map.values().toArray(new Object[map.size()]);
    	Object[] rvalues = range.toArray(new Object[range.size()]);
        for (int i = 0; i < rvalues.length; i++)	{
        	for (int j = 0; j < values.length; j++)	{
        		if (values[j].equals(rvalues[i]))	{
        			break;
        		} else if (j == values.length - 1)	{
        			return false;
        		}
        	}
        }
        return true;
    }
    
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) {
    	Map<V, Set<K>> result = new HashMap<V, Set<K>>();
    	for (K key : map.keySet()) {
    		V value = map.get(key);
    		if (!result.containsKey(value)) {
    			result.put(value, new HashSet<K>());
    		}
    		result.get(value).add(key);
    	}
    	return result;
	}

	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Map<V, K> result = new HashMap<V, K>();
		if (isOneOnOne(map)) {
			for (K key : map.keySet()) {
				V value = map.get(key);
				result.put(value, key);
			}
		}
        return result;
	}
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.4
        return false;
	}
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        // TODO: implement, see exercise P-5.5
        return null;
	}
}
