package io.chaldeaprjkt.gamespace.data

/**
 * Settings.System keys that only exist as constants in the patched ROM framework
 * (chaldeaprjkt frameworks/base). Defined here as literals so the app also compiles
 * against a stock framework jar. Values match the ROM's Settings.System constants.
 */
object SettingKeys {
    const val THREE_FINGER_GESTURE = "three_finger_gesture"
    const val GAMESPACE_SUPPRESS_FULLSCREEN_INTENT = "gamespace_suppress_fullscreen_intent"
    const val GAMESPACE_GAME_LIST = "gamespace_game_list"
}
