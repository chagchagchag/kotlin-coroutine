package io.chagchagchag.demo.kotlin_coroutine.exception_handler

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.runBlocking

fun main(){
  val log = logger()

  try{
    runBlocking {
      throw IllegalStateException("퇴근 실패")
      log.info("퇴근합니다.")
    }
  } catch (e: Exception){
    log.error("에러 메시지 : ${e.message}")
  }
}