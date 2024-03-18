package io.chagchagchag.demo.kotlin_coroutine.structured_concurrency

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()

  runBlocking {
    val job = CoroutineScope(EmptyCoroutineContext).launch {
      val sum = sumCart2()
      log.info("(1)")
      log.info("cartSum = $sum")
      log.info("(2)")
      assert(sum == 5000 + 7000 + 3000)
    }

    job.join()
  }
}

suspend fun sumCart2() : Int{
  return withContext(Dispatchers.IO){
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
    applePrice.await() + bananaPrice.await() + carrotPrice.await()
  }
}