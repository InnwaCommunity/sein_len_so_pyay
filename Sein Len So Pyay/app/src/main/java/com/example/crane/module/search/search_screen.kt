package com.example.crane.module.search

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.crane.models.SearchAccountData


//@Preview(showBackground = true)
//@Composable
//fun SearchScreenPreview() {
//    val navController = rememberNavController()
//    CraneTheme {
//        SearchScreen(navController)
//    }
//}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchScreen(navController: NavController){
    val searchAccountData = listOf<SearchAccountData>(
        SearchAccountData(
            userName = "Allison Stanton",
            imageUrl = "https://s3-alpha-sig.figma.com/img/87ac/15cd/e47e22be5dd7c74ae98d9c91133cad95?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=LEYyDmrG6mROSVoHsizQU4hEunrnOkQBSiHL3yiCGnvBuqs0s5Vh6L4Gqy10tJDn4OToM4enkEnV5UFSDBUU8xmGGAYUgl652nxV4QBAm7WiGs1q3pngeE6fL5DQ2jP2jE347pMaltRIzkDsXTQtbnm4IQtbxNVjaPa0UMXSH90Ehy~kq9nk2Ql-38B~lu-j9HVWBFkyVaF3aukIH2qxLxi-UN9kYPh4TZPgEgTYBkWub~FRUQGa5xnA9AQy1xJ7u7jB1fda2GmVsji4GwulDnjTiDPKX0b7kzAdWefQEngYFXrHVQ7kBZCJ-q3ZMiaY5tr47fcpCWPgFUWNDbv~Jg__"
//        imageUrl = "https://picsum.photos/id/237/200/300"
            ),
        SearchAccountData(
                userName = "Zain Dorwart",
        imageUrl = "https://s3-alpha-sig.figma.com/img/5544/3c84/9337dc004f0d9edc98625da9efdaa942?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=eRtdnfXmw5u4QC4QNcOc0NXXzodUM69oW3nC5MdhLQvXFxW73I0v7qL3rVUmQTuPfNbFtsbOwp1reZESJhM6dK8rgFa6dcd5p4F4e4SqZHvf-THunOHqwntQvKHaHO2iY~Irgs8s2xgbP1uHEJwxKRZJBYKpMpVCU7z8TdgoGUvER85Pmc8Iupt1ItocMm227TpOFs1zqjKWCDNTtjcmCFz38yav9HAIHbwAziaVQ5Nwtv1OsjDNnNyuI5QSvpVyVOyNut-7wLnEW9VneS6KvXYWwkCqvGLa5CjwYkfomU6IRVwOcnRsFvt3IW17-lA8pHqpPcBuS7h-6ZN8013jBA__"
//            imageUrl = "https://picsum.photos/id/237/200/300"
        ),
        SearchAccountData(
            userName = "Zain Lipshutz",
            imageUrl = "https://s3-alpha-sig.figma.com/img/9fe8/5daa/f75896b4323d39ad5091979b2c1f926f?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Rk2kwBh9QSBS~QI-QAh2UJnPoFCrueLK2g03~K2zgpGFxaACjrdn-DCjvCPVw-0M09vAAR9g-hCUlzLS8rxRi40FYXqUWijeyCDI7erKutMRg9BO~A6UgLrIECY0fhdrXLpaPFU6ABbRrToPD5EuRwaeZJ2vIP8YoZb0IFE01Pr4M5wGUcYTqYe9xdqDtxV6NTy3B16O7F4pRIajOqW7VXTYfCRDIkjPlPQ2YX4Exlory7gmw61UQaTEWfqYig3~WAL2WEyfhChk2j5a6CNEl2gE1tos~xlWQXcTOFv1qaPRETNvkLkbYj3BY12~NV8F0Hgu1~epMmM6dTNSNlIHQw__"
//            imageUrl = "https://picsum.photos/id/237/200/300"
        ),
        SearchAccountData(
            userName = "Giana Donin",
            imageUrl = "https://s3-alpha-sig.figma.com/img/1eb6/1183/fe77d59173e34d97d89a002c7d7b7229?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=gxdzVS-SpnkXdgsARURCDrApBESoGQ9b96wk-PNTIdKWL6HH6briTfIyzqcH7anZi3NwRufWjODNXCz~lQ-9w9NEL2jnDffgoB32dwaqIyV2vh-A6r6CydXj2zUHfKUPrkRfNgpHO9OPfj9B-7fuoZmlZaO6WOBn5ow5cSo1LYJ6O4J-W~A1utjc3tepbY~d6FMZNMqVnuzovxilEUgqGHQC-E-JehodCRXBqkCcpYqY6Bzj3HSOj6PrQ1ZQ65Ji8XlXGQG~yAoSEGApnSsraARd2-BFhZ-U3Y3u7J9cLeBpAEDm7PqHyGXvVzEsVvE69uah7qbdV3xu8a18hpfAYQ__"
//            imageUrl = "https://picsum.photos/id/237/200/300"
        ),
        SearchAccountData(
            userName = "Paityn Aminoff",
            imageUrl = "https://s3-alpha-sig.figma.com/img/ec4e/dfd7/de1fb99c6d0a3a9ff09ed665523e2869?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=QyFktuUIglviaudITWJhqsaRGZZxCTVgz9Gh8DZSmPY-KUw~Uuhj4SKCuRHY5W3MWxN4P3EHgacqOIWhyJs68K44Dyr7UyoS5eq-I0mWUO87uro79GeD9jsccM3f51zRx2XREgi7CoQat3PR1xcGyY-RoBKq7YWlErpaWyLteTkbJ1gJrPU6EwE6eY0njNa8xPtPdKBBo1FHd-YxsXS9-hdsAitgdSNHzaxi3-~JGoDTo1iG4b8P-FKrcjEMEXOKW0U48vUhxrI-cFhB7H9Z3pSOGBwnaJa~MvpHm4OSNojmPSxeRDmnNbiufuAoxxNhH73XTf4VJHYZSNSXqag7cg__"
//            imageUrl = "https://picsum.photos/id/237/200/300"
        ),
        SearchAccountData(
            userName = "Cristofer",
            imageUrl = "https://s3-alpha-sig.figma.com/img/1705/dccb/b1174273fc00cb3347b03a7732de44a6?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=Njm7gmUIZMZGN0hDUKyAtbOeDGXzNXUxfG2a8eSHfYfwXnWTG-cjV8lzM3B3sAdtMAoNmI83j9aU0pcaHzdr6wbrubWhV6wyCQXhlJ2nVoMK~fZmYbAysdkipB-B1a05nYtpiY42FZeK922kEeZxuFQ7i1ZhGZNyEUm3wprR~V150PklpERJPNPTeTOelhgw5NH3Jsn4MRqLmCuLb0t86Wqf21-ytBw2J-EnZZpdbK3QsYb4RQz17g8-6nwNYjoGnUPZEHrXnvH55UjRYfvbeZTxTUq4g~qwHQg4AcnPLbKS77qSGzRw4bcBSLaRstDixC7DTquiLQ3-MvHMIdQLhA__"
//            imageUrl = "https://picsum.photos/id/237/200/300"
        ),
        SearchAccountData(
            userName = "Martin Bator",
            imageUrl = "https://s3-alpha-sig.figma.com/img/0550/62c9/5a6e894371ef02fa8ca68762d776ae33?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=bS9gpTPsgP061yIe4Qr4L7EsX-Taa1zR90~DzDLyjz~Gr8SUZSKuYBwYkj258caRwpJb1CqY6A9DM3G6cHZhY~DsGXulR5w2befpoEaC8kT4jKBrdnpfEHvGxCBU4We-Bn-d1cPw7fxBC8Hcq2L8sSJZoxO2HeasGma1tKdDrZdSg~ZTDPUFIrFOxfWKNLjbzOMIg-uxGCh6UcIvsW7zLqmpkDminvBbTKAiwKZStc54EVQs09NrNIMtSufvQtdewbi3RhIL5B1PJPpSoBitujg7TsNVhogKxPvO93kucyAxyIsGJ2oF3lDWnM0hoUIgrJTBvmSFvmZ6-aQX3G9HTg__"
//            imageUrl = "https://picsum.photos/id/237/200/300"
        ),
        SearchAccountData(
            userName = "Adison Geidt",
            imageUrl = "https://s3-alpha-sig.figma.com/img/02e3/0fd6/e661884ccd1b66d9b25c94f5fc8eed3b?Expires=1717372800&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=BjK0Psx-s4Ml3Hdrqsi3WgChnTGVyz0SOeySeKB-mrxG4oCDZE6reG9V2ZZZ8EXILdq36VsitQz1DpyYZBrsmZSkrOPOvnm2eGJE6Wl1EkK-DPKFbETIY9HeJL~3tJ8Uw-VzMtlw1XLVXoFU5pnarfP8N6baOOA89rFrJXb27SfCYGKjo3VsyBN1AEf2TwfUui9P4O82ldEFNxpJsUF3hwNvZiW~21FXRipmq195suAGl8fO2ZaUm12WzTc~DBoEeHD0lzVkgHRO61BL~MJF5odhJU~JNgseDl831~t8-39CX6awHu-K4kcK48q62jpCoh6bjPgPSNqjX5X7Y-I-qQ__"
//            imageUrl = "https://picsum.photos/id/237/200/300"
        )
    )
    Scaffold (
        topBar = {
            var searchInput by remember { mutableStateOf("") }
            TopAppBar(title = { Text(text = "SearchScreen") },
                actions = {
                    OutlinedTextField(
                        value = searchInput,
                        onValueChange = {searchInput=it},
//        label = { Text(text = "Email Address") },
//                        placeholder = { Text(text = "Enter your email") },
                        trailingIcon = {
                            Icon(imageVector = Icons.Default.Search, contentDescription = "Email Icon")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(8.dp),
                        shape = RoundedCornerShape(12.dp)
                    )
                })
        }
    ){ paddingValues ->
        Column (
            modifier = Modifier.padding(paddingValues)
        ){
            LazyColumn(
                horizontalAlignment = Alignment.Start,
                verticalArrangement = Arrangement.Center
            ){
                items(searchAccountData){item ->
                    Row (
                        horizontalArrangement = Arrangement.SpaceBetween,
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier.padding(8.dp)
                    ){
                        Row (
                            horizontalArrangement = Arrangement.Start,
                            verticalAlignment = Alignment.CenterVertically,
                        ){
                            Image(
                                painter = rememberAsyncImagePainter(item.imageUrl),
                                contentDescription = null,
                                modifier = Modifier
                                    .size(42.dp)
                                    .clip(CircleShape),
                                contentScale = ContentScale.Crop,
                            )
                            Text(text = item.userName,
                                color = Color(0xFF29332A),
                                fontSize = 16.sp,
                                fontWeight = FontWeight.W500)
                        }
                        IconButton(onClick = { /*TODO*/ }) {
                            Icons.Default.MoreVert
                        }
                    }
                }
            }
        }
    }
}