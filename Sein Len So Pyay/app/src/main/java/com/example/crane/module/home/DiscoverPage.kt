package com.example.crane.module.home

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.rounded.Close
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FilledIconButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.SheetState
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.crane.models.NewFeedData
import com.example.crane.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DiscoverPage(navController: NavController) {
    val newFeedDatas = listOf(
        NewFeedData(
            userName = "Susan",
            profileImg = R.drawable.img,
            plantedType = "Planted Fiddle Leaf Ficus",
            createTime = "- 2h ago",
            description = "Our community's green initiative is blossoming beautifully! Look at this magnificent addition to our planet, courtesy of one of our..see more",
            image = R.drawable.img_2,
            reactCount = 201,
            commmandCount = 43,
            shareCount = 8
        ),
        NewFeedData(
            userName = "Julia",
            profileImg = R.drawable.img_1,
            plantedType = "Planted Mango Tree",
            createTime = "- 6h ago",
            description = "A new addition to our growing forest! Hats off for planting this lovely tree and the...see more",
            image = R.drawable.img_3,
            reactCount = 842,
            commmandCount = 125,
            shareCount = 46
        )
    )
    val scope = rememberCoroutineScope()
    var isBottomSheetVisible by rememberSaveable { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState(
        skipPartiallyExpanded = true
    )
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        LazyColumn (
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ){
            items(newFeedDatas) { item ->
                Box( modifier = Modifier
                    .padding(8.dp)
                    .width(350.dp)
                    .background(Color(0xFFF4F7F2), shape = RoundedCornerShape(10.dp)) // Add background color and corner radius
//                    .border(1.dp, Color.Gray, shape = RoundedCornerShape(10.dp)) // Optional: Add border
                ){
                    Column(modifier = Modifier
                        .padding(8.dp)
                        .width(330.dp)) {
                        Row(verticalAlignment = Alignment.CenterVertically) {
                            Image(
                                painter = painterResource(item.profileImg),
                                contentDescription = "avatar",
                                contentScale = ContentScale.Crop,
                                modifier = Modifier
                                    .size(36.dp)
                                    .clip(CircleShape)
//                                    .border(2.dp, Color.Gray, CircleShape)
                            )
                            Column (
                                modifier = Modifier
                                    .fillMaxWidth()
                            ){
                                Row (
                                    horizontalArrangement = Arrangement.SpaceBetween
                                ){
                                    Text(text = item.userName,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W700,
                                        color = Color(0xFF29332A))
                                    Spacer(modifier = Modifier.weight(1f))
                                    Text(text = "Follow",
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W500,
                                        color = Color(0xFF3A7D44))
                                }
                                Row {
                                    Text(text = item.plantedType,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W500,
                                        color = Color(0xFF787A76) )
                                    Text(text = item.createTime,
                                        fontSize = 16.sp,
                                        fontWeight = FontWeight.W500,
                                        color = Color(0xFF787A76))
                                }
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Text(text = item.description,
                            fontSize = 14.sp,
                            fontWeight = FontWeight.W500,
                            color = Color(0xFF29332A))
                        Image(
                            painter = painterResource(item.image),
                            contentDescription = "newFeed1",
                            contentScale = ContentScale.FillBounds,
                            modifier = Modifier
                                .size(310.dp)
//                                .clip(RoundedCornerShape(percent = 10))
                        )
                        Row (
                            horizontalArrangement = Arrangement.SpaceEvenly,
                            modifier = Modifier
                                .fillMaxWidth()
                        ){
                            Row (
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically,
                            ){
                                IconButton(
                                    modifier = Modifier
                                        .size(17.dp)
                                        .padding(0.dp),
                                    onClick = { /*TODO*/ }
                                ) {
                                    Icon(
                                        painter = painterResource(id = R.drawable.react_icon),
                                        contentDescription = "react_icon",
                                        modifier = Modifier.size(17.dp) // Ensure Icon size is as desired
                                    )
                                }
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(text = "${item.reactCount}loves",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W500)
                            }
                            Row (
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                IconButton(
                                    modifier = Modifier
                                        .size(17.dp)
                                        .padding(0.dp),
                                    onClick = { /*TODO*/ }
                                ) {
                                    Icon(
                                        modifier = Modifier.size(17.dp),
                                        painter = painterResource(id = R.drawable.command_icon),
                                        contentDescription = "command_icon")
                                }
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(text = "${item.commmandCount}commands",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W500)
                            }
                            Row (
                                horizontalArrangement = Arrangement.Center,
                                verticalAlignment = Alignment.CenterVertically
                            ){
                                IconButton(
                                    modifier = Modifier
                                        .size(17.dp)
                                        .padding(0.dp),
                                    onClick = { /*TODO*/ }
                                ) {
                                    Icon(
                                        modifier = Modifier.size(17.dp),
                                        painter = painterResource(id = R.drawable.share_icon),
                                        contentDescription = "share_icon")
                                }
                                Spacer(modifier = Modifier.width(2.dp))
                                Text(text = "${item.shareCount}shares",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.W500)
                            }
                        }
                    }
                }
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BottomSheet(
    isBottomSheetVisible: Boolean,
    sheetState: SheetState,
    onDismiss: () -> Unit
) {

    if (isBottomSheetVisible) {

        ModalBottomSheet(
            onDismissRequest = onDismiss,
            sheetState = sheetState,
            containerColor = Color.Transparent,
            contentColor = MaterialTheme.colorScheme.onSurface,
            shape = RectangleShape,
            dragHandle = null,
            scrimColor = Color.Black.copy(alpha = .5f),
            windowInsets = WindowInsets(0, 0, 0, 0)
        ) {
            Box(
                modifier = Modifier
                    .statusBarsPadding()
                    .fillMaxWidth()
                    .padding(8.dp),
                contentAlignment = Alignment.Center
            ) {

                FilledIconButton(
                    modifier = Modifier.size(48.dp),
                    onClick = onDismiss,
                    colors = IconButtonDefaults.filledIconButtonColors(
                        containerColor = MaterialTheme.colorScheme.background
                    )
                ) {

                    Icon(
                        imageVector = Icons.Rounded.Close,
                        contentDescription = "Hide the dialog."
                    )

                }

            }
            // Implement the custom layout here ...

        }

    }

}

