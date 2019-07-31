package sorting

import java.util.*

/*
Sorting
Sorting is the act of ordering elements. The ability of a program to organize and retrieve data quickly and efficiently is incredibly important in software development.
Learning how to effectively sort and retrieve the data you're working with enables you to write better, faster algorithms.

Bubble Sort
This is a very simple sorting algorithm. Because it's also very inefficient, Bubble Sort is not practical for real-world use and is generally only discussed in an academic context. The basic theory behind BubbleSort is that you take an array of integers and iterate through it; for each element at some index  whose value i is greater than the element at the index following it (i.e., index i+1 ), you must swap the two values. The act of swapping these values causes the larger, unsorted values to float to the back (like a bubble) of the data structure until they land in the correct location.

 */


fun main() {
    var scan = Scanner(System.`in`)
    val n = scan.nextInt()
    var unsortedNumbers = Array(n) { 0 }

    if (n in 2..600) {

        for (i in 0 until n) {
            unsortedNumbers[i] = scan.nextInt()
        }

        bubbleSort(unsortedNumbers)
    }
}

fun bubbleSort(unsortedNumbers: Array<Int>) {

    var numberOfSwaps = 0
    var getSortedList = unsortedNumbers
    for (i in 0 until getSortedList.size) {
        // Track number of elements swapped during a single array traversal

        for (j in 0 until getSortedList.size - 1) {
            if (getSortedList[j] > getSortedList[j + 1]) {
                var temporaryNumber = getSortedList[j]
                getSortedList[j] = getSortedList[j + 1]
                getSortedList[j + 1] = temporaryNumber
                numberOfSwaps++
            }
        }

        // If no elements were swapped during a traversal, array is sorted
        if (numberOfSwaps == 0) {
            break
        }
    }

    println("Array is sorted in $numberOfSwaps swaps.")
    println("First Element: ${getSortedList[0]}")
    println("Last Element: ${getSortedList[getSortedList.size-1]}")

}


