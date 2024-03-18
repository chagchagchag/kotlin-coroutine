package io.chagchagchag.demo.kotlin_coroutine.exception_handler

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*

fun main(){
  val log = logger()

  runBlocking {
    val job = CoroutineScope(Dispatchers.IO).launch {
      launch {
        launch {
          throw IllegalStateException("퇴근 최소됨...")
          log.info("퇴근해요")
        }
      }
    }

    try{
      job.join()
    } catch (e: Exception){
      log.info("catch >>> 예외 메시지 : ${e.message}")
    }
  }
}
