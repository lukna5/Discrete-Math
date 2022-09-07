import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class Peano {

    public interface Function {
        int apply(int... args);
    }

    public static class N implements Function {

        @Override
        public int apply(int... args) {
            return args[0] + 1;
        }
    }

    public static class Z implements Function {

        @Override
        public int apply(int... args) {
            return 0;
        }
    }

    public static class U implements Function {
        private final int lowerIndex;
        private final int upperIndex;

        public U(final int lowerIndex, final int upperIndex) {
            this.lowerIndex = lowerIndex;
            this.upperIndex = upperIndex;
        }

        @Override
        public int apply(int... args) {
            return args[upperIndex];
        }
    }

    public static class S implements Function {
        private final Function g;
        private final List<Function> f;


        public S(Function g, List<Function> f) {
            this.g = g;
            this.f = f;
        }

        @Override
        public int apply(int... args) {
            int[] fResults = new int[f.size()];
            IntStream.range(0, f.size()).forEach(index -> fResults[index] = f.get(index).apply(args));
            return g.apply(fResults);
        }
    }

    public static class R implements Function {
        private final Function f;
        private final Function g;

        public R(Function f, Function g) {
            this.f = f;
            this.g = g;
        }


        @Override
        public int apply(int... args) {
            int x = args[0];
            int y = args[1];
            if (y == 0) {
                return f.apply(x);
            } else {
                return g.apply(x, y - 1, new R(f, g).apply(x, y - 1));
            }
        }
    }

    public static void main(String[] args) {
        Function pred = new S(
                new R(new Z(), new U(3, 1)),
                Arrays.asList(new U(1, 0), new U(1, 0))
        );
        Function exp = new R(
                new U(1, 0),
                new S(pred, List.of(new U(3, 2)))
        );
        createTest(1000, 9, exp);
        createTest(9, 2, exp);
        createTest(3, 3, exp);
        createTest(0, 14, exp);
        createTest(100, 150, exp);
        createTest(1000, 999, exp);
    }

    private static void createTest(int a, int b, Function f) {
        System.out.println(a + " - " + b + ": " + f.apply(a, b));
    }
}
