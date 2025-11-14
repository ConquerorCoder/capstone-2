   ## Design Decisions

### 1. Why I used an Interface (OrderItem)
Using an interface allows the Order class to treat pizzas, drinks, and add-ons the same way.  
This improves flexibility while keeping beginner-friendly code.


### 2. Validation System(changed class)
centralizes all input-checking.  
This prevents repeated try/catch code and keeps the UI clean.

### 3. Simplicity Over Complexity
The design uses interfaces and clean separation but avoids advanced patterns unless required.  
This balances readability, maintainability, and beginner-friendly practices.