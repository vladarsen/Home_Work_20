package com.vladarsenjtev;

import java.util.*;

public class Main {
    public static final Map<String, List> library = new HashMap();

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product("Граф Монте-Кристо", 200, true));
        products.add(new Product("451 градус по Фаренгейту", 230, true));
        products.add(new Product("Фауст", 600, true));
        products.add(new Product("Великий Гэтсби", 700, false));
        products.add(new Product("Властелин колец", 500, false));


        library.put("Book", products);
        for (Map.Entry<String, List> entry : library.entrySet())
            System.out.println(entry.getKey() + " - " + entry.getValue());
        System.out.println();

        System.out.println(getMap("Book"));
    }

    public static Optional getMap(String category)  {
       Optional optional = library.get(category).stream()
               .min(Comparator.comparing(Product::price));
       return optional;
    }
}