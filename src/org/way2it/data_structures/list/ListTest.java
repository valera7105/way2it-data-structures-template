package org.way2it.data_structures.list;

public class ListTest {

    public static void main(String[] args) {

        List list = new List();

        list.add("Mars");
        list.add("Snickers");
        list.add("Lion");

        System.out.println("Verifications after adding Mars, Snickers and Lion: ");
        verifyLength(3, list.getLength());
        verifyValue("Mars", list.get(0));
        verifyValue("Snickers", list.get(1));
        verifyValue("Lion", list.get(2));
        System.out.println();

        list.add("Bounty");
        list.add("Kit-Kat");

        System.out.println("Verifications after adding Bounty and Kit-Kat: ");
        verifyLength(5, list.getLength());
        verifyValue("Mars", list.get(0));
        verifyValue("Snickers", list.get(1));
        verifyValue("Lion", list.get(2));
        verifyValue("Bounty", list.get(3));
        verifyValue("Kit-Kat", list.get(4));
        System.out.println();

        list.addAtIndex("Twix", 2);

        System.out.println("Verifications after inserting Twix at index 2: ");
        verifyLength(6, list.getLength());
        verifyValue("Mars", list.get(0));
        verifyValue("Snickers", list.get(1));
        verifyValue("Twix", list.get(2));
        verifyValue("Lion", list.get(3));
        verifyValue("Bounty", list.get(4));
        verifyValue("Kit-Kat", list.get(5));
        System.out.println();

        list.remove(1);

        System.out.println("Verifications after removing element at index 1 (Snickers): ");
        verifyLength(5, list.getLength());
        verifyValue("Mars", list.get(0));
        verifyValue("Twix", list.get(1));
        verifyValue("Lion", list.get(2));
        verifyValue("Bounty", list.get(3));
        verifyValue("Kit-Kat", list.get(4));
        System.out.println();

        System.out.println("Verifications of indexOf() method: ");
        verifyIndex("Mars", 0, list.indexOf("Mars"));
        verifyIndex("Kit-Kat", 4, list.indexOf("Kit-Kat"));
        verifyIndex("Snickers", -1, list.indexOf("Snickers"));
        System.out.println();
    }

    private static void verifyLength(int expected, int actual) {
        System.out.print("\t");
        if (expected != actual) {
            System.out.printf("Error! Length of list should be equal to %s, your value is %s\n", expected, actual);
        } else {
            System.out.println("OK");
        }
    }

    private static void verifyValue(String expected, String actual) {
        System.out.print("\t");
        if (!expected.equals(actual)) {
            System.out.printf("Error! Expected value: %s, your value is: %s\n", expected, actual);
        } else {
            System.out.println("OK");
        }
    }

    private static void verifyIndex(String value, int expectedIndex, int actualIndex) {
        System.out.print("\t");
        if (expectedIndex != actualIndex) {
            System.out.printf("Error! Index of value \"%s\" should be %s, your index is %s\n", value, expectedIndex, actualIndex);
        } else {
            System.out.println("OK");
        }
    }
}
