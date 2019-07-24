package arrays

import java.util.*

/*
Create an array of numbers between 0 to 500 that are multiples of 10.
- arrayOfNumbers()
Create an array with all the even indexed numbers of given array.
Write a snippet for finding a transpose of a matrix.
Write a snippet to append elements of two arrays.
Write snippet to convert wrapper typed array to a primitive array.
 */

//Create an array of numbers between 0 to 500 that are multiples of 10.
fun arrayOfNumbers() {
    var listOfMultipleOf10 = Array(51) { it * 10 }
    println(listOfMultipleOf10.toList())
}

//Create an array with all the even indexed numbers of given array.
fun arrayOfEvenIndexedNumbers(arr:Array<Int>) : IntArray
{
    return arr.filterIndexed{index,_ -> index%2==0 }.toIntArray()
}

//Write a snippet for finding a transpose of a matrix.
//Description :
// Transpose of a matrix is obtained by changing rows to columns and columns to rows.
// In other words, transpose of A[][] is obtained by changing A[i][j] to A[j][i].

fun transposeMatrix(inputTransposeMatrix: Array<Array<Int>>): Array<IntArray> {

    var transposeMatrix = Array(inputTransposeMatrix.size){IntArray(inputTransposeMatrix[0].size)}

    for (rows in 0 until inputTransposeMatrix.size )
    {
        for (columns in 0 until inputTransposeMatrix.size)
        {
            transposeMatrix[columns][rows] = inputTransposeMatrix[rows][columns]
        }
    }

    return transposeMatrix
}

//Write a snippet to append elements of two arrays.
fun appendTwoArray()
{
    val arrayOne = arrayOf(1,2,3)
    val arraySecond= arrayOf(9,8,7)

    val appendArray = arrayOne +arraySecond

    println(Arrays.toString(appendArray))

}

//Write snippet to convert wrapper typed array to a primitive array.

/*
Primitive type arrays

Kotlin also has specialized classes to represent arrays of primitive types without boxing overhead:
 ByteArray, ShortArray, IntArray and so on. These classes have no inheritance relation to the Array class,
 but they have the same set of methods and properties. Each of them also has a corresponding factory function:
 */


fun wrapperTypeToPremitive()
{
    val arrayIntWrapper = arrayOf(1,2,4,5,6)
    val arrayIntPrimitive = arrayIntWrapper.toIntArray()

    println(Arrays.toString(arrayIntPrimitive))

    val arrayDoubleWrapper = arrayOf(1.2,2.0,9.12,22.1)
    val arrayDoublePrimitive= arrayDoubleWrapper.toDoubleArray()

    println(Arrays.toString(arrayDoublePrimitive))


}

fun main()
{

    arrayOfNumbers()

    println(arrayOfEvenIndexedNumbers(arrayOf(1,2,3,4,5,6,7)).toList()) // Answer : [1, 3, 5, 7]

    println("Input Array : " + Arrays.deepToString(arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9))))
    println("Transpose Array : " + Arrays.deepToString(transposeMatrix(arrayOf(arrayOf(1,2,3), arrayOf(4,5,6), arrayOf(7,8,9)))))

    appendTwoArray()

    wrapperTypeToPremitive()

}