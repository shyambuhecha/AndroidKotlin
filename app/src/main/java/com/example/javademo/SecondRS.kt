//import kotlin.math.absoluteValue
//
//interface RocketController {
//    fun igniteEngine()
//    fun shutdownEngine()
//}
//
//abstract class Rocket(
//    val name: String,
//    var velocity: Double,
//    var fuelCapacity: Double,
//    val countdownTime: Int,
//    val targetDistance: Double
//) {
//    private var fuelLevel: Double = 0.0
//    private var elapsedTime: Double = 0.0
//    private var distanceTraveled: Double = 0.0
//    private var isEngineIgnited: Boolean = false
//
//    abstract val fuelConsumptionRate: Double
//
//    fun addFuel(amount: Double) {
//        fuelLevel += amount
//        if (fuelLevel > fuelCapacity) {
//            fuelLevel = fuelCapacity
//        }
//        println("Fuel level is now $fuelLevel liters.")
//    }
//
//    fun countdown() {
//        println("Countdown started for $name.")
//        for (i in countdownTime downTo 1) {
//            println(i)
//            Thread.sleep(1000)
//            if (isAbortSignalReceived()) {
//                println("Abort signal received. Countdown aborted.")
//                return
//            }
//        }
//    }
//
//    fun launch() {
//        if (fuelLevel == 0.0) {
//            println("Cannot launch $name without fuel.")
//            return
//        }
//        println("$name launching!")
//        igniteEngine()
//        while (fuelLevel > 0.0 && distanceTraveled < targetDistance) {
//            val fuelConsumed = fuelConsumptionRate * elapsedTime
//            fuelLevel -= fuelConsumed
//            if (fuelLevel < 0.0) {
//                fuelLevel = 0.0
//            }
//            val acceleration = calculateAcceleration()
//            velocity += acceleration * elapsedTime
//            if (velocity < 0.0) {
//                velocity = 0.0
//            }
//            distanceTraveled += velocity * elapsedTime
//            elapsedTime += 1.0
//            println("$name is $distanceTraveled km away from the launch site at a speed of $velocity km/s.")
//        }
//        shutdownEngine()
//        calculateTravelStats()
//        if (distanceTraveled >= targetDistance) {
//            deploySatellite()
//        }
//    }
//
//    fun calculateTravelStats() {
//        val timeTaken = elapsedTime
//        val averageSpeed = distanceTraveled / timeTaken
//        println("$name traveled a distance of $distanceTraveled km in $timeTaken seconds at an average speed of $averageSpeed km/s.")
//    }
//
//    abstract fun deploySatellite()
//
//    private fun calculateAcceleration(): Double {
//        return if (isEngineIgnited) {
//            -1.0 * fuelConsumptionRate.absoluteValue / (fuelLevel + 1.0)
//        } else {
//            0.0
//        }
//    }
//
//    private fun isAbortSignalReceived(): Boolean {
//        // Logic to check for abort signal goes here.
//        return false
//    }
//}
//
//class SatelliteRocket(
//    name: String,
//    countdownTime: Int,
//    targetDistance: Double,
//    fuelCapacity: Double
//) : Rocket(name, 0.0, fuelCapacity, countdownTime, targetDistance), RocketController {
//
//    override val fuelConsumptionRate: Double = 10.0
//
//    override fun igniteEngine() {
//        isEngineIgnited = true
//        println("$name engine ignited.")
//    }
//
//    override fun shutdownEngine() {
//        isEngineIgnited = false
//        println("$name engine shutdown.")
//    }
//
//    override fun deploySatellite() {
//        println("$name deploying satellite.")
//    }
//}
//
//fun main() {
//    val rocket = SatelliteRocket("Falcon-9", 10, 0.0, 500
