package navigation.components

sealed interface Screen1Event {
    data object ClickButton1: Screen1Event
    data class UpdateText(val text: String): Screen1Event
}