package io.chagchagchag.demo.kotlin_coroutine.coroutine_context

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.EmptyCoroutineContext

fun main(){
  val log = logger()
  // (1)
  val emptyContext = EmptyCoroutineContext // object 타입이기에 생성자를 호출하지 않아도 바로 대입이 됩니다.
  log.info("emptyContext = $emptyContext")

  // (2)
  val element1 = CoroutineName("배고파요")
  val mergedContext1 = emptyContext + element1
  log.info("mergedContext1 = $mergedContext1, 클래스 = ${mergedContext1.javaClass.simpleName}")

  // (3)
  val element2 = CoroutineName("한입만")
  val mergedContext2 = mergedContext1 + element2
  log.info("mergedContext2 = $mergedContext2, 클래스 = ${mergedContext2.javaClass.simpleName}")

  // (4)
  val element3 = Dispatchers.IO
  val mergedContext3 = mergedContext2 + element3
  log.info("mergedContext3 = $mergedContext3, 클래스 = ${mergedContext3.javaClass.simpleName}")

  // (5)
  val element4 = Job()
  val mergedContext4 = mergedContext3 + element4
  log.info("mergedContext4 = $mergedContext4, class = ${mergedContext4.javaClass.simpleName}")
}