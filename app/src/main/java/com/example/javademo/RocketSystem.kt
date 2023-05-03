//package com.example.javademo
//
//import kotlin.concurrent.thread
//import kotlin.system.exitProcess
//
//class RocketSystem {}
//fun main() {
//    println("Welcome to the rocket launching system!")
//    println("Please enter the countdown time in seconds:")
//
//    val countdownTime = readLine()?.toIntOrNull()
//
//    if (countdownTime == null || countdownTime <= 0) {
//        println("Invalid countdown time!")
//        exitProcess(0)
//    }
//
//    println("Countdown started:")
//
//    for (i in countdownTime downTo 1) {
//        println(i)
//        Thread.sleep(1000)
//    }
//
//    thread {
//        igniteEngine()
//    }
//
//    println("Engine ignited!")
//
//    thread {
//        startThrust()
//    }
//
//    println("Thrust started!")
//
//    Thread.sleep(5000)
//
//    println("Rocket has launched!")
//}
//
//fun igniteEngine() {
//    println("Igniting engine...")
//    // Code to ignite the rocket engine
//}
//
//fun startThrust() {
//    println("Starting thrust...")
//    // Code to start the rocket thrust
//}