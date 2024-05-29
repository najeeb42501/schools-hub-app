package com.example.schoolshub

import HomeScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.*
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.*
import com.example.schoolshub.ui.theme.SchoolsHubTheme
import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.ui.Alignment
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val schools = remember {
                mutableStateListOf<School>(
                    // Add more schools here
                    School(
                        1,
                        "IBA Public School",
                        R.drawable.ibaschool,
                        "Secondary",
                        "123 Green St",
                        "A leading school offering advanced learning.",
                        "K-12",
                        listOf("Sports Complex", "Science Labs", "Art Rooms"),
                        "1991",
                        mapOf("Grade 1" to 3000, "Grade 2" to 3200)
                    ),
                    School(
                        2,
                        "Allied  School",
                        R.drawable.alliedschool,
                        "Secondary",
                        "123 Green St",
                        "A leading school offering advanced learning.",
                        "K-12",
                        listOf("Sports Complex", "Science Labs", "Art Rooms"),
                        "1991",
                        mapOf("Grade 1" to 3000, "Grade 2" to 3200)
                    ),
                    School(
                        3,
                        "School Of Excellence",
                        R.drawable.soe,
                        "Primary",
                        "123 Green St",
                        "A leading school offering advanced learning.",
                        "K-12",
                        listOf("Sports Complex", "Science Labs", "Art Rooms"),
                        "1991",
                        mapOf("Grade 1" to 3000, "Grade 2" to 3200)
                    ),
                    School(
                        4,
                        "The City School",
                        R.drawable.cityschool,
                        "Secondary",
                        "123 Green St",
                        "A leading school offering advanced learning.",
                        "K-12",
                        listOf("Sports Complex", "Science Labs", "Art Rooms"),
                        "1991",
                        mapOf("Grade 1" to 3000, "Grade 2" to 3200)
                    ),
                )
            }
            val blogPosts = remember {
                mutableStateListOf(
                    BlogPost(
                        1,
                        "Selecting the Right School for Your Child",
                        "Choosing the right school for your child is crucial for their future success. In Pakistan, where educational standards and facilities can vary widely, it's important to thoroughly research and consider several key factors before making this significant decision.\n" +
                                "\n" +
                                "Firstly, consider the school's curriculum and teaching methodology. Ensure that the school follows a recognized curriculum that aligns with your educational goals for your child, whether it's the local board, Cambridge, or IB. Visit the school to understand their teaching methods and see if they focus on rote learning or encourage critical thinking and creativity.\n" +
                                "\n" +
                                "Secondly, evaluate the school's facilities and infrastructure. A good school should have well-equipped classrooms, libraries, science and computer labs, and sports facilities. Check if they provide a safe and stimulating environment for learning and extracurricular activities.\n" +
                                "\n" +
                                "Thirdly, assess the quality of the teaching staff. The teachers should be qualified, experienced, and dedicated to their profession. It's beneficial to inquire about the teacher-to-student ratio, as a lower ratio often allows for more personalized attention to each student.\n" +
                                "\n" +
                                "Another important aspect is the school's culture and values. The school's ethos should resonate with your family's values and beliefs. This includes their approach to discipline, inclusivity, and their emphasis on moral and ethical education.\n" +
                                "\n" +
                                "Furthermore, consider the school's performance and reputation. Look at their academic results, the success of their alumni, and any awards or recognition the school has received. Speak to other parents and read reviews to get an idea of the school's standing in the community.\n" +
                                "\n" +
                                "Lastly, factor in the logistics such as the location of the school, transportation options, and the fee structure. The school should be conveniently located and within your budget while still providing quality education.",
                        "Ayesha Khan",
                        "2024-05-24"
                    ),
                    BlogPost(
                        2,
                        "Ensuring a Better Future for Your Child",
                        "Every parent wants the best for their child. This article discusses how to ensure a better future through education and extracurricular activities in Pakistan.",
                        "Bilal Ahmed",
                        "2024-05-22"
                    ),
                    BlogPost(
                        3,
                        "Key Factors to Check Before Selecting a School",
                        "Before selecting a school, it's important to check certain factors such as the school's environment, curriculum, and facilities. This guide helps parents make an informed decision in Pakistan.",
                        "Sara Ali",
                        "2024-05-20"
                    ),
                    BlogPost(
                        4,
                        "Importance of Extracurricular Activities",
                        "Extracurricular activities play a vital role in the overall development of a child. Learn why they are important and how to choose the right school that offers these activities in Pakistan.",
                        "Zainab Malik",
                        "2024-05-18"
                    ),
                    BlogPost(
                        5,
                        "How to Evaluate a School's Performance",
                        "Evaluating a school's performance can be challenging. This article provides tips on how to assess a school's academic achievements and overall performance in Pakistan.",
                        "Hamza Qureshi",
                        "2024-05-16"
                    ),
                    BlogPost(
                        6,
                        "How to Evaluate a School's Performance",
                        "Evaluating a school's performance can be challenging. This article provides tips on how to assess a school's academic achievements and overall performance in Pakistan.",
                        "Hamza Qureshi",
                        "2024-05-16"
                    ),
                    BlogPost(
                        7,
                        "How to Evaluate a School's Performance",
                        "Evaluating a school's performance can be challenging. This article provides tips on how to assess a school's academic achievements and overall performance in Pakistan.",
                        "Hamza Qureshi",
                        "2024-05-16"
                    ),
                    BlogPost(
                        8,
                        "How to Evaluate a School's Performance",
                        "Evaluating a school's performance can be challenging. This article provides tips on how to assess a school's academic achievements and overall performance in Pakistan.",
                        "Hamza Qureshi",
                        "2024-05-16"
                    )
                )
            }

            SchoolsHubTheme {
                val navController = rememberNavController()
                SchoolsHubTheme {
                    MyApp(schools, blogPosts, navController)
                }
            }
        }
    }
}

@Composable
fun MyApp(
    schools: MutableList<School>,
    blogPosts: MutableList<BlogPost>,
    navController: NavHostController
) {

    SplashScreen(navController = navController)
    Scaffold(
        bottomBar = {
            if (currentDestination(navController) != "splash_screen") {
                BottomNavigationBar(navController = navController)
            }
//            BottomNavigationBar(navController = navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "splash_screen",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("splash_screen") {
                SplashScreen(navController)
            }
            composable("home") { HomeScreen() }
            composable("search") { SearchScreen(schools, navController) }
            composable("blogs") { BlogsScreen(blogPosts, navController) }
            composable("blogPost/{blogPostId}") { backStackEntry ->
                val blogPostId = backStackEntry.arguments?.getString("blogPostId")?.toInt() ?: 0
                val blogPost = blogPosts.find { it.id == blogPostId }
                BlogPostScreen(blogPost, navController)
            }
            composable("ai_bot") { AIBotScreen() }
            composable("schoolProfile/{schoolID}") { backStackEntry ->
                val schoolId = backStackEntry.arguments?.getString("schoolID")?.toInt() ?: 0
                val school = schools.find { it.id == schoolId }
                school?.let { SchoolProfileScreen(it, navController) }
            }
        }
    }
}


@Composable
fun BottomNavigationBar(navController: NavController) {
    BottomNavigation(
        backgroundColor = MaterialTheme.colorScheme.background
    ) {
        val items = listOf(
            "home" to R.drawable.home,
            "search" to R.drawable.search,
            "blogs" to R.drawable.book,
            "ai_bot" to R.drawable.bot
        )
        items.forEach { (label, iconResId) ->
            val isSelected = currentDestination(navController) == label
            BottomNavigationItem(
                icon = {
                    Icon(
                        painterResource(id = iconResId),
                        contentDescription = label,
                        tint = if (isSelected) MaterialTheme.colorScheme.primary else Color.Gray,
                        modifier = Modifier.size(34.dp)
                    )
                },
                selected = isSelected,
                onClick = { navController.navigate(label) }
            )
        }
    }
}

@Composable
fun currentDestination(navController: NavController): String? {
    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    return currentBackStackEntry?.destination?.route
}


@Composable
fun SplashScreen(navController: NavController) {
    val delay = remember { Animatable(0f) }

    LaunchedEffect(key1 = true) {
        delay.animateTo(1f, animationSpec = tween(3000))
        navController.navigate("home")
    }

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.schools_hub_logo),
            contentDescription = "App Logo"
        )
        Text(
            text = "SCHOOLS HUB ", fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = MaterialTheme.colorScheme.primary,
            modifier = Modifier.padding(bottom = 16.dp)
        )
    }
}


data class School(
    val id: Int,
    val name: String,
    val imageRes: Int,
    val type: String,
    val address: String,
    val description: String,
    val level: String,
    val facilities: List<String>,
    val foundedDate: String,
    val fees: Map<String, Int>
)


data class BlogPost(
    val id: Int,
    val title: String,
    val content: String,
    val author: String,
    val date: String
)



