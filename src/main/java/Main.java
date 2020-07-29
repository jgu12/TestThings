import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

//    Use Supplier if it takes nothing, but returns something.
//    Use Consumer if it takes something, but returns nothing.
//    Use Callable if it returns a result and might throw (most akin to Thunk in general CS terms).
//    Use Runnable if it does neither and cannot throw.

    private static Consumer<String[]> doThings = args -> {
//        if(args.length != 2){
//            throw new RuntimeException("number of args in doThings must be 2");
//        }
//        if(args[0] == null || args[1] == null){
//            throw new RuntimeException("null arg exists");
//        }
        System.out.println("do something with first arg: "+ args[0]);
        System.out.println("do something with second arg: "+ args[1]);
    };

    private static Consumer<String[]> doThings1 = args -> {
        System.out.println("do another thing with first arg: "+ args[0]);
    };

    private static Consumer<String[]> logDecorator(Consumer<String[]> f) {
        Consumer<String[]> fun = (args) -> {
            System.out.println(">>>entering logDecorator");
            f.accept(args);
            long time = System.currentTimeMillis();
            System.out.println(">>>leaving logDecorator, time = " + time);
        };
        return fun;
    }



    private static Function<Integer, Long> fib = n -> {
        if (n == 0 || n == 1) return 1L;
        return Main.fib.apply(n - 1) + Main.fib.apply(n - 2);
    };

    private static Function<List<String>, Integer> test = argsList -> {
        if(argsList.size() != 2){
            throw new RuntimeException("Number of argument must be 2");
        }
        System.out.println(argsList.get(0));
        System.out.println(argsList.get(1));
        return 0;
    };

    private static <T, K> Function<T, K> timer(Function<T, K> f) {
        Function<T, K> fun = (args) -> {
            System.out.println("entering timer, args = " + args);
            long time = System.currentTimeMillis();
            K ret = f.apply(args);
            time = System.currentTimeMillis() - time;
            System.out.println("leaving timer, time = " + time);
            return ret;
        };
        System.out.println("leaving timer, fun = " + fun.toString());
        return fun;
    }

    public static void main(String[] args){
        doThings();
        doThings1("Thing1 ha ha ha");
//        Function<Integer, Long> tfib = timer(fib);
//        long res = tfib.apply(30);
//        System.out.println("res = " + res);
    }


    public static void doThings(){
        String[] args = new String[2];
        args[0] = "arg 1 - something";
        args[1] = "arg 2 - '//some//path//to//something'";
        Consumer<String[]> action = doThings;
        Consumer<String[]> decorator = logDecorator(action);
        decorator.accept(args);
    }

    public static void doThings1(String arg){
        String[] args = new String[1];
        args[0] = arg;
        Consumer<String[]> action = doThings1;
        Consumer<String[]> decorator = logDecorator(action);
        decorator.accept(args);
    }

    private static void run(){
        Function<List<String>, Integer> mytest = test;
        List<String> argsList = new ArrayList<>();
        argsList.add("first arg - a name");
        argsList.add("second arg - '//a/path//to//something//or//else'");
        test.apply(argsList);
    }
}
