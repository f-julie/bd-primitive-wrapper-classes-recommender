com.amazon.ata.generics.classroom.recommender

# Class MostRecentlyUsed\<E\>

#### Type Parameters:
E - The type to store in the collection.

#### Description
A collection of the n most recently used items. When item n+1 is added it replaces the oldest item in the collection, the one that was added before any of the other items.

### Method Summary
| Method                    | Description                                        |
|---------------------------|----------------------------------------------------|
| E add(E mostRecentlyUsed) | Adds an item to the collection.                    |
| E get(int index)          | Return's the nth oldest element in the collection. |
| int getSize()             | Returns the number of elements in the collection.  |

# Interface ReadOnlyDAO<K,V>

#### Type Parameters:
K - The type of the key.

V - The type of the value or data.

#### Description
Access a single item of data via a unique key.

### Method Summary
| Method       | Description                                                  |
|--------------|--------------------------------------------------------------|
| V get(K key) | Get a specific value of type V for a specific key of type K. |
