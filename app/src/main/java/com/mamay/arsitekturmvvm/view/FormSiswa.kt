package com.mamay.arsitekturmvvm.view

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formSiswa(
    // edit parameter pilihan jenis kelamin dan onsubmitbuttonclicked
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){}