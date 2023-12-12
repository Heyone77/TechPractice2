package com.example.techpractice2

import androidx.compose.foundation.gestures.detectTapGestures
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.hapticfeedback.HapticFeedbackType
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.platform.LocalHapticFeedback
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun MainWindow() {
    Column(Modifier.fillMaxSize()) {
        Text(text = "123111111111111111")
        Text(text = "123111111111111111")
        Text(text = "123111111111111111")
        Text(text = "123111111111111111")
        Text(text = "123111111111111111")
        Text(text = "1233123213123")
        Text(text = "123321312312")
        Text(text = "123312312312312312")
        Text(text = "123412412412321312")

        Spacer(Modifier.weight(1f, fill = true))
        ButtonColumn()

    }
}


@Composable
fun SquareButton(text: String, modifier: Modifier = Modifier, onClick: () -> Unit) {
    Button(
        onClick = onClick,
        modifier = modifier,
        shape = RectangleShape,
        contentPadding = PaddingValues(0.dp)
    ) {
        Text(text)
    }
}

@Composable
fun ButtonColumn() {
    Column(
        Modifier
            .fillMaxWidth()
            .padding(0.dp)
    ) {
        // Первые три кнопки
        SquareButton(
            text = "Накладная",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* TODO */ }
        )
        SquareButton(
            text = "Платёжка",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* TODO */ }
        )
        SquareButton(
            text = "Заявка на оплату",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* TODO */ }
        )

        // Визуальный разделитель
        Divider(
            color = Color.Gray, // Вы можете выбрать цвет разделителя
            thickness = 1.dp, // и его толщину
            modifier = Modifier.padding(vertical = 8.dp) // и отступы
        )

        // Последняя кнопка
        SquareButton(
            text = "Загрузить",
            modifier = Modifier.fillMaxWidth(),
            onClick = { /* TODO */ }
        )
    }
}

@Composable
fun TextListWithContextMenu(items: List<String>) {
    val haptics = LocalHapticFeedback.current
    val expanded = remember { mutableStateOf(false) }
    val selectedItem = remember { mutableStateOf<String?>(null) }

    LazyColumn {
        items(items) { item ->
            Text(
                text = item,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
                    .pointerInput(Unit) {
                        detectTapGestures(
                            onLongPress = {
                                haptics.performHapticFeedback(HapticFeedbackType.LongPress)
                                selectedItem.value = item
                                expanded.value = true
                            }
                        )
                    }
            )
        }
    }

    if (expanded.value) {
        DropdownMenu(
            expanded = expanded.value,
            onDismissRequest = { expanded.value = false }
        ) {
            items.forEachIndexed { index, s ->
                DropdownMenuItem(text = { /*TODO*/ }, onClick = { /*TODO*/ })
            }
        }
    }
}


@Preview(showSystemUi = true)
@Composable
fun PreviewMainWindow() {
    MainWindow()
}
