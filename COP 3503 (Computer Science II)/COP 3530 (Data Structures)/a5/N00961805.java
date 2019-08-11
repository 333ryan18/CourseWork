// Francis Rukab COP3530
import java.io.File;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.InputMismatchException;
import java.util.Locale;
import java.util.NoSuchElementException;
import java.util.regex.Pattern;

public class n00961805
{
    public static final void main(final String[] args)
    {
        HuffmanTree<Character> huffmanTree;
        boolean continueFlag;

        if ( args.length > 0 )
        {
            for ( String arg : args )
            {
                huffmanTree = new HuffmanTree<>(HuffmanTree.ALPHABET_ASCII);

                if ( huffmanTree.openFile(arg) )
                {
                    continueFlag = true;

                    do
                    {
                        System.out.println("\nPlease select an option from the following menu.\n");
                        System.out.println("[1]: Print the huffman tree.");
                        System.out.println("[2]: Print the code table.");
                        System.out.println("[3]: Print the compressed binary output using the huffman tree.");
                        System.out.println("[4]: Print the uncompressed text input using the huffman tree.");
                        System.out.println("\n*Note: You may enter the word \"stop\" (not case-sensitive) at any time to end the program.\n");
                        System.out.println("Selection: ");
                        String input = Support.readString();

                        if ( Support.isStringParsedAsInteger(input) )
                        {
                            System.out.println();

                            switch ( Integer.parseInt(input) )
                            {

                                case 1:

                                    System.out.println(huffmanTree.toString(TreeNode.TRAVERSAL_ORDER.DEFAULT));
                                    break;

                                case 2:

                                    System.out.println(huffmanTree.formatCodeTable());
                                    break;

                                case 3:

                                    System.out.println(huffmanTree.formatData(arg, HuffmanTree.DataFormats.COMPRESSED));
                                    break;

                                case 4:

                                    System.out.println(huffmanTree.formatData(arg, HuffmanTree.DataFormats.UNCOMPRESSED));
                                    break;

                                default:

                                    System.out.println("Unable to recognize your selection. Integers 1 through 4 are valid.");
                                    break;
                            }
                        }
                        else
                        {
                            if ( input.equalsIgnoreCase("stop") )
                            {
                                continueFlag = false;
                            }
                            else
                            {
                                System.out.println("Unable to recognize your selection. Integers 1 through 4 are valid.");
                            }
                        }
                    }
                    while ( continueFlag );
                }
            }
        }

        System.out.println("\nExiting...\n");
        System.exit(0);
    }
}

final class Support
{

    private static final String CHARSET_NAME = "UTF-8";

    private static final Locale LOCALE = Locale.US;

    private static final Pattern WHITESPACE_PATTERN = Pattern.compile("\\p{javaWhitespace}+");

    private static final Pattern EVERYTHING_PATTERN = Pattern.compile("\\A");

    private static Scanner scanner;

    private Support() { }

    private static String readAll() {
        if (!scanner.hasNextLine())
            return "";

        String result = scanner.useDelimiter(EVERYTHING_PATTERN).next();
        scanner.useDelimiter(WHITESPACE_PATTERN);
        return result;
    }

    public static String readString() {
        try {
            return scanner.next();
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'String' value from standard input, but there are no more tokens available");
        }
    }

    private static int readInt() {
        try {
            return scanner.nextInt();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read an 'int' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read an 'int' value from standard input, but there are no more tokens available");
        }

    }

    private static double readDouble() {
        try {
            return scanner.nextDouble();
        }
        catch (InputMismatchException e) {
            String token = scanner.next();
            throw new InputMismatchException("attempts to read a 'double' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'double' value from standard input, but there are no more tokens available");
        }
    }

    private static boolean readBoolean() {
        try {
            String token = readString();
            if ("true".equalsIgnoreCase(token))  return true;
            if ("false".equalsIgnoreCase(token)) return false;
            if ("1".equals(token))               return true;
            if ("0".equals(token))               return false;
            throw new InputMismatchException("attempts to read a 'boolean' value from standard input, but the next token is \"" + token + "\"");
        }
        catch (NoSuchElementException e) {
            throw new NoSuchElementException("attempts to read a 'boolean' value from standard input, but there are no more tokens available");
        }

    }

    private static String[] readAllStrings() {
        String[] tokens = WHITESPACE_PATTERN.split(readAll());
        if (tokens.length == 0 || tokens[0].length() > 0)
            return tokens;

        String[] decapitokens = new String[tokens.length-1];
        for (int i = 0; i < tokens.length - 1; i++)
            decapitokens[i] = tokens[i+1];
        return decapitokens;
    }

    private static double[] readAllDoubles() {
        String[] fields = readAllStrings();
        double[] vals = new double[fields.length];
        for (int i = 0; i < fields.length; i++)
            vals[i] = Double.parseDouble(fields[i]);
        return vals;
    }

    static {
        resync();
    }

    private static void resync() {
        setScanner(new Scanner(new java.io.BufferedInputStream(System.in), CHARSET_NAME));
    }

    private static void setScanner(Scanner scanner) {
        Support.scanner = scanner;
        Support.scanner.useLocale(LOCALE);
    }

    @Deprecated
    public static double[] readDoubles() {
        return readAllDoubles();
    }

    @Deprecated
    public static String[] readStrings() {
        return readAllStrings();
    }


    public static void main(String[] args) {

        System.out.println("Type a string: ");
        String s = Support.readString();
        System.out.println("Your string was: " + s);
        System.out.println();

        System.out.println("Type an int: ");
        int a = Support.readInt();
        System.out.println("Your int was: " + a);
        System.out.println();

        System.out.println("Type a boolean: ");
        boolean b = Support.readBoolean();
        System.out.println("Your boolean was: " + b);
        System.out.println();

        System.out.println("Type a double: ");
        double c = Support.readDouble();
        System.out.println("Your double was: " + c);
        System.out.println();
    }
    
    
    public static final String constructAlphabetString(final int begin, final int end)
    {
        String alphabet = "";

        for ( int i = begin; i <= end; i++ )
        {
            alphabet = ( alphabet + (char) i );
        }

        return alphabet;
    }

    public final static boolean isStringParsedAsInteger(final String s)
    {
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

    public final static String padRight(final String input, final int width, final char padChar)
    {
        final StringBuilder sb = new StringBuilder(input);

        for ( int i = input.length(); i < width; i++ )
        {
            sb.append(padChar);
        }

        return sb.toString();
    }
}

class HuffmanTree<T extends Comparable<? super T>> extends Tree<T>
{
    public enum DataFormats
    {
        COMPRESSED, ORIGINAL, UNCOMPRESSED
    }

    public static final String ALPHABET_ASCII = Support.constructAlphabetString(32, 126);
    private Character          alphabetFirst  = null;
    private int                alphabetSize   = 0;
    private String             alphabetString = null;
    private String[]           codeTable      = new String[this.getAlphabetSize()];
    private int[]              frequencies    = new int[this.getAlphabetSize()];
    private String             inputString    = "";


    public HuffmanTree(final String alphabet)
    {
        super();
        this.reset(alphabet);
    }

    String compressInput(final String input)
    {
        String retVal = "";

        for ( int i = 0; i < input.length(); i++ )
        {
            char character = input.charAt(i);
            int codeIndex = ( character - this.getAlphabetFirst().charValue() );

            retVal = ( retVal + this.getCodeTable()[codeIndex] );
        }

        return retVal;
    }

    @SuppressWarnings("unchecked")
    void createCodeTable(final HuffmanNode<T> x, final String s)
    {
        if ( !x.isLeaf() )
        {
            this.createCodeTable((HuffmanNode<T>) x.getLeft(), s + "0");
            this.createCodeTable((HuffmanNode<T>) x.getRight(), s + "1");
        }
        else
        {
            int index = ( ( (Character) x.getData() ).charValue() - this.getAlphabetFirst().charValue() );
            this.codeTable[index] = s;
        }
    }

    @SuppressWarnings("unchecked")
    void createHuffmanTree()
    {
        PriorityQueue<HuffmanNode<T>> pq = new PriorityQueue<>();
        int newSize = 0;

        for ( int i = 0; i < this.getAlphabetSize(); i++ )
        {
            Character letter = this.getAlphabetString().charAt(i);

            if ( this.getFrequencies()[i] > 0 )
            {
                pq.add(new HuffmanNode<>((T) letter, null, null, null, this.getFrequencies()[i]));
                newSize++;
            }
        }

        while ( pq.size() > 1 )
        {
            HuffmanNode<T> left = pq.poll();
            HuffmanNode<T> right = pq.poll();
            HuffmanNode<T> parent = new HuffmanNode<>(null, null, right, left, (left.getCount() + right.getCount()));
            pq.add(parent);
            newSize++;
        }

        this.setRoot(pq.poll());
        this.setSize(newSize);
    }

    public String formatCodeTable()
    {
        StringBuilder sb = new StringBuilder();
        sb.append("Code table:\n\n");

        for ( int i = 0, c = this.getAlphabetFirst().charValue(); i < this.getAlphabetSize(); i++, c++ )
        {
            if ( this.getCodeTable()[i] != null )
            {
                sb.append((char) c + " = " + this.getCodeTable()[i] + "\n");
            }
        }

        return sb.toString();
    }

    public String formatData(final String filePath, final DataFormats format)
    {
        StringBuilder sb = new StringBuilder();
        String fileData = "", dataString = "";
        int byteCount = 0, bitCount = 0;
        boolean isInput = false;

        switch ( format )
        {
            case ORIGINAL:

                fileData = this.inputString;
                byteCount = this.inputString.length();
                bitCount = this.inputString.length() * 8;
                isInput = true;
                break;

            case COMPRESSED:

                fileData = this.compressInput(this.inputString);
                byteCount = (int) ( Math.ceil(this.compressInput(this.inputString).length() / 8.0) );
                bitCount = this.compressInput(this.inputString).length();
                isInput = false;
                break;

            case UNCOMPRESSED:

                fileData = this.uncompressOutput(this.compressInput(this.inputString));
                byteCount = this.uncompressOutput(this.compressInput(this.inputString)).length();
                bitCount = this.uncompressOutput(this.compressInput(this.inputString)).length() * 8;
                isInput = true;
                break;
        }

        if ( filePath != null )
        {
            sb.append("File: " + filePath);
        }
        else
        {
            sb.append("\nFile: N/A");
        }

        sb.append("\nSize: " + byteCount + " bytes, " + bitCount + " bits.");

        if ( isInput )
        {
            dataString = ( "\nData:\n\n" + fileData );
        }
        else
        {
            String formattedData = "";

            for ( int i = 0; i < bitCount; i++ )
            {
                if ( ( ( i + 1 ) % 24 ) == 0 )
                {
                    formattedData = ( formattedData + fileData.charAt(i) + "\n" );
                }
                else if ( ( ( i + 1 ) % 8 ) == 0 )
                {
                    formattedData = ( formattedData + fileData.charAt(i) + " " );
                }
                else
                {
                    formattedData = ( formattedData + fileData.charAt(i) );
                }
            }

            dataString = ( "\nData:\n\n" + formattedData );
        }

        sb.append(dataString);
        return sb.toString();
    }

    final Character getAlphabetFirst()
    {
        return this.alphabetFirst;
    }

    final int getAlphabetSize()
    {
        return this.alphabetSize;
    }

    final String getAlphabetString()
    {
        return this.alphabetString;
    }

    final String[] getCodeTable()
    {
        return this.codeTable;
    }

    final int[] getFrequencies()
    {
        return this.frequencies;
    }

    final String getInputString()
    {
        return this.inputString;
    }

    @SuppressWarnings("unchecked")
    void initialize()
    {
        this.createHuffmanTree();
        this.createCodeTable((HuffmanNode<T>) this.getRoot(), "");
    }

    public boolean openFile(final String filePath)
    {
        boolean retVal = false;

        if ( ( filePath == null ) || filePath.isEmpty() ) { return retVal; }

        Scanner inputStream = null;

        try
        {
            inputStream = new Scanner(new File(filePath));
            retVal = this.parseFile(inputStream);

            if ( retVal )
            {
                this.initialize();
            }

            return retVal;
        }
        catch ( Exception exception )
        {
            System.out.println("An exception in the the process of reading the file occurred");
        }
        finally
        {
            if ( inputStream != null )
            {
                inputStream.close();
            }
        }

        return retVal;
    }

    @SuppressWarnings("SameReturnValue")
    boolean parseFile(final Scanner inputStream)
    {
        while ( inputStream.hasNextLine() )
        {
            String line = inputStream.nextLine();

            for ( int i = 0; i < line.length(); i++ )
            {
                CharSequence currentCharacterSequence = line.subSequence(i, ( i + 1 ));
                char currentCharacter = line.charAt(i);

                if ( this.getAlphabetString().contains(currentCharacterSequence) )
                {
                    this.setInputString(this.getInputString() + currentCharacter);
                    int index = ( currentCharacter - this.getAlphabetFirst().charValue() );
                    this.getFrequencies()[index]++;
                }
            }
        }

        return true;
    }

    final void reset(final String alphabet)
    {
        this.setAlphabet(alphabet);
        this.setCodeTable(new String[this.getAlphabetSize()]);
        this.setFrequencies(new int[this.getAlphabetSize()]);
        this.setInputString("");
    }

    final void setAlphabet(final String alphabet)
    {
        this.setAlphabetString(alphabet);
        this.setAlphabetSize(this.getAlphabetString().length());
        this.setAlphabetFirst(this.getAlphabetString().charAt(0));
    }

    final void setAlphabetFirst(final Character alphabetFirst)
    {
        this.alphabetFirst = alphabetFirst;
    }

    final void setAlphabetSize(final int alphabetSize)
    {
        this.alphabetSize = alphabetSize;
    }

    final void setAlphabetString(final String alphabetString)
    {
        this.alphabetString = alphabetString;
    }

    final void setCodeTable(final String[] codeTable)
    {
        this.codeTable = codeTable;
    }

    final void setFrequencies(final int[] frequencies)
    {
        this.frequencies = frequencies;
    }

    final void setInputString(final String inputString)
    {
        this.inputString = inputString;
    }

    @SuppressWarnings("unchecked")
    String uncompressOutput(final String output)
    {
        String retVal = "";
        int x = 0;

        for ( int i = 0; i < this.getInputString().length(); i++ )
        {
            HuffmanNode<T> nextNode = (HuffmanNode<T>) this.getRoot();

            while ( !nextNode.isLeaf() )
            {
                if ( output.charAt(x) == '1' )
                {
                    nextNode = (HuffmanNode<T>) nextNode.getRight();
                }
                else if ( output.charAt(x) == '0' )
                {
                    nextNode = (HuffmanNode<T>) nextNode.getLeft();
                }

                x++;
            }

            retVal = ( retVal + ( (Character) nextNode.getData() ).charValue() );
        }

        return retVal;
    }
}

class HuffmanNode<T extends Comparable<? super T>> extends TreeNode<T> implements Comparable<HuffmanNode<T>>
{
    private int count = 0;

    public HuffmanNode(final T data, final Node parent, final Node right, final Node left, final int count)
    {
        super(data, parent, right, left);
        this.setCount(count);
    }

    @Override
    public int compareTo(final HuffmanNode<T> node)
    {
        return ( this.getCount() - node.getCount() );
    }

    @Override
    protected String generateDataString(final int minWidth)
    {
        String data = "";

        if ( this.getData() != null )
        {
            data = this.getData().toString() + " (" + Integer.toString(this.getCount()) + ")";
        }
        else
        {
            data = "(" + Integer.toString(this.getCount()) + ")";
        }

        if ( !data.matches("\\[.+]") )
        {
            data = String.format("[%-" + ( minWidth - 3 ) + "s]", data);
        }

        return data;
    }

    public final int getCount()
    {
        return this.count;
    }

    final void setCount(final int count)
    {
        this.count = count;
    }
}

class Tree<T extends Comparable<? super T>>
{
    private Node root = null;
    private int  size = 0;

    Tree()
    {
        this.clear();
    }

    final void clear()
    {
        this.setRoot(null);
        this.setSize(0);
    }

    public final Node getRoot()
    {
        return this.root;
    }

    public final int getSize()
    {
        return this.size;
    }

    public final boolean isEmpty()
    {
        return ( this.getSize() == 0 );
    }

    final void setRoot(final Node root)
    {
        this.root = root;
    }

    public final void setSize(final int size)
    {
        this.size = size;
    }

    @Override
    public String toString()
    {
        return this.toString(this.getRoot(), TreeNode.TRAVERSAL_ORDER.DEFAULT, 15);
    }

    @SuppressWarnings("unchecked")
    String toString(final Node root, final TreeNode.TRAVERSAL_ORDER travOrder, final int minWidth)
    {
        if ( root != null ) { return ( (TreeNode<T>) root ).toString(travOrder, minWidth); }

        return "";
    }

    public String toString(final TreeNode.TRAVERSAL_ORDER travOrder)
    {
        return this.toString(this.getRoot(), travOrder, 15);
    }

}

class TreeNode<T extends Comparable<? super T>> extends DataNode<T>
{
    public enum TRAVERSAL_ORDER
    {
        DEFAULT
    }

    private Node parent = null;

    TreeNode(final T data, final Node parent, final Node right, final Node left)
    {
        super(data, right, left);
        this.setParent(parent);
    }

    String generateDataString(final int minWidth)
    {
        String data = "";

        if ( this.getData() != null )
        {
            data = this.getData().toString();
        }

        if ( !data.matches("\\[.+]") )
        {
            data = String.format("[%-" + ( minWidth - 3 ) + "s]", data);
        }

        return data;
    }

    public final Node getLeft()
    {
        return this.getPrevious();
    }

    final Node getParent()
    {
        return this.parent;
    }

    public final Node getRight()
    {
        return this.getNext();
    }

    public final boolean isLeaf()
    {
        return ( ( this.getLeft() == null ) && ( this.getRight() == null ) );
    }

    final boolean isRoot()
{
    return ( this.getParent() == null );
}


    final void setParent(final Node parent)
    {
        this.parent = parent;
    }


    @Override
    public String toString()
    {
        return this.toString(TRAVERSAL_ORDER.DEFAULT, 15);
    }

    public String toString(final TRAVERSAL_ORDER travOrder, final int minWidth)
    {
        return this.toStringBuilder(new StringBuilder(), true, new StringBuilder(), travOrder, minWidth).toString();
    }

    @SuppressWarnings("unchecked")
    StringBuilder toStringBuilder(final StringBuilder prefix, final boolean isTail, final StringBuilder sb, final TRAVERSAL_ORDER travOrder, final int minWidth)
    {
        String connector1, connector2, padding1, padding2, dataString = "";
        connector1 = new StringBuilder(Support.padRight("└", minWidth - 1, '─')).append(" ").toString();
        connector2 = new StringBuilder(Support.padRight("┌", minWidth - 1, '─')).append(" ").toString();
        padding1 = Support.padRight("│", minWidth + 1, ' ');
        padding2 = Support.padRight(" ", minWidth + 1, ' ');
        dataString = String.format("%-" + ( minWidth ) + "s%s%n", ( isTail ? connector1 : connector2 ), this.generateDataString(minWidth));

                if ( this.getRight() != null )
                {
                    ( (TreeNode<T>) this.getRight() ).toStringBuilder(new StringBuilder().append(prefix).append(isTail ? padding1 : padding2), false, sb, travOrder, minWidth);
                }

                sb.append(prefix).append(dataString);

                if ( this.getLeft() != null )
                {
                    ( (TreeNode<T>) this.getLeft() ).toStringBuilder(new StringBuilder().append(prefix).append(isTail ? padding2 : padding1), true, sb, travOrder, minWidth);
                }

        return sb;
    }
}

class DataNode<T> extends Node
{
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
        StringBuilder builder = new StringBuilder();
        builder.append("DataNode [data=");
        builder.append(this.getData());

        if ( this.getNext() != null )
        {
            builder.append(", next=");
            builder.append(this.getNext().hashCode());
        }

        if ( this.getPrevious() != null )
        {
            builder.append(", previous=");
            builder.append(this.getPrevious().hashCode());
        }

        builder.append("]");
        return builder.toString();
    }
}

abstract class Node
{
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