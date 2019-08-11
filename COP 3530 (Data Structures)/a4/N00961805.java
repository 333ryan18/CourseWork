/*
    Francis Rukab
    N00961805
    02.22.2018
 */
import java.util.*;
import javax.swing.*;
import java.awt.Component;
import java.text.SimpleDateFormat;

public class n00961805
{
    public static void main(final String[] args)
    {
        KnapsackSolver knapsackSolver;
        String inputString;
        boolean continueFlag;

        do
        {
            inputString = Support.getInputString(null,
                    "*Note: You may enter \"stop\" (not case sensitive) to exit the program.\n" + "\nPlease enter the necessary parameters:",
                    "Parameter Input");
            continueFlag = ((inputString != null) && (inputString.equalsIgnoreCase("stop") == false));

            if (continueFlag)
            {
                String[] parameters = inputString.trim().split(" ");

                assert (parameters.length > 1);

                int[] itemWeights = new int[parameters.length - 1];
                int capacity = 0;

                if (Support.isStringParsedAsInteger(parameters[0]))
                {
                    capacity = Integer.parseInt(parameters[0]);
                }
                else
                {
                    Support.displayException(null, new Exception("Error Parsing Input: parameters[0] is not an integer!"), true);
                }

                for (int i = 0; i < itemWeights.length; i++)
                {
                    if (Support.isStringParsedAsInteger(parameters[i + 1]))
                    {
                        itemWeights[i] = Integer.parseInt(parameters[i + 1]);
                    }
                    else
                    {
                        Support.displayException(null, new Exception("Error Parsing Input: parameters[" + (i + 1) + "]  is not an integer!"), true);
                    }
                }

                knapsackSolver = new KnapsackSolver(capacity, itemWeights);
                knapsackSolver.displaySolutionSets();
            }
        }
        while (continueFlag);

        System.exit(0);
    }
}

class KnapsackSolver
{
    protected static List<KnapsackItem> knapsack(final List<KnapsackItem> items, final int capacity, final int start)
    {
        if ( capacity > 0 )
        {
            for ( int i = start; i < items.size(); i++ )
            {
                List<KnapsackItem> answer = KnapsackSolver.knapsack(items, capacity - items.get(i).getWeight(), i + 1);

                if ( answer != null )
                {
                    answer.add(items.get(i));
                    return answer;
                }
            }

            return null;
        }
        else
        {
            if ( capacity == 0 )
            {
                List<KnapsackItem> temp = new LinkedList<KnapsackItem>();
                return temp;
            }
            else
            {
                return null;
            }
        }
    }

    private int                      capacity     = 0;
    private List<KnapsackItem>       items        = null;
    private List<List<KnapsackItem>> solutionSets = null;

    public KnapsackSolver(final int capacity, final int itemWeights[])
    {
        List<KnapsackItem> items = new LinkedList<KnapsackItem>();

        for ( int itemWeight : itemWeights )
        {
            items.add(new KnapsackItem(itemWeight));
        }

        this.reset(capacity, items);
    }

    public void displaySolutionSets()
    {
        if ( this.getSolutionSets().isEmpty() )
        {
            JOptionPane.showMessageDialog(null, "This application was unable to find any solution sets for the given parameters.", "No Solution Sets", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            final int numSolutionSets = this.getSolutionSets().size();
            final StringBuilder sb = new StringBuilder();
            sb.append("Solution Sets Found:\n\n");

            for ( int i = 0; i < numSolutionSets; i++ )
            {
                sb.append("Solution Set " + i + ": " + this.getSolutionSets().get(i).toString() + "\n");
            }

            JOptionPane.showMessageDialog(null, sb.toString(), numSolutionSets + " Solutions Found", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    public final int getCapacity()
    {
        return this.capacity;
    }

    public final List<KnapsackItem> getItems()
    {
        return this.items;
    }

    public final List<List<KnapsackItem>> getSolutionSets()
    {
        return this.solutionSets;
    }

    protected void populateSolutionSets()
    {
        List<KnapsackItem> solution;
        List<KnapsackItem> tempItems = new LinkedList<KnapsackItem>(this.getItems());

        do
        {
            for ( int i = 0; i < this.getItems().size(); i++ )
            {
                solution = KnapsackSolver.knapsack(tempItems, this.getCapacity(), i);

                if ( solution != null )
                {
                    Collections.sort(solution, new KnapsackItem.KnapsackItemAscending());

                    if ( this.getSolutionSets().contains(solution) == false )
                    {
                        this.getSolutionSets().add(solution);
                    }
                }
            }

            tempItems = tempItems.subList(0, tempItems.size() - 1);
        }
        while ( tempItems.size() >= 1 );
    }

    public void reset(final int capacity, final List<KnapsackItem> items)
    {
        Collections.sort(items, new KnapsackItem.KnapsackItemDescending());
        this.setCapacity(capacity);
        this.setItems(items);
        this.setSolutionSets(new LinkedList<List<KnapsackItem>>());
        this.populateSolutionSets();
    }

    protected final void setCapacity(final int capacity)
    {
        this.capacity = capacity;
    }

    protected final void setItems(final List<KnapsackItem> items)
    {
        this.items = items;
    }

    protected final void setSolutionSets(final List<List<KnapsackItem>> solutionSets)
    {
        this.solutionSets = solutionSets;
    }
}

class KnapsackItem
{
    public final static class KnapsackItemAscending implements Comparator<KnapsackItem>
    {
        @Override
        public final int compare(final KnapsackItem item1, final KnapsackItem item2)
        {
            int retVal = item2.getWeight() - item1.getWeight();

            if ( retVal == 0 )
            {
                retVal = item2.getValue() - item1.getValue();
            }

            return retVal;
        }
    }

    public final static class KnapsackItemDescending implements Comparator<KnapsackItem>
    {
        @Override
        public final int compare(final KnapsackItem item1, final KnapsackItem item2)
        {
            int retVal = item1.getWeight() - item2.getWeight();

            if ( retVal == 0 )
            {
                retVal = item1.getValue() - item2.getValue();
            }

            return retVal;
        }
    }

    private int value  = 0;
    private int weight = 0;

    public KnapsackItem(final int weight)
    {
        this.setValue(1);
        this.setWeight(weight);
    }

    @Override
    public boolean equals(final Object obj)
    {
        if ( this == obj ) { return true; }

        if ( obj == null ) { return false; }

        if ( !( obj instanceof KnapsackItem ) ) { return false; }

        KnapsackItem other = (KnapsackItem) obj;

        if ( this.getValue() != other.getValue() ) { return false; }

        if ( this.getWeight() != other.getWeight() ) { return false; }

        return true;
    }

    public final int getValue()
    {
        return this.value;
    }

    public final int getWeight()
    {
        return this.weight;
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 1;
        result = ( prime * result ) + this.getValue();
        result = ( prime * result ) + this.getWeight();
        return result;
    }

    public final void setValue(final int value)
    {
        this.value = value;
    }

    public final void setWeight(final int weight)
    {
        this.weight = weight;
    }

    @Override
    public String toString()
    {
        StringBuilder builder = new StringBuilder();

        if ( this.getValue() != 1 )
        {
            builder.append("weight=");
            builder.append(this.getWeight());
            builder.append(", value=");
            builder.append(this.getValue());
        }
        else
        {
            builder.append(this.getWeight());
        }

        return builder.toString();
    }
}

final class Support
{
    public final static void displayException(final Component parent, final Exception exception, final boolean isFatal)
    {
        if ( parent == null )
        {
            Support.normalizeUIX(parent);
        }

        String dialogTitle, recoveryMessage;

        if ( isFatal )
        {
            dialogTitle = "Fatal Exception Occurred";
            recoveryMessage = "This error is fatal. The program cannot recover from the problem, and will be terminated following this message.";
        }
        else
        {
            dialogTitle = "Non-fatal Exception Occurred";
            recoveryMessage = "This error is not fatal. The program has recovered from the problem, and you may continue operating it.";
        }

        JOptionPane.showMessageDialog(parent, exception.toString() + "\n\nSource file: " + exception.getStackTrace()[0].getFileName() + "\nLine number: " + exception.getStackTrace()[0].getLineNumber() + "\n\nCause file: " + exception.getStackTrace()[exception.getStackTrace().length - 1].getFileName() + "\nLine number: " + exception.getStackTrace()[exception.getStackTrace().length - 1].getLineNumber() + "\n\nWhen: " + Support.getDateTimeStamp() + "\n\nRecovery: " + recoveryMessage, dialogTitle, JOptionPane.ERROR_MESSAGE);
        exception.printStackTrace();

        if ( isFatal )
        {
            System.exit( -1);
        }
    }

    public final static String getDateTimeStamp()
    {
        SimpleDateFormat dateFormatter = new SimpleDateFormat("MM.dd.yyyy hh:mm:ss a z");
        return dateFormatter.format(new Date());
    }

    public final static String getInputString(final Component parent, final String message, final String title)
    {
        if ( parent == null )
        {
            Support.normalizeUIX(parent);
        }

        String s;

        do
        {
            s = JOptionPane.showInputDialog(parent, message, title, JOptionPane.QUESTION_MESSAGE);
        }
        while ( ( s == null ) || s.isEmpty() );

        return s;
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

    public final static void normalizeUIX(final Component parent)
    {
        try
        {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch ( final Exception exception )
        {
            Support.displayException(parent, exception, false);
        }
    }

}