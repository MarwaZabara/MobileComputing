package com.example.mobilecomputinglab1.ui.Home

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.constraintlayout.compose.ConstraintLayout
import androidx.constraintlayout.compose.Dimension
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.mobilecomputinglab1.data.Reminder

import java.text.SimpleDateFormat
import java.util.*

//@Composable
//fun CategoryPayment(
//    modifier: Modifier = Modifier
//) {
////    val viewModel: CategoryPaymentViewModel = viewModel()
////    val viewState by viewModel.state.collectAsState()
//
//    Column(modifier = modifier) {
//        PaymentList(
//            list = viewState.payments
//        )
//    }
//}




@Composable
fun ReminderList (reminders: Array<String>){
    Scaffold(
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxWidth(),
            contentPadding = PaddingValues(16.dp)
        ) {
//            item {
//                Row(
//                    modifier = Modifier.fillMaxWidth()
//                        .wrapContentHeight()
//                        .padding(vertical = 25.dp),
//                    horizontalArrangement = Arrangement.Center,
//                    verticalAlignment = Alignment.CenterVertically
//                ) {
//                    Text(
//                        "\uD83C\uDF3F  Plants in Cosmetics",
//                        style = MaterialTheme.typography.h3
//                    )
//                }
//            }
            items(reminders) { reminder ->
                ReminderCard(reminder)
            }
        }
    }
}

//@Composable
//fun ReminderList(
//    list: Array<Reminder>?
//) {
//    LazyColumn(
//        modifier = Modifier.fillMaxWidth(),
//        contentPadding = PaddingValues(16.dp)
//    ) {
//        item {
//            Row(
//                modifier = Modifier.fillMaxWidth()
//                    .wrapContentHeight()
//                    .padding(vertical = 25.dp),
//                horizontalArrangement = Arrangement.Center,
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Text(
//                    "\uD83C\uDF3F  Plants in Cosmetics",
//                    style = MaterialTheme.typography.h3
//                )
//            }
//        }
//        items(platList) { plant ->
//            PlantCard(plant.name, plant.description, plant.imageRes)
//        }
//    }
//}
//
//
//
//    LazyColumn(
//        contentPadding = PaddingValues(0.dp),
//        verticalArrangement = Arrangement.Center
//    ) {
//        items(list) { item ->
//            Log.i("print",item)
//            ReminderCard(name = item)
//        }
//    }
//}


@Composable
fun ReminderCard(name: String) {
    Card(
        modifier = Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .wrapContentHeight(),
        shape = MaterialTheme.shapes.medium,
        elevation = 5.dp,
        backgroundColor = MaterialTheme.colors.surface
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = name,
                style = MaterialTheme.typography.h4,
                color = MaterialTheme.colors.onSurface,
                textAlign = TextAlign.Center,
                 modifier = Modifier.fillMaxWidth()
            )
        }
//            Image(
//                painter = painterResource(id = image),
//                contentDescription = null,
//                modifier = Modifier.size(130.dp)
//                    .padding(8.dp),
//                contentScale = ContentScale.Fit,
//            )
//            Column(Modifier.padding(8.dp)) {
//                Text(
//                    text = name,
//                    style = MaterialTheme.typography.h4,
//                    color = MaterialTheme.colors.onSurface,
//                )
//                Text(
//                    text = description,
//                    style = MaterialTheme.typography.body2,
//                )
//            }
    }}

//@Composable
//private fun PaymentListItem(
//    payment: Payment,
//    onClick: () -> Unit,
//    modifier: Modifier = Modifier,
//) {
//    ConstraintLayout(modifier = modifier.clickable { onClick() }) {
//        val (divider, paymentTitle, paymentCategory, icon, date) = createRefs()
//        Divider(
//            Modifier.constrainAs(divider) {
//                top.linkTo(parent.top)
//                centerHorizontallyTo(parent)
//                width = Dimension.fillToConstraints
//            }
//        )
//
//        // title
//        Text(
//            text = payment.paymentTitle,
//            maxLines = 1,
//            style = MaterialTheme.typography.subtitle1,
//            modifier = Modifier.constrainAs(paymentTitle) {
//                linkTo(
//                    start = parent.start,
//                    end = icon.start,
//                    startMargin = 24.dp,
//                    endMargin = 16.dp,
//                    bias = 0f // float this towards the start. this was is the fix we needed
//                )
//                top.linkTo(parent.top, margin = 10.dp)
//                width = Dimension.preferredWrapContent
//            }
//        )
//
//        // category
//        Text(
//            text = payment.paymentCategory,
//            maxLines = 1,
//            style = MaterialTheme.typography.subtitle2,
//            modifier = Modifier.constrainAs(paymentCategory) {
//                linkTo(
//                    start = parent.start,
//                    end = icon.start,
//                    startMargin = 24.dp,
//                    endMargin = 8.dp,
//                    bias = 0f // float this towards the start. this was is the fix we needed
//                )
//                top.linkTo(paymentTitle.bottom, margin = 6.dp)
//                bottom.linkTo(parent.bottom, 10.dp)
//                width = Dimension.preferredWrapContent
//            }
//        )
//
//        // date
//        Text(
//            text = when {
//                payment.paymentDate != null -> { payment.paymentDate.formatToString() }
//                else -> Date().formatToString()
//            },
//            maxLines = 1,
//            overflow = TextOverflow.Ellipsis,
//            style = MaterialTheme.typography.caption,
//            modifier = Modifier.constrainAs(date) {
//                linkTo(
//                    start = paymentCategory.end,
//                    end = icon.start,
//                    startMargin = 8.dp,
//                    endMargin = 16.dp,
//                    bias = 0f // float this towards the start. this was is the fix we needed
//                )
//                centerVerticallyTo(paymentCategory)
//                top.linkTo(paymentTitle.bottom, 6.dp)
//                bottom.linkTo(parent.bottom, 10.dp)
//            }
//        )
//
//        // icon
//        IconButton(
//            onClick = { /*TODO*/ },
//            modifier = Modifier
//                .size(50.dp)
//                .padding(6.dp)
//                .constrainAs(icon) {
//                    top.linkTo(parent.top, 10.dp)
//                    bottom.linkTo(parent.bottom, 10.dp)
//                    end.linkTo(parent.end)
//                }
//        ) {
//            Icon(
//                imageVector = Icons.Filled.Check,
//                contentDescription = stringResource(R.string.check_mark)
//            )
//        }
//    }
//}
//
//private fun Date.formatToString(): String {
//    return SimpleDateFormat("MMMM dd, yyyy", Locale.getDefault()).format(this)
//}