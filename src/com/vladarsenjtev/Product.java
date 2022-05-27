package com.vladarsenjtev;

import java.time.LocalDate;
import java.util.Date;

public record Product(String type, int price, LocalDate localDate) {
}