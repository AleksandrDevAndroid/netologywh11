import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        addTask();
    }

    public static void addTask() {
        Scanner sc = new Scanner(System.in);
        List<String> taskList = new ArrayList<>();
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
                        showTask(taskList);
                        System.out.println("Введите название задачи:");
                        String inputTask = sc.nextLine();
                        if (taskList.contains(inputTask)) {
                            System.out.println("Данная задача уже есть в списке.");
                            break;
                        }
                        taskList.add(inputTask);
                        System.out.println("Добавлено!");
                        break;
                    case 2:
                        if (taskList.size() == 0) {
                            System.out.println("Ваш список задач пуст.");
                        }
                        showTask(taskList);
                        break;
                    case 3:
                        showTask(taskList);
                        int numTask = Integer.parseInt(sc.nextLine());
                        removeTask(taskList, String.valueOf(numTask));
                        break;
                    case 4:
                        showTask(taskList);
                        String removeTaskName = sc.nextLine();
                        removeTask(taskList, removeTaskName);
                        break;
                    case 5:
                        showTask(taskList);
                        String removeTaskKey = sc.nextLine();
                        removeKeyWord(taskList, removeTaskKey);
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

    public static void showTask(List<String> array) {
        if (!array.isEmpty()) {
            System.out.println("Ваш список дел:");
            Iterator<String> item = array.iterator();
            while (item.hasNext()) {
                String task = item.next();
                System.out.printf("%d. %s\n", array.indexOf(task) + 1, task);
            }
        }
    }
    
    public static void removeTask(List<String> array, String task) {
        if (array.contains(task)) {
            array.remove(task);
        } else
            array.remove(Integer.parseInt(task) - 1);

    }

    public static List<String> removeKeyWord(List<String> array, String word) {
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
