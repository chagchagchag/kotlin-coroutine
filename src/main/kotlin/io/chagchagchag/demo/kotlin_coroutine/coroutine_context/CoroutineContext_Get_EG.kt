package io.chagchagchag.demo.kotlin_coroutine.coroutine_context

import io.chagchagchag.demo.kotlin_coroutine.helper.logger
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.CoroutineName
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job

@OptIn(ExperimentalStdlibApi::class)
fun main(){
  val log = logger()
  var multipleContexts = CoroutineName("배고파요") + Dispatchers.IO
  // (1)
  val hungryElement = multipleContexts[CoroutineName]
  log.info("hungryElement = $hungryElement, 클래스 = ${hungryElement?.javaClass?.simpleName}")
  // (2)
  val dispatcherElement = multipleContexts[CoroutineDispatcher]
  log.info("dispatcherElement = $dispatcherElement, 클래스 = ${dispatcherElement?.javaClass?.simpleName}")
  // (3)
  val dispatcherElementGet = multipleContexts[CoroutineDispatcher]
  log.info("dispatcherElementGet = $dispatcherElementGet, 클래스 = ${dispatcherElementGet?.get(CoroutineDispatcher)}")
  // (4)
  val jobElement = multipleContexts[Job]
  log.info("jobElement = $jobElement, 클래스 = ${jobElement?.get(Job)}")
}