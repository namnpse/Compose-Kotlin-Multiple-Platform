package navigation.components

import com.arkivanov.decompose.ComponentContext
import com.arkivanov.decompose.ExperimentalDecomposeApi
import com.arkivanov.decompose.router.stack.StackNavigation
import com.arkivanov.decompose.router.stack.childStack
import com.arkivanov.decompose.router.stack.pop
import com.arkivanov.decompose.router.stack.pushNew
import kotlinx.serialization.Serializable

class RootComponent(
    componentContext: ComponentContext
) : ComponentContext by componentContext {

    private val navigation = StackNavigation<Configuration>()

    val childStack = childStack(
        source = navigation,
        serializer = Configuration.serializer(),
        initialConfiguration = Configuration.Screen1,
        handleBackButton = true,
        childFactory = ::createChild
    )

    @OptIn(ExperimentalDecomposeApi::class)
    private fun createChild(
        config: Configuration,
        context: ComponentContext
    ): Screen {
        return when (config) {
            Configuration.Screen1 ->
                Screen.Screen1(
                    Screen1Component(
                        componentContext = context,
                        onNavigateToNextScreen = { text ->
                            navigation.pushNew(Configuration.Screen2(text))
                        }
                    )
                )

            is Configuration.Screen2 ->
                Screen.Screen2(
                    Screen2Component(
                        text = config.text,
                        componentContext = context,
                        onGoBack = {
                            navigation.pop()
                        }
                    )
                )
        }
    }

    sealed class Screen {
        data class Screen1(val component: Screen1Component) : Screen()
        data class Screen2(val component: Screen2Component) : Screen()
    }

    @Serializable
    sealed class Configuration {
        @Serializable
        data object Screen1 : Configuration()

        @Serializable
        data class Screen2(val text: String) : Configuration()
    }
}