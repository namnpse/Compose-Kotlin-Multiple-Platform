package navigation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.value.MutableValue
import com.arkivanov.decompose.value.Value

class Screen1Component(
    componentContext: ComponentContext,
    private val onNavigateToNextScreen: (String) -> Unit
): ComponentContext by componentContext {

    private var _text = MutableValue("")
    val text: Value<String> = _text

    fun onEvent(event: Screen1Event) {
        when(event) {
            Screen1Event.ClickButton1 -> onNavigateToNextScreen(text.value)
            is Screen1Event.UpdateText -> {
                _text.value = event.text
            }
        }
    }
}