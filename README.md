# ISEP - CLEAN CODE - TP FINAL
### Project by Hans Haller, Id N° 61622
## About the project structure :

This project uses Java 1.8 SDK.



Please note:

* The class ShoppingCart, certainly only containing a List of Products, has been created if there were others objects to be added to the ShoppingCart.
* The class DoubleHandler was created to define a method to handle .0001 and .9999 exceptions using mathematics formulas. This allow us to use native Java double type.

GitHub Repo available: `github.com/Hnshlr/GL-CC_TPFINAL_HANS_HALLER_61622`

Repo is private until due date for final return. If you'd like to access the repo, please request by mail: `hans.haller@eleve.isep.fr` 
Make sure to provide me with your github username.

Clean Code :

My project is built such as there is :
- A Product.java class, with a name, an initial cost, a product classification and a isImported boolean. Moreover, the product class contains a tax value and a cost with taxes included attribute.
- A shopping cart, which atm is only composed of a List of product, but could be gifted more attributes (Id of the guy pushing the cart, for example?).
- A FacturationSystemIsep class, implementing the functional interface FacturationSystemIsep whose only method is a method to calculate and inform product's tax value and cost with taxes.
- A Invoice class, which act as a mother for all classes. Indeed, it contains the facturation system instance used, in this very case an instance of the FacturationSystemIsep class.
It also contains the  shopping cart that stores all the products, as well a total tax and total price value.
- Going forward with building the concept, I realized issues upon manipulating doubles, such as some ending with .0001 or .9999
This is caused by the Java, using 2 ^ EXP form to represent doubles. To fix this myself, I've created a DoubleHandler class to fix such decimal errors using only native Math functions.
- Finally, in order to verify all methods implemented in my FacturationSystemIsep implementation, I've worked with unit tests, under the "JUnitTesting" class, to verify a single product tax value, then a single product cost with taxes included.
Then I've verified the whole shopping cart total tax value, and finally the total price with taxes included.

Functional Programming :  

I used a Functional Interface to define how a FacturationSystem would work. In my case, the method this functional interface provide is a method to calculate a product cost with taxes.
Then, I created a FacturationSystemIsep class that implement this interface, and use the TP subject tax calculation rules to calculate product tax value and cost with taxes.
This interface could be used to define future Facturation System.

TDD :

For my tests, I first decided to verify each product tax value. 
Then, I verified each new product cost with taxes included.
Following that, I verified the total tax value.
Finally, I use one test to check product total value (with total tax included).

Design Pattern :

Currently, my shopping cart uses the FacturationSystemIsep.java class, an implementation of the FacturationSystem interface, in order to calculate a product

Differently from TP4, I've used my enum to enumerate product's classification (Meds, Food, etc).
This enum only store percentage values, where in TP4, the getter would return the whole new price after delivery calculation.
The reason I decided to only return percentage values, is to avoid a pre-meditated price calculation, since I wasn't to sure of my future percentage calculations. 
Then I also realised that hhe product could be submitted to others fees (In this case, the isImported fee).
Keeping my enumeration that way allow one to, if there were to be new way to filter/classify products, to simply add to the enum a new parameter (or complete new element).