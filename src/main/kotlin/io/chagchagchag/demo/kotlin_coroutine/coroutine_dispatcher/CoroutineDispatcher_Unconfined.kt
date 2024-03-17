package io.chagchagchag.demo.kotlin_coroutine.coroutine_dispatcher

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*

fun main(){
  val log = logger()

  runBlocking {
    launch(Dispatchers.Unconfined) {
      log.info("(1) at Unconfined, Thread Name = ${Thread.currentThread().name}")

      withContext(Dispatchers.IO){
        log.info("(2) at Dispatchers.IO, Thread Name = ${Thread.currentThread().name}")
      }

      log.info("(3) at Unconfined, Thread Name = ${Thread.currentThread().name}")
      delay(1500)
      log.info("(4) at Unconfined, ThreadName = ${Thread.currentThread().name}")
    }
  }
}