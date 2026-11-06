package com.mamay.arsitekturmvvm.view

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.material3.Button
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mamay.arsitekturmvvm.R

@OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)
@Composable
fun FormSiswa(
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
) {
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by rememberSaveable { mutableStateOf("") }
    var txtGender by rememberSaveable { mutableStateOf("") }

    Scaffold(
        modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text(text = stringResource(id = R.string.app_name), color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = colorResource(id = R.color.purple_500)
                )
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = txtNama,
                onValueChange = { txtNama = it },
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier
                    .width(250.dp)
                    .padding(top = 20.dp),
                label = { Text(text = "Nama Lengkap") }
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(12.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Blue
            )

            Row(
                modifier = Modifier.horizontalScroll(rememberScrollState()),
                verticalAlignment = Alignment.CenterVertically
            ) {
                pilihanJK.forEach { item ->
                    Row(
                        modifier = Modifier.selectable(
                            selected = txtGender == item,
                            onClick = { txtGender = item }
                        ),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        RadioButton(
                            selected = txtGender == item,
                            onClick = { txtGender = item }
                        )
                        Text(text = item)
                    }
                }
            }

            HorizontalDivider(
                modifier = Modifier
                    .padding(5.dp)
                    .width(250.dp),
                thickness = 1.dp,
                color = Color.Blue
            )

            OutlinedTextField(
                value = txtAlamat,
                onValueChange = { txtAlamat = it },
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.width(250.dp),
                label = { Text(text = "Alamat Lengkap") }
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                modifier = Modifier.fillMaxWidth(),
                enabled = txtNama.isNotBlank() && txtAlamat.isNotBlank() && txtGender.isNotBlank(),
                onClick = {
                    onSubmitButtonClicked(mutableListOf(txtNama, txtAlamat, txtGender))
                }
            ) {
                Text(text = "Simpan")
            }
        }
    }
}
