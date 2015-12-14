package ss.week5;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class MapUtil {
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {
		return false;
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
        // TODO: implement, see exercise P-5.3
        return null;
	}
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
        // TODO: implement, see exercise P-5.3
        return null;
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
