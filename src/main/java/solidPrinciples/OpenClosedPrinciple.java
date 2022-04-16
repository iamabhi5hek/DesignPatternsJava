package solidPrinciples;

import java.util.List;
import java.util.stream.Stream;

/*
open for extension but closed for modification
 */
public class OpenClosedPrinciple {
    public static void main(String[] args) {
        Product apple = new Product("Apple", Color.RED, Size.LARGE);
        Product tree = new Product("Tree", Color.GREEN, Size.HUGE);
        Product capsicum = new Product("Capsicum", Color.YELLOW, Size.MEDIUM);

        List<Product> products = List.of(apple, tree, capsicum);

        ProductFilter pf = new ProductFilter();
        System.out.println("Green prod(old): ");
        pf.filterByColor(products, Color.GREEN)
                .forEach(p -> System.out.println(" - " + p.name + " : " + p.size));


        BetterFilter bf = new BetterFilter();
        System.out.println("Red prod(new): ");
        bf.filter(products, new ColorSpec(Color.RED))
                .forEach(p -> System.out.println(" - " + p.name + " : " + p.size));


        System.out.println("Large red");
        bf.filter(products,
                new AndSpecifications<>(
                        new ColorSpec(Color.RED),
                        new SizeSpec(Size.LARGE)
                ))
                .forEach(p -> System.out.println(" - " + p.name + " : " + p.size));


    }
}

enum Color{
    RED, GREEN, YELLOW
}

enum Size{
    MEDIUM, LARGE, HUGE
}

class Product{
    public String name;
    public Color color;
    public Size size;

    public Product(String name, Color color, Size size) {
        this.name = name;
        this.color = color;
        this.size = size;
    }
}

class ProductFilter{
    public Stream<Product> filterByColor(List<Product> products, Color color){
        return products.stream().filter(p->p.color==color);
    }

    public Stream<Product> filterBySize(List<Product> products, Size size){
        return products.stream().filter(p->p.size==size);
    }

    public Stream<Product> filterBySizeAndColor(List<Product> products, Color color, Size size){
        return products.stream().filter(p->p.color==color && p.size==size);
    }
}

interface Specification<T>{
    boolean isSatisfied(T item);
}

interface Filter<T>{
    Stream<T> filter(List<T> items, Specification<T> spec);
}

class ColorSpec implements Specification<Product>{

    private Color color;

    public ColorSpec(Color color) {
        this.color = color;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.color == color;
    }
}

class SizeSpec implements Specification<Product>{

    private Size size;

    public SizeSpec(Size size) {
        this.size = size;
    }

    @Override
    public boolean isSatisfied(Product item) {
        return item.size == size;
    }
}

class BetterFilter implements Filter<Product>{

    @Override
    public Stream<Product> filter(List<Product> items, Specification<Product> spec) {
        return items.stream().filter(p -> spec.isSatisfied(p));
    }
}

class AndSpecifications<T> implements Specification<T>{

    private Specification<T> first, second;

    public AndSpecifications(Specification<T> first, Specification<T> second) {
        this.first = first;
        this.second = second;
    }

    @Override
    public boolean isSatisfied(T item) {
        return first.isSatisfied(item) && second.isSatisfied(item);
    }
}