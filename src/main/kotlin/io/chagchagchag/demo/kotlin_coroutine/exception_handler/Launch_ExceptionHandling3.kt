package io.chagchagchag.demo.kotlin_coroutine.exception_handler

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*

fun main(){
  val log = logger()

  runBlocking {
    val handler = CoroutineExceptionHandler{ _, e ->
      log.error("ErrorHandler >>> 예외 메시지 : ${e.message}")
    }

    val job = CoroutineScope(Dispatchers.IO + handler).launch {
      launch {
        launch {
          throw IllegalStateException("퇴근 취소 ... ")
          log.info("퇴근합니다.")
        }
      }
    }

    job.join()
  }
}
