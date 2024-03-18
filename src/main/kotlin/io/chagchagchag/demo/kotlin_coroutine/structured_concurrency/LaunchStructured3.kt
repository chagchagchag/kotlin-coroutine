package io.chagchagchag.demo.kotlin_coroutine.structured_concurrency

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()

  runBlocking {
    val job = CoroutineScope(EmptyCoroutineContext).launch {
      log.info("(1)")
      val outerJob = launch {
        launch {
          delay(1000)
          log.info("주문 완료")
        }

        launch {
          delay(1000)
          log.info("결제 완료")
        }

        launch {
          delay(1000)
          log.info("배송 예약 완료")
        }
      }
      outerJob.join()
    }
    job.join()
    log.info("(2)")
  }
}
