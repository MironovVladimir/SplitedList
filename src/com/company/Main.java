package com.company;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.HashSet;

public class Main {

    public static void main(String[] args) {
    	LinkedList<Integer> test1 = new LinkedList<Integer>();
	    LinkedList<Integer> test2 = new LinkedList<Integer>();
	    for(int i = 0; i<10; i++) test1.add(new Integer(i));
	    for(int i = 10; i<17; i++) test2.add(new Integer(i));
	    for(int i = 17; i<36; i++){
	    	Integer t = new Integer(i);
	    	test1.add(t);
	    	test2.add(t);
		}
	    System.out.println(test2.get(SearchSplit(test2,test1)));
	    System.out.println(test1.get(SearchSplit2(test1, test2)));
    }

	//Выбрасывает исключение при передаче в качестве аргументов списков без совпадающих элементов в конце,
	//в остальных случаях возврщает индекс первого совпадающего элемента в списке, переданном первым аргументом.
    static int SearchSplit(List A, List B){
    	int deltaSize = A.size()-B.size();
    	Iterator iterator1 = A.iterator();
    	Iterator iterator2 = B.iterator();
    	int ret = 0;
    	if(deltaSize>=0) {
    		ret = deltaSize;
    		for(int i = 0; i<deltaSize; i++) iterator1.next();
		}
    	else for(int i = 0; i<(-deltaSize); i++) iterator2.next();
    	while(iterator1.next()!=iterator2.next()) ret++;
    	return ret;
	}

	static int SearchSplit2(List<Integer> A, List<Integer> B){
		int ret = 0;
		HashSet<Integer> hashSet = new<Integer> HashSet(B);
    	for(int i : A) if(!hashSet.contains(i)) ret++;
    	return ret;
	}
}