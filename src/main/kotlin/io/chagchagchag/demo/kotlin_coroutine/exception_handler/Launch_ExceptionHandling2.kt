package io.chagchagchag.demo.kotlin_coroutine.exception_handler

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking

fun main(){
  val log = logger()

  runBlocking {
    val job = CoroutineScope(Dispatchers.IO).launch {
      try{
        launch {
          launch {
            throw IllegalStateException("퇴근 최소됨...")
            log.info("퇴근해요")
          }
        }
      } catch (e: Exception){
        log.error("catch >>> 예외 메시지 = ${e.message}")
      }
    }

    job.join()
  }
}
