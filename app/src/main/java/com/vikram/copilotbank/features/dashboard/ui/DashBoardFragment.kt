package com.vikram.copilotbank.features.dashboard.ui

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.platform.ComposeView
import androidx.compose.ui.platform.ViewCompositionStrategy
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.fragment.app.Fragment
import androidx.navigation.findNavController
import com.vikram.copilotbank.R
import com.vikram.copilotbank.widgets.PrimaryButton
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DashBoardFragment: Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        return ComposeView(
            requireContext()).apply {
                setViewCompositionStrategy(ViewCompositionStrategy.DisposeOnViewTreeLifecycleDestroyed)
                setContent {
                   Column(
                       modifier = Modifier.padding(20.dp)
                   ) {
                       Text(
                           text = "Quick Links",
                           fontSize = 16.sp
                       )
                       Spacer(modifier = Modifier.height(15.dp))
                       Card(
                         modifier = Modifier
                             .fillMaxWidth()
                             .shadow(elevation = 10.dp)
                             .border(width = 1.dp, color = colorResource(id = R.color.divideColor))
                             .background(color = colorResource(id = R.color.white))
                       ) {
                          Column (
                              modifier = Modifier
                                  .align(Alignment.CenterHorizontally)
                                  .padding(horizontal = 10.dp)
                          ){
                              Row (
                                  modifier = Modifier
                                      .fillMaxWidth()
                                      .align(Alignment.CenterHorizontally)
                              ) {
                                  PrimaryButton(
                                      modifier = Modifier.wrapContentSize(),
                                      text = "UPI",
                                      onClick = {
                                          findNavController().navigate(R.id.action_dashBoardScreen_to_profileScreen)
                                      })
                                  PrimaryButton(
                                      modifier = Modifier.wrapContentSize(),
                                      text = "UPI",
                                      onClick = {
                                          findNavController().navigate(R.id.action_dashBoardScreen_to_profileScreen)
                                      })
                              }

                          }

                       }
                   }
                }
            }
    }
}