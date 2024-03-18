package io.chagchagchag.demo.kotlin_coroutine.structured_concurrency

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()

  runBlocking {
    val job = CoroutineScope(EmptyCoroutineContext).launch {
      val applePrice = async {
        delay(1000)
        5000
      }
      val bananaPrice = async {
        delay(1000)
        7000
      }
      val carrotPrice = async {
        delay(1000)
        3000
      }

      log.info("(1)")
      val sum = applePrice.await() + bananaPrice.await() + carrotPrice.await()
      log.info("sum = $sum")
      log.info("(2)")
      assert(sum == 5000 + 7000 + 3000)
    }

    job.join() // join() 하지 않으면 main 문은 자기 마음대로 끝냅니다.
  }
}
