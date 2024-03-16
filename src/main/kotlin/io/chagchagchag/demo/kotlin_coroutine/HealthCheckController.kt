package io.chagchagchag.demo.kotlin_coroutine

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController


@RestController
@RequestMapping("/healthcheck")
class HealthCheckController {

  private suspend fun ok(): String = "OK"

  @GetMapping("/ready")
  suspend fun ready(): String{
    return ok()
  }
}