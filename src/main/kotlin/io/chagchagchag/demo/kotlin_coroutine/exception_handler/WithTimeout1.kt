package io.chagchagchag.demo.kotlin_coroutine.exception_handler

import kotlinx.coroutines.async
import kotlinx.coroutines.runBlocking
import kotlinx.coroutines.withTimeout

fun main(){
  runBlocking {
    val a = withTimeout(500){
      async {  }
    }
  }
}