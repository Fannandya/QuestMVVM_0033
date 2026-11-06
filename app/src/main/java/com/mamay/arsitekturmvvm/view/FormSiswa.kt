package com.mamay.arsitekturmvvm.view

import android.adservices.topics.Topic
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun formSiswa(
    // edit parameter pilihan jenis kelamin dan onsubmitbuttonclicked
    pilihanJK: List<String>,
    onSubmitButtonClicked: (MutableList<String>) -> Unit,
    modifier: Modifier = Modifier
){
    var txtNama by rememberSaveable { mutableStateOf("") }
    var txtAlamat by remember { mutableStateOf("") }
    var txtGender by remember { mutableStateOf("") }
    val listData: MutableList<String> = mutableStateOf(txtNama,txtAlamat,txtGender)

    Scaffold(modifier = Modifier,
        topBar = {
            TopAppBar(title = { Text(stringResource(id = R.string.app_name), color = Color.White) },
                colors = TopAppBarDefaults.mediumTopAppBarColors(colorResource(id = R.color.purple_500))
            )
        }){ isiRuang ->

        Column(
            modifier = Modifier.padding(isiRuang),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally
        ){
            //edit 3 : value, onValueChange, selected, onClick
            OutlinedTextField(
                value = txtNama,
                singleLine = true,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.width(250.dp).padding(top=20.dp),
                label = { Text(text = "Nama Lengkap") },
                onValueChange = {
                    txtNama = it
                }
            )

            HorizontalDivider(
                modifier = Modifier
                    .padding(12.dp)
                    .width(250.dp),
                thickness = dimensionResource(R.dimen.thickness_divider),
                color = Color.Blue
            )

            Row {
                pilihanJK.forEach { item ->
                    Row(modifier = Modifier.selectable(
                        selected = txtGender == item,
                        onClick = {
                            txtGender = item
                        }
                    ),
                        verticalAlignment = Alignment.CenterVertically) {
                        RadioButton(
                            selected = txtGender == item,
                            onClick = {
                                txtGender = item
                            }
                        )
                        Text(item)
                    }
                }
            }
        }
}