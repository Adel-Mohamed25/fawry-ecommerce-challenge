# Fawry Rise Journey – E‑Commerce Challenge (Java)

This project is a clean, multi‑file Java implementation of the **Full‑Stack Development Internship Challenge** for Fawry Integrated Systems.

## Project structure

```
FawryECommerce/
└── src/
    └── fawry/challenge/
        ├── Product.java
        ├── PerishableProduct.java
        ├── Shippable.java
        ├── ShippableProduct.java
        ├── Cheese.java
        ├── TV.java
        ├── MobileCard.java
        ├── CartItem.java
        ├── ShoppingCart.java
        ├── ShippingService.java
        ├── Customer.java
        └── Main.java
```

## Requirements

* **JDK 17+** (tested on Temurin 21).
* Any IDE (IntelliJ, VS Code) or just a terminal.

## Compile & run (terminal)

```bash
# 1 – navigate to project root
cd FawryECommerce

# 2 – compile all sources to the 'out' folder
javac -d out src/com/fawry/challenge/*.java

# 3 – run
java -cp out com.fawry.challenge.Main
```

## What it covers

* **OOP pillars** – abstraction, inheritance, encapsulation, polymorphism.  
* **Open/Closed & SRP** – easy to extend with new product types.
* **Interface Segregation** – `Shippable` contains only what shipping needs (`getName`, `getWeight`).
* **Error handling** for empty cart, insufficient balance, out‑of‑stock, expired products.
* **ShippingService** receives *only* items implementing `Shippable`.

## Customisation

* Add new products by extending `Product` or `ShippableProduct`.
* Adjust shipping rate in `ShippingService`.
* Replace console I/O with REST endpoints or a UI layer for full‑stack scope.

---

> **Author:** Adel Mohamed  
> **Date:** 2025-07-05
