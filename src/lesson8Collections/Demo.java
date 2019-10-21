package lesson8Collections;

import utils.CollectionUtils;
import utils.MapUtils;

import java.util.*;

public class Demo {
    public static void main(String[] args) {

        List<Book> books = new LinkedList<>();


        books.add(new Book("Война и мир", "Толстой", "Лев", "Николаевич"));
        books.add(new Book("Лолита", "Набоков", "Владимир", "Владимирович"));
        books.add(new Book("Унесённые ветром", "Митчелл", "Маргарет", "Манерлин "));
        runTask1(books);

        books = new LinkedList<>();
        books.add(new Book("Война и мир", "Толстой", "Лев", "Николаевич"));
        books.add(new Book("Лолита", "Набоков", "Владимир", "Владимирович"));
        books.add(new Book("Унесённые ветром", "Митчелл", "Маргарет", "Манерлин "));
        runTask2(books);

        runTask4();

        runTask5();
    }

    private static void runTask1(List<Book> books) {
        System.out.println("1. Создать экземпляр класса LinkedList, разместить в " +
                "нём 3 ссылки на объекты класса Book. " +
                "List< Book > list = new LinkedList< Book >();\n" +
                "Вывести информацию о всех книгах.");
        CollectionUtils.printList(books);

        System.out.println("\nПрограммно удалить из коллекции вторую книгу, вывести на экран информацию о оставшихся книгах.");
        int numberBookForDel = 2;
        books.remove(numberBookForDel - 1);
        CollectionUtils.printList(books);
    }

    private static void runTask2(List<Book> books) {
        System.out.println("\n2. Создать экземпляр класса HashSet, добавить в него " +
                "25 ссылок на экземпляры класса Book, предусмотреть не менее 6 " +
                "одинаковых по значению книг.");
        Set<Book> booksSet = new HashSet<>();
        booksSet.addAll(books);
        booksSet.addAll(books);
        booksSet.addAll(books);
        booksSet.addAll(books);
        booksSet.addAll(books);
        booksSet.addAll(books);
        CollectionUtils.printList(booksSet);

        System.out.println("\nВывести на экран информацию о книгах (содержащихся в " +
                "коллекции HashSet), название которых начинается с гласной буквы.");
        int isVowel = 0;
        for (Book book : booksSet) {
            isVowel = book.getName().toLowerCase().substring(0, 1).replaceAll("[^аяуюиыэеоё]", "").length();
            if (isVowel == 1) {
                System.out.println(book);
            }
        }

        runTask3(booksSet);

    }

    private static void runTask3(Set<Book> booksSet) {
        System.out.println("\n3. Отсортировать коллекцию из задания 2 по фамилии, " +
                "затем по имени, по отчеству (эти поля надо добавить в класс Book " +
                "для автора книги).");

        Set<Book> treeSet = new TreeSet<Book>(Comparator.comparing(Book::getAuthorSurName));
        treeSet.addAll(booksSet);
        System.out.println("sort getAuthorSurName");
        CollectionUtils.printList(treeSet);

        treeSet = new TreeSet<Book>(Comparator.comparing(Book::getAuthorFirstName));
        treeSet.addAll(booksSet);
        System.out.println("sort getAuthorFirstName");
        CollectionUtils.printList(treeSet);

        treeSet = new TreeSet<Book>(Comparator.comparing(Book::getAuthorSecondName));
        treeSet.addAll(booksSet);
        System.out.println("sort getAuthorSecondName");
        CollectionUtils.printList(treeSet);

    }

    private static void runTask4() {
        System.out.println("\n4. Создать экземпляр класса TreeSet, поместить в " +
                "него объекты класса Student(надо его спроектировать).");

        //option 1
        System.out.println("option 1 with compareTo");
        Set<Student> treeSet = new TreeSet<>();
        treeSet.add(new Student("Швед", "Павел", "Олегович", "Группа3"));
        treeSet.add(new Student("Шеин", "Анна", "Витальевна", "Группа1"));
        treeSet.add(new Student("Романовская", "Татьяна", "Витальевна", "Группа2"));
        treeSet.add(new Student("Мигалевич", "Ольга", "Евгеньевна", "Группа3"));
        treeSet.add(new Student("Мигалевич", "Ольга", "Евгеньевна", "Группа1"));
        //Comparator comp = treeSet.comparator(); -- another method sort
        CollectionUtils.printList(treeSet);

        //option 2
        System.out.println("option 2 with StudentComparator");
        Set<Student> treeSet2 = new TreeSet<>(new StudentComparator());
        treeSet2.addAll(treeSet);
        CollectionUtils.printList(treeSet2);

        //option 3
        System.out.println("option 3 with Comparator.comparing");
        Set<Student> treeSet3 = new TreeSet<Student>(Comparator.comparing(Student::getFirstName)
                .thenComparing(Student::getSecondName)
                .thenComparing(Student::getGroup)
                .thenComparing(Student::getSurName));
        treeSet3.addAll(treeSet);
        CollectionUtils.printList(treeSet3);

        System.out.println("\nВывести на экран информацию о каждом чётном в списке " +
                "студенте, каждого нечётного студента удалить из коллекции.");
        Iterator<Student> iterator = treeSet3.iterator();
        int i = 0;
        while (iterator.hasNext()) {
            i++;
            if (i % 2 == 1){
                iterator.next();
                iterator.remove();
            } else{
            iterator.next();
            }
        }
        CollectionUtils.printList(treeSet3);

    }

    private static void runTask5() {
        System.out.println("\n4. Создать экземпляр класса HashMap, разместить в нём " +
                "следующую информацию: в качестве ключа  - категория товара в каталоге " +
                "(catalog.onliner.by) в качестве значения - количество товаров в данной " +
                "категории.");

        Map<String,Integer> goodsHashMap = new HashMap<>();
        goodsHashMap.put("Гаджеты",100);
        goodsHashMap.put("Аудиотехника",1100);
        goodsHashMap.put("Видеоигры",900);
        goodsHashMap.put("Телеведение и видео",1505);
        goodsHashMap.put("Комплектующие",0);
        goodsHashMap.put("Электропитание",0);
        System.out.println(goodsHashMap);

        System.out.println("\nСортировать коллекцию по количеству товаров в каждой " +
                "категории");

        Map<String,Integer> goodsTreeMap = new TreeMap<>();
        goodsTreeMap.putAll(goodsHashMap);
        System.out.println(goodsTreeMap);

        goodsTreeMap = MapUtils.sortByValues(goodsTreeMap);
        System.out.println(goodsTreeMap);

        System.out.println("\nНайти категорию в которой содержится максимальное " +
                "количество товаров.");

        Integer maxValue = 0;
        String keyForMaxValue = "";
        for(Map.Entry e : goodsTreeMap.entrySet()){
            if ((Integer)e.getValue() > maxValue){
                keyForMaxValue = (String) e.getKey();
            }
        }
        System.out.println(keyForMaxValue + " " + goodsTreeMap.get(keyForMaxValue));


        System.out.println("\nУдалить все категории в которых нет ни одного товара " +
                "(предусмотреть такие категории при заполнении коллекции).");

        Set keys = goodsTreeMap.keySet();
        for (Iterator i = keys.iterator(); i.hasNext();) {
            String key = (String) i.next();
            Integer value = (Integer) goodsTreeMap.get(key);
            if (value == 0){
                i.remove();
            }
        }

        System.out.println(goodsTreeMap);
    }

}
