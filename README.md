**Coollection**

*A cool way to manipulate collections in Java.*

Iterate over a collection is a medieval way to filtering, mapping and ordering. And with Java we are used to work like that. Coollection changes that, is the future, while closures don't arrives for Java.

"Download Coollection 0.2.0":http://github.com/downloads/wagnerandrade/coollection/coollection-0.2.0.jar

**How it works?**

It's easy to use. Just import the collection static methods in your class and... More nothing!

```java 
import static com.wagnerandade.coollection.Coollection.*;
``` 

**How to use this?**

```java
public class Animal {
  private String name;
  private Specime specime;
  
}

List<Animal> animals;
  
```


**1 - Filter**

First you need a Collection. Here we create a Animal List, and we called it animals.

```java
List<Animal> animals;
```

Later you goes add a lot of animals in this list.

Now, you want to take *all* cats, it's easy for Coollections! In this case, name is a method (@animal.name()@).

```java
from(animals).where("name", eq("Cat")).all();
```

Or, would the *first* animal with 2 year old? Easy too!

```java
from(animals).where("age", eq(2)).first();
```

**2 - Filter specification**

You can be more specific in your query, adding more specifications, like *and* and *or*.

```java
from(animals).where("name", eq("Lion")).and("age", eq(2)).all();
from(animals).where("name", eq("Dog")).or("age", eq(5)).all();
```

**3 - Matchers**

There are other matchers to be precise!

```java
eq("Cat")
eqIgnoreCase("Cat")
contains("og")
greaterThan(3)
lessThan(10)
isNull()
```

Or a special matcher, called *not*.

```java
not(eq("Bird"))
not(contains("at"))
not(isNull())
```

**4 - Order**

Order is a very interesting feature to sort your collection.

```java
from(animals).where("name", eq("Cat")).orderBy("age").all();
from(animals).where("age", eq(5)).orderBy("name", Order.DESC).first();
```

**5 - Select**

Select field from expression.

```java
from(animals).select("name").all();
from(animals).select("toString").all();
from(animals).select("specime").all();
from(animals).<Specime>select("specime").all();
```


You can use just order, without filter.

```java
from(animals).orderBy("name");
```


**To Maven Integration**

import project from git to your workspace and add dependency

```xml
  <dependency>
    <groupId>coollection</groupId>
    <artifactId>coollection</artifactId>
    <version>0.0.1-SNAPSHOT</version>
  </dependency>
```


Be happy!
