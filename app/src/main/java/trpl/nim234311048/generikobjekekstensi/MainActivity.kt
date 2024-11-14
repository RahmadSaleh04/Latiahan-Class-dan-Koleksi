package trpl.nim234311048.generikobjekekstensi

// Data class untuk Event
data class Event(
    val title: String,
    val description: String? = null,
    val daypart: Daypart,
    val durationInMinutes: Int
)

// Enum untuk Daypart
enum class Daypart {
    MORNING,
    AFTERNOON,
    EVENING,
}

// Ekstensi properti untuk menentukan durasi event
val Event.durationOfEvent: String
    get() = if (this.durationInMinutes < 60) "short" else "long"

fun main() {
//    val event = Event(
//        title = "Study Kotlin",
//        description = "Commit to studying Kotlin at least 15 minutes per day.",
//        daypart = Daypart.EVENING,
//        durationInMinutes = 15
//    )
//    println(event)

    // Membuat daftar event
    val events = mutableListOf(
        Event(title = "Wake up", description = "Time to get up", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Bath", daypart = Daypart.MORNING, durationInMinutes = 0),
        Event(title = "Eat breakfast", daypart = Daypart.MORNING, durationInMinutes = 15),
        Event(title = "Learn about Kotlin", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event(title = "Nap", description = "Nap Time", daypart = Daypart.AFTERNOON, durationInMinutes = 30),
        Event(title = "Practice Compose", daypart = Daypart.AFTERNOON, durationInMinutes = 60),
        Event(title = "Watch latest DevBytes video", daypart = Daypart.AFTERNOON, durationInMinutes = 10),
        Event(title = "Check out latest Android Jetpack library", daypart = Daypart.EVENING, durationInMinutes = 45),
        Event(title = "Sleep at night", daypart = Daypart.EVENING, durationInMinutes = 45)
    )

    // Menampilkan semua event
    println("Daftar Event:")
    events.forEach { println(it) }

    println()

    // Tugas 4: Filter event dengan durasi kurang dari 60 menit
    val shortEvents = events.filter { it.durationInMinutes < 60 }
    println("Tugas 4: Anda memiliki ${shortEvents.size} event singkat.")

    println()

    // Tugas 5: Mengelompokkan event berdasarkan Daypart
    val groupedEvents = events.groupBy { it.daypart }
    println("Tugas 5: Grup Event berdasarkan Daypart:")
    groupedEvents.forEach { (daypart, events) ->
        println("$daypart: ${events.size} events")
    }

    println()

    // Tugas 6: Menampilkan event terakhir
    println("Tugas 6: Event terakhir hari ini: ${events.last().title}")

    println()

    // Tugas 7: Menampilkan durasi event pertama
    println("Tugas 7: Durasi event pertama hari ini: ${events.first().durationOfEvent}")
}
