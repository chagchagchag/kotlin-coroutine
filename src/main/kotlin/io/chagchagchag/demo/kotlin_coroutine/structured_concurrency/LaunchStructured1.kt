package io.chagchagchag.demo.kotlin_coroutine.structured_concurrency

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()

  runBlocking {
    val job = CoroutineScope(EmptyCoroutineContext).launch {
      val order = launch {
        delay(1000)
        log.info("주문 완료")
      }

      val pay = launch {
        delay(1000)
        log.info("결제 완료")
      }

      val delivery_reservation = launch {
        delay(1000)
        log.info("배송 예약 완료")
      }

      log.info("(1)")
      order.join()
      pay.join()
      delivery_reservation.join()
      log.info("(2)")
    }

    job.join()
  }
}
