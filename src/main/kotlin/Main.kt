import java.util.*


fun main() {

    val parking = Parking(mutableSetOf())

    val car = Vehicle("AAA", VehicleType.AUTO, setCheckInTime(9,30), "CARD_009")
    val moto = Vehicle("ABH", VehicleType.MOTO, setCheckInTime(10,5))
    val minibus = Vehicle("AAC", VehicleType.MINI_BUS, setCheckInTime(7,0))
    val bus = Vehicle("AAD", VehicleType.BUS, setCheckInTime(6,0), "CARD_002")
    val car1 = Vehicle("AAE", VehicleType.AUTO, setCheckInTime(11,10), "CARD_003")
    val moto1 = Vehicle("AAG", VehicleType.MOTO, setCheckInTime(5,50))
    val minibus1 = Vehicle("AAH", VehicleType.MINI_BUS, setCheckInTime(12,0))
    val bus1 = Vehicle("AAI", VehicleType.BUS, setCheckInTime(10,10), "CARD_004")
    val car2 = Vehicle("AAJ", VehicleType.AUTO, setCheckInTime(11,40), "CARD_005")
    val moto2 = Vehicle("AAK", VehicleType.MOTO, setCheckInTime(8,0))
    val minibus2 = Vehicle("AAL", VehicleType.MINI_BUS, setCheckInTime(6,0))
    val bus2 = Vehicle("AAM", VehicleType.BUS, setCheckInTime(10,3), "CARD_006")
    val car3 = Vehicle("AAN", VehicleType.AUTO, setCheckInTime(3,59), "CARD_007")
    val moto3 = Vehicle("AAO", VehicleType.MOTO, setCheckInTime(2,7))
    val minibus3 = Vehicle("AAP", VehicleType.MINI_BUS, setCheckInTime(10,10))
    val bus3 = Vehicle("AAQ", VehicleType.BUS, setCheckInTime(7,0), "CARD_008")
    val car4 = Vehicle("AAR", VehicleType.AUTO, setCheckInTime(7,15), "CARD_009")
    val moto4 = Vehicle("AAS", VehicleType.MOTO, setCheckInTime(6,45))
    val minibus4 = Vehicle("AAT", VehicleType.MINI_BUS, setCheckInTime(5,45))
    val bus4 = Vehicle("AAU", VehicleType.BUS, setCheckInTime(7,20), "CARD_010")
    val bus5 = Vehicle("ATC", VehicleType.BUS, setCheckInTime(7,0), "CARD_019")
    val bus6 = Vehicle("ATC", VehicleType.BUS, setCheckInTime(9,40), "CARD_019")

    val vehicleList = mutableListOf(
        car, car1, car2, car3, car4,
        moto, moto1, moto2, moto3, moto4,
        bus, bus1, bus2, bus3, bus4, bus5, bus6,
        minibus, minibus1, minibus2, minibus3, minibus4
    )

    parking.addListVehicles(vehicleList)
    parking.removeVehicle(car)
    parking.removeVehicle(bus3)
    parking.removeVehicle(moto2)


    parking.listVehicles()

    println(parking.validatePlate("ATC"))

    parking.addVehicle(bus3)

    parking.getEarnings()

}

fun setCheckInTime(hours: Int,minutes: Int): Calendar {
    val checkInTime = Calendar.getInstance()
    checkInTime.set(Calendar.HOUR_OF_DAY, hours)
    checkInTime.set(Calendar.MINUTE, minutes)
    return checkInTime
}