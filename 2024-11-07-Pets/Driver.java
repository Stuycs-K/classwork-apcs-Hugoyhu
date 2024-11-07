/*
The Bird class's getName function was overridden to take the superclass function and alter it by inserting "The Mighty" in front of the original output
*/
/*
A bird is an animal but an animal is not a bird, you cannot store a parent class in a child class.
*/
public class Driver {
  public static void main (String[] args) {
    Animal animal1 = new Animal("Bark", 2, "Theo");
    animal1.speak();

    Bird bird1 = new Bird("Tweet", 1, "Polly", 6, "red");
    bird1.speak();

    Animal a1 = new Animal("Moo", 6, "Margarette");
    Animal a2 = new Bird("Chirp", 6, "Margarine", 8, "blue");
    Bird b1 = new Bird("Click", 4, "Molly", 0.7, "green");
    //Bird b2 = new Animal("Neigh", 13, "Tree", 70, "brown");

    a1.speak();
    a2.speak();
    b1.speak();
  }
}
