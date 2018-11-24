package io.github.fatimazza.footballclub.utils

import kotlinx.coroutines.experimental.Dispatchers
import kotlinx.coroutines.experimental.ExperimentalCoroutinesApi
import kotlin.coroutines.experimental.CoroutineContext

class TestContextProvider : CoroutineContextProvider() {
    @ExperimentalCoroutinesApi
    override val main: CoroutineContext = Dispatchers.Unconfined
}