import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.schoolshub.R
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState

@OptIn(ExperimentalPagerApi::class)
@Composable
fun HomeScreen() {

    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {

        Text(
            text = "SCHOOLS - HUB",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.fillMaxWidth()
        )

        Divider(
            color = Color.LightGray,
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        ImageSlider()


        Spacer(modifier = Modifier.height(10.dp))

        Divider(
            color = Color.LightGray,
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Text(
            text = "Platform to Select Desired School for Your Children",
            textAlign = TextAlign.Center,
            fontSize = 24.sp,
            fontWeight = FontWeight.Medium,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        Divider(
            color = Color.LightGray,
            thickness = 2.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Our Mission", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )

        Card(modifier = Modifier
            .fillMaxWidth()
            .padding(4.dp)){
            Text(
                text = "SchoolsHub is an innovative platform designed to connect students, parents, and educators. " +
                        "Our goal is to enhance communication, provide educational resources, and create a community " +
                        "that fosters learning and growth.",
                fontSize = 18.sp,
                modifier = Modifier.padding(16.dp),
                textAlign = TextAlign.Center

            )
        }


        Spacer(modifier = Modifier.height(10.dp))

        Text(text = "Services", fontSize = 24.sp, fontWeight = FontWeight.Bold)

        Divider(
            color = Color.LightGray,
            thickness = 1.dp,
            modifier = Modifier.fillMaxWidth()
        )


        ServiceCard("Comprehensive School Profiles", R.drawable.home)
        ServiceCard("Read Blogs - Learn from Experts", R.drawable.book)
        ServiceCard("AI ChatBot Assistant With Guide", R.drawable.bot)
    }
}

@Composable
fun ServiceCard(serviceName: String, iconId: Int) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),

    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = iconId),
                contentDescription = "$serviceName Icon",
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = serviceName,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium,
                color = MaterialTheme.colorScheme.primary,
            )
        }
    }
}



@OptIn(ExperimentalPagerApi::class)
@Composable
fun ImageSlider() {
    val images = listOf(
        R.drawable.image1,
        R.drawable.image2,
        R.drawable.image3
    )
    val pagerState = rememberPagerState()

    HorizontalPager(
        count = images.size,
        state = pagerState,
        modifier = Modifier
            .fillMaxWidth()
            .height(200.dp)
    ) { page ->
        Image(
            painter = painterResource(id = images[page]),
            contentDescription = null,
            modifier = Modifier
                .fillMaxSize()
                .background(Color.White)
        )
    }
}