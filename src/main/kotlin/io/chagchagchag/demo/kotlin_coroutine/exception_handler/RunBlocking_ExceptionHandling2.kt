package io.chagchagchag.demo.kotlin_coroutine.exception_handler

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.CoroutineExceptionHandler
import kotlinx.coroutines.runBlocking

fun main(){
  val log = logger()

  val handler = CoroutineExceptionHandler{_, e ->
    log.error("catched >>> 에러 메시지 : ${e.message}")
  }

  runBlocking {
    throw IllegalStateException("퇴근 실패")
    log.info("퇴근했어요.")
  }
}
