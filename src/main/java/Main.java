import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

public class Main {

//    Use Supplier if it takes nothing, but returns something.
//    Use Consumer if it takes something, but returns nothing.
//    Use Callable if it returns a result and might throw (most akin to Thunk in general CS terms).
//    Use Runnable if it does neither and cannot throw.

    // ref: https://ezsi.github.io/2014/06/08/java-lambda-tools/

    private static Consumer<String[]> doThings = args -> {
        System.out.println("do something with first arg: "+ args[0]);
        System.out.println("do something with second arg: "+ args[1]);
    };

    private static Consumer<String[]> doActualThings1 = args -> {
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


    public static void main(String[] args){
        doThings();
        doThings1("Thing1");
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
        Consumer<String[]> action = doActualThings1;
        Consumer<String[]> decorator = logDecorator(action);
        decorator.accept(args);
    }

}
