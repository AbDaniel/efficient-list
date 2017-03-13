import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Created by daniel on 3/10/17.
 */

public class EfficientList<T> implements List<T> {

    private IndexedBinaryTree<T> root;

    public int size() {
        int size = 0;
        IndexedBinaryTree<T> currentNode = root;
        while (currentNode != null) {
            size += currentNode.leftTreeSize + 1;
            currentNode = currentNode.right;
        }

        return size;
    }

    public boolean isEmpty() {
        return false;
    }

    public boolean contains(Object o) {
        return false;
    }

    public Iterator<T> iterator() {
        return null;
    }

    public Object[] toArray() {
        return new Object[0];
    }

    public <T1> T1[] toArray(T1[] a) {
        return null;
    }

    public boolean add(T t) {
        IndexedBinaryTree<T> nodeToBeInserted = new IndexedBinaryTree<>(t);
        if (root == null) {
            root = nodeToBeInserted;
            return true;
        }

        IndexedBinaryTree<T> currentNode = root;
        while (currentNode.right != null) {
            currentNode = currentNode.right;
        }

        currentNode.right = nodeToBeInserted;
        return true;
    }

    public boolean remove(Object o) {
        return false;
    }

    public boolean containsAll(Collection<?> c) {
        return false;
    }

    public boolean addAll(Collection<? extends T> c) {
        return false;
    }

    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    public boolean removeAll(Collection<?> c) {
        return false;
    }

    public boolean retainAll(Collection<?> c) {
        return false;
    }

    public void clear() {

    }

    public T get(int index) {
        IndexedBinaryTree<T> currentNode = root;
        while (index != currentNode.leftTreeSize) {
            if (index < currentNode.leftTreeSize) currentNode = currentNode.left;
            else {
                index -= currentNode.leftTreeSize + 1;
                currentNode = currentNode.right;
            }
        }
        return currentNode.data;
    }

    public T set(int index, T element) {
        return null;
    }

    public void add(int index, T element) {
        if (index < 0 || index > this.size()) throw new IndexOutOfBoundsException();

        IndexedBinaryTree<T> elementTobeInserted = new IndexedBinaryTree<>(element);

        if (index == this.size()) {
            this.add(element);
            return;
        }

        int i = index;
        IndexedBinaryTree<T> currentNode = root;
        while (i != currentNode.leftTreeSize) {
            if (i < currentNode.leftTreeSize) {
                currentNode.increaseLeftTreeSize(1);
                currentNode = currentNode.left;
            } else {
                i -= currentNode.leftTreeSize + 1;
                currentNode = currentNode.right;
            }
        }

        if (currentNode.left == null) {
            currentNode.increaseLeftTreeSize(1);
            currentNode.left = elementTobeInserted;
        } else {
            currentNode.increaseLeftTreeSize(1);
            currentNode = currentNode.left;
            while (currentNode.right != null) {
                currentNode = currentNode.right;
            }

            currentNode.right = elementTobeInserted;
        }
    }

    public T remove(int index) {
        return null;
    }

    public int indexOf(Object o) {
        return 0;
    }

    public int lastIndexOf(Object o) {
        return 0;
    }

    public ListIterator<T> listIterator() {
        return null;
    }

    public ListIterator<T> listIterator(int index) {
        return null;
    }

    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }

    private static class IndexedBinaryTree<T> {
        T data;
        IndexedBinaryTree<T> left;
        IndexedBinaryTree<T> right;
        int leftTreeSize;

        IndexedBinaryTree(T data) {
            this.data = data;
        }

        void increaseLeftTreeSize(int i) {
            this.leftTreeSize += 1;
        }
    }

}
