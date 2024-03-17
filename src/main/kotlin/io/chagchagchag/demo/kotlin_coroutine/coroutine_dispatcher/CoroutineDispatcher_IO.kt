package io.chagchagchag.demo.kotlin_coroutine.coroutine_dispatcher

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

@OptIn(ExperimentalStdlibApi::class)
fun main(){
  val log = logger()

  runBlocking {
    // (1)
    log.info("스레드 == ${Thread.currentThread().name}")
    log.info("디스패처 == ${this.coroutineContext[CoroutineDispatcher]}")

    // (2)
    withContext(Dispatchers.IO){
      log.info("스레드 == ${Thread.currentThread().name}")
      log.info("디스패처 == ${this.coroutineContext[CoroutineDispatcher]}")
    }
  }
}