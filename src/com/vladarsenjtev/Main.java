package com.vladarsenjtev;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Main {
    public static final Map<String, List> library = new HashMap();

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Граф Монте-Кристо", 200));
        products.add(new Product("451 градус по Фаренгейту", 230));
        products.add(new Product("Фауст", 600));
        products.add(new Product("Великий Гэтсби", 700));
        products.add(new Product("Властелин колец", 500));


        library.put("Book", products);
        for (Map.Entry<String, List> entry : library.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
        System.out.println();
        System.out.println(getMap("Book"));

    }

    public static List getMap(String category) {
        List<Product> list = new ArrayList<>(library.get(category));
        return list.stream()
                .filter(lis -> lis.price() > 250)
                .collect(Collectors.toList());
    }
}