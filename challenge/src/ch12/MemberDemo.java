package ch12;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class MemberDemo {
    public static void main(String[] args){
        Stream<String> sm;
        List<String> names = Arrays.asList("홍길동", "배장화", "임꺽정", "연흥부", "김선달", "황진이");

        sm = names.stream();
        sm.filter(n -> n.charAt(0) < '이').forEach(n -> System.out.print(n+" "));
        System.out.println();

        sm = names.stream();
        sm.sorted().forEach(n -> System.out.print(n + " "));
        System.out.println();

        sm = names.stream();
        System.out.println(sm.findFirst());

        sm = names.stream();
        System.out.println(sm.findFirst().get());

        sm = names.stream();
        System.out.println(sm.count());
    }
}
