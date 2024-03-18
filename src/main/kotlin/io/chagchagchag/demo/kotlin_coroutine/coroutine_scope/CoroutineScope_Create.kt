package io.chagchagchag.demo.kotlin_coroutine.coroutine_scope

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.CoroutineScope
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()

  val coroutineScope = CoroutineScope(EmptyCoroutineContext)

  log.info("방금 생성한 코루틴 스코프 = $coroutineScope")
  log.info("코루틴 스코프 클래스 = ${coroutineScope.javaClass.simpleName}")
}
