package com.android.settingslib.widget

import android.content.Context
import android.util.AttributeSet
import androidx.preference.Preference
import androidx.preference.PreferenceViewHolder
import com.airbnb.lottie.LottieAnimationView
import com.android.settingslib.R

/**
 * Standalone replacement for AOSP SettingsLib's IllustrationPreference.
 * Reads `app:lottie_rawRes` from XML and plays it in a looping Lottie view.
 */
class IllustrationPreference @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null
) : Preference(context, attrs) {

    private var rawRes = 0

    init {
        layoutResource = R.layout.preference_illustration
        isSelectable = false
        rawRes = attrs?.getAttributeResourceValue(AUTO_NS, "lottie_rawRes", 0) ?: 0
    }

    override fun onBindViewHolder(holder: PreferenceViewHolder) {
        super.onBindViewHolder(holder)
        holder.isDividerAllowedAbove = false
        holder.isDividerAllowedBelow = false
        val view = holder.findViewById(R.id.lottie_view) as? LottieAnimationView ?: return
        if (rawRes != 0) {
            view.setAnimation(rawRes)
            view.repeatCount = com.airbnb.lottie.LottieDrawable.INFINITE
            view.playAnimation()
        }
    }

    private companion object {
        const val AUTO_NS = "http://schemas.android.com/apk/res-auto"
    }
}
