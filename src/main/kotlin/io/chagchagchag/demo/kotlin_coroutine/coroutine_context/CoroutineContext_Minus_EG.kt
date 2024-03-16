package io.chagchagchag.demo.kotlin_coroutine.coroutine_context

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

@OptIn(ExperimentalStdlibApi::class)
fun main(){
  val log = logger()
  // (1)
  val context1 = CoroutineName("짬뽕") + Dispatchers.IO + Job()
  log.info("context1 = $context1, 클래스 = ${context1.javaClass.simpleName}")
  // (2)
  val minus1 = context1.minusKey(Job)
  log.info("minus1 = $minus1, 클래스 = ${minus1.javaClass.simpleName}")
  // (3)
  val minus2 = minus1.minusKey(Job)
  log.info("minus2 = $minus2, 클래스 = ${minus2.javaClass.simpleName}")
  // (4)
  val minus3 = minus2.minusKey(CoroutineDispatcher)
  log.info("minus3 = $minus3, 클래스 = ${minus3.javaClass.simpleName}")
  // (5)
  val minus4 = minus3.minusKey(CoroutineName)
  log.info("minus4 = $minus4, 클래스 = ${minus4.javaClass.simpleName}")
}

