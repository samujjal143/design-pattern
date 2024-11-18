1. SINGLETON 
    - The SINGLETON is a creational design pattern. This pattern ensures that only one instance of its kind exists and
    provides a single point of access to it from any other part of our application. 
    - It should be used when a class must have a single instance available. As this pattern disables all means of 
    creating objects of a class except for the special static creation method, this method either creates a new object
    or returns the existing instance if it has already been created.
    - This pattern requires special treatment in a multi-threaded environment as its code needs to be adapted to handle
    multiple threads.

2. BUILDER
   - The BUILDER is a creational design pattern that lets us create complex objects on a step-by-step basis. It allows us
   to produce different types and representations of an object using the same construction process.
   - To make use of the builder pattern, we have to create a builder class which contains the same fields of the objects
   we need created. Inside this class, we will have several methods that accept the parts or fields of the object we want 
   to instantiate separately, in addition to another method responsible for the actual creation process of our object
   - If the same creation code is used to create several objects in our application, then we can think about creating a
   director class. Directors encapsulate various ways to construct a product using the same builder object.
   - If we are making use of a director class, the client code must create both the builder and the director objects and
   must pass the builder object created to the director.