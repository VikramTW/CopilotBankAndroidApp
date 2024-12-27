package com.vikram.copilotbank.features.profile.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.unit.dp
import androidx.fragment.app.Fragment
import com.vikram.copilotbank.widgets.PrimaryButton

class ProfileFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(inflater.context).apply {
            setContent {
                Column {
                    Text("Profile Screen View")
                    Spacer(modifier = Modifier.height(30.dp))
                    PrimaryButton(
                        text = "Edit Profile",
                        onClick = {
                        //NavController(context).navigate(R.id.profileScreen)
                    })
                }
            }
        }
    }
}