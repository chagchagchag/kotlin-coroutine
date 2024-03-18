package io.chagchagchag.demo.kotlin_coroutine.coroutine_dispatcher

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.newFixedThreadPoolContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext


fun main(){
  val log = logger()

  runBlocking {
    log.info("START")
    val fixedDispatcher = newFixedThreadPoolContext(1, "messageSender")

    withContext(fixedDispatcher){
      log.info("스레드 : ${Thread.currentThread().name}, 디스패처 : $fixedDispatcher")
      fixedDispatcher.close()
      log.info("END")
    }
  }
}