package edu.hw4;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.stream.Collectors;

public class Tasks {
    public Tasks() {
    }

    // task 1: Отсортировать животных по росту от самого маленького к самому большому -> List<Animal>
    public List<Animal> getSortedByHeightAnimals(List<Animal> animals) {
        return animals.stream().sorted(Comparator.comparingInt(Animal::height)).toList();
    }

    //task 2: Отсортировать животных по весу от самого тяжелого к самому легкому, выбрать k первых -> List<Animal>
    public List<Animal> getKHeaviestAnimals(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::weight).reversed())
            .limit(k)
            .toList();
    }

    // task 3: Сколько животных каждого вида -> Map<Animal.Type, Integer>
    public Map<Animal.Type, Long> countAnimalsOfTypes(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.groupingBy(Animal::type, Collectors.counting()));
    }

    // task 4: У какого животного самое длинное имя -> Animal
    public Animal getLongestAnimalName(List<Animal> animals) {
        return animals.stream()
            .max(Comparator.comparingInt(animal -> animal.name().length()))
            .orElseThrow();
    }

    // task 5: Каких животных больше: самцов или самок -> Sex
    public Animal.Sex getMostCommonSex(List<Animal> animals) {
        int maleCount = (int) animals.stream()
            .filter(a -> a.sex() == Animal.Sex.M).count();
        int femaleCount = animals.size() - maleCount;

        return (femaleCount > maleCount) ? Animal.Sex.F : Animal.Sex.M;
    }

    // task 6: Самое тяжелое животное каждого вида -> Map<Animal.Type, Animal>
    public Map<Animal.Type, Animal> getHeaviestAnimalsOfTypes(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::type,
                Function.identity(),
                BinaryOperator.maxBy(Comparator.comparingInt(Animal::weight))
            ));
    }

    // task 7: K-е самое старое животное -> Animal
    public Animal getOldestAnimal(List<Animal> animals, int k) {
        return animals.stream()
            .sorted(Comparator.comparingInt(Animal::age).reversed()).skip(k - 1)
            .findAny().orElseThrow();
    }

    // task 8: Самое тяжелое животное среди животных ниже k см -> Optional<Animal>
    public Optional<Animal> getHeaviestAnimalWhichBelowK(List<Animal> animals, int k) {
        return animals.stream()
            .filter(animal -> animal.height() < k)
            .max(Comparator.comparingInt(Animal::weight));
    }

    // task 9: Сколько в сумме лап у животных в списке -> Integer
    public int countSumOfPaws(List<Animal> animals) {
        return animals.stream()
            .mapToInt(Animal::paws)
            .sum();
    }

    // task 10: Список животных, возраст у которых не совпадает с количеством лап -> List<Animal>
    public List<Animal> getAnimalsWhichCountOfPawsNotEqualAge(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.paws() != animal.age())
            .toList();
    }

    // task 11: Список животных, которые могут укусить (bites == true)
    // и рост которых превышает 100 см -> List<Animal>
    public List<Animal> getAnimalsWhichCanBiteAndMoreThanHundred(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.bites() && animal.height() > 100)
            .toList();
    }

    // task 12: Сколько в списке животных, вес которых превышает рост -> Integer
    public long countAnimalsWhichWeightMoreThanHeight(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.weight() > animal.height())
            .count();
    }

    // task 13: Список животных, имена которых состоят из более чем двух слов -> List<Animal>
    public List<Animal> getAnimalWhichHaveNameMoreTwoWords(List<Animal> animals) {
        return animals.stream()
            .filter(animal -> animal.name().split(" ").length > 2)
            .toList();
    }

    // task 14: Есть ли в списке собака ростом более k см -> Boolean
    public boolean isInListDogMoreThanK(List<Animal> animals, int k) {
        return animals.stream()
            .anyMatch(animal -> animal.type() == Animal.Type.DOG && animal.height() > k);
    }

    // task 15: Найти суммарный вес животных каждого вида, которым от k до l лет -> Map<Animal.Type, Integer>
    public Map<Animal.Type, Integer> getSumWeightForEachType(List<Animal> animals, int k, int l) {
        return animals.stream()
            .filter(animal -> animal.age() >= k && animal.age() <= l)
            .collect(Collectors.groupingBy(Animal::type, Collectors.summingInt(Animal::weight)));
    }

    // task 16: Список животных, отсортированный по виду, затем по полу,
    // затем по имени -> List<Animal>
    public List<Animal> sortByTypeSexName(List<Animal> animals) {
        return animals.stream()
                .sorted(Comparator.comparing(Animal::type)
                .thenComparing(Animal::sex)
                .thenComparing(Animal::name))
                .toList();
    }

    // task 17: Правда ли, что пауки кусаются чаще, чем собаки -> Boolean
    // (если данных для ответа недостаточно, вернуть false)
    public boolean isSpidersBiteMoreThanDogs(List<Animal> animals) {
        long spiderCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.SPIDER)
            .count();

        long dogCount = animals.stream()
            .filter(animal -> animal.type() == Animal.Type.DOG)
            .count();

        if (spiderCount == 0 || dogCount == 0) {
            return false;
        }

        double spiderBiteProbability = (double) spiderCount / animals.size();
        double dogBiteProbability = (double) dogCount / animals.size();

        return spiderBiteProbability > dogBiteProbability;
    }

    // task 18: Найти самую тяжелую рыбку в 2-х или более списках -> Animal
    public Animal findHeaviestFish(List<List<Animal>> animals) {
        return animals.stream()
            .flatMap(List::stream)
            .filter(animal -> animal.type() == Animal.Type.FISH)
            .max(Comparator.comparingInt(Animal::weight))
            .orElse(null);
    }

    // task 19: Животные, в записях о которых есть ошибки:
    // вернуть имя и список ошибок -> Map<String, Set<ValidationError>>.
    public Map<String, Set<ValidationError>> findAnimalWithError(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::name,
                this::validateAnimal
            ));
    }

    //task 20 Сделать результат предыдущего задания более читабельным:
    // вернуть имя и названия полей с ошибками, объединенные в строку -> Map<String, String>
    public Map<String, String> animalErrorToString(List<Animal> animals) {
        return animals.stream()
            .collect(Collectors.toMap(
                Animal::name,
                animal -> {
                    Set<ValidationError> errors = validateAnimal(animal);
                    Set<String> errorMessages = new TreeSet<>();
                    for (var e : errors) {
                        errorMessages.add(e.type.toString());
                    }
                    return String.join("; ", errorMessages);
                }
            ));
    }

    private Set<ValidationError> validateAnimal(Animal animal) {

        Set<ValidationError> errors = new HashSet<>();

        errors.addAll(validateName(animal.name()));
        errors.addAll(validateType(animal.type()));
        errors.addAll(validateSex(animal.sex()));
        errors.addAll(validateAge(animal.age()));
        errors.addAll(validateHeight(animal.height()));
        errors.addAll(validateWeight(animal.weight()));

        return errors;
    }

    private static Set<ValidationError> validateName(String name) {
        Set<ValidationError> errorsName = new HashSet<>();

        if (name.length() == 0) {
            errorsName.add(
                new ValidationError(
                    "Name must contain at least 1 character", ValidationErrorType.INVALID_NAME
                ));
        } else if (Character.toUpperCase(name.charAt(0)) != name.charAt(0)) {
            errorsName.add(new ValidationError(
                "Name must starts with capital character",
                ValidationErrorType.INVALID_NAME
            ));
        } else if (Character.isDigit(name.charAt(0))) {
            errorsName.add(new ValidationError(
                "Name mustn't starts with digit",
                ValidationErrorType.INVALID_NAME
            ));
        }

        return errorsName;
    }

    private static Set<ValidationError> validateAge(int age) {
        Set<ValidationError> errorsAge = new HashSet<>();
        if (age < 0) {
            errorsAge.add(new ValidationError("Age mustn't be negative", ValidationErrorType.INVALID_AGE));
        }
        return errorsAge;
    }

    private static Set<ValidationError> validateHeight(int height) {
        Set<ValidationError> errorsHeight = new HashSet<>();
        if (height < 0) {
            errorsHeight.add(new ValidationError("Height mustn't be negative", ValidationErrorType.INVALID_HEIGHT));
        }
        return errorsHeight;
    }

    private static Set<ValidationError> validateWeight(int weight) {
        Set<ValidationError> errorsWeight = new HashSet<>();
        if (weight < 0) {
            errorsWeight.add(new ValidationError("Weight mustn't be negative", ValidationErrorType.INVALID_WEIGHT));
        }
        return errorsWeight;
    }

    private static Set<ValidationError> validateType(Animal.Type type) {
        Set<ValidationError> errorsType = new HashSet<>();

        if (type == null) {
            errorsType.add(new ValidationError(
                "Type cannot be null",
                ValidationErrorType.INVALID_TYPE
            ));
        }
        return errorsType;
    }

    private static Set<ValidationError> validateSex(Animal.Sex sex) {
        Set<ValidationError> errorsSex = new HashSet<>();

        if (sex == null) {
            errorsSex.add(new ValidationError(
                "Sex cannot be null",
                ValidationErrorType.INVALID_SEX
            ));
        }
        return errorsSex;
    }

    enum ValidationErrorType {
        INVALID_AGE,
        INVALID_HEIGHT,
        INVALID_NAME,
        INVALID_TYPE,
        INVALID_WEIGHT,
        INVALID_SEX
    }

    public static class ValidationError extends RuntimeException {
        private final String message;
        private final ValidationErrorType type;

        ValidationError(String message, ValidationErrorType type) {
            this.message = message;
            this.type = type;
        }

        public String getMessage() {
            return message;
        }

        public ValidationErrorType getType() {
            return type;
        }
    }

}
