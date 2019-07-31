package linkedlist

class SingleLinkedList<E> {

    private var size = 0
    private var head: Node<E>? = null
    private var tail: Node<E>? = null

    private inner class Node<E>(internal var element: E, internal var next: Node<E>?)

    // Adding first node value
    fun addFirst(element: E) {
        val currentNode = head
        val newNode = Node<E>(element, currentNode)
        head = newNode
        if (currentNode == null) {
            tail = newNode
        }
        size++
    }

    // Adding last node value
    fun addLast(element: E) {
        val lastTail = tail
        val newNode = Node<E>(element, null)
        tail = newNode
        if (lastTail == null) {
            head = newNode
        } else {
            lastTail.next = newNode
        }
        size++
    }


    // Adding node value on a given index
    fun add(index: Int, element: E) {
        validatePositionIndex(index)
        if (index == 0) {
            addFirst(element)
        } else {
            var currentHead = head
            var previousIndex = index - 1
            for (i in 0 until previousIndex) {
                currentHead = currentHead!!.next
            }
            var next = currentHead!!.next
            var newNode = Node<E>(element, next)
            currentHead.next = newNode
            size++
        }
    }


    // Fetching the first node value
    fun getFirst() = head!!.element

    // Fetching the last node value
    fun getLast() = tail!!.element


    // Fetching the value of a node at a given index
    fun get(index: Int): E {
        validatePositionIndex(index)

        var currentHead = head

        for (i in 0 until index) {
            currentHead = currentHead!!.next
        }


        return currentHead!!.element
    }

    //Updating a node from a  Singly Linked List
    fun set(index: Int, element: E): E {
        validatePositionIndex(index)

        var currentHead = head

        for (i in 0 until index) {
            currentHead = currentHead!!.next
        }

        val oldElement = head!!.element
        currentHead!!.element = element

        return oldElement

    }

    private fun validatePositionIndex(index: Int) {
        if (index in (size + 1)..-1) {
            throw IndexOutOfBoundsException(outOfBoundsMsg(index))
        }
    }

    private fun outOfBoundsMsg(index: Int): String {
        return "Index: $index, Size: $size"
    }

    //Deleting a node from a Singly Linked List

    fun remove(element: E): Boolean {

        var currNode = head

        while (currNode!!.next != null) {
            if (currNode!!.element == element) {

                unlink(currNode)
                return true
            }

            currNode = currNode.next
        }
        return false

    }


    fun remove(index: Int) {

        validatePositionIndex(index)
        var currentHead = head

        for (i in 0 until index) {
            currentHead = currentHead!!.next
        }

        unlink(currentHead!!)
    }

    fun removeFirst() {

        head?.let {
            val next = it.next
            head = null
            head = next
            if (next == null) {
                tail = null
            }
        }
        size--
    }

    fun removeLast() {
        tail?.let {
            val preNode = getPrevious(it)
            tail = preNode

            if (preNode == null) {
                head = null
            } else {
                preNode.next = null
            }
        }
        size--
    }

    //Clearing the LinkedList
    fun clear() : Int {

        var currNode = head
        while (currNode != null) {
            val next = currNode.next
            currNode.next = null
            currNode = next
        }
        tail = null
        head = tail
        size = 0

        return size

    }

    private fun unlink(currNode: Node<E>): E {
        val previousNode = getPrevious(currNode)
        val nextNode = currNode.next
        val currElement = currNode.element

        if (previousNode == null) {
            head = nextNode
        } else {
            previousNode.next = head
            currNode.next = null
        }

        if (nextNode == null) {
            previousNode!!.next = null
            tail = previousNode
        } else {
            previousNode!!.next = currNode
            currNode.next = null
        }

        size--

        return currElement
    }

    private fun getPrevious(node: Node<E>): Node<E>? {

        if (head != null && node == head) return null
        var currentNode = head
        while (currentNode != null) {
            if (currentNode.next == node) {
                return currentNode
            }
            currentNode = currentNode.next
        }

        return null
    }

    operator fun contains(element: E) = indexOf(element) != -1

    // Searching for an element in a Singly Linked List
    fun indexOf(element: E): Int {
        var index = 0
        var x = head
        while (x != null) {
            if (element == x.element)
                return index
            index++
            x = x.next
        }
        return -1
    }

}