package pl.nn.hack4good.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
class DataEndpoint {

    @GetMapping("/data")
    fun get(@RequestParam userSwitch: Boolean = false): Response {
        if (userSwitch) {
            return Response.anotherMock()
        }
        return Response.mock()
    }
}
data class Response(
    val name: String,
    val footprints: List<Footprint>,
    val challenges: List<Challenge>,
    val chart: List<ChartElement>,
    val rankings: List<Ranking>
    ) {

    companion object {
        fun mock(): Response {
            val challenges = listOf(Challenge(
                    name = "Send files on cloud instead of mail attachments",
                    streakDays = 2,
                    value = "50"
                ),
                Challenge(
                    name = "Don't use external monitor if you don't have to",
                    streakDays = 1,
                    value = "100"
                ),
                Challenge(
                    name = "Turn of your computer after finishing work",
                    streakDays = 3,
                    value = "300"
                )
                )
            val footprints = listOf(
                    Footprint(
                    category = "Electricity",
                    emitted = "100",
                    emittedTrend = Trend.UP,
                    tip = "You can turn off your secondary screen"
                ),
                Footprint(
                    category = "Video",
                    emitted = "50",
                    emittedTrend = Trend.UP,
                    tip = "You can stream music from Spotify instead of YT"
                ),
                Footprint(
                    category = "Bandwidth",
                    emitted = "50",
                    emittedTrend = Trend.DOWN,
                    tip = "You send a OneDrive link instead of attachment"
                ),
                Footprint(
                    category = "Storage",
                    emitted = "10",
                    emittedTrend = Trend.DOWN,
                    tip = "Clean up files that you don't use"
                ),
                Footprint(
                    category = "Printing",
                    emitted = "80",
                    emittedTrend = Trend.UP,
                    tip = "Print double sided"
                )
            )
            val chart = listOf(
                    ChartElement(
                        uv = "1000",
                        pv = "1000",
                        name = "Monday"
                    ),
                    ChartElement(
                        uv = "975",
                        pv = "1200",
                        name = "Tuesday"
                    ),
                    ChartElement(
                        uv = "950",
                        pv = "1100",
                        name = "Wednesday"
                    ),
                    ChartElement(
                        uv = "925",
                        pv = "800",
                        name = "Thursday"
                    ),
                    ChartElement(
                        uv = "900",
                        pv = "750",
                        name = "Friday"
                    ),
                    ChartElement(
                        uv = "875",
                        pv = "950",
                        name = "Saturday"
                    ),
                    ChartElement(
                        uv = "675",
                        pv = "550",
                        name = "Saturday"
                    )
                )
            val rankings = listOf(
                Ranking(
                   leader = RankingPerson("https://randomuser.me/api/portraits/women/43.jpg", 1, 220) ,
                   before = RankingPerson("https://randomuser.me/api/portraits/thumb/men/61.jpg", 13, 4500) ,
                   me = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 14, 4678) ,
                   after = RankingPerson("https://randomuser.me/api/portraits/thumb/men/77.jpg", 15, 4900)
                ), Ranking (
                    leader = RankingPerson("https://randomuser.me/api/portraits/thumb/men/72.jpg", 1, 2000) ,
                    before = RankingPerson("https://randomuser.me/api/portraits/women/40.jpg", 100, 10101) ,
                    me = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 101, 12000) ,
                    after = RankingPerson("https://randomuser.me/api/portraits/women/49.jpg", 102, 13000)
                )
            )
            return Response("John Kowalski",footprints, challenges, chart, rankings)
        }

        fun anotherMock(): Response {
            val challenges = listOf(
                Challenge(
                    name = "Turn of your computer after finishing work",
                    streakDays = 3,
                    value = "300"
                ),
                Challenge(
                name = "Send files on cloud instead of mail attachments",
                streakDays = 2,
                value = "50"
            ),
            Challenge(
                name = "Disable your camera while presenting screen",
                streakDays = 1,
                value = "100"
            )
            )
            val footprints = listOf(
                Footprint(
                    category = "Bandwidth",
                    emitted = "50",
                    emittedTrend = Trend.DOWN,
                    tip = "You send a OneDrive link instead of attachment"
                ),
                Footprint(
                    category = "Electricity",
                    emitted = "100",
                    emittedTrend = Trend.UP,
                    tip = "You can turn off your secondary screen"
                ),

                Footprint(
                    category = "Storage",
                    emitted = "10",
                    emittedTrend = Trend.DOWN,
                    tip = "Clean up files that you don't use"
                ),
                Footprint(
                    category = "Video",
                    emitted = "50",
                    emittedTrend = Trend.UP,
                    tip = "You can stream music from Spotify instead of YT"
                ),
                Footprint(
                    category = "Printing",
                    emitted = "80",
                    emittedTrend = Trend.UP,
                    tip = "Print double sided"
                )
            )
            val chart = listOf(
                ChartElement(
                    uv = "1200",
                    pv = "1000",
                    name = "Saturday"
                ),
                ChartElement(
                    uv = "975",
                    pv = "1200",
                    name = "Sunday"
                ),
                ChartElement(
                    uv = "950",
                    pv = "1100",
                    name = "Monday"
                ),
                ChartElement(
                    uv = "925",
                    pv = "800",
                    name = "Tuesday"
                ),
                ChartElement(
                    uv = "890",
                    pv = "750",
                    name = "Thursday"
                ),
                ChartElement(
                    uv = "875",
                    pv = "950",
                    name = "Friday"
                ),
                ChartElement(
                    uv = "575",
                    pv = "550",
                    name = "Saturday"
                )
            )
            val rankings = listOf(
                Ranking(
                    leader = RankingPerson("https://randomuser.me/api/portraits/women/42.jpg", 1, 220) ,
                    before = RankingPerson("https://randomuser.me/api/portraits/thumb/men/60.jpg", 13, 4500) ,
                    me = RankingPerson("https://randomuser.me/api/portraits/thumb/men/74.jpg", 14, 4678) ,
                    after = RankingPerson("https://randomuser.me/api/portraits/thumb/men/76.jpg", 15, 4900)
                ), Ranking (
                    leader = RankingPerson("https://randomuser.me/api/portraits/thumb/men/71.jpg", 1, 2000) ,
                    before = RankingPerson("https://randomuser.me/api/portraits/women/39.jpg", 100, 10101) ,
                    me = RankingPerson("https://randomuser.me/api/portraits/thumb/men/74.jpg", 101, 12000) ,
                    after = RankingPerson("https://randomuser.me/api/portraits/women/48.jpg", 102, 13000)
                )
            )
            return Response("Niko Bellic", footprints, challenges, chart, rankings)
        }
    }
}


data class Footprint(
    val category: String,
    val emitted: String,
    val emittedTrend: Trend,
    val tip: String
    )

data class Challenge(
    val name: String,
    val value: String,
    val streakDays: Int
)

data class ChartElement(
    val name: String,
    val uv: String,
    val pv: String
)

data class Ranking(
    val leader: RankingPerson,
    val me: RankingPerson,
    val before: RankingPerson,
    val after: RankingPerson
)

data class RankingPerson(
    val url: String,
    val value: Int,
    val position: Int
)

enum class Trend {
    UP, DOWN, NEUTRAL
}