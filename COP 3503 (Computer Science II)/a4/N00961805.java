/*
 * Title: COP 3503 - Assignment 4
 * Francis Rukab N00961805
 * Date: 10/24/2017
 */

import javax.annotation.processing.FilerException;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.io.FileOutputStream;
import java.io.FileNotFoundException;

public class N00961805
{
    public static class AmericanCar extends Car
    {
        private boolean isMadeInDetroit = false;
        private boolean isUnionShop     = false;

        public AmericanCar()
        {
        }

        public AmericanCar(final AmericanCar newAmericanCar)
        {
            super(newAmericanCar);
            this.setMadeInDetroit(newAmericanCar.isMadeInDetroit());
            this.setUnionShop(newAmericanCar.isUnionShop());
        }

        public AmericanCar(final String ownersName,
                           final String address,
                           final String phone,
                           final String email,
                           final boolean isConvertible,
                           final String color,
                           final boolean isMadeInDetroit,
                           final boolean isUnionShop)
        {
            super(ownersName, address, phone, email, isConvertible, color);
            this.setMadeInDetroit(isMadeInDetroit);
            this.setUnionShop(isUnionShop);
        }

        @Override
        public int hashCode()
        {
            /*
             * The hashCode method is a way to reduce all of an object's properties down to a single integer to assist in equality comparisons. Each
             * property's individual hash code is joined by the XOR operator, which will generate a new hash code that will change even if only a
             * single bit changes in any of its component parts.
             */
            return (super.hashCode() ^ this.isMadeInDetroit().hashCode() ^ this.isUnionShop().hashCode());
        }

        public final Boolean isMadeInDetroit()
        {
            return this.isMadeInDetroit;
        }

        public final Boolean isUnionShop()
        {
            return this.isUnionShop;
        }

        protected final void setAmericanCar(final AmericanCar newAmericanCar)
        {
            this.setCar(newAmericanCar);
            this.setMadeInDetroit(newAmericanCar.isMadeInDetroit());
            this.setUnionShop(newAmericanCar.isUnionShop());
        }

        protected final void setMadeInDetroit(final boolean isMadeInDetroit)
        {
            this.isMadeInDetroit = isMadeInDetroit;
        }

        protected final void setUnionShop(final boolean isUnionShop)
        {
            this.isUnionShop = isUnionShop;
        }

        @Override
        public String toString()
        {
            return (super.toString() + "Made in detroit: " + this.isMadeInDetroit() + "\nUnion shop: " + this.isUnionShop() + "\n");
        }
    }

    public static class Bicycle extends Vehicle
    {
        private int numberOfSpeeds = 0;

        public Bicycle()
        {
        }

        public Bicycle(final Bicycle newBicycle)
        {
            super(newBicycle);
            this.setNumberOfSpeeds(newBicycle.getNumberOfSpeeds());
        }

        public Bicycle(final String ownersName, final String address, final String phone, final String email, final int numberOfSpeeds)
        {
            super(ownersName, address, phone, email);
            this.setNumberOfSpeeds(numberOfSpeeds);
        }

        public final Integer getNumberOfSpeeds()
        {
            return this.numberOfSpeeds;
        }

        @Override
        public int hashCode()
        {
            /*
             * The hashCode method is a way to reduce all of an object's properties down to a single integer to assist in equality comparisons. Each
             * property's individual hash code is joined by the XOR operator, which will generate a new hash code that will change even if only a
             * single bit changes in any of its component parts.
             */
            return (super.hashCode() ^ this.getNumberOfSpeeds().hashCode());
        }

        protected final void setBicycle(final Bicycle newBicycle)
        {
            this.setVehicle(newBicycle);
            this.setNumberOfSpeeds(this.numberOfSpeeds);
        }

        protected final void setNumberOfSpeeds(final int numberOfSpeeds)
        {
            this.numberOfSpeeds = numberOfSpeeds;
        }

        @Override
        public String toString()
        {
            return (super.toString() + "Number of speeds: " + this.getNumberOfSpeeds() + "\n");
        }
    }

    public static class Car extends Vehicle
    {
        private String  color         = "";
        private boolean isConvertible = false;

        public Car()
        {
        }

        public Car(final Car newCar)
        {
            super(newCar);
            this.setConvertible(newCar.isConvertible());
            this.setColor(newCar.getColor());
        }

        public Car(final String ownersName,
                   final String address,
                   final String phone,
                   final String email,
                   final boolean isConvertible,
                   final String color)
        {
            super(ownersName, address, phone, email);
            this.setConvertible(isConvertible);
            this.setColor(color);
        }

        public final String getColor()
        {
            return this.color;
        }

        @Override
        public int hashCode()
        {
            /*
             * The hashCode method is a way to reduce all of an object's properties down to a single integer to assist in equality comparisons. Each
             * property's individual hash code is joined by the XOR operator, which will generate a new hash code that will change even if only a
             * single bit changes in any of its component parts.
             */
            return (super.hashCode() ^ this.getColor().hashCode() ^ this.isConvertible().hashCode());
        }

        public final Boolean isConvertible()
        {
            return this.isConvertible;
        }

        protected void setCar(final Car newCar)
        {
            this.setVehicle(newCar);
            this.setConvertible(newCar.isConvertible());
            this.setColor(newCar.getColor());
        }

        protected final void setColor(final String color)
        {
            this.color = color;
        }

        protected final void setConvertible(final boolean isConvertible)
        {
            this.isConvertible = isConvertible;
        }

        @Override
        public String toString()
        {
            return (super.toString() + "Color: " + this.getColor() + "\nConvertible: " + this.isConvertible() + "\n");
        }
    }

    public static class ForeignCar extends Car
    {
        private String countryOfManufacture = "";
        private float  importDuty           = 0.0f;

        public ForeignCar()
        {
        }

        public ForeignCar(final ForeignCar newForeignCar)
        {
            super(newForeignCar);
            this.setCountryOfManufacture(newForeignCar.getCountryOfManufacture());
            this.setImportDuty(newForeignCar.getImportDuty());
        }

        public ForeignCar(final String ownersName,
                          final String address,
                          final String phone,
                          final String email,
                          final boolean isConvertible,
                          final String color,
                          final String countryOfManufacture,
                          final float importDuty)
        {
            super(ownersName, address, phone, email, isConvertible, color);
            this.setCountryOfManufacture(countryOfManufacture);
            this.setImportDuty(importDuty);
        }

        public final String getCountryOfManufacture()
        {
            return this.countryOfManufacture;
        }

        public final Float getImportDuty()
        {
            return this.importDuty;
        }

        @Override
        public int hashCode()
        {
            /*
             * The hashCode method is a way to reduce all of an object's properties down to a single integer to assist in equality comparisons. Each
             * property's individual hash code is joined by the XOR operator, which will generate a new hash code that will change even if only a
             * single bit changes in any of its component parts.
             */
            return (super.hashCode() ^ this.getCountryOfManufacture().hashCode() ^ this.getImportDuty().hashCode());
        }

        protected final void setCountryOfManufacture(final String countryOfManufacture)
        {
            this.countryOfManufacture = countryOfManufacture;
        }

        protected final void setForeignCar(final ForeignCar newForeignCar)
        {
            this.setCar(newForeignCar);
            this.setCountryOfManufacture(newForeignCar.getCountryOfManufacture());
            this.setImportDuty(newForeignCar.getImportDuty());
        }

        protected final void setImportDuty(final float importDuty)
        {
            this.importDuty = importDuty;
        }

        @Override
        public String toString()
        {
            return (super.toString() + "Country of manufacture: " + this.getCountryOfManufacture() + "\nImport duty: " + this.getImportDuty() + "\n");
        }
    }

    public static class Truck extends Vehicle
    {
//        protected static boolean validateDateString(final String date)
//        {
//            if ((date == null) || date.isEmpty())
//            {
//                return false;
//            }
//
//            // Check for MM/DD/YYYY format and insure the correct number of months and days.
//            if (date.matches("[0-9]+/[0-9]+/[0-9]+"))
//            {
//                int[] intArray = {
//                        0, 0, 0
//                };
//                String[] stringArray = date.split("/", 3);
//
//                for (int i = 0; i < 3; i++)
//                {
//                    intArray[i] = Integer.parseInt(stringArray[i]);
//                }
//
//                if (intArray[0] < 1)
//                {
//                    Support.displayException(null, new Exception("Month value must exceed the lower bound of 1."), false);
//                    return false;
//                }
//
//                if (intArray[0] > 12)
//                {
//                    Support.displayException(null, new Exception("Month value must not exceed the upper bound of 12."), false);
//                    return false;
//                }
//
//                int dayUpperBound, dayLowerBound = 1;
//
//                switch (intArray[0])
//                {
//
//                    case 2:
//
//                        dayUpperBound = 28;
//                        break;
//
//                    case 4:
//                    case 6:
//                    case 9:
//                    case 11:
//
//                        dayUpperBound = 30;
//                        break;
//
//                    default:
//
//                        dayUpperBound = 31;
//                        break;
//                }
//
//                if (intArray[1] < dayLowerBound)
//                {
//                    Support.displayException(null, new Exception("Day value must exceed the lower bound of " + dayLowerBound + "."), false);
//                    return false;
//                }
//
//                if (intArray[1] > dayUpperBound)
//                {
//                    Support.displayException(null, new Exception("Day value must not exceed the upper bound of " + dayUpperBound + "."), false);
//                    return false;
//                }
//
//                if (intArray[2] < 0)
//                {
//                    Support.displayException(null, new Exception("Year value must be greater than or equal to 0."), false);
//                    return false;
//                }
//
//                return true;
//            }
//
//            return false;
//        }

        private float  costOfTruck   = 0.0f;
        private String datePurchased = "1/1/1970";
        private float  numberOfTons  = 0.0f;

        public Truck()
        {
        }

        public Truck(final String ownersName,
                     final String address,
                     final String phone,
                     final String email,
                     final float numberOfTons,
                     final float costOfTruck,
                     final String datePurchased)
        {
            super(ownersName, address, phone, email);
            this.setNumberOfTons(numberOfTons);
            this.setCostOfTruck(costOfTruck);
            //this.setDatePurchased(datePurchased);
        }

        public Truck(final Truck newTruck)
        {
            super(newTruck);
            this.setNumberOfTons(newTruck.getNumberOfTons());
            this.setCostOfTruck(newTruck.getCostOfTruck());
            //this.setDatePurchased(newTruck.getDatePurchased());
        }

        public final Float getCostOfTruck()
        {
            return this.costOfTruck;
        }

        public final String getDatePurchased()
        {
            return this.datePurchased;
        }

        public final Float getNumberOfTons()
        {
            return this.numberOfTons;
        }

        @Override
        public int hashCode()
        {
            /*
             * The hashCode method is a way to reduce all of an object's properties down to a single integer to assist in equality comparisons. Each
             * property's individual hash code is joined by the XOR operator, which will generate a new hash code that will change even if only a
             * single bit changes in any of its component parts.
             */
            return (super.hashCode() ^ this.getNumberOfTons().hashCode() ^ this.getCostOfTruck().hashCode() ^ this.getDatePurchased().hashCode());
        }

        protected final void setCostOfTruck(final float costOfTruck)
        {
            this.costOfTruck = costOfTruck;
        }

//        protected final void setDatePurchased(final String datePurchased)
//        {
//            if (Truck.validateDateString(datePurchased))
//            {
//                this.datePurchased = datePurchased;
//            }
//            else
//            {
//                Support.displayException(null, new Exception("The given date is invalid. The object has not been changed."), false);
//            }
//        }

        protected final void setNumberOfTons(final float numberOfTons)
        {
            this.numberOfTons = numberOfTons;
        }

        protected final void setTruck(final Truck newTruck)
        {
            this.setVehicle(newTruck);
            this.setNumberOfTons(newTruck.getNumberOfTons());
            this.setCostOfTruck(newTruck.getCostOfTruck());
            // this.setDatePurchased(newTruck.getDatePurchased());
        }

        @Override
        public String toString()
        {
            return (super.toString() + "Number of tons: " +
                    this.getNumberOfTons() +
                    "\nCost of truck: " +
                    this.getCostOfTruck() +
                    "\nDate purchased: " +
                    this.getDatePurchased() + "\n");
        }
    }

    public static class Vehicle
    {
        public final static class VehicleEmailAscendingComparator implements Comparator<Vehicle>
        {
            @Override
            public final int compare(final Vehicle vehicle1, final Vehicle vehicle2)
            {
                return vehicle1.getEmail().compareTo(vehicle2.getEmail());
            }
        }

        public final static class VehicleEmailAscendingIgnoreCaseComparator implements Comparator<Vehicle>
        {
            @Override
            public final int compare(final Vehicle vehicle1, final Vehicle vehicle2)
            {
                return vehicle1.getEmail().compareToIgnoreCase(vehicle2.getEmail());
            }
        }

        public final static class VehicleEmailDescendingComparator implements Comparator<Vehicle>
        {
            @Override
            public final int compare(final Vehicle vehicle1, final Vehicle vehicle2)
            {
                return vehicle2.getEmail().compareTo(vehicle1.getEmail());
            }
        }

        public final static class VehicleEmailDescendingIgnoreCaseComparator implements Comparator<Vehicle>
        {
            @Override
            public final int compare(final Vehicle vehicle1, final Vehicle vehicle2)
            {
                return vehicle2.getEmail().compareToIgnoreCase(vehicle1.getEmail());
            }
        }

        private String address    = "";
        private String email      = "";
        private String ownersName = "";
        private String phone      = "";

        public Vehicle()
        {
        }

        public Vehicle(final String ownersName, final String address, final String phone, final String email)
        {
            this.setOwnersName(ownersName);
            this.setAddress(address);
            this.setPhone(phone);
            this.setEmail(email);
        }

        public Vehicle(final Vehicle newVehicle)
        {
            this.setVehicle(newVehicle);
        }

        @Override
        public boolean equals(final Object obj)
        {
            if (obj == null) // If 'obj' is null, it cannot be equal to 'this' so return false.
            {
                return false;
            }

            if (this == obj) // If 'obj' is located at the same memory address as 'this',
            {				 // then 'obj' is 'this', and thus they are equal so return true.
                return true;
            }

            // Check to see if 'this' is an object of the same class as 'obj'.
            if (this.getClass() != obj.getClass())
            {
                // If 'this' is not an object of the same class as 'obj',
                // check to see if the two classes are assignment compatible.
                if (this.getClass().isInstance(obj))
                {
                    // If the two classes are assignment compatible,
                    // use the hashCode methods to determine equality.
                    if (this.hashCode() == obj.hashCode())
                    {
                        return true;
                    }
                }
            }
            // If 'this' is an object of the same class as 'obj',
            // use the hashCode methods to determine equality.
            else
            {
                if (this.hashCode() == obj.hashCode())
                {
                    return true;
                }
            }

            // If the two classes are not the same or assignment compatible, return false.
            // If hashCode method comparisons are false, return false.
            return false;
        }

        public final String getAddress()
        {
            return this.address;
        }

        public final String getEmail()
        {
            return this.email;
        }

        public final String getOwnersName()
        {
            return this.ownersName;
        }

        public final String getPhone()
        {
            return this.phone;
        }

        @Override
        public int hashCode()
        {
            /*
             * The hashCode method is a way to reduce all of an object's properties down to a single integer to assist in equality comparisons. Each
             * property's individual hash code is joined by the XOR operator, which will generate a new hash code that will change even if only a
             * single bit changes in any of its component parts.
             */
            return (this.getOwnersName().hashCode() ^ this.getAddress().hashCode() ^ this.getPhone().hashCode() ^ this.getEmail().hashCode());
        }

        protected final void setAddress(final String address)
        {
            this.address = address;
        }

        protected final void setEmail(final String email)
        {
            this.email = email;
        }

        protected final void setOwnersName(final String ownersName)
        {
            this.ownersName = ownersName;
        }

        protected final void setPhone(final String phone)
        {
            this.phone = phone;
        }

        protected final void setVehicle(final Vehicle newVehicle)
        {
            this.setAddress(newVehicle.getAddress());
            this.setEmail(newVehicle.getEmail());
            this.setOwnersName(newVehicle.getOwnersName());
            this.setPhone(newVehicle.getPhone());
        }

        @Override
        public String toString()
        {
            return ("Record type: " + this.getClass().getSimpleName() +
                    "\nOwner's name: " +
                    this.getOwnersName() +
                    "\nOwner's address: " +
                    this.getAddress() +
                    "\nOwner's phone number: " +
                    this.getPhone() +
                    "\nOwner's email address: " +
                    this.getEmail() + "\n");
        }
    }

    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("vehicle.txt");
        List<Vehicle> vehicleList = new ArrayList<Vehicle>();

        // Create a Scanner for the file
        Scanner input = new Scanner(file);
        // Read data from a file
        do {
            String line1 = input.nextLine();
            System.out.println(line1);
        } while (input.hasNext());
    }

    public A4(final String[] args){

        List<Vehicle> vehicleList = new ArrayList<Vehicle>();

        if (args.length > 0)
        {
            for (String arg: args)
            {
                this.openFile(arg, vehicleList);
            }
        }
        else
        {
            this.openFile(null, vehicleList);
        }
    }

    protected final void openFile(final String filePath, final List<Vehicle> vehicleList)
    {
        String newFilePath = filePath;

        if ((newFilePath == null) || newFilePath.isEmpty())
        {
            newFilePath = Support.getFilePath(null, true, this.isDebugging());
        }

        if ((newFilePath == null) || newFilePath.isEmpty())
        {
            // User has canceled the file operation; abort!
            return;
        }

        Scanner inputStream = null; // Stream object for file input.

        try
        {
            // Initialize file stream. If the given path is invalid, an exception is thrown.
            inputStream = new Scanner(new File(newFilePath));
            this.parseFile(inputStream, vehicleList);
        }
        catch (final Exception exception)
        {
            // Handle the exception by alerting the user of the error.
            Support.displayException(null, exception, false);
        }
        finally
        {
            if (inputStream != null)
            {
                // Close the input stream.
                inputStream.close();
                inputStream = null;
            }
        }
    }

    protected final void parseFile(final Scanner inputStream, final List<Vehicle> vehicleList)
    {
        while (inputStream.hasNextLine())
        {
            String ownersName, address, phone, email, numberOfSpeeds, isConvertible, color, numberOfTons, costOfTruck, datePurchased, isMadeInDetroit, isUnionShop, countryOfManufacture, importDuty;

            // Get the next line in the file.
            String line = inputStream.nextLine().trim();

            switch (line.toLowerCase())
            {

                case "vehicle":

                    ownersName = inputStream.nextLine();
                    address = inputStream.nextLine();
                    phone = inputStream.nextLine();
                    email = inputStream.nextLine();

                    vehicleList.add(new Vehicle(ownersName, address, phone, email));
                    break;

                case "bicycle":

                    ownersName = inputStream.nextLine();
                    address = inputStream.nextLine();
                    phone = inputStream.nextLine();
                    email = inputStream.nextLine();
                    numberOfSpeeds = inputStream.nextLine();

                    if (Support.isStringParsedAsInteger(numberOfSpeeds))
                    {
                        vehicleList.add(new Bicycle(ownersName, address, phone, email, Integer.parseInt(numberOfSpeeds)));
                    }
                    else
                    {
                        Support.displayException(null, new Exception("Failure parsing file: 'numberOfSpeeds' must be an integer."), false);
                    }
                    break;

                case "car":

                    ownersName = inputStream.nextLine();
                    address = inputStream.nextLine();
                    phone = inputStream.nextLine();
                    email = inputStream.nextLine();
                    isConvertible = inputStream.nextLine();
                    color = inputStream.nextLine();

                    if (Support.isStringParsedAsBoolean(isConvertible))
                    {
                        vehicleList.add(new Car(ownersName, address, phone, email, Boolean.parseBoolean(isConvertible), color));
                    }
                    else
                    {
                        Support.displayException(null, new Exception("Failure parsing file: 'isConvertible' must be a boolean."), false);
                    }
                    break;

                case "truck":

                    ownersName = inputStream.nextLine();
                    address = inputStream.nextLine();
                    phone = inputStream.nextLine();
                    email = inputStream.nextLine();
                    numberOfTons = inputStream.nextLine();
                    costOfTruck = inputStream.nextLine();
                    datePurchased = inputStream.nextLine();

                    if (Support.isStringParsedAsFloat(numberOfTons) && Support.isStringParsedAsFloat(costOfTruck))
                    {
                        vehicleList.add(new Truck(ownersName,
                                address,
                                phone,
                                email,
                                Float.parseFloat(numberOfTons),
                                Float.parseFloat(costOfTruck),
                                datePurchased));
                    }
                    else
                    {
                        if (!Support.isStringParsedAsFloat(numberOfTons))
                        {
                            Support.displayException(null, new Exception("Failure parsing file: 'numberOfTons' must be a float."), false);
                        }
                        else if (!Support.isStringParsedAsFloat(costOfTruck))
                        {
                            Support.displayException(null, new Exception("Failure parsing file: 'costOfTruck' must be a float."), false);
                        }
                        else
                        {
                            Support.displayException(null, new Exception("Failure parsing file: unknown anomaly."), false);
                        }
                    }
                    break;

                case "american car":

                    ownersName = inputStream.nextLine();
                    address = inputStream.nextLine();
                    phone = inputStream.nextLine();
                    email = inputStream.nextLine();
                    isConvertible = inputStream.nextLine();
                    color = inputStream.nextLine();
                    isMadeInDetroit = inputStream.nextLine();
                    isUnionShop = inputStream.nextLine();

                    if ((Support.isStringParsedAsBoolean(isConvertible)) && (Support.isStringParsedAsBoolean(isMadeInDetroit)) &&
                            (Support.isStringParsedAsBoolean(isUnionShop)))
                    {
                        vehicleList.add(new AmericanCar(ownersName,
                                address,
                                phone,
                                email,
                                Boolean.parseBoolean(isConvertible),
                                color,
                                Boolean.parseBoolean(isMadeInDetroit),
                                Boolean.parseBoolean(isUnionShop)));
                    }
                    else
                    {
                        if (!Support.isStringParsedAsBoolean(isConvertible))
                        {
                            Support.displayException(null, new Exception("Failure parsing file: 'isConvertible' must be a boolean."), false);
                        }
                        else if (!Support.isStringParsedAsBoolean(isMadeInDetroit))
                        {
                            Support.displayException(null, new Exception("Failure parsing file: 'isMadeInDetroit' must be a boolean."), false);
                        }
                        else if (!Support.isStringParsedAsBoolean(isUnionShop))
                        {
                            Support.displayException(null, new Exception("Failure parsing file: 'isUnionShop' must be a boolean."), false);
                        }
                        else
                        {
                            Support.displayException(null, new Exception("Failure parsing file: unknown anomaly."), false);
                        }
                    }
                    break;

                case "foreign car":

                    ownersName = inputStream.nextLine();
                    address = inputStream.nextLine();
                    phone = inputStream.nextLine();
                    email = inputStream.nextLine();
                    isConvertible = inputStream.nextLine();
                    color = inputStream.nextLine();
                    countryOfManufacture = inputStream.nextLine();
                    importDuty = inputStream.nextLine();

                    if (Support.isStringParsedAsFloat(importDuty) && (Support.isStringParsedAsBoolean(isConvertible)))
                    {
                        vehicleList.add(new ForeignCar(ownersName,
                                address,
                                phone,
                                email,
                                Boolean.parseBoolean(isConvertible),
                                color,
                                countryOfManufacture,
                                Float.parseFloat(importDuty)));
                    }
                    else
                    {
                        if (!Support.isStringParsedAsFloat(importDuty))
                        {
                            Support.displayException(null, new Exception("Failure parsing file: 'importDuty' must be a float."), false);
                        }
                        else if (!Support.isStringParsedAsBoolean(isConvertible))
                        {
                            Support.displayException(null, new Exception("Failure parsing file: 'isConvertible' must be a boolean."), false);
                        }
                        else
                        {
                            Support.displayException(null, new Exception("Failure parsing file: unknown anomaly."), false);
                        }
                    }
                    break;

                default:

                    if (!line.isEmpty())
                    {
                        Support.displayException(null, new Exception("Failure parsing file: record type '" + line + "' is not recognized."), false);
                    }
                    break;
            }
        }
    }

    protected final void printAllVehicles(final List<Vehicle> vehicleList)
    {
        for (int i = 0; i < vehicleList.size(); i++)
        {
            StdOut.println(vehicleList.get(i).toString());
        }
    }

    protected final void printNumberOfVehicles(final List<Vehicle> vehicleList)
    {
        StdOut.println("Number of records: " + vehicleList.size() + "\n");
    }

    protected final void printSortedBicyclesAndTrucks(final List<Vehicle> vehicleList)
    {
        List<Vehicle> sortedList = new ArrayList<Vehicle>();
        sortedList.addAll(vehicleList);
        Collections.sort(sortedList, new Vehicle.VehicleEmailAscendingComparator());

        for (int i = 0; i < vehicleList.size(); i++)
        {
            if ((vehicleList.get(i) instanceof Bicycle) || (vehicleList.get(i) instanceof Truck))
            {
                StdOut.println(vehicleList.get(i).toString());
            }
        }
    }

    protected final void printVehiclesInAreaCode(final List<Vehicle> vehicleList, final int areaCode)
    {
        for (int i = 0; i < vehicleList.size(); i++)
        {
            if (vehicleList.get(i).getPhone().contains("(" + areaCode + ")"))
            {
                StdOut.println(vehicleList.get(i).toString());
            }
        }
    }

    protected final void setDebugging(final boolean isDebugging)
    {
        this.isDebugging = isDebugging;
    }

    protected final void sortAndPrintAllVehicles(final List<Vehicle> vehicleList)
    {
        List<Vehicle> sortedList = new ArrayList<Vehicle>();
        sortedList.addAll(vehicleList);
        Collections.sort(sortedList, new Vehicle.VehicleEmailAscendingComparator());

        for (int i = 0; i < sortedList.size(); i++)
        {
            StdOut.println(sortedList.get(i).toString());
        }
    }

    public class Support{
        public final static String getFilePath(final Component parent, final boolean isOpen, final boolean isDebugging)
        {
            if ( parent == null )
            {
                Support.normalizeUIX(parent);
            }

            JFileChooser fileDialog = new JFileChooser();
            String filePath = null;
            boolean isDone = false;
            int choice = 0;

            do // Loop while 'isDone' equals false, post-test.
            {
                if ( isOpen )
                {
                    choice = fileDialog.showOpenDialog(parent);
                }
                else
                {
                    choice = fileDialog.showSaveDialog(parent);
                }

                switch ( choice )
                {
                    case JFileChooser.APPROVE_OPTION:

                        try
                        {
                            filePath = fileDialog.getSelectedFile().getCanonicalPath();
                            isDone = true;
                        }
                        catch ( final Exception exception )
                        {
                            filePath = null;
                            isDone = false;
                        }
                        break;

                    case JFileChooser.CANCEL_OPTION:

                        filePath = null;
                        isDone = true;
                        break;

                    default:

                        filePath = null;
                        isDone = false;
                        break;
                }
            }
            while ( !isDone );

            if ( isDebugging )
            {
                Support.displayDebugMessage(null, "File Path: " + filePath + "\n");
            }

            return filePath;
        }
}
}