package io.chagchagchag.demo.kotlin_coroutine.coroutine_scope

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()

  runBlocking {
    val scope = CoroutineScope(EmptyCoroutineContext)
    log.info("scope 에 생성된 Job = ${scope.coroutineContext[Job]}")

    log.info("launchedJob 을 시작하겠습니다.")

    val launchedJob = scope.launch {
      delay(1000)
      val currentContext = this.coroutineContext
      val scopeClassName = this.javaClass.simpleName
      val currentJob = this.coroutineContext[Job]
      log.info("this.coroutineContext = $currentContext")
      log.info("class name = $scopeClassName")
      log.info("현재 Job 의 부모(parent) = ${currentJob?.parent}")
    }

    launchedJob.join()
    log.info("launchedJob 을 종료합니다.")
  }

}
