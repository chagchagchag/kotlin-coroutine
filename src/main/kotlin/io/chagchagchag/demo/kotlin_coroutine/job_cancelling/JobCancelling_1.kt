package io.chagchagchag.demo.kotlin_coroutine.job_cancelling

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*

fun main(){
  val log = logger()
  runBlocking {
    val scope = CoroutineScope(Dispatchers.Default)

    log.info("첫번째 잡의 CoroutineContext : ${scope.coroutineContext[Job]}")
    log.info("첫번째 잡의 CoroutineContext 의 부모 컨텍스트 : ${scope.coroutineContext[Job]?.parent}")

    val job = scope.launch {
      log.info("두번째 잡의 CoroutineContext : ${this.coroutineContext[Job]}")
      log.info("두번째 잡의 CoroutineContext 의 부모 컨텍스트 : ${this.coroutineContext[Job]?.parent}")

      launch {
        log.info("세번째 잡의 CoroutineContext : ${this.coroutineContext[Job]}")
        log.info("세번째 잡의 CoroutineContext 의 부모 컨텍스트 : ${this.coroutineContext[Job]?.parent}")
      }

      launch {
        log.info("네번째 잡의 CoroutineContext : ${this.coroutineContext[Job]}")
        log.info("네번째 잡의 CoroutineContext 의 부모 컨텍스트 : ${this.coroutineContext[Job]?.parent}")
      }
    }

    job.join()
  }
}