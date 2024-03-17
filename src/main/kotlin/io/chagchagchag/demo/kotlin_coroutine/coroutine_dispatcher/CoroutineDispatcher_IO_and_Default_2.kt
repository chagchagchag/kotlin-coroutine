package io.chagchagchag.demo.kotlin_coroutine.coroutine_dispatcher

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main (){
  val log = logger()

  runBlocking {
    for(i in 1 until 2000){
      launch (Dispatchers.Default){
        log.info("현재 스레드 : ${Thread.currentThread().name}")
      }

      launch (Dispatchers.IO){
        log.info("현재 스레드 : ${Thread.currentThread().name}")
      }
    }
  }
}
