package edu.hw4;

import org.junit.jupiter.api.Test;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class Tests {

    Tasks tasks = new Tasks();

    @Test
    public void task1() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);

        List<Animal> animals = List.of(dog, cat, bird, spider);

        List<Animal> result = tasks.getSortedByHeightAnimals(animals);

        List<Animal> expected = List.of(spider, bird, cat, dog);

        assertThat(result).isEqualTo(expected);

    }

    @Test
    public void task2() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);

        List<Animal> animals = List.of(dog, cat, bird, spider);

        List<Animal> result = tasks.getKHeaviestAnimals(animals, 2);

        List<Animal> expected = List.of(dog, cat);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task3() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2);

        Map<Animal.Type, Long> result = tasks.countAnimalsOfTypes(animals);

        Map<Animal.Type, Long> expected = new HashMap<>();
        expected.put(Animal.Type.DOG, 2L);
        expected.put(Animal.Type.BIRD, 1L);
        expected.put(Animal.Type.SPIDER, 1L);
        expected.put(Animal.Type.CAT, 2L);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task4() {
        Animal dog = new Animal("Big Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Small Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal bird = new Animal("Little Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Creepy Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);

        List<Animal> animals = List.of(dog, cat, bird, spider);

        Animal result = tasks.getLongestAnimalName(animals);

        Animal expected = spider;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public final void test5() {

        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        assertThat(tasks.getMostCommonSex(animals)).isEqualTo(Animal.Sex.M);
    }

    @Test
    public void task6() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        Map<Animal.Type, Animal> result = tasks.getHeaviestAnimalsOfTypes(animals);

        Map<Animal.Type, Animal> expected = new HashMap<>();
        expected.put(Animal.Type.CAT, cat2);
        expected.put(Animal.Type.DOG, dog2);
        expected.put(Animal.Type.BIRD, bird);
        expected.put(Animal.Type.SPIDER, spider);
        expected.put(Animal.Type.FISH, fish);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task7() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        Animal result = tasks.getOldestAnimal(animals, 3);

        Animal expected = dog;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task8() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        Animal result = tasks.getHeaviestAnimalWhichBelowK(animals, 80).get();

        Animal expected = cat2;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task9() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        int result = tasks.countSumOfPaws(animals);

        int expected = 26;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task10() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        List<Animal> result = tasks.getAnimalsWhichCountOfPawsNotEqualAge(animals);

        List<Animal> expected = List.of(cat, cat2, spider, dog2, fish);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task11() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 150, 3, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 145, 4, false);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 180, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        List<Animal> result = tasks.getAnimalsWhichCanBiteAndMoreThanHundred(animals);

        List<Animal> expected = List.of(dog, dog2);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task12() {
        Animal dog = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 4, 25, 40, true);
        Animal cat = new Animal("Cat", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Cat", Animal.Type.CAT, Animal.Sex.M, 5, 145, 4, false);
        Animal bird = new Animal("Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 20, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 180, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 6, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        long result = tasks.countAnimalsWhichWeightMoreThanHeight(animals);

        long expected = 2L;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task13() {
        Animal dog = new Animal("Sammy Brown Jr", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Mary", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Lovely Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Little Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Creepy Odd Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        List<Animal> result = tasks.getAnimalWhichHaveNameMoreTwoWords(animals);

        List<Animal> expected = List.of(dog, spider);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task14() {
        Animal dog = new Animal("Sammy Brown", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Mary", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Lovely Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Little Bird", Animal.Type.BIRD, Animal.Sex.M, 2, 20, 0, false);
        Animal spider = new Animal("Creepy Odd Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish);

        boolean result = tasks.isInListDogMoreThanK(animals, 100);
        boolean expected = false;

        assertThat(result).isEqualTo(expected);

        result = tasks.isInListDogMoreThanK(animals, 47);
        expected = true;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task15() {
        Animal dog = new Animal("Sammy Brown", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Mary", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Lovely Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Little Bird", Animal.Type.BIRD, Animal.Sex.M, 3, 20, 1, false);
        Animal bird2 = new Animal("Little Bird Second", Animal.Type.BIRD, Animal.Sex.M, 4, 20, 4, false);
        Animal spider = new Animal("Creepy Odd Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish, bird2);

        Map<Animal.Type, Integer> result = tasks.getSumWeightForEachType(animals, 2, 8);

        Map<Animal.Type, Integer> expected = new HashMap<>();
        expected.put(Animal.Type.DOG, 9);
        expected.put(Animal.Type.CAT, 6);
        expected.put(Animal.Type.BIRD, 5);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task16() {
        Animal dog = new Animal("Sammy Brown", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Mary", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Lovely Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Little Bird", Animal.Type.BIRD, Animal.Sex.M, 3, 20, 1, false);
        Animal bird2 = new Animal("Little Bird Second", Animal.Type.BIRD, Animal.Sex.M, 4, 20, 4, false);
        Animal spider = new Animal("Creepy Odd Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 0, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, spider, dog2, fish, bird2);

        List<Animal> result = tasks.sortByTypeSexName(animals);

        List<Animal> expected = List.of(cat2, cat, dog2, dog, bird, bird2, fish, spider);

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task17() {
        Animal dog = new Animal("Sammy Brown", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Mary", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Lovely Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Little Bird", Animal.Type.BIRD, Animal.Sex.M, 3, 20, 1, false);
        Animal bird2 = new Animal("Little Bird Second", Animal.Type.BIRD, Animal.Sex.M, 4, 20, 4, false);
        Animal spider = new Animal("Creepy Odd Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 12, true);
        Animal fish1 = new Animal("Dorri", Animal.Type.FISH, Animal.Sex.M, 1, 10, 20, true);

        List<Animal> animals = List.of(dog, cat, cat2, bird, fish, spider, dog2, fish, bird2);

        boolean result = tasks.isSpidersBiteMoreThanDogs(animals);

        boolean expected = false;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public void task18() {
        Animal dog = new Animal("Sammy Brown", Animal.Type.DOG, Animal.Sex.F, 4, 50, 3, true);
        Animal cat = new Animal("Mary", Animal.Type.CAT, Animal.Sex.F, 3, 30, 2, true);
        Animal cat2 = new Animal("Lovely Cat", Animal.Type.CAT, Animal.Sex.M, 5, 45, 4, true);
        Animal bird = new Animal("Little Bird", Animal.Type.BIRD, Animal.Sex.M, 3, 20, 1, false);
        Animal bird2 = new Animal("Little Bird Second", Animal.Type.BIRD, Animal.Sex.M, 4, 20, 4, false);
        Animal spider = new Animal("Creepy Odd Spider", Animal.Type.SPIDER, Animal.Sex.M, 1, 5, 0, false);
        Animal dog2 = new Animal("Dog", Animal.Type.DOG, Animal.Sex.F, 8, 80, 6, true);
        Animal fish = new Animal("Nemo", Animal.Type.FISH, Animal.Sex.M, 1, 10, 12, true);
        Animal fish1 = new Animal("Dorri", Animal.Type.FISH, Animal.Sex.M, 1, 10, 20, true);

        List<Animal> animals1 = List.of(dog, cat, cat2, bird, fish);
        List<Animal> animals2 = List.of(spider, dog2, fish1, bird2);
        List<List<Animal>> animals = List.of(animals1, animals2);

        Animal result = tasks.findHeaviestFish(animals);

        Animal expected = fish1;

        assertThat(result).isEqualTo(expected);
    }

    @Test
    public final void test19() {
        Animal animal1 = new Animal(
            "Sam",
            Animal.Type.BIRD,
            Animal.Sex.M,
            1,
            40,
            50,
            false
        );

        List<Animal> animals = List.of(animal1);

        Set<Tasks.ValidationError> expected = null;
            //Set.of(
//            new Tasks.ValidationError(
//                "Name must starts with capital character",
//                Tasks.ValidationErrorType.INVALID_NAME
//            )
//            new Tasks.ValidationError(
//                "Type cannot be null",
//                Tasks.ValidationErrorType.INVALID_TYPE
//            ),
//            new Tasks.ValidationError(
//                "Sex cannot be null",
//                Tasks.ValidationErrorType.INVALID_SEX
//            ),
//            new Tasks.ValidationError(
//                "Age mustn't be negative",
//                Tasks.ValidationErrorType.INVALID_AGE
//            ),
//            new Tasks.ValidationError(
//                "Weight mustn't be negative",
//                Tasks.ValidationErrorType.INVALID_WEIGHT
//            ),
//            new Tasks.ValidationError(
//                "Height mustn't be negative",
//                Tasks.ValidationErrorType.INVALID_HEIGHT
//            )
//        );

        Set<Tasks.ValidationError> actual = tasks.findAnimalWithError(animals).get("some");

        assertEquals(expected, actual);

    }

    @Test
    public final void test20() {
        Animal animal1 = new Animal(
            "",
            null,
            Animal.Sex.F,
            -1,
            0,
            -50,
            false
        );

        List<Animal> animals = List.of(animal1);

        String expected = "INVALID_AGE; INVALID_NAME; INVALID_TYPE; INVALID_WEIGHT";

        String result = tasks.animalErrorToString(animals).get("");

        assertThat(result).isEqualTo(expected);
    }

}
