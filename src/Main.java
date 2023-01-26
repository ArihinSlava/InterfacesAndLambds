import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Main {


    public static void main(String[] args) {

        /// Task 1
        System.out.println("Task 1 ");

        Predicate<Integer> predicate = new Predicate<Integer>() {
            @Override
            public boolean test(Integer integer) {
                return integer > 0;
            }
        };
        System.out.println(predicate.test(8));
        System.out.println(predicate.test(-5));
        System.out.println();

        Predicate<Integer> predicate1 = integer -> integer > 0;
        System.out.println(predicate1.test(10));
        System.out.println(predicate1.test(-20));
        System.out.println();


        /// Task 2
        System.out.println("Task2");

        Consumer<String> greeting = new Consumer<String>() {
            @Override
            public void accept(String name) {
                System.out.printf("Hello, %s! \n", name);

            }
        };
        greeting.accept("Vycheslav");

        Consumer<String> greeting1 = name -> System.out.println("Hello" + " " + name + "!");
        greeting1.accept("Marina");
        System.out.println();


        /// Task3
        System.out.println("Task3");

        Function<Double, Long> function = new Function<Double, Long>() {
            @Override
            public Long apply(Double number) {
                return Math.round(number);
            }
        };
        System.out.println(function.apply(12.111));


        Function<Double, Long> function1 = number -> Math.round(number);
        System.out.println(function1.apply(10.4444));
        System.out.println();

        /// Task 4
        System.out.println("Task4");

        Supplier<Integer> supplier = new Supplier<Integer>() {
            @Override
            public Integer get() {
                Random random = new Random();
                return random.nextInt(100);
            }
        };
        System.out.println(supplier.get());

        Supplier<Integer> supplier1 = () -> {
            Random random = new Random();
            return random.nextInt(100);
        };

        System.out.println(supplier1.get());
        System.out.println();

        /// Task5
        System.out.println("Task5");


        Predicate<Integer> predicate2 = x -> x % 2 != 0;
        Function<Integer, Integer> function2 = x -> x * 2;
        Function<Integer, Integer> function3 = x -> x * 3;
        Function<Integer, Integer> result = ternaryOperator(predicate2, function2, function3);
        result.apply(4);

    }

    public static <T, U> Function<T, U> ternaryOperator(
            Predicate<? super T> condition,
            Function<? super T, ? extends U> ifTrue,
            Function<? super T, ? extends U> ifFalse) {
        return t -> {
            U result = condition.test(t) ? ifTrue.apply(t) : ifFalse.apply(t);
            System.out.println(result);
            return result;
        };
    }
}
