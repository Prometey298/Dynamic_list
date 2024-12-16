import java.util.Arrays;
import java.util.Comparator;

/**
 * Реализация динамического списка на основе массива.
 *
 * @param <E> тип элементов в списке
 */
public class ArrayList_DimaBrovko<E> implements IntensiveList<E> {
    private Object[] elements;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList_DimaBrovko() {
        elements = new Object[DEFAULT_CAPACITY];
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void add(E element) {
        ensureCapacity();
        elements[size++] = element;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
        ensureCapacity();
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        checkIndex(index);
        return (E) elements[index];
    }

    @Override
    public E set(int index, E element) {
        checkIndex(index);
        E oldValue = (E) elements[index];
        elements[index] = element;
        return oldValue;
    }

    @Override
    public E remove(int index) {
        checkIndex(index);
        E removedElement = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        }
        elements[--size] = null; // Удаляем ссылку на объект для сборщика мусора
        return removedElement;
    }

    @Override
    public void clear() {
        Arrays.fill(elements, null);
        size = 0;
        elements = new Object[DEFAULT_CAPACITY]; // Сбрасываем емкость к дефолту
    }

    @Override
    public void quickSort(Comparator<E> comparator) {
        quickSort(elements, 0, size - 1, comparator);
    }

    private void quickSort(Object[] array, int low, int high, Comparator<E> comparator) {
        if (low < high) {
            int pivotIndex = partition(array, low, high, comparator);
            quickSort(array, low, pivotIndex - 1, comparator);
            quickSort(array, pivotIndex + 1, high, comparator);
        }
    }

    private int partition(Object[] array, int low, int high, Comparator<E> comparator) {
        E pivot = (E) array[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (comparator.compare((E) array[j], pivot) <= 0) {
                i++;
                swap(array, i, j);
            }
        }
        swap(array, i + 1, high);
        return i + 1;
    }

    private void swap(Object[] array, int i, int j) {
        Object temp = array[i];
        array[i] = array[j];
        array[j] = temp;
    }

    @Override
    public boolean isSorted() {
        for (int i = 1; i < size; i++) {
            if (((Comparable<E>) elements[i]).compareTo((E) elements[i - 1]) < 0) {
                return false;
            }
        }
        return true;
    }

    @Override
    public void split(int size) {
        if (size < 0 || size > this.size) {
            throw new IllegalArgumentException("Некорректный размер: " + size);
        }

        this.size = size;

        for (int i = size; i < elements.length; i++) {
            elements[i] = null; // Удаляем лишние элементы
        }

        // Если необходимо уменьшить емкость массива:
        if (size < elements.length / 2) {
            elements = Arrays.copyOf(elements, Math.max(DEFAULT_CAPACITY, size));
        }

    }

    private void ensureCapacity() {
        if (size == elements.length) {
            elements = Arrays.copyOf(elements, elements.length * 2);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона: " + index);
        }
    }
}
