package com.example.crane.module.championsprofile

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.crane.R
import com.example.crane.models.PostData
import com.example.crane.ui.theme.CraneTheme

//
//@Preview(showBackground = true)
//@Composable
//fun PostsPagePreview() {
//    val navController = rememberNavController()
//    CraneTheme {
//        PostsPage(navController)
//    }
//}
@Composable
fun PostsPage(navController: NavController){
    val plants = remember {
        listOf(
            PostData("https://s3-alpha-sig.figma.com/img/169d/da81/c11644be1e8a356832d839fce3770ae5?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=ZO~9EH4zrGybFATC6sjYhcBh7DUkWqNIla8T8kVkN9CZzYRXwanJzgAC7~O6RmX6UbC0RIFc6x-IXbRN4GHB1Nfud6e2sAE0sAbsmx~mcRTuJJJZytnl1yGI~ZMRaNs7eOoJoaRZtTn5vIhMupW5qL44khiDGNYg0fxT22BgMXXLAEP3ylS5F48dggLdUrDrz7oTIAZJLnWrVTYq8S3jJu3PexNcY0YPCtkpMHQ~yCjgIlhhPZ5ERrJRHSm7VKSY3o5PHyETQT9X64yWzyafJeJG1O1iTHqAMSoYkr7Zp-GFZrwPCJXJ1QGheZXjn~fszWlcJ-I96WvTIg2YflDzvA__",
                "104"),
            PostData("https://s3-alpha-sig.figma.com/img/2b58/94ce/212af7e48c818c4653f93be11fca5d80?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Qb2pTBTs3NWFB7imb82XE8JirOOIzJgdkxP3AkwuN17l3jztqyKHpZgbq-U4M3XDCprpKta1xZuCc6Hg3~TL3Arl8IkOvTw0UvFE46NPT8uNomnameYK2pkoCvkwx-q9RUOg9X~wNxGNDV~INz~FQ-KCWNyVGJUxShGv8YcF18-bIqTggbCwNC7MUbXv8qm~FTNSAt95NQNnke4AKNs516ztevQRHPyjExNFX-agvR8~R9O4ZPQ71tJkSO9dAA4kLEyyz9RtB~ZcZXb987HoQ0zTReE85kacLgGytQmKhwNZGl9DrmHONQ46olF7LgKQECmor-mGU6wIsBBU1PxGxg__",
                "2.1k"),
            PostData("https://s3-alpha-sig.figma.com/img/9225/cc96/e701b7b81cbc3eb4e80fc4d0337b0bcf?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=hT4u4cgoJdwv5HLZ3EywVVWeUAzTQ3AZXTgbQWyevHO9dtHfJDb3wzKzqVhvBbvcm9ArIrmxtIXFBPj~GX1R0w3OlExmIsBxHjlRNarAvBYew-5q9vLuq4AqBlZRnbQApmaz6m2STHU4-qSxmqn9nLoeDrm8Ms~WfhxMIlosgr4d3B3iAwDUY5UpbH8r~OTCTkj9BmPNDg~-7LpLU80c33iw~O5jL7x637Y7cAVV9xqcyqLp7JH7aNEQ1GczIG3dtoPXbGA0ajPAaZqUaSjB~tcgHHcEgjBzxy3T~CdzLdwow20NU1BVB53jg-buXVQ~42f5GvXpwGm~Ab0wFHdprg__",
                "856"),
            PostData("https://s3-alpha-sig.figma.com/img/0de5/0865/3df5a9e1379f9fe733791948ecc04dd2?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Tdq7Yj5~4Wcj43fmtYe-zIRCIeT~LVVjPx5MpojYDKRxUzuEhxw59R~0LTX0PlUTlpL9FqK~RUjhtaRZgaWDl0NX-UfkL8iVaqThieDXTwiB8yidlC8H8Oci2IWCZL3Lk1YcHNQSSKEY~8wI0kVEPaSX50A0oa1OhbxFTsfAKBHhnZ-J7T9FgQyWlnvOOchJF0KEMBIDpdZZpfQTcg19kt-NFORB09M97tgxcSy~btCd8oaB459ws6NlGfrYaa~d3BDGypgxQmg4IYERap6GBqIEvgE0oMHjplzSm~64FgqIwuMf25wD4ZUTTJFqS4Mmnnx~Ubok5KEXqrH-a5yYpQ__",
                "58"),
            PostData("https://s3-alpha-sig.figma.com/img/fb6b/ec38/00c491a4e4dbb11f8b0cd9734ef0e91c?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=SHAiMnNuPjXl6lJG~NPwIi1yFOdDmaGvOmcgRB3AO~Fr8CXSOuArSwa-7tcpNW2-pvaXkJEWrJlzMx37A7ABUgBVZmtA90Suik~lT7CKLrFbhpMsnDIZ-a6QCBCiTQfI31TUDA4EA3wny9PpbB6WY6rvlYT824D6aOr9VEPNjDIcYCPzz5GE1uxy5jrKRWcc4NZOPY~DOcYcB~LC3-mDMd8WtXPEXLXN1emF8s6BiA4RbIx1ognxhgb~PELyi-qe9zGbIy4Bq~OGvZDodZMTwJdmY9QtwqSe7pKB4M5DbCEovqrlLJ1F7r-VWtmeOIDpJPjVZgefn7vbJaDTWvwIHg__",
                "104"),
            PostData("https://s3-alpha-sig.figma.com/img/a41a/f78e/db2bb842c5b30cb7ac8cca657f361686?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=JP~N5nAXtY7RBSKgpKCWwBtJpX5jJIhR4AtE8uar9eP34kJ271k97Zo0WxW6yxVnxaX3HeR5XUbx3u1-RDH4NDW~2QlPXjBWu-BjbnrTK2Lc9dHmMq5sWSge4yagtq~CRwf1JJzqOEjVErX5s~NlPqXjj0yQWtBphrcB8sKbuXFDGQA5RgpG2QONeIozgBfLfWDCzXogHHTyD55KREodu4i8OPnh9ALrw12RgV8pFbE6Vh29aIseRfPk0tDnmTDtXAOBSw4zjX0bEgZtHFfSk71FS264gqD78XkPZ8ddGjAYzLaFK7SqUXEMc87C8tBNul5jDHrNA472E78hPiTl-w__",
                "2.1k"),
            PostData("https://s3-alpha-sig.figma.com/img/2b58/94ce/212af7e48c818c4653f93be11fca5d80?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Qb2pTBTs3NWFB7imb82XE8JirOOIzJgdkxP3AkwuN17l3jztqyKHpZgbq-U4M3XDCprpKta1xZuCc6Hg3~TL3Arl8IkOvTw0UvFE46NPT8uNomnameYK2pkoCvkwx-q9RUOg9X~wNxGNDV~INz~FQ-KCWNyVGJUxShGv8YcF18-bIqTggbCwNC7MUbXv8qm~FTNSAt95NQNnke4AKNs516ztevQRHPyjExNFX-agvR8~R9O4ZPQ71tJkSO9dAA4kLEyyz9RtB~ZcZXb987HoQ0zTReE85kacLgGytQmKhwNZGl9DrmHONQ46olF7LgKQECmor-mGU6wIsBBU1PxGxg__",
                "856"),
            PostData("https://s3-alpha-sig.figma.com/img/9225/cc96/e701b7b81cbc3eb4e80fc4d0337b0bcf?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=hT4u4cgoJdwv5HLZ3EywVVWeUAzTQ3AZXTgbQWyevHO9dtHfJDb3wzKzqVhvBbvcm9ArIrmxtIXFBPj~GX1R0w3OlExmIsBxHjlRNarAvBYew-5q9vLuq4AqBlZRnbQApmaz6m2STHU4-qSxmqn9nLoeDrm8Ms~WfhxMIlosgr4d3B3iAwDUY5UpbH8r~OTCTkj9BmPNDg~-7LpLU80c33iw~O5jL7x637Y7cAVV9xqcyqLp7JH7aNEQ1GczIG3dtoPXbGA0ajPAaZqUaSjB~tcgHHcEgjBzxy3T~CdzLdwow20NU1BVB53jg-buXVQ~42f5GvXpwGm~Ab0wFHdprg__",
                "58")
        )
    }

        LazyVerticalGrid(
        columns = GridCells.Fixed(2)
    ) {
        items(plants.size) {item ->
            Box(
                contentAlignment = Alignment.TopEnd,
                modifier = Modifier
                    .size(162.dp)
                    .padding(3.dp)
                    .background(Color.Gray)
            ) {
                Image(
                    contentDescription = null,
                    modifier = Modifier
                        .height(162.dp)
                        .fillMaxWidth(),
                    painter = rememberAsyncImagePainter(plants[item].postUrl),
                    contentScale = ContentScale.Crop
                )
                Card(
                    shape = RoundedCornerShape(15.dp,15.dp,15.dp,15.dp),
                    colors = CardDefaults.cardColors(
                        containerColor = Color.Black.copy(alpha = 0.6f),
                    ),

                    modifier = Modifier
                        .height(20.dp)
                        .width(60.dp)
                ) {
                    Box(
                        modifier = Modifier.fillMaxWidth(),
                        contentAlignment = Alignment.Center) {
                        Row (
                            modifier = Modifier.fillMaxWidth(),
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            verticalAlignment = Alignment.CenterVertically
                        ){
                            Icon(painter = painterResource(id = R.drawable.react_icon),
                                modifier = Modifier
                                    .size(10.dp)
                                    .background(Color.Yellow),

                                contentDescription = null)
                            Text(
                                text = plants[item].reactCount,
                                color = Color.White,
                                fontSize = 14.sp,
                                fontWeight = FontWeight.W500
                            )
                        }
                    }
                }
            }
        }
    }
}

