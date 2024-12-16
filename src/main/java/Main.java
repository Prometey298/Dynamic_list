import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        // Создаем экземпляр нашего динамического списка
        IntensiveList<Integer> list = new ArrayList_DimaBrovko<>();

        // Добавляем элементы в список
        list.add(5);
        list.add(3);
        list.add(8);
        list.add(1);
        list.add(4);

        // Выводим текущее состояние списка
        System.out.println("Список после добавления элементов: ");
        printList(list);

        // Получаем элемент по индексу
        System.out.println("Элемент по индексу 2: " + list.get(2));

        // Заменяем элемент по индексу
        list.set(2, 10);
        System.out.println("Список после замены элемента по индексу 2: ");
        printList(list);

        // Удаляем элемент по индексу
        list.remove(1);
        System.out.println("Список после удаления элемента по индексу 1: ");
        printList(list);

        // Проверяем, отсортирован ли список
        System.out.println("Список отсортирован: " + list.isSorted());

        // Сортируем список
        list.quickSort(Comparator.naturalOrder());
        System.out.println("Список после быстрой сортировки: ");
        printList(list);

        // Проверяем, отсортирован ли список после сортировки
        System.out.println("Список отсортирован: " + list.isSorted());

        // Обрезаем список до размера 3
        list.split(3);
        System.out.println("Список после обрезки до размера 3: ");
        printList(list);

        // Очищаем список
        list.clear();
        System.out.println("Список после очистки: ");
        printList(list);
    }

    private static void printList(IntensiveList<?> list) {
        for (int i = 0; i < list.size(); i++) {
            System.out.print(list.get(i) + " ");
        }
        System.out.println();
    }
}
