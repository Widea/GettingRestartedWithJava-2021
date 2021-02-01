import java.util.LinkedList;

/**
 * Problem statement:
 * An animal shelter holds only dogs and cats, and operates on a strictly "first in, first out" basis.
 * People must adopt either the "oldest" (based on arrival time) of all animals at the shelter,
 * or they can select whether they would prefer a dog or a cat (and will receive the oldest animal of that type).
 * They cannot select which specific animal they would like.
 * Create the data structures to maintain this system and implement operations such as enqueue,
 * dequeueAny, dequeueDog and dequeueCat.You may use the built-in LinkedList data structure.
 * */

public class StacksAndQueues7V {
    public static abstract class Animal {
        private String name;
        private int order;
        public Animal(String name) {
          this.name = name;
        }
        int getOrder() {
            return order;
        }
        void setOrder(int value) {
            this.order = value;
        }
        boolean isOlderThan(Animal animal) {
            return this.order < animal.getOrder();
        }

        @Override
        public String toString() {
            return name;
        }
    }

    public static class Dog extends Animal {
        public Dog (String name) {
            super(name);
        }
    }

    public static class Cat extends Animal {
        public Cat (String name) {
            super(name);
        }
    }

    public static class AnimalFarm {
        private LinkedList<Dog> dogs = new LinkedList<>();
        private LinkedList<Cat> cats = new LinkedList<>();
        private int count;

        public AnimalFarm() {
            this.count = 0;
        }

        public int farmSize() {
            return dogs.size() + cats.size();
        }

        public void enqueue(Animal animal) {
            count = count + 1;
            animal.setOrder(count);
            if(animal instanceof Dog) {
                dogs.addLast((Dog)animal);
            } else if (animal instanceof Cat) {
                cats.addLast((Cat) animal);
            }
        }

        public Animal dequeueAny() {
            if(farmSize() == 0) {
                return null;
            }
            if (dogs.isEmpty()) {
                return dequeueCat();
            } else if (cats.isEmpty()) {
                return dequeueDog();
            } else {
                if(dogs.peekFirst().isOlderThan(cats.peekFirst())) {
                    return dequeueDog();
                } else {
                    return dequeueCat();
                }
            }
        }

        public Dog dequeueDog() {
            if(dogs.isEmpty())
                return null;
            return dogs.poll();
        }

        public Cat dequeueCat() {
            if(cats.isEmpty())
                return null;
            return cats.poll();
        }
    }

    public static void main(String[] args) {
        AnimalFarm farm = new AnimalFarm();

        Animal dog1 = new Dog("dog1");
        Animal dog2 = new Dog("dog2");
        Animal dog3 = new Dog("dog3");
        Animal dog4 = new Dog("dog4");
        Animal cat1 = new Cat("cat1");
        Animal cat2 = new Cat("cat2");
        Animal cat3 = new Cat("cat3");
        Animal cat4 = new Cat("cat4");

        System.out.println("CURRENT FARM SIZE: " +farm.farmSize());
        farm.enqueue(dog1);
        farm.enqueue(cat1);
        farm.enqueue(dog2);
        farm.enqueue(cat2);
        farm.enqueue(cat3);
        farm.enqueue(dog3);
        farm.enqueue(dog4);
        farm.enqueue(cat4);

        System.out.println("Dequeue any: " + farm.dequeueAny());
        System.out.println("Dequeue cat: " + farm.dequeueCat());
        System.out.println("Dequeue dog: " + farm.dequeueDog());
        System.out.println("Dequeue dog: " + farm.dequeueDog());
        while(farm.farmSize() != 0) {
            System.out.println("Dequeue any: " + farm.dequeueAny());
        }
        System.out.println("Attempting to request animal from empty farm: " +farm.dequeueAny());
    }
}