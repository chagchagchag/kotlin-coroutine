package io.chagchagchag.demo.kotlin_coroutine.coroutine_dispatcher

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.newSingleThreadContext
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withContext

fun main() {
  val log = logger()

  runBlocking {
    log.info("START")
    val singleDispatcher = newSingleThreadContext("sumCartDispatcher")

    withContext(singleDispatcher) {
      log.info("스레드 : ${Thread.currentThread().name}, 디스패처 : $singleDispatcher")
      singleDispatcher.close()
      log.info("END")
    }
  }
}
