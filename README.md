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
   to instantiate separately, in addition to another method responsible for the actual creation process of our object.
   - If the same creation code is used to create several objects in our application, then we can think about creating a
   director class. Directors encapsulate various ways to construct a product using the same builder object.
   - If we are making use of a director class, the client code must create both the builder and the director objects and
   must pass the builder object created to the director.

3. ADAPTER
   - The ADAPTER pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate
   with one another.
   - It uses inheritance and composition to enable objects with incompatible interfaces to collaborate with one another.
   To do that, it creates a middle layer class that serves as a translator between our code and the legacy of the third
   party class we want to make use of.
   - By following the ADAPTER pattern, we will be applying the Single Responsibility and the Open Closed Principles
   because the adapting behaviour is now separated and we can introduce new adapters without breaking existing code.

4. OBSERVER
   - The OBSERVER design pattern is a behavioral design pattern that notifies multiple objects, or subscribers about
   any events that happen to the object they're observing, or publisher.
   - It allows us to change or take action on a set of objects when and if the state of another object changes and this
   can be done even if the modifiable set of objects is unknown beforehand or changes dynamically at runtime.
   - By using this pattern, we will be applying the Open Closed Principle as we can introduce new subscriber classes
   without having to change the publisher's code, and vice versa if there's a publisher interface.

5. STATE
   - The STATE pattern is a behavioral design pattern that allows an object alter its behavior when its internal state
   changes. This allows us to avoid primitive if-else statements and extract each logic to a separate classes and let 
   the context delegate the behavior to the corresponding state class.
   - By following the STATE pattern, we will be applying the Single Responsibility and the Open Closed Principles
   because each state is now organized in a separate class, and we have the ability to introduce new states without
   changing existing state classes or the context.