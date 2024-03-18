package io.chagchagchag.demo.kotlin_coroutine.structured_concurrency

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*

fun main(){
  val log = logger()

  runBlocking {
    val job = CoroutineScope(Dispatchers.Default).launch {
      log.info("(before) 부모 코루틴 컨텍스트 : ${this.coroutineContext}")

      withContext(Dispatchers.IO){
        log.info("withContext 컨텍스트 : ${this.coroutineContext}")
      }

      log.info("(after) 부모 코루틴 컨텍스트 : ${this.coroutineContext}")
    }

    job.join()
  }
}