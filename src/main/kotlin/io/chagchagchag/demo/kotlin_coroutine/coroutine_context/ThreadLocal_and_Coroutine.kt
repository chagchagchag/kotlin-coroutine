package io.chagchagchag.demo.kotlin_coroutine.coroutine_context

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking


fun main(){
  val log = logger()
  val isGreen = ThreadLocal<String>()
  isGreen.set("Yes")

  runBlocking {
    log.info("현재 스레드 = {}", Thread.currentThread().name)
    log.info("isGreen == {}", isGreen.get())
    assert(isGreen.get() != null)

    launch (Dispatchers.IO){
      log.info("현재 스레드 = {}", Thread.currentThread().name)
      log.info("isGreen = {}", isGreen.get())
      assert(isGreen.get() == null)
    }
  }
}