package test;

import java.io.*;
import java.nio.file.*;
import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;


public class lng_java {

    private static class Triplet {
        private final String first;
        private final String second;
        private final String third;

        Triplet(String first, String second, String third) {
            this.first = first;
            this.second = second;
            this.third = third;
        }

        @Override
        public String toString() {
            return first + ";" + second + ";" + third;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (!(o instanceof Triplet)) return false;
            Triplet triplet = (Triplet) o;
            return Objects.equals(first, triplet.first) &&
                    Objects.equals(second, triplet.second) &&
                    Objects.equals(third, triplet.third);
        }

        @Override
        public int hashCode() {
            return Objects.hash(first, second, third);
        }
    }

    public static void main(String[] args) throws IOException {

        long startTime = System.currentTimeMillis();

        Map<Triplet, List<Triplet>> result = Files.lines(Paths.get("lng-big.csv"))
                .map(l -> l.split(";"))
                .map(a -> {
                    if (a.length == 3) {
                        return new Triplet(a[0], a[1], a[2]);
                    }
                    return null;
                })
                .filter(t -> t != null)
                .distinct()
                .collect(Collectors.groupingBy(r -> r, Collectors.mapping(r -> r, Collectors.toList())));

        AtomicInteger i = new AtomicInteger(0);

        long count = result.entrySet()
                .stream()
                .filter(r -> r.getValue().size() > 0)
                .count();

        Files.write(Paths.get("result.txt"),
                new StringBuilder("Records grouping count that greater 1 is ")
                        .append(count)
                        .append("\n")
                        .toString()
                        .getBytes());

        Files.write(Paths.get("result.txt"),
                () -> result
                        .entrySet()
                        .stream()
                        .sorted((o1, o2) -> {
                            return (o2.getValue().size() > o1.getValue().size()) ? 1 : ((o2.getValue().size() < o1.getValue().size())) ? -1 : 0;
                        })
                        .<CharSequence>map(e -> "Group " + i.incrementAndGet() + '\n'
                                + e.getValue()
                                .stream()
                                .map(Object::toString)
                                .collect(Collectors.joining("\n"))).iterator(), StandardOpenOption.APPEND);

        long timeSpent = System.currentTimeMillis() - startTime;

        System.out.println(timeSpent);
    }
}

