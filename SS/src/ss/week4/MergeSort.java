package ss.week4;

import java.util.*;

public class MergeSort {
    public static <Elem extends Comparable<Elem>>
    List<Elem> mergesort(List<Elem> list) {
    	if (list.size() < 2) {
    		return list;
    	}
    	List<Elem> fst = list.subList(0, list.size() / 2);
    	List<Elem> snd = list.subList(list.size() / 2, list.size() - 1);
    	fst = mergesort(fst);
    	snd = mergesort(snd);
    	List<Elem> res = new ArrayList<Elem>(); 
    	int fi = 0;
    	int si = 0;
    	while (fi < fst.size() && si < snd.size()) {
    		if (fst.get(fi).compareTo(snd.get(si)) < 0) {
    			res.add(fst.get(fi));
    			fi++;
    		}
    		else {
    			res.add(snd.get(si));
    			si++;
    		}
    	}
    	if (fi <= fst.size() - 1) {
    		res.addAll(fst.subList(fi, fst.size() - 1));
    	} else if (si <= snd.size() - 1) {
    		res.addAll(snd.subList(si, snd.size() - 1));
    	}
    	return res;
    }
}
