package ss.week5;

import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class MapUtil {
	
	//@ensures \result == true || \result == false;
	//@requires map != null;
    public static <K, V> boolean isOneOnOne(Map<K, V> map) {     	
    	int count = 0;
    	V a;
    	Set<K> key = map.keySet();
    	
    	for (K k:key) {
    		a = map.get(k);
    		for (K kk:key) {
    			if (map.get(kk).equals(a)) {
    				count++;
    			}
    		}
    		if (count > 1) {
    			return false;
    		}
    		count = 0;
    	}

        return true;
    }
    
	//@ensures \result == true || \result == false;
	//@requires map != null && range != null;
    public static <K, V> 
           boolean isSurjectiveOnRange(Map<K, V> map, Set<V> range) {
        Collection<K> key = map.keySet();
        int count = 0;
        int countNotInMap = 0;
        for (V v:range) {
        	for (K k:key) {
        		if (map.get(k).equals(v)) {
        			count++;
        		}
        	} 	
        	if (count == 0) {
        		countNotInMap++;
        	}
        	count = 0;
        }       
        if (countNotInMap > 0) {
        	return false;
        }       
        return true;
    }
    
    //@ensures \result != null;
    public static <K, V> Map<V, Set<K>> inverse(Map<K, V> map) { 
    	//you need a set here, because only the keys are unique in hashmap, not the values,
    	//if you inverse, one value can have multiple keys 
        Map<V, Set<K>> result = new HashMap<>();
        Set<K> keySet = map.keySet();
        Collection<V> values = map.values();
        for (V v:values) {
        	Set<K> resK = new HashSet<>();
            for (K k:keySet) {
            	if (map.get(k).equals(v)) {
            		resK.add(k);
            	}	
            }
            result.put(v, resK);
        }
        return result;
	}
    
  //@ensures \result != null;
	public static <K, V> Map<V, K> inverseBijection(Map<K, V> map) {
		Collection<V> v = map.values();
		Set<V> values = new HashSet<>();
		Map<V, K> result = new HashMap<>();
		
		for (V vv:v) {
			values.add(vv);
		}
		
        if (isOneOnOne(map) && isSurjectiveOnRange(map, values)) {
        	Set<K> keys = map.keySet();
        	for (K k:keys) {
        		result.put(map.get(k), k);
        	}
        }
        return result;
        
	}
	
	//@ensures \result == true || \result == false;
	//@requires f != null && g != null;
	public static <K, V, W> boolean compatible(Map<K, V> f, Map<V, W> g) {
        Set<K> keysF = f.keySet();
        Set<V> keysG = g.keySet();
        int count = 0;
        int notInSet = 0;
        
        for (K k:keysF) {
        	for (V v:keysG) {
        		if (f.get(k).equals(v)) {
        			count++;
        		}
        	}
        	if (count == 0) {
    			notInSet++;
    		}
    		count = 0;
        }
 		if (notInSet > 0) {
 			return false;
 		}
        return true;
	}
	
	//@ensures \result != null;
	public static <K, V, W> Map<K, W> compose(Map<K, V> f, Map<V, W> g) {
        if (compatible(f, g)) {
        	Map<K, W> result = new HashMap<>();
        	Set<K> keysF = f.keySet();
            Set<V> keysG = g.keySet();
        	
            for (K k:keysF) {
            	for (V v:keysG) {
            		if (f.get(k).equals(v)) {
            			result.put(k, g.get(v));
            		}
            	}
        
            }
            return result;
        }
        return null;
	}
}
