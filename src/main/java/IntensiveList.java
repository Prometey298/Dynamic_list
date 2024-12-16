import java.util.Comparator;

/**
 * Интерфейс для динамического списка.
 *
 * @param <E> тип элементов в списке
 */
public interface IntensiveList<E> {
    /**
     * Возвращает количество элементов в списке.
     *
     * @return количество элементов
     */
    int size();

    /**
     * Добавляет элемент в конец списка.
     *
     * @param element элемент для добавления
     */
    void add(E element);

    /**
     * Добавляет элемент по указанному индексу.
     *
     * @param index индекс, по которому добавляется элемент
     * @param element элемент для добавления
     */
    void add(int index, E element);

    /**
     * Получает элемент по указанному индексу.
     *
     * @param index индекс элемента
     * @return элемент по указанному индексу
     */
    E get(int index);

    /**
     * Заменяет элемент по указанному индексу новым значением.
     *
     * @param index индекс элемента для замены
     * @param element новое значение элемента
     * @return старое значение элемента
     */
    E set(int index, E element);

    /**
     * Удаляет элемент по указанному индексу.
     *
     * @param index индекс элемента для удаления
     * @return удаленный элемент
     */
    E remove(int index);

    /**
     * Очищает список, удаляя все элементы.
     */
    void clear();

    /**
     * Выполняет быструю сортировку элементов списка с использованием заданного компаратора.
     *
     * @param comparator компаратор для сравнения элементов
     */
    void quickSort(Comparator<E> comparator);

    /**
     * Проверяет, отсортирован ли список.
     *
     * @return true, если список отсортирован; иначе false
     */
    boolean isSorted();

    /**
     * Обрезает список до указанного размера.
     *
     * @param size новый размер списка
     */
    void split(int size);
}
