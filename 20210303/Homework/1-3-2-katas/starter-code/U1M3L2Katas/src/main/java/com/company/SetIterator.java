package com.company;
import java.util.HashSet;
import java.util.Iterator;

public class SetIterator {
    public void printSet(int a, int b, int c, int d, int e){
            HashSet<Integer> hashSet = new HashSet<Integer>();
            hashSet.add(a);
            hashSet.add(b);
            hashSet.add(c);
            hashSet.add(d);
            hashSet.add(e);
        Iterator<Integer> it = hashSet.iterator();
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
