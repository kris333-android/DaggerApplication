package com.example.daggertutorial

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.example.daggertutorial.app.MainApplication
import com.example.daggertutorial.ui.theme.DaggerTutorialTheme
import com.example.daggertutorial.viewmodel.AppViewModelFactory
import com.example.daggertutorial.viewmodel.MainViewModel
import javax.inject.Inject

class MainActivity : ComponentActivity() {

    @Inject
    lateinit var viewModelFactory: AppViewModelFactory
    private val viewModel: MainViewModel by viewModels { viewModelFactory }


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        (application as MainApplication).appComponent.injectMainActivity(this)
     //   viewModel = ViewModelProvider(this, viewModelFactory).get(MainViewModel::class.java)

        enableEdgeToEdge()
        setContent {
            LaunchedEffect(Unit) {
                viewModel.getProducts()
            }
            DaggerTutorialTheme {
                val uiState = viewModel.uiState.collectAsStateWithLifecycle()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = uiState.value.products.joinToString(),
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    DaggerTutorialTheme {
        Greeting("Android")
    }
}