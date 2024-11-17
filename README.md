1. SINGLETON 
    - The SINGLETON is a creational design pattern. This pattern ensures that only one instance of its kind exists and
    provides a single point of access to it from any other part of our application. 
    - It should be used when a class must have a single instance available. As this pattern disables all means of 
    creating objects of a class except for the special static creation method, this method either creates a new object
    or returns the existing instance if it has already been created.
    - This pattern requires special treatment in a multi-threaded environment as its code needs to be adapted to handle
    multiple threads.