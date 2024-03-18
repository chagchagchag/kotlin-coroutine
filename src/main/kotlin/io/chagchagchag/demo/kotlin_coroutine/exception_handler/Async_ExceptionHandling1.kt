package io.chagchagchag.demo.kotlin_coroutine.exception_handler

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking

fun main(){
  val log = logger()

  runBlocking {
    val deferred = CoroutineScope(Dispatchers.IO).async {
      throw IllegalArgumentException("퇴근 취소됨...")
      "퇴근해요"
    }

    try{
      deferred.await()
    } catch (e: Exception){
      log.info("catch >>> 예외 메시지 : ${e.message}")
    }
  }
}
