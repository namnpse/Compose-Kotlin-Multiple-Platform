package navigation.components

import com.arkivanov.decompose.ComponentContext

class Screen2Component(
    val text: String,
    componentContext: ComponentContext,
    private val onGoBack: () -> Unit
): ComponentContext by componentContext {

    fun goBack() {
        onGoBack()
    }
}