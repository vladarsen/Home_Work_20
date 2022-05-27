package com.vladarsenjtev;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final Map<String, List> library = new HashMap();

    public static void main(String[] args) throws InterruptedException {
        LocalDate current_date = LocalDate.now();

        List<Product> products = new ArrayList<>();
        products.add(new Product("Граф Монте-Кристо", 74, current_date));
        products.add(new Product("451 градус по Фаренгейту", 230, current_date));
        products.add(new Product("Фауст", 600, current_date));
        products.add(new Product("Великий Гэтсби", 700, current_date));
        products.add(new Product("Властелин колец", 500, current_date));


        library.put("Book", products);
        for (Map.Entry<String, List> entry : library.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
        System.out.println();
        System.out.println(getMap("Book"));

    }

    public static List getMap(String category) {
        List<Product> list = new ArrayList<>(library.get(category));
        return list.stream()
                .filter(lis -> lis.localDate().getYear() == 2022 && lis.price() < 75)
                .collect(Collectors.toList());
    }
}