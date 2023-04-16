package com.example.androidkotlin

class Properties {

    //mutable and read only property
    var name: String = "John"
    var city: String = "Dubai"
    var state: String? = null
    var country: String = "Abudhabi"


}

class Rectangle(val hight: Int, val width: Int) {
    //first way to declare
    val area: Int
        get() = this.width * this.hight

    //second way to declare
    val areaOfRectangle: Int get() = this.width * this.hight

    var shape: String
        get() = shape
        set(value) {
            shape = value
        }

    /*
    If you need to annotate an accessor or change its visibility,
    but you don't want to change the default implementation,
    you can define the accessor without defining its body
     */
    var setterVisibility: String = "Shyam"
        // the setter is private and has the default implementation
        private set
    var setterWithAnnotation: Any? = null
    // annotate the setter with Inject
       // @Inject set

    /*
    Backing fields : A backing field is a private field that stores the value of a property
    backing property : it is a property that has custom getter/setter logic and a private field that stores its value.
     */
    //Backing fields
    var _name: String = ""

    var name: String
    get() = _name
    set(value) {
        _name = value
        println("name is $value")
    }

   //backing property :
    var numberArray = arrayOf(1,2,3,4,5,6)
    private var elementCount : Int = 0
    var elementOfArray : Int
       get() {
           if(numberArray.isEmpty()){
               return  0
           }else{
               return numberArray.count()
           }
       }
    set(value) {
        elementCount = value
    }
}
class CompileTimeConstant {
//    const val PI = 3.14
//
//    @Deprecated(PI) fun printConstant() {
//        println(PI)
//    }

}

class LateInitProperty {
    lateinit var userName: String


    fun setUpName(userName: String) {
        this.userName = userName
    }

    fun printUserName() {
        if(::userName.isInitialized) {
            println("UserName is $userName")
        }else{
            println("Name is not initialize")
        }
    }
}

fun main() {
    val myAddress = Properties()
    println("My Address : ${myAddress.name}, ${myAddress.city}")

    //computed property
    val rectangle = Rectangle(5, 10)
    println(rectangle.area)

    println(rectangle.name)

    println(rectangle.elementOfArray)

    println()

    //LateInit
    var lateinitProperties = LateInitProperty()
    lateinitProperties.printUserName()

    lateinitProperties.setUpName("Shyam")
    lateinitProperties.printUserName()

    lateinitProperties.setUpName("Sudhir")
    lateinitProperties.printUserName()




}