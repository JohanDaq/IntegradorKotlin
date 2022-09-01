data class Parking(
    val vehicles: MutableSet<Vehicle>,
) {
    private val spaces = 20

    fun addVehicle(vehicle: Vehicle): Boolean{
        return when{
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

    fun validatePlate(plate: String): Boolean{
        return this.vehicles.any { it.plate == plate }
    }

    fun removeVehicle(vehicle: Vehicle){
        checkOutVehicle(vehicle)
        vehicles.remove(vehicle)
    }

    private fun checkOutVehicle(vehicle: Vehicle){
        val parkingSpace = ParkingSpace(vehicle,this)
        val fee = parkingSpace.calculateFee(vehicle.type,(parkingSpace.parkedTime).toInt())
        parkingSpace.checkOutVehicle(vehicle.plate,{ println("Your fee is $fee. Come back soon.") },{ println("Sorry, the check-out failed") })
    }
}
