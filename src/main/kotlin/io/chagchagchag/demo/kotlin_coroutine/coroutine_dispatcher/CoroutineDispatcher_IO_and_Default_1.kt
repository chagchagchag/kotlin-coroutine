package io.chagchagchag.demo.kotlin_coroutine.coroutine_dispatcher

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*

@OptIn(ExperimentalStdlibApi::class)
fun main(){
  val log = logger()

  runBlocking {
    // (1)
    log.info("스레드 == ${Thread.currentThread().name}")
    log.info("디스패처 == ${this.coroutineContext[CoroutineDispatcher.Key]}")

    // (2)
    withContext(Dispatchers.Default){
      log.info("스레드 == ${Thread.currentThread().name}")
      log.info("디스패처 == ${this.coroutineContext[CoroutineDispatcher.Key]}")
    }

    // (3)
    withContext(Dispatchers.IO){
      log.info("스레드 == ${Thread.currentThread().name}")
      log.info("디스패처 == ${this.coroutineContext[CoroutineDispatcher.Key]}")
    }

    // (4)
    CoroutineScope(CoroutineName("배고파요")).launch {
      log.info("스레드 == ${Thread.currentThread().name}")
      log.info("디스패처 == ${this.coroutineContext[CoroutineDispatcher.Key]}")
    }
  }
}
