import java.util.*


fun main() {
    val car = Vehicle("AAA", VehicleType.AUTO, Calendar.getInstance().timeInMillis - 198L * MINUTES_IN_MILLISECONDS, "CARD_009")
//    val moto = Vehicle("ABH", VehicleType.MOTO, Calendar.getInstance())
//    val minibus = Vehicle("AAC", VehicleType.MINI_BUS, Calendar.getInstance())
//    val bus = Vehicle("AAD", VehicleType.BUS, Calendar.getInstance(), "CARD_002")
    val car1 = Vehicle("AAE", VehicleType.AUTO, Calendar.getInstance().timeInMillis - 300L * MINUTES_IN_MILLISECONDS, "CARD_003")
//    val moto1 = Vehicle("AAG", VehicleType.MOTO, Calendar.getInstance())
//    val minibus1 = Vehicle("AAH", VehicleType.MINI_BUS, Calendar.getInstance())
//    val bus1 = Vehicle("AAI", VehicleType.BUS, Calendar.getInstance(), "CARD_004")
//    val car2 = Vehicle("AAJ", VehicleType.AUTO, Calendar.getInstance(), "CARD_005")
//    val moto2 = Vehicle("AAK", VehicleType.MOTO, Calendar.getInstance())
//    val minibus2 = Vehicle("AAL", VehicleType.MINI_BUS, Calendar.getInstance())
//    val bus2 = Vehicle("AAM", VehicleType.BUS, Calendar.getInstance(), "CARD_006")
//    val car3 = Vehicle("AAN", VehicleType.AUTO, Calendar.getInstance(), "CARD_007")
//    val moto3 = Vehicle("AAO", VehicleType.MOTO, Calendar.getInstance())
//    val minibus3 = Vehicle("AAP", VehicleType.MINI_BUS, Calendar.getInstance())
//    val bus3 = Vehicle("AAQ", VehicleType.BUS, Calendar.getInstance(), "CARD_008")
//    val car4 = Vehicle("AAR", VehicleType.AUTO, Calendar.getInstance(), "CARD_009")
//    val moto4 = Vehicle("AAS", VehicleType.MOTO, Calendar.getInstance())
//    val minibus4 = Vehicle("AAT", VehicleType.MINI_BUS, Calendar.getInstance())
//    val bus4 = Vehicle("AAU", VehicleType.BUS, Calendar.getInstance(), "CARD_010")
//    val bus5 = Vehicle("AUC", VehicleType.BUS, Calendar.getInstance(), "CARD_019")
//    val bus6 = Vehicle("ARC", VehicleType.BUS, Calendar.getInstance(), "CARD_019")

    val vehicleList = mutableListOf<Vehicle>(
        car
    )


    val parking: Parking = Parking(mutableSetOf())


    vehicleList.forEach { parking.addVehicle(it) }

    parking.removeVehicle(car1)
    println(parking.validatePlate(car.plate))

}