/*
    Francis Rukab
    2/8/2018
    COP 3530
    Assignment 3
 */
import java.util.Scanner;

public class n00961805 {

    public static int[] getParameters() {
        int[] retVal = { 0, 0, 0 };
        System.out.println("Please enter the necessary parameters: ");
        Scanner scanner = new Scanner(System.in);
        String parameterString = scanner.nextLine();
        if(parameterString.equals("stop")){
            System.exit(1);
        }
        String[] parameters = parameterString.split(" ");

        if ( parameters.length != 3 )
        {
            System.out.println("Incorrect Input.\n");
            n00961805.countingGame();
        }

        if ( n00961805.isStringParsedAsInteger(parameters[0]) )
        {
            retVal[0] = Integer.parseInt(parameters[0]);
        }
        else
        {
            System.out.println("Stopping the Program.\n");
            System.exit(1);
        }

        if ( n00961805.isStringParsedAsInteger(parameters[1]) )
        {
            retVal[1] = Integer.parseInt(parameters[1]);
        }
        else
        {
            System.out.println("Second parameter is not an integer.\n");
            System.out.println();
            n00961805.countingGame();
        }

        if ( n00961805.isStringParsedAsInteger(parameters[2]) )
        {
            retVal[2] = Integer.parseInt(parameters[2]);
        }
        else
        {
            System.out.println("Third parameter is not an integer.\n");
            System.out.println();
            n00961805.countingGame();
        }

        return retVal;
    }

    public static void countingGame() {
        int[] parameters = n00961805.getParameters();

        int total = parameters[0];
        int start = parameters[1];
        int step = parameters[2];

        DoubleLinkedList<Integer> myList = new DoubleLinkedList<Integer>();

        for ( int i = 1; i <= total; i++ )
        {
            myList.insertTail(i);
        }

        DoubleLinkedListIterator<Integer> iterator = myList.getIterator();
        iterator.resetHead();

        for ( int i = 1; i < start; i++ )
        {
            iterator.nextNode();
        }

        while ( myList.getSize() > 1 )
        {
            for ( int i = 1; i <= step; i++ )
            {
                iterator.nextNode();
            }

            iterator.deleteCurrent();
        }

        System.out.println(iterator.getCurrent().toString());
        System.out.println();
        n00961805.countingGame();
    }

    private final static boolean isStringParsedAsInteger(final String s) {
        try
        {
            Integer.parseInt(s);
        }
        catch ( final Exception exception )
        {
            return false;
        }

        return true;
    }

    private static class DoubleLinkedList<T> {
        private Node head = null;
        private int  size = 0;
        private Node tail = null;

        public DoubleLinkedList()
        {
        }

        public Node getHead()
        {
            return this.head;
        }

        public DoubleLinkedListIterator<T> getIterator()
        {
            return new DoubleLinkedListIterator<T>(this);
        }

        public int getSize()
        {
            return this.size;
        }

        public Node getTail()
        {
            return this.tail;
        }

        public void insertTail(final T data)
        {
            DoubleLinkedListIterator<T> iterator = this.getIterator();
            iterator.resetTail();
            iterator.insertAfter(data);
        }

        public boolean isEmpty()
        {
            return ( this.getSize() <= 0 );
        }

        public void setHead(final Node head)
        {
            this.head = head;
        }

        public void setSize(final int size)
        {
            this.size = size;
        }

        public void setTail(final Node tail)
        {
            this.tail = tail;
        }

        @Override
        public String toString()
        {
            StringBuilder output = new StringBuilder();
            DoubleLinkedListIterator<T> iterator = this.getIterator();
            iterator.resetHead();

            for ( int i = 0; i < this.getSize(); i++ )
            {
                output.append(iterator.getCurrent().toString() + "\n");
                iterator.nextNode();
            }

            return output.toString();
        }
    }

    private static class DoubleLinkedListIterator<T> {
        private Node                current  = null;
        private DoubleLinkedList<T> list     = null;
        private Node                next     = null;
        private Node                previous = null;

        public DoubleLinkedListIterator(final DoubleLinkedList<T> list)
        {
            this.setList(list);
        }

        public boolean atHead()
        {
            return ( this.getCurrent() == this.getList().getHead() );
        }

        public boolean atTail()
        {
            return ( this.getCurrent() == this.getList().getTail() );
        }

        @SuppressWarnings("unchecked")
        public T deleteCurrent()
        {
            T retVal = ( (DataNode<T>) this.getCurrent() ).getData();

            if ( this.atHead() )
            {
                this.getList().setHead(this.getNext());
                this.getList().getHead().setPrevious(null);
                this.resetHead();
            }
            else if ( this.atTail() )
            {

                this.getList().setTail(this.getPrevious());
                this.getList().getTail().setNext(null);
                this.resetTail();
                this.nextNode();
            }
            else
            {
                this.getPrevious().setNext(this.getNext());
                this.getNext().setPrevious(this.getPrevious());
                this.setCurrent(this.getNext());
                this.setNext(this.getCurrent().getNext());
                this.setPrevious(this.getCurrent().getPrevious());
            }

            int newSize = ( this.getList().getSize() - 1 );
            this.getList().setSize(newSize);
            return retVal;
        }

        public Node getCurrent()
        {
            return this.current;
        }

        public final DoubleLinkedList<T> getList()
        {
            return this.list;
        }

        public final Node getNext()
        {
            return this.next;
        }

        public final Node getPrevious()
        {
            return this.previous;
        }

        public void insertAfter(final T data)
        {
            Node newNode = new DataNode<T>(data, null, null);

            if ( this.getList().isEmpty() )
            {
                this.getList().setHead(newNode);
                this.getList().setTail(newNode);
                this.setCurrent(newNode);
                this.resetHead();
            }
            else
            {
                newNode.setPrevious(this.getCurrent());
                this.getCurrent().setNext(newNode);
                this.getList().setTail(newNode);
                this.nextNode();
            }

            int newSize = ( this.getList().getSize() + 1 );
            this.getList().setSize(newSize);
        }

        public void nextNode()
        {
            if ( this.atTail() )
            {
                this.resetHead();
            }
            else
            {
                this.setPrevious(this.getCurrent());
                this.setCurrent(this.getNext());

                if ( this.getCurrent() != null )
                {
                    this.setNext(this.getCurrent().getNext());
                }
                else
                {
                    this.setNext(null);
                }
            }
        }

        public void resetHead()
        {
            if ( this.getList().getHead() != null )
            {
                this.setPrevious(this.getList().getHead().getPrevious());
                this.setCurrent(this.getList().getHead());
                this.setNext(this.getList().getHead().getNext());
            }
            else
            {
                this.setPrevious(null);
                this.setCurrent(null);
                this.setNext(null);
            }
        }

        public void resetTail()
        {
            if ( this.getList().getTail() != null )
            {
                this.setPrevious(this.getList().getTail().getPrevious());
                this.setCurrent(this.getList().getTail());
                this.setNext(this.getList().getTail().getNext());
            }
            else
            {
                this.setPrevious(null);
                this.setCurrent(null);
                this.setNext(null);
            }
        }

        public final void setCurrent(final Node current)
        {
            this.current = current;
        }

        public final void setList(final DoubleLinkedList<T> list)
        {
            this.list = list;
        }

        public final void setNext(final Node next)
        {
            this.next = next;
        }

        public final void setPrevious(final Node previous)
        {
            this.previous = previous;
        }
    }

    private static class Node {
        private Node next     = null;
        private Node previous = null;

        public Node(final Node next, final Node previous)
        {
            this.setNext(next);
            this.setPrevious(previous);
        }

        @Override
        public boolean equals(final Object obj)
        {
            if ( this == obj ) { return true; }

            if ( obj == null ) { return false; }

            if ( !( obj instanceof Node ) ) { return false; }

            return this.hashCode() == obj.hashCode();
        }

        public final Node getNext()
        {
            return this.next;
        }

        public final Node getPrevious()
        {
            return this.previous;
        }

        @Override
        public int hashCode()
        {
            return System.identityHashCode(this);
        }

        public final void setNext(final Node next)
        {
            this.next = next;
        }

        public final void setPrevious(final Node previous)
        {
            this.previous = previous;
        }

        @Override
        public String toString()
        {
            return "Node@" + this.hashCode();
        }
    }

    private static class DataNode<T> extends Node {
        private T data = null;

        public DataNode(final T data, final Node next, final Node previous)
        {
            super(next, previous);
            this.setData(data);
        }

        @Override
        public boolean equals(final Object obj)
        {
            if ( this == obj ) { return true; }
            if ( !super.equals(obj) ) { return false; }
            if ( !( obj instanceof DataNode ) ) { return false; }

            DataNode<?> other = (DataNode<?>) obj;

            if ( this.getData() == null )
            {
                if ( other.getData() != null ) { return false; }
            }
            else if ( !this.getData().equals(other.getData()) ) { return false; }

            return true;
        }

        public final T getData()
        {
            return this.data;
        }

        @Override
        public int hashCode()
        {
            final int prime = 31;
            int result = super.hashCode();
            result = ( prime * result ) + ( ( this.getData() == null ) ? 0 : this.getData().hashCode() );
            return result;
        }

        public final void setData(final T data)
        {
            this.data = data;
        }

        @Override
        public String toString()
        {
            String result = String.valueOf(this.getData());
            result.replace("DataNode [data=", "");
            result.replace("]", "");
            return result.toString();
        }
    }

    public static void main(String[] args) {
        n00961805.countingGame();
    }
}