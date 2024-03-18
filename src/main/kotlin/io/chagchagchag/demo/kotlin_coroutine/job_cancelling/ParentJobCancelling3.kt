package io.chagchagchag.demo.kotlin_coroutine.job_cancelling

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()
  runBlocking {
    val outerScope = CoroutineScope(EmptyCoroutineContext)

    val outerJob = outerScope.launch {
      launch {
        try{
          delay(1000)
          log.info("배고파요")
        }
        catch (e: Exception){
          log.info("배고픈데 취소됐어요")
          log.info("e = ${e.message}")
        }
      }

      launch {
        try{
          delay(1000)
          log.info("밥먹어요")
        }
        catch (e: Exception){
          log.info("밥 취소되었어요 ㅠㅠ")
          log.info("e = ${e.message}")
        }
      }

      delay(1000)
      log.info("밥 다 먹었어요")
    }

    delay(300)
    outerJob.cancelAndJoin()
  }
}