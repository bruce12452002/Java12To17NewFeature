package org.example;

public class NewFeature {
    public static void main(String[] args) {
        String s = "dd";
        NewFeature j = new NewFeature();
        System.out.println(j.switch1(s));
        System.out.println(j.switch2(s));
        System.out.println(j.multiString());
        j.testInstanceOf(s);
        Animal xxx = new Animal(111, "xxx");
        System.out.println(xxx.id + "=" + xxx.name());
    }

    private int switch1(String s) {
        return switch (s) { // 必需有回傳值或直接 return
            case "bruce" -> 1;
            case "aa", "dd" -> 2;
            default -> 3;
        };
    }

    private int switch2(String s) {
        return switch (s) { // 必需有回傳值或直接 return
            case "bruce":
                yield 1;
            case "aa", "dd":
                yield 2;
            default:
                yield 3;
        };
    }

    private String multiString() {
        return """
                Hi, my name is xxx!
                How are you?
                """;
    }

    private void testInstanceOf(Object o) {
        if (o instanceof String p) {
            System.out.println(o);
        }
    }

    /**
     * record 相當於一個類別，會將參數名稱和類型產生 getter 方法，但方法名就是參數名
     * 因為原本的類別寫法要寫很多的 getter/setter hashCode…等，雖然可以自動生成，但代碼看起來就是多
     * 不可用泛型
     */
    public record Animal(int id, String name) {
        public static int a;
        public static final String b = "bb";
    }
    /**
     * 反編譯後代碼
     *      public static record Animal(int id, String name) {
     *         public static int a;
     *         public static final String b = "bb";
     *
     *         public Animal(int id, String name) {
     *             this.id = id;
     *             this.name = name;
     *         }
     *
     *         public int id() {
     *             return this.id;
     *         }
     *
     *         public String name() {
     *             return this.name;
     *         }
     *     }
     */
}
