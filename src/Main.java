import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        List<String> names = Arrays.asList("Jack", "Connor", "Harry", "George", "Samuel", "John");
        List<String> families = Arrays.asList("Evans", "Young", "Harris", "Wilson", "Davies",
                "Adamson", "Brown");
        Collection<Person> persons = new ArrayList<>();
        for (int i = 0; i < 10000000; i++) {
            persons.add(new Person(
                    names.get(new Random().nextInt(names.size())),
                    families.get(new Random().nextInt(families.size())),
                    new Random().nextInt(100),
                    Sex.values()[new Random().nextInt(Sex.values().length)],
                    Education.values()[new Random().nextInt(Education.values().length)])
            );

        }
        long count = persons.stream()
                .filter(person -> person.getAge() < 18)
                .count();
        System.out.println("количество несовершеннолетних граждан " + count + " человек.");
        System.out.println();
        families = persons.stream()
                .filter(x -> x.getAge() == 18)
                .filter(x -> x.getSex() == Sex.MAN)
                .map(x -> x.getFamily())
                .collect(Collectors.toList());
        System.out.println("Фамилии призывников: " + families);
        System.out.println();
        families = persons.stream()
                .filter(x -> x.getEducation() == Education.HIGHER)
                .filter(x -> x.getAge() > 18)
                .filter(x -> x.getSex()==Sex.MAN ? x.getAge()<65 : x.getAge()<60)
                .map(x -> x.getFamily())
                .sorted(Comparator.naturalOrder())
                .collect(Collectors.toList());
        System.out.println("Список потенциально работоспособных людей с высшим образованием:" + families);

    }
}

//(x, y) -> y != 0 ? x / y : 0;


