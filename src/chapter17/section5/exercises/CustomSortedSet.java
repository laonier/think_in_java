package chapter17.section5.exercises;

import common.generator.GeneratorUtil;
import common.generator.RandomGenerator;

import java.util.*;

public class CustomSortedSet<T> implements SortedSet<T> {
    private final List<T> list;
    public CustomSortedSet(){
        list = new LinkedList<>();
    }
    private CustomSortedSet(List<T> list){
        this.list = list;
    }

    @Override
    public boolean equals(Object obj) {
        return obj instanceof CustomSortedSet && ((CustomSortedSet)obj).list.equals(list);
    }

    @Override
    public int hashCode() {
        return list.hashCode();
    }

    @Override
    public String toString() {
        return list.toString();
    }

    @Override
    public Comparator<? super T> comparator() {
        return null;
    }

    @Override
    public SortedSet<T> subSet(T fromElement, T toElement) {
        checkForNull(toElement);
        checkForNull(fromElement);
        int toIndex = list.indexOf(toElement);
        checkForValidIndex(toIndex);
        int fromIndex = list.indexOf(fromElement);
        checkForValidIndex(fromIndex);
        return new CustomSortedSet<>(list.subList(fromIndex, toIndex));
    }

    @Override
    public SortedSet<T> headSet(T toElement) {
        checkForNull(toElement);
        int toIndex = list.indexOf(toElement);
        checkForValidIndex(toIndex);
        return new CustomSortedSet<>(list.subList(0, toIndex));
    }

    @Override
    public SortedSet<T> tailSet(T fromElement) {
        checkForNull(fromElement);
        int fromIndex = list.indexOf(fromElement);
        checkForValidIndex(fromIndex);
        return new CustomSortedSet<>(list.subList(fromIndex, list.size()-1));
    }

    @Override
    public T first() {
        return list.get(0);
    }

    @Override
    public T last() {
        return list.get(size()-1);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public boolean isEmpty() {
        return list.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        checkForNull(o);
        return Collections.binarySearch((List<Comparable<T>>)list, (T)o) >= 0;
    }

    @Override
    public Iterator<T> iterator() {
        return list.iterator();
    }

    @Override
    public Object[] toArray() {
        return list.toArray();
    }

    @Override
    public <T> T[] toArray(T[] a) {
        return list.toArray(a);
    }

    @Override
    public boolean add(T s) {
        checkForNull(s);
        int ip = Collections.binarySearch((List<Comparable<T>>)list, s);
        if (ip < 0) {
            ip = -(ip + 1);
            if(ip == size()){
                list.add(s);
            } else {
                list.add(ip, s);
            }
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(Object o) {
        checkForNull(o);
        return list.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        checkForNullElements(c);
        return list.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        checkForNull(c);
        checkForNullElements(c);
        boolean result = false;
        for(T t: c){
            result |= add(t);
        }
        return result;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        checkForNullElements(c);
        return list.retainAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        checkForNullElements(c);
        return list.removeAll(c);
    }

    @Override
    public void clear() {
        list.clear();
    }
    private void checkForNull(Object o){
        if (o == null){
            throw new NullPointerException();
        }
    }
    private void checkForValidIndex(int index){
        if (index < 0){
            throw new IllegalArgumentException();
        }
    }
    private void checkForNullElements(Collection<?> c){
        for(Object s: c){
            if (s == null) {
                throw new IllegalArgumentException();
            }
        }
    }
    public static void main(String[] args) {
        Set<String> set = new CustomSortedSet<>();
        GeneratorUtil.fill(set, 10, RandomGenerator.String.class);
        System.out.println(set);
        System.out.println("so");
    }
}
