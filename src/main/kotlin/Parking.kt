import javax.rmi.CORBA.Util

data class Parking(
    val vehicles: MutableSet<Vehicle>,
) {
    private val spaces = 20
    private var checkedOutCars: Int = 0
    private var earnings: Int = 0
    fun addVehicle(vehicle: Vehicle): Boolean {
        return when {
            vehicles.contains(vehicle) -> {
                println("Sorry, the has check-in failed")
                false
            }

            (vehicles.size < spaces) -> {
                println("Welcome to AlkeParking! ${vehicle.plate}")
                vehicles.add(vehicle)
                true
            }

            else -> {
                println("Sorry, the check-in failed")
                false
            }
        }
    }

    fun validatePlate(plate: String): Boolean {
        return this.vehicles.any { it.plate == plate }
    }

    fun searchVehicle(plate: String): Vehicle? {
        return vehicles.find { it.plate == plate }
    }

    fun checkOutVehicle(vehicle: Vehicle) {
        val parkingSpace = ParkingSpace(vehicle, this)
        parkingSpace.checkOutVehicle(vehicle.plate, {
            println("Your fee is $it. Come back soon.")
            checkedOutCars++
            earnings += it
            vehicles.remove(vehicle)
        }, { println("Sorry, the check-out failed") })
    }

    fun getEarnings(): Unit{
        val profit = Pair(checkedOutCars, earnings)
        println("${profit.first} vehicles have checked out and have earnings of $${profit.second}")
    }

    fun listVehicles(): Unit = vehicles.forEach(){ println(it.plate) }
}
