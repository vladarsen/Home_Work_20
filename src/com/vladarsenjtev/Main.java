package com.vladarsenjtev;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static final Map<String, List> library = new HashMap();

    public static void main(String[] args) throws InterruptedException {


        List<Product> products = new ArrayList<>();
        products.add(new Product("Граф Монте-Кристо", 200, new Date()));
        Thread.sleep(5000);
        products.add(new Product("451 градус по Фаренгейту", 230, new Date()));
        Thread.sleep(5000);
        products.add(new Product("Фауст", 600, new Date()));
        Thread.sleep(5000);
        products.add(new Product("Великий Гэтсби", 700, new Date()));
        Thread.sleep(5000);
        products.add(new Product("Властелин колец", 500, new Date()));


        library.put("Book", products);
        for (Map.Entry<String, List> entry : library.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
        System.out.println();
        System.out.println(getMap("Book"));

    }

    public static List getMap(String category) {
        return library.get(category).stream()
                .sorted(Comparator.comparing(Product::date))
                .limit(3)
                .toList();
    }
}