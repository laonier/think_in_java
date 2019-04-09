package chapter17.section5;

import chapter17.section2.Provinces;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        ArrayList<String> aList = new ArrayList<>(Provinces.provincialCapital());
        LinkedList<String> lList = new LinkedList<>(Provinces.provincialCapital());
        Iterator<String> aIte = aList.iterator();
        Iterator<String> lIte = lList.iterator();
        System.out.print("ArrayList: ");
        while (aIte.hasNext()){
            System.out.print(aIte.next() + " ");
        }
        System.out.println();
        System.out.print("LinkedList: ");
        while (lIte.hasNext()){
            System.out.print(lIte.next() + " ");
        }
        System.out.println();
        System.out.println("ListIterator add");
//        Collections.reverse(aList);
        ListIterator<String> llIte = lList.listIterator(lList.size()-1);
        ListIterator<String> alIte = aList.listIterator(aList.size());
        while (llIte.hasPrevious()){
            if(alIte.hasPrevious()){
                llIte.add(alIte.previous()+ "-a");
            }
            llIte.previous();
            llIte.previous();
        }
        System.out.println(lList);
    }
}
