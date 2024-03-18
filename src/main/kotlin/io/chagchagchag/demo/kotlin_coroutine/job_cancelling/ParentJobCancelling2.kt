package io.chagchagchag.demo.kotlin_coroutine.job_cancelling

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()

  runBlocking {
    val scope = CoroutineScope(EmptyCoroutineContext)

    val job = scope.launch {
      launch {
        delay(1000)
        log.info("배고파요")
      }

      launch {
        try{
          delay(1000)
          log.info("밥먹어요")
        }
        catch(e: Exception){
          log.info("밥 취소되었어요 ㅠㅠ")
          log.info("e = $e")
        }
      }
      delay(1000)
      log.info("밥 다먹었어요")
    }

    delay(300)
    job.cancelAndJoin()
    log.info("End")
  }
}