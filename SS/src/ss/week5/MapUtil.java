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
    //@ ensures \result == (\forall K x1, x2; map.keySet().contains(x1) && map.keySet().contains(x2) && x1 != x2; map.get(x1) != map.get(x2));
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
    
    //@ ensures \result == (\forall V v1; range.contains(v1); \exists K k1; map.keySet().contains(k1); map.get(k1).equals(v1));
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
    
    //@ ensures \forall K k1; map.keySet().contains(k1); \result.get(map.get(k)).contains(k1));
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

    	//@ ensures \forall K k1; map.keySet().contains(k1); k1 == \result.get(map.get(k1));
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

	//@ ensures (\forall V value; f.containsValue(value); g.containsKey(value)) == \result;
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        for (V value : f.values())	{
        	if (!g.containsKey(value))	{
        		return false;
        	}
        }
        return true;
	}

	//@ ensures (\forall K k1; f.containsKey(k1); \result.get(k1).equals(g.get(f.get(k1))));
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
	    if (compatible(f, g))	{
        	HashMap<K, W> resultaat = new HashMap<K, W>();
        	for (K key : f.keySet())	{
        		resultaat.put(key, g.get(f.get(key)));
        	}
        	return resultaat;
        }
        return null;
	}
}
