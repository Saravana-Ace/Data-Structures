public class LList<T> implements ListInterface<T> {

    private Node firstNode; // Reference to first node of chain
    private int numberOfEntries;

    public LList() {
        initializeDataFields();
    }

    public void clear() {
        initializeDataFields();
    }

    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        if(isEmpty())
            firstNode = newNode;
        else {
            Node lastNode = getNodeAt(numberOfEntries);
            lastNode.setNextNode(newNode);
        }
        numberOfEntries++;
    }

    public void add(int newPosition, T newEntry) {
        if((newPosition >= 1) && (newPosition <= numberOfEntries + 1)) {
            Node newNode = new Node(newEntry);
            if(newPosition == 1) {
                newNode.setNextNode(firstNode);
                firstNode = newNode;
            }
            else {
                Node nodeBefore = getNodeAt(newPosition - 1);
                Node nodeAfter = nodeBefore.getNextNode();
                newNode.setNextNode(nodeAfter);
                nodeBefore.setNextNode(newNode);
            }
            numberOfEntries++;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to add operation");
    }

    public boolean isEmpty() {
        boolean result;
        if(numberOfEntries == 0) {
            assert firstNode == null;
            result = true;
        }
        else {
            assert firstNode == null;
            result = false;
        }

        return result;
    }

    public T[] toArray() {
        @SuppressWarnings("unchecked")
        T[] result = (T[])new Object[numberOfEntries];

        int index = 0;
        Node currentNode = firstNode;
        while((index < numberOfEntries) && (currentNode != null)) {
            result[index] = (T)currentNode.getData();
            currentNode = currentNode.getNextNode();
            index++;
        }
        return result;
    }

    public T remove(int givenPosition) {
        T result = null;
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            if(givenPosition == 1) {
                result = (T)firstNode.getData();
                firstNode = firstNode.getNextNode();
            }
            else {
                Node nodeBefore = getNodeAt(givenPosition - 1);
                Node nodeToRemove = nodeBefore.getNextNode();
                result = (T)nodeToRemove.getData();
                Node nodeAfter = nodeToRemove.getNextNode();
                nodeBefore.setNextNode(nodeAfter);
            }
            numberOfEntries--;
            return result;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }

    public T replace(int givenPositiion, T newEntry) {
        if((givenPositiion >= 1) && (givenPositiion <= numberOfEntries)) {
            assert !isEmpty();
            Node desiredNode = getNodeAt(givenPositiion);
            T originalEntry = (T)desiredNode.getData();
            desiredNode.setData(newEntry);
            return originalEntry;
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }

    public T getEntry(int givenPosition) {
        if((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
            assert !isEmpty();
            return (T)getNodeAt(givenPosition).getData();
        }
        else
            throw new IndexOutOfBoundsException("Illegal position given to remove operation.");
    }

    public boolean contains(T anEntry) {
        boolean found = false;
        Node currentNode = firstNode;

        while(!found && (currentNode != null)) {
            if(anEntry.equals(currentNode.getData()))
                found = true;
            else
                currentNode = currentNode.getNextNode();
        }
        return found;
    }

    public int getLength() {
        return numberOfEntries;
    }

    // Initializes the class's data fields to indicate an empty list.
    private void initializeDataFields()
    {
        firstNode = null;
        numberOfEntries = 0;
    } // end initializeDataFields


    // Returns a reference to the node at a given position.
    // Precondition: The chain is not empty;
    // 1 <= givenPosition <= numberOfEntries.
    private Node getNodeAt(int givenPosition)
    {
        assert !isEmpty() && (1 <= givenPosition) && (givenPosition <= numberOfEntries);
        Node currentNode = firstNode;

        // Traverse the chain to locate the desired node
        // (skipped if givenPosition is 1)
        for (int counter = 1; counter < givenPosition; counter++)
            currentNode = currentNode.getNextNode();

        assert currentNode != null;

        return currentNode;
    } // end getNodeAt

    private class Node<T> {
        private T data;
        private Node next;

        public Node(T dataPortion) {
            this(dataPortion, null);
        }

        public Node(T dataPortion, Node nextNode) {
            data = dataPortion;
            next = nextNode;
        }

        public T getData() {
            return data;
        }

        public void setData(T dataPortion) {
            data = dataPortion;
        }

        public Node getNextNode() {
            return next;
        }

        public void setNextNode(Node nextNode) {
            next = nextNode;
        }
    }
}