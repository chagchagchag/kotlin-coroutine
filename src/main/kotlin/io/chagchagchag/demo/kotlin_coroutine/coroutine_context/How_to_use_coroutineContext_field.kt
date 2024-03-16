package io.chagchagchag.demo.kotlin_coroutine.coroutine_context

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.runBlocking
import kotlin.coroutines.coroutineContext
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

fun main(){
  val log = logger()
  runBlocking {
    log.info("현재 코루틴 스코프 내의 코루틴 컨텍스트 : ${this.coroutineContext}")
    inner() // 다른 함수를 호출할 때 어떻게 되는지 확인해봅니다.
  }
}

private suspend fun inner(){
  val log = logger()

  log.info("suspend 함수 내에서의 context ${coroutineContext}")

  var result = suspendCoroutine<String> { continuation ->
    log.info("Continuation 객체 내의 context = ${continuation.context}")
    continuation.resume("OK")
  }
}
