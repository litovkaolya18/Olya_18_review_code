package ru.litovka.basic;

/**
 * Узел бинарного дерева поиска.
 * Хранит значение, ссылки на родителя, левый и правый дочерние узлы.
 */
public class Node {

    /** Значение узла (может быть null для пустого корня). */
    private Integer value;

    /** Родительский узел. */
    private Node parent;

    /** Левый потомок. */
    private Node left;

    /** Правый потомок. */
    private Node right;       // Правый потомок

    /** Создаёт пустой узел. */
    public Node() {
        this.value = null;
        this.parent = null;
        this.left = null;
        this.right = null;
    }

    /**
     * Добавляет значение в дерево.
     *
     * @param newValue добавляемое значение
     */
    public void add(int newValue) {
        if (value == null) {
            value = newValue;
            return;
        }

        if (newValue > value) {
            if (right == null) {
                right = new Node();
                right.parent = this;
            }
            right.add(newValue);
        } else {
            if (left == null) {
                left = new Node();
                left.parent = this;
            }
            left.add(newValue);
        }
    }

    /**
     * Проверяет, содержится ли значение в дереве.
     *
     * @param target искомое значение
     * @return true, если значение найдено
     */
    public boolean contains(int target) {
        //FIX_ME: если Integer = null, то сравнение int == Integer может привести к ошибке
        // if (target == value) return true;
        if (value != null && value.equals(target)) {
            return true;
        }

        if (value == null) return false;

        if (target > value) {
            return right != null && right.contains(target);
        } else {
            return left != null && left.contains(target);
        }
    }

    /**
     * Удаляет значение из дерева.
     *
     * @param target удаляемое значение
     * @return true, если удаление выполнено
     */
    public boolean remove(int target) {
        if (value == null) return false;

        if (target < value) {
            return left != null && left.remove(target);
        }
        if (target > value) {
            return right != null && right.remove(target);
        }

        // target == value → удаляем этот узел
        if (left == null && right == null) {
            replaceNode(null);
        } else if (left != null && right == null) {
            replaceNode(left);
        } else if (left == null && right != null) {
            replaceNode(right);
        } else {
            Node successor = right.findMin();
            this.value = successor.value;
            right.remove(successor.value);
        }

        return true;
    }

    /**
     * Заменяет текущий узел другим.
     *
     * @param newNode новый узел
     */
    private void replaceNode(Node newNode) {
        if (parent != null) {
            if (parent.left == this) {
                parent.left = newNode;
            } else {
                parent.right = newNode;
            }
        }
        if (newNode != null) newNode.parent = parent;
    }

    /**
     * Находит минимальный узел в поддереве.
     *
     * @return минимальный узел
     */
    private Node findMin() {
        return (left == null) ? this : left.findMin();
    }

    /**
     * Возвращает строку — левосторонний обход дерева.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        inorder(sb);
        return sb.toString().trim();
    }

    /**
     * Рекурсивный симметричный обход.
     */
    private void inorder(StringBuilder sb) {
        if (left != null) left.inorder(sb);
        if (value != null) sb.append(value).append(" ");
        if (right != null) right.inorder(sb);
    }
}
