package com.example.androidkotlin

import kotlin.reflect.KProperty

class DelegateProperty {
}

class Example {
    var name: String by Delegate()
}
class Delegate {
    private var value: String = ""

    operator fun getValue(example: Example, property: KProperty<*>): String {
        println("Getting Value : $value")
        return value
    }

    operator fun setValue(example: Example, property: KProperty<*>, newValue: String) {
        println("new value : $newValue")
        value = newValue
    }
}

fun main() {
    val example = Example()
    example.name = "Shyam"
    example.name

}