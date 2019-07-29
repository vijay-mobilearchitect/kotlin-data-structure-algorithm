package linkedlist
/*
Linked List in Kotlin | Data Structures

Questions

1-Write an API in linked list  which adds all the elements of an array to the list.
2-Write the above API for doubly linked list.
3-Write a snippet to link a node at head of a circular linked list.
4-Write a snippet to unlink a node from circular linked list.
5-Implement toString() method of circular linked list.

*/

fun main(){

    var linkyList = LinkyList<String>()

   // linkyList.addFirst("Vijay")

    linkyList.addLast("Kotlin")
    linkyList.addLast("Java")
    linkyList.addLast("C#")
    linkyList.addLast("C")
    linkyList.addLast("C++")

    linkyList.add(2,"RxJava")
    linkyList.set(3,"RxBinding")


    println("Linked List - First: " + linkyList.getFirst())
    println("Linked List - Last: " + linkyList.getLast())
    println("Linked List at 2 : " + linkyList.get(2))

    println("Linked List at 3 : " + linkyList.get(3))

    println("C++" in linkyList)
    println("Kotlin" in linkyList)

    println("Get First : " + linkyList.getFirst())

    linkyList.removeFirst()

    println("Get First after Removal: " + linkyList.getFirst())

    println("Get Last : " + linkyList.getLast())

    linkyList.removeLast()

    println("Get Last after Removal: " + linkyList.getLast())

    println("RxJava" in linkyList)

    linkyList.remove(3)


    println("RxBinding : "+ "RxBinding" in linkyList)

    println("Is Hello word available? : " + linkyList.remove("Hello"))

    println("Clear LinkedList : "+ linkyList.clear())



}