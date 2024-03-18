package io.chagchagchag.demo.kotlin_coroutine.coroutine_dispatcher

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*

fun main(){
  val log = logger()

  runBlocking {
    val fixed = newFixedThreadPoolContext(2,"messageSenderDispatcher")
    val singleThreadDispatcher = newSingleThreadContext("sumCartDispatcher")

    val job = launch (singleThreadDispatcher){
      log.info("스레드 1 : ${Thread.currentThread().name}")

      withContext(fixed){
        log.info("스레드 2 : ${Thread.currentThread().name}")

        withContext(Dispatchers.IO){
          log.info("스레드 3 : ${Thread.currentThread().name}")

          withContext(singleThreadDispatcher){
            log.info("스레드 4 : ${Thread.currentThread().name}")
          }
        }
      }
    }

    job.join()
    fixed.close()
    singleThreadDispatcher.close()
  }
}

