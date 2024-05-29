package com.example.crane.module.plants

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.crane.models.PlantData
import com.example.crane.ui.theme.CraneTheme


@Preview(showBackground = true)
@Composable
fun PlantScreenPreview() {
    val navController = rememberNavController()
    CraneTheme {
        PlantScreen(navController)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PlantScreen(navController: NavController){
    val plantDatas= listOf<PlantData>(
        PlantData(
            image = "https://s3-alpha-sig.figma.com/img/169d/da81/c11644be1e8a356832d839fce3770ae5?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ZO~9EH4zrGybFATC6sjYhcBh7DUkWqNIla8T8kVkN9CZzYRXwanJzgAC7~O6RmX6UbC0RIFc6x-IXbRN4GHB1Nfud6e2sAE0sAbsmx~mcRTuJJJZytnl1yGI~ZMRaNs7eOoJoaRZtTn5vIhMupW5qL44khiDGNYg0fxT22BgMXXLAEP3ylS5F48dggLdUrDrz7oTIAZJLnWrVTYq8S3jJu3PexNcY0YPCtkpMHQ~yCjgIlhhPZ5ERrJRHSm7VKSY3o5PHyETQT9X64yWzyafJeJG1O1iTHqAMSoYkr7Zp-GFZrwPCJXJ1QGheZXjn~fszWlcJ-I96WvTIg2YflDzvA__",
            name = "miosa",
            date = "12,June,2023",
            age = "11 days"
        ),
        PlantData(
            image = "https://s3-alpha-sig.figma.com/img/2b58/94ce/212af7e48c818c4653f93be11fca5d80?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Qb2pTBTs3NWFB7imb82XE8JirOOIzJgdkxP3AkwuN17l3jztqyKHpZgbq-U4M3XDCprpKta1xZuCc6Hg3~TL3Arl8IkOvTw0UvFE46NPT8uNomnameYK2pkoCvkwx-q9RUOg9X~wNxGNDV~INz~FQ-KCWNyVGJUxShGv8YcF18-bIqTggbCwNC7MUbXv8qm~FTNSAt95NQNnke4AKNs516ztevQRHPyjExNFX-agvR8~R9O4ZPQ71tJkSO9dAA4kLEyyz9RtB~ZcZXb987HoQ0zTReE85kacLgGytQmKhwNZGl9DrmHONQ46olF7LgKQECmor-mGU6wIsBBU1PxGxg__",
            name = "Crimson",
            date = "12,May,2023",
            age = "1 Month"
        ),
        PlantData(
            image = "https://s3-alpha-sig.figma.com/img/9225/cc96/e701b7b81cbc3eb4e80fc4d0337b0bcf?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=hT4u4cgoJdwv5HLZ3EywVVWeUAzTQ3AZXTgbQWyevHO9dtHfJDb3wzKzqVhvBbvcm9ArIrmxtIXFBPj~GX1R0w3OlExmIsBxHjlRNarAvBYew-5q9vLuq4AqBlZRnbQApmaz6m2STHU4-qSxmqn9nLoeDrm8Ms~WfhxMIlosgr4d3B3iAwDUY5UpbH8r~OTCTkj9BmPNDg~-7LpLU80c33iw~O5jL7x637Y7cAVV9xqcyqLp7JH7aNEQ1GczIG3dtoPXbGA0ajPAaZqUaSjB~tcgHHcEgjBzxy3T~CdzLdwow20NU1BVB53jg-buXVQ~42f5GvXpwGm~Ab0wFHdprg__",
            name = "miosa",
            date = "12,Feb,2023",
            age = "3 Months"
        ),
        PlantData(
            image = "https://s3-alpha-sig.figma.com/img/0de5/0865/3df5a9e1379f9fe733791948ecc04dd2?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Tdq7Yj5~4Wcj43fmtYe-zIRCIeT~LVVjPx5MpojYDKRxUzuEhxw59R~0LTX0PlUTlpL9FqK~RUjhtaRZgaWDl0NX-UfkL8iVaqThieDXTwiB8yidlC8H8Oci2IWCZL3Lk1YcHNQSSKEY~8wI0kVEPaSX50A0oa1OhbxFTsfAKBHhnZ-J7T9FgQyWlnvOOchJF0KEMBIDpdZZpfQTcg19kt-NFORB09M97tgxcSy~btCd8oaB459ws6NlGfrYaa~d3BDGypgxQmg4IYERap6GBqIEvgE0oMHjplzSm~64FgqIwuMf25wD4ZUTTJFqS4Mmnnx~Ubok5KEXqrH-a5yYpQ__",
            name = "miosa",
            date = "12,Jan,2023",
            age = "4 Months"
        ),
        PlantData(
            image = "https://s3-alpha-sig.figma.com/img/fb6b/ec38/00c491a4e4dbb11f8b0cd9734ef0e91c?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=SHAiMnNuPjXl6lJG~NPwIi1yFOdDmaGvOmcgRB3AO~Fr8CXSOuArSwa-7tcpNW2-pvaXkJEWrJlzMx37A7ABUgBVZmtA90Suik~lT7CKLrFbhpMsnDIZ-a6QCBCiTQfI31TUDA4EA3wny9PpbB6WY6rvlYT824D6aOr9VEPNjDIcYCPzz5GE1uxy5jrKRWcc4NZOPY~DOcYcB~LC3-mDMd8WtXPEXLXN1emF8s6BiA4RbIx1ognxhgb~PELyi-qe9zGbIy4Bq~OGvZDodZMTwJdmY9QtwqSe7pKB4M5DbCEovqrlLJ1F7r-VWtmeOIDpJPjVZgefn7vbJaDTWvwIHg__",
            name = "miosa",
            date = "12,June,2022",
            age = "1 Year"
        ),
        PlantData(
            image = "https://s3-alpha-sig.figma.com/img/a41a/f78e/db2bb842c5b30cb7ac8cca657f361686?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=JP~N5nAXtY7RBSKgpKCWwBtJpX5jJIhR4AtE8uar9eP34kJ271k97Zo0WxW6yxVnxaX3HeR5XUbx3u1-RDH4NDW~2QlPXjBWu-BjbnrTK2Lc9dHmMq5sWSge4yagtq~CRwf1JJzqOEjVErX5s~NlPqXjj0yQWtBphrcB8sKbuXFDGQA5RgpG2QONeIozgBfLfWDCzXogHHTyD55KREodu4i8OPnh9ALrw12RgV8pFbE6Vh29aIseRfPk0tDnmTDtXAOBSw4zjX0bEgZtHFfSk71FS264gqD78XkPZ8ddGjAYzLaFK7SqUXEMc87C8tBNul5jDHrNA472E78hPiTl-w__",
            name = "miosa",
            date = "12,June,2021",
            age = "2 Years"
        )
    )
    Scaffold (
        topBar = {
            TopAppBar(title = { Text(text = "Your Plant") },
                actions = {
                    IconButton(onClick = { /*TODO*/ }) {
                        Text(text = "Add")
                    }
                })
        }
    ){ paddingValues ->
        Column (
            modifier = Modifier.padding(paddingValues)
        ){
            LazyVerticalGrid(
                columns = GridCells.Fixed(2)
            ) {
                items(plantDatas.size) {item ->
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .height(231.dp)
                            .width(160.dp)
                            .padding(3.dp)
                            .background(Color(0xFFEFF2ED))
                    ) {
                        Column (
                            horizontalAlignment = Alignment.Start,
                            verticalArrangement = Arrangement.Top,
//                            modifier = Modifier.padding(10.dp)
                        ){
                            Image(
                                modifier = Modifier
                                    .height(150.dp)
                                    .width(150.dp),
                                contentScale = ContentScale.Crop,
                                painter = rememberAsyncImagePainter(plantDatas[item].image),
                                contentDescription = null,
                            )
                            PlantDescription(title = "Name: ", data = plantDatas[item].name)
                            PlantDescription(title = "Date: ", data = plantDatas[item].date)
                            PlantDescription(title = "Age: ", data = plantDatas[item].age)
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun PlantDescription(title: String, data: String){
    Row {
        Text(text = title,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            color = Color(0xFF565954))
        Text(text = data,
            fontWeight = FontWeight.W500,
            fontSize = 14.sp,
            color = Color(0xFF565954))
    }
}