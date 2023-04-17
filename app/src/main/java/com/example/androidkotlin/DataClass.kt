package com.example.androidkotlin

class DataClass {

}

data class Person1(val name: String, val age: Int) {

}

fun main() {
    val person1 = Person1("Shyam",21)
    //the copy() function is a built-in function that is used to create
    // a new object that is a copy of the original object with some
    // or all of its properties modified.
    val person2 = person1.copy("Raj")



    println(person2)
}