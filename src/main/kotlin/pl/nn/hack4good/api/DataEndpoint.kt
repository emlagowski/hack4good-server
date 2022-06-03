package pl.nn.hack4good.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class DataEndpoint {

    @GetMapping("/data")
    fun get(): Response {
        return Response.mock()
    }
}
data class Response(
    val footprints: List<Footprint>,
    val challenges: List<Challenge>,
    val chart: List<ChartElement>,
    val rankings: List<Ranking>
    ) {

    companion object {
        fun mock(): Response {
            val challenges =
                listOf(Challenge(
                    name = "Send files on cloud instead of mail attachments",
                    streakDays = 2,
                    value = "50"
                ),
                Challenge(
                    name = "Use one display while working on single app",
                    streakDays = 1,
                    value = "100"
                ),
                Challenge(
                    name = "Turn of your computer after finishing work",
                    streakDays = 3,
                    value = "300"
                )
                )

            val footprints =
                listOf(
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
                    category = "Bandwith",
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

            val chart =
                listOf(
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
                   leader = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 1, 220) ,
                   before = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 13, 4500) ,
                   me = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 14, 4678) ,
                   after = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 15, 4900)
                ), Ranking (
                    leader = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 1, 2000) ,
                    before = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 100, 10101) ,
                    me = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 101, 12000) ,
                    after = RankingPerson("https://randomuser.me/api/portraits/thumb/men/75.jpg", 1102, 13000)
                )
            )

            return Response(footprints, challenges, chart, rankings)
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