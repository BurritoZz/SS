package ss.week4;

import java.util.*;

public class MergeSort {
	public static <Elem extends Comparable<Elem>>
    	List<Elem> mergesort(List<Elem> list) {
    	if (list.size() < 2)	{
    		return list;
    	} else {
    		List<Elem> fst = list.subList(0, list.size() / 2);
    		List<Elem> snd = list.subList(list.size() / 2, list.size());
    		fst = mergesort(fst);
    		snd = mergesort(snd);
    		List<Elem> res;
    		res = new ArrayList<Elem>();
    		int fi = 0;
    		int si = 0;
    		while (fi < fst.size() && si < snd.size())	{
    			if (fst.get(fi).compareTo(snd.get(si)) < 0)	{
    				res.add(fst.get(fi));
    				fi++;
    			} else {
    				res.add(snd.get(si));
    				si++;
    			}
    		}
    		if (fi < fst.size())	{
    			res.addAll(fst.subList(fi, fst.size()));
    		} else if (si < snd.size())	{
    			res.addAll(snd.subList(si, snd.size()));
    		}
    		return res;
    	}
    }
}