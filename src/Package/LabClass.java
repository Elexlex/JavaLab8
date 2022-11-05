package Package;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

public class LabClass{
    static Generics generics = new Generics();
public static void main(String[] args){
    Scanner num = new Scanner(System.in);
    int menu;
    do {
        generics.outputElements();
        System.out.print("\n\n1. Add element\n2. Delete element\n3. Delete all elements\n4. Add a collection to your list.\n5. Exit\n- ");
        menu = num.nextInt();
        switch (menu) {
            case 1 -> inputElement();
            case 2 -> generics.deleteElement();
            case 3 -> deleteAllElements();
            case 4 -> addCollection();
        }
    }while (menu!=5);
}
private static <T> void deleteAllElements(){
    ArrayDeque<T> deque = generics.getGroup();
    deque.clear();
    generics.setGroup(deque);

}
private static void inputElement(){
    Scanner name = new Scanner(System.in);
    System.out.print("\n\n- Input an element of the list: ");
    String line = name.nextLine();
    generics.addElement(line);
}
    public static void addCollection(){
        ArrayDeque<String> deque = generics.getGroup();
        Collection<String> list = new ArrayList<>();
        for (int i = 0; i<5; i++){
            double number = Math.random()*100;
            list.add(String.valueOf(number));
        }
        deque.addAll(list);
        generics.setGroup(deque);
    }
}
class Generics<GenericType>{
    private ArrayDeque<GenericType> group = new ArrayDeque<>();

    public ArrayDeque<GenericType> getGroup() {
        return group;
    }

    public void setGroup(ArrayDeque<GenericType> group) {
        this.group = group;
    }

    public void deleteElement(){
        if (group.isEmpty()){
            System.out.print("\n\n- Your list is empty.");
            return;
        }
        group.removeFirst();
    }
    public void addElement(GenericType element){
        group.add(element);
    }
    public void outputElements(){
        System.out.print("\n\n- Your list: ");
        for (GenericType element : group)
            System.out.print(element + " // ");
    }
}