package io.chagchagchag.demo.kotlin_coroutine.coroutine_scope

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.*
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()

  runBlocking {
    val scope = CoroutineScope(EmptyCoroutineContext)
    log.info("현재 Job = ${scope.coroutineContext[Job]}")

    log.info("시작")
    val deferred = scope.async {
      delay(1000)
      val currentContext = this.coroutineContext
      val currentContextClassName = this.javaClass.simpleName
      val whatIsParent = this.coroutineContext[Job]?.parent

      log.info("현재 코루틴 컨텍스트 = $currentContext")
      log.info("현재 코루틴 컨텍스트의 클래스명 = $currentContextClassName")
      log.info("현재 Job 의 부모 = $whatIsParent")

      25000
    }

    log.info("코루틴이 반환한 값 = ${deferred.await()}")
    log.info("끝")
  }
}
