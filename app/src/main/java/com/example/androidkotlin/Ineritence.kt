package com.example.androidkotlin

class Ineritence {

}
fun main() {
    //single
    val myCat = Cat("catty")
    myCat.makeSound()

    //multi level
    val myDog1 = Dog1("Sheru")
    println("${myDog1.name} is my dog")
    myDog1.eat()
    myDog1.makeSound()
}

//single
open class Animal(val name: String) {
    open fun makeSound() {
        println("$name is making a sound.")
    }
}


class Cat(name: String) : Animal(name) {
    override fun makeSound() {
        println("$name is meowing.")
    }
}
//multilevel

open class Dog(name: String) : Animal(name) {
    override fun makeSound() {
        super.makeSound()
        println("$name is sound Bhow Bhow")
    }
}

open class Dog1(name: String) : Dog(name) {
   fun eat() {
       println("$name is eating")
   }
}
//hiarchial

//dimond problem : Hybrid inheritence (hiarchial + multiple)
open class person(val name: String,val surname: String) {
    open fun personFullName(name: String) {
        println("person full name is $name $surname                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                             ")
    }
}

interface work {
    fun workAtOffice()
}