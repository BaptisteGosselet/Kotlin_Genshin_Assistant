package com.example.genshinassistant

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.Text
import com.example.genshinassistant.ui.theme.GenshinAssistantTheme
import com.example.genshinassistant.views.GridList
import com.example.genshinassistant.views.RowList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GenshinAssistantTheme {
                GridList();
            }
        }
    }


}
