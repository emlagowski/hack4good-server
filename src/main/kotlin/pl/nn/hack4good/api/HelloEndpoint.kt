package pl.nn.hack4good.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class TestEndpoint {

    @GetMapping("/hello")
    fun test(): Response {
        return Response("Hubert")
    }
}

data class Response(val name: String)