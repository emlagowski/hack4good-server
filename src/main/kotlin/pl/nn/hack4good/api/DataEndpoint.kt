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
    val chart: List<ChartElement>
    ) {

    companion object {
        fun mock(): Response {
            val challenges =
                listOf(Challenge(
                    name = "Switch off your second monitor",
                    streakDays = 3,
                    value = "100"
                ),
                    Challenge(
                    name = "Send a link",
                    streakDays = 3,
                    value = "100"
                )
                )

            val footprints =
                listOf(
                    Footprint(
                    category = "Attachments",
                    emitted = "50",
                    saved = "50",
                    emittedTrend = Trend.UP,
                    savedTrend = Trend.DOWN,
                    tip = "Use OneDrive instead of sending attachment"
                )
            )

            val chart =
                listOf(
                    ChartElement(
                        uv = "590",
                        pv = "800",
                        name = "Page A"
                    ),
                    ChartElement(
                        uv = "590",
                        pv = "800",
                        name = "Page B"
                    ),
                    ChartElement(
                        uv = "590",
                        pv = "800",
                        name = "Page C"
                    )
                )
            return Response(footprints, challenges, chart)
        }
    }
}


data class Footprint(
    val category: String,
    val emitted: String,
    val saved: String,
    val emittedTrend: Trend,
    val savedTrend: Trend,
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
enum class Trend {
    UP, DOWN, NEUTRAL
}