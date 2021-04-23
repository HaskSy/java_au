# Design

+ [Flatten Nested List Iterator](#flatten-nested-list-iterator)

## Flatten Nested List Iterator
https://leetcode.com/problems/flatten-nested-list-iterator/
```java
public class NestedIterator implements Iterator<Integer> {

    private final List<NestedInteger> nestedList;
    private NestedIterator iterator;
    private int index;
    public NestedIterator(List<NestedInteger> nestedList) {
        this.nestedList = nestedList;
        this.iterator = null;
        this.index = 0;
    }

    @Override
    public Integer next() {
        if(nestedList.get(index).isInteger()) return nestedList.get(index++).getInteger();
        return iterator.next();
    }

    @Override
    public boolean hasNext() {
        if (nestedList.size() > index && nestedList.get(index) != null) {
            if (nestedList.get(index).isInteger()) return true;

            if (iterator == null) iterator = new NestedIterator(nestedList.get(index).getList());

            if (iterator.hasNext()) return true;

            index++;
            iterator = null;
            return this.hasNext();
        }
        return false;
    }
}

```