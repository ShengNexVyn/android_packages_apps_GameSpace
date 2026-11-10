package com.android.settingslib.collapsingtoolbar

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import com.android.settingslib.R
import com.google.android.material.appbar.CollapsingToolbarLayout
import com.google.android.material.appbar.MaterialToolbar

/**
 * Standalone replacement for AOSP SettingsLib's CollapsingToolbarBaseActivity.
 * Hosts fragments in R.id.content_frame under a collapsing app bar (R.id.app_bar).
 */
open class CollapsingToolbarBaseActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.collapsing_toolbar_base_layout)
        setSupportActionBar(findViewById<MaterialToolbar>(R.id.action_bar))
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        findViewById<CollapsingToolbarLayout>(R.id.collapsing_toolbar).title = title
    }

    override fun setTitle(title: CharSequence?) {
        super.setTitle(title)
        findViewById<CollapsingToolbarLayout?>(R.id.collapsing_toolbar)?.title = title
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}
