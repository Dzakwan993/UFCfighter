import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.ufcfighter.R

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AboutScreen() {
    Column {
        TopAppBar(title = { Text("About Me") })

        Image(painter = painterResource(id = R.drawable.dzakwan), contentDescription = "dzakwan", modifier = Modifier.size(100.dp))
        Text("Namea: Muhammad Dzakwan Naufal")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Email: dzakwan@email.com")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Perguruan Tinggi: Politeknik Negeri Batam")
        Spacer(modifier = Modifier.height(8.dp))
        Text("Jurusan: Teknik Informatika")


    }
}

