import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        addNotes();
    }

    public static void addNotes() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> arrayList = new ArrayList<>();
        boolean flag = true;
        while (flag) {
            showMenu();
            try {
                int input = Integer.parseInt(sc.nextLine());
                switch (input) {
                    case 0:
                        flag = false;
                        break;
                    case 1:
                        showTask(arrayList);
                        System.out.println("Введите название задачи:");
                        String inputTask = sc.nextLine();
                        if (arrayList.contains(inputTask)) {
                            System.out.println("Данная задача уже есть в списке.");
                            break;
                        }
                        arrayList.add(inputTask);
                        System.out.println("Добавлено!");
                        break;
                    case 2:
                        if (arrayList.size() == 0) {
                            System.out.println("Ваш список задач пуст.");
                        }
                        showTask(arrayList);
                        break;
                    case 3:
                        showTask(arrayList);
                        int removeTaskNum = Integer.parseInt(sc.nextLine());
                        removeTask(arrayList, removeTaskNum - 1);
                        break;
                    case 4:
                        showTask(arrayList);
                        String removeTaskName = sc.nextLine();
                        removeTask(arrayList, removeTaskName);
                        break;
                    case 5:
                        showTask(arrayList);
                        String removeTaskKey = sc.nextLine();
                        removeKeyWord(arrayList, removeTaskKey);
                        break;
                    default:
                        System.out.println("Такого пункта нет в меню.");
                        break;
                }
            } catch (IllegalArgumentException e) {
                System.out.println("Не верный формат ввода,введите число.");
            }
        }
    }

    public static void showTask(ArrayList<String> array) {
        if (array.size() > 0) {
            System.out.println("Ваш список дел:");
            Iterator<String> item = array.iterator();
            while (item.hasNext()) {
                String task = item.next();
                System.out.printf("%d. %s\n", array.indexOf(task) + 1, task);

            }

        }
    }

    public static <T> List<T> removeTask(ArrayList<T> array, Object object) {
        T element = (T) object;
        if (element instanceof Integer) {
            array.remove(Integer.parseInt(String.valueOf(element)));
        } else if (element instanceof String) {
            array.remove(element);
        }
        return array;
    }

    public static ArrayList removeKeyWord(ArrayList array, String word) {
        Iterator<String> iterator = array.iterator();
        while (iterator.hasNext()) {
            String item = iterator.next();
            if (item.contains(word)) {
                iterator.remove();
            }
        }
        return array;
    }

    public static void showMenu() {
        System.out.println("0. Выход из программы\n" +
                "1. Добавить дело\n" +
                "2. Показать дела\n" +
                "3. Удалить дело по номеру\n" +
                "4. Удалить дело по названию\n" +
                "5. Удалить дело по ключевому слову\n");
    }

}
