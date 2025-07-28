# Design Patterns Overview

This document outlines several key design patterns, their purpose, and how they should be used.

---

## 1. SINGLETON

- The SINGLETON is a creational design pattern. This pattern ensures that only one instance of its kind exists and provides a single point of access to it from any other part of our application.
- It should be used when a class must have a single instance available. As this pattern disables all means of creating objects of a class except for the special static creation method, this method either creates a new object or returns the existing instance if it has already been created.
- This pattern requires special treatment in a multi-threaded environment as its code needs to be adapted to handle multiple threads.

---

## 2. BUILDER

- The BUILDER is a creational design pattern that lets us create complex objects on a step-by-step basis. It allows us to produce different types and representations of an object using the same construction process.
- To make use of the builder pattern, we have to create a builder class which contains the same fields of the objects we need created. Inside this class, we will have several methods that accept the parts or fields of the object we want to instantiate separately, in addition to another method responsible for the actual creation process of our object.
- If the same creation code is used to create several objects in our application, then we can think about creating a director class. Directors encapsulate various ways to construct a product using the same builder object.
- If we are making use of a director class, the client code must create both the builder and the director objects and must pass the builder object created to the director.

---

## 3. PROTOTYPE

- The PROTOTYPE is a creational design pattern that delegates the object duplication or cloning process to the actual objects that are being cloned without coupling the creation of the object to its class.
- We should use PROTOTYPE pattern when our code shouldn't depend on the concrete classes of the objects that we need to copy or duplicate as this pattern will clone objects without coupling them to their concrete classes.
- This will get rid of repeated initialization code and will save resources and time.

---

## 4. FACTORY METHOD

- The FACTORY METHOD is a creational design pattern. It loosens the coupling of a given code by separating the product's construction code from the code that uses this product.
- If we have no idea beforehand of the exact types and dependencies of the objects our code will work with then we should use this pattern as the factory pattern makes it easy to extend the product construction code independently from the rest of the application and hence allows us to introduce new products without breaking existing code.
- By following the FACTORY METHOD pattern, we will be applying the Open-Closed Principle and the Single Responsibility Principle as we are centralizing the product creation code in one place in the program.

---

## 5. ADAPTER

- The ADAPTER pattern is a structural design pattern that allows objects with incompatible interfaces to collaborate with one another.
- It uses inheritance and composition to enable objects with incompatible interfaces to collaborate with one another. To do that, it creates a middle layer class that serves as a translator between our code and the legacy of the third party class we want to make use of.
- By following the ADAPTER pattern, we will be applying the Single Responsibility and the Open-Closed Principles because the adapting behaviour is now separated and we can introduce new adapters without breaking existing code.

---

## 6. FLYWEIGHT

- FLYWEIGHT is a structural design pattern that lets us fit more objects into the available RAM by sharing common parts of state between multiple objects, instead of storing all of the data in each object individually.
- A FLYWEIGHT refers to an object that minimizes memory usage by sharing some of the initial objects' data with other similar objects.
- It should be used when a program must support a huge number of similar objects which barely fit into the available amount of RAM.
- By applying this pattern, we will be splitting the state of the initial object into two: an intrinsic-immutable state and an extrinsic-mutable one.

---

## 7. PROXY

- PROXY is a structural design pattern that lets us provide a substitute for another object and controls access to that object, allowing us to perform something before or after the request reaches the original object.
- To do this, the PROXY must implement the same interface of the original object.
- Additionally, the PROXY can manage the lifecycle of the service object, and the proxy will work even if the service object isn't ready or is not available
- By following this pattern, we will be applying the Open-Closed Principle, as we can introduce new proxies without changing the service nor the clients.

---

## 8. STRATEGY

- The STRATEGY pattern is a behavioral design pattern that lets us define a family of algorithms, puts each of them into a separate class, and makes their objects interchangeable. By doing this, our several behaviors or strategies will be easily replaceable and interchangeable by clients at runtime.
- By following the STRATEGY pattern, we will be following the Single Responsibility and the Open-Closed Principles because each strategy is isolated in a separate class and we can easily introduce new strategies without modifying the existing strategy classes nor the context.

---

## 9. OBSERVER

- The OBSERVER design pattern is a behavioral design pattern that notifies multiple objects, or subscribers about any events that happen to the object they're observing, or publisher.
- It allows us to change or take action on a set of objects when and if the state of another object changes and this can be done even if the modifiable set of objects is unknown beforehand or changes dynamically at runtime.
- By using this pattern, we will be applying the Open-Closed Principle as we can introduce new subscriber classes without having to change the publisher's code, and vice versa if there's a publisher interface.

---

## 10. STATE

- The STATE pattern is a behavioral design pattern that allows an object alter its behavior when its internal state changes. This allows us to avoid primitive if-else statements and extract each logic to a separate classes and let the context delegate the behavior to the corresponding state class.
- By following the STATE pattern, we will be applying the Single Responsibility and the Open-Closed Principles because each state is now organized in a separate class, and we have the ability to introduce new states without changing existing state classes or the context.

---

## 11. CHAIN OF RESPONSIBILITY

- The CHAIN OF RESPONSIBILITY is a behavioral design pattern that lets us transform particular behaviors into standalone objects called handlers. Then upon receiving a request this request will pass along the chain of handlers where each one can decide either to process the request or pass it to the next handler in the chain.
- We should use the CHAIN OF RESPONSIBILITY pattern when we encounter the need to execute several handlers in a particular order.
- Additionally, this pattern is useful when the handlers and their order might change at runtime because we have the ability to insert, remove or reorder handlers dynamically.
- Each handler in a chain must make two decisions when receiving a request. It will either process the request or it will pass it along the chain. Finally, concerning the client, he may trigger any handler in the chain, not just the first one and the request will be passed along the chain until some handler refuses to pass it further or until it reaches the end of the chain.

---

## 12. COMMAND

- The COMMAND is a behavioral design pattern that turns a request or a behavior into a stand-alone object that contains everything about that request.
- It is used to encapsulate all the relevant information needed to perform an action or trigger an event.
- It opens a lot of interesting uses: such as passing commands as method arguments, storing them inside other objects or even switching commands at runtime.
- Commands can be serialized, making it easy to write it to and read from a file.