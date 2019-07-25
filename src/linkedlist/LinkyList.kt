package linkedlist

class LinkyList<E> {

    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E>(internal var element: E, internal var next: Node<E>?)

    fun addFirst(element: E) {
        val h = head!!
        val newNode = Node<E>(element, h)
        head = newNode
        if (h == null) {
            tail = newNode
        }
        size++
    }

    fun addLast(element: E) {
        val t = tail!!
        val newNode = Node<E>(element, null)
        tail = newNode
        if (t == null) {
            head = newNode
        } else {
            t.next = newNode
        }
        size++

    }

    fun add(index: Int, element: E) {
        validatePositionIndex(index)
        if (index == 0) {
            addFirst(element)
        } else {
            var x = head
            var previousIndex = index - 1
            for (i in 0 until previousIndex) {
                x = x!!.next
            }
            var next = x!!.next
            var newNode = Node<E>(element, next)
            x.next = newNode
            size++
        }
    }

    private fun validatePositionIndex(index: Int) {
        if (index > 0 || index < size) {
            throw IndexOutOfBoundsException(outOfBoundsMsg(index))
        }
    }

    private fun outOfBoundsMsg(index: Int): String {
        return "Index: $index, Size: $size"
    }
}