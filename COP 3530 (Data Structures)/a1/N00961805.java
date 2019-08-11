import java.util.Arrays;
import java.util.Collections;

// highArray.java
    // demonstrates array class with high-level interface
    // to run this program: C>java HighArrayApp
    ////////////////////////////////////////////////////////////////
    class HighArray
    {
        private long[] a;                 // ref to array a
        private int nElems;               // number of data items
        //-----------------------------------------------------------
        public HighArray(int max)         // constructor
        {
            a = new long[max];                 // create the array
            nElems = 0;                        // no items yet
        }
        //-----------------------------------------------------------
        public boolean find(long searchKey)
        {                              // find specified value
            int j;
            for(j=0; j<nElems; j++)            // for each element,
                if(a[j] == searchKey)           // found item?
                    break;                       // exit loop before end
            if(j == nElems)                    // gone to end?
                return false;                   // yes, can't find it
            else
                return true;                    // no, found it
        }  // end find()
        //-----------------------------------------------------------
        public void insert(long value)    // put element into array
        {
            a[nElems] = value;             // insert it
            nElems++;                      // increment size
        }
        //-----------------------------------------------------------
        public boolean delete(long value)
        {
            int j;
            for(j=0; j<nElems; j++)        // look for it
                if( value == a[j] )
                    break;
            if(j==nElems)                  // can't find it
                return false;
            else                           // found it
            {
                for(int k=j; k<nElems; k++) // move higher ones down
                    a[k] = a[k+1];
                nElems--;                   // decrement size
                return true;
            }
        }  // end delete()
        //-----------------------------------------------------------
        public void display()             // displays array contents
        {
            for(int j=0; j<nElems; j++)       // for each element,
                System.out.print(a[j] + " ");  // display it
            System.out.println("");
        }
        //-----------------------------------------------------------
        public long getMin()             // Finds Array Min
        {
            long result = this.a[0];

            for (int i = 0; i < this.nElems; i++) {
                if (this.a[i] < result) {
                    result = this.a[i];
                }
            }

                return result;
        }
        //-----------------------------------------------------------
        public long getMax()             // displays array contents
        {
            long result = this.a[0];

            for (int i = 0; i < this.nElems; i++) {
                if (this.a[i] > result) {
                    result = this.a[i];
                }
            }
            return result;
        }
        //-----------------------------------------------------------
    }  // end class HighArray
    ////////////////////////////////////////////////////////////////
    public class n00961805
    {
        public static void main(String[] args)
        {
            int maxSize = 100;            // array size
            HighArray arr;                // reference to array
            arr = new HighArray(maxSize); // create the array

            arr.insert(77);               // insert 10 items
            arr.insert(99);
            arr.insert(44);
            arr.insert(55);
            arr.insert(22);
            arr.insert(88);
            arr.insert(11);
            arr.insert(00);
            arr.insert(66);
            arr.insert(33);

            arr.display();                // display items

            int searchKey = 35;           // search for item
            if( arr.find(searchKey) )
                System.out.println("Found " + searchKey);
            else
                System.out.println("Can't find " + searchKey);

            arr.delete(00);               // delete 3 items
            arr.delete(55);
            arr.delete(99);

            arr.display();                // display items again

            System.out.println("Maximum: " + arr.getMax());
            System.out.println("Minimum: " + arr.getMin());
        }  // end main()
    }  // end class HighArrayApp