package com.mamay.arsitekturmvvm.view.uicontroller

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.layout.padding
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.mamay.arsitekturmvvm.model.DataJK
import com.mamay.arsitekturmvvm.view.FormSiswa
import com.mamay.arsitekturmvvm.view.TampilSiswa
import com.mamay.arsitekturmvvm.viewmodel.SiswaViewModel

enum class Navigasi {
    Formulir,
    Detail
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SiswaApp(
    modifier: Modifier = Modifier,
    viewModel: SiswaViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    val uiState = viewModel.statusUI.collectAsState()

    Scaffold(modifier = modifier) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = Navigasi.Formulir.name,
            modifier = Modifier.padding(innerPadding)
        ) {
            composable(route = Navigasi.Formulir.name) {
                val context = LocalContext.current
                FormSiswa(
                    pilihanJK = DataJK.jenisKelamin.map(context.resources::getString),
                    onSubmitButtonClicked = { dataSiswa ->
                        viewModel.setSiswa(dataSiswa)
                        navController.navigate(Navigasi.Detail.name)
                    }
                )
            }
            composable(route = Navigasi.Detail.name) {
                TampilSiswa(
                    statusUiSiswa = uiState.value,
                    onBackButtonClicked = { cancelAndBackToFormulir(navController) }
                )
            }
        }
    }
}

private fun cancelAndBackToFormulir(navController: NavHostController) {
    navController.popBackStack(Navigasi.Formulir.name, inclusive = false)
}
