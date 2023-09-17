package task02;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;
import task02.processors.LogProcessor;
import task02.processors.RemoveFriendProcessor;
import task02.processors.SwapParentsProcessor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

/**
 * Unit test for simple App.
 */
public class AppTest
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testSwapParents()
    {
        Person person = getSimplePerson();
        List<Consumer<Person>> personProcessors = new ArrayList<>(List.of(
                new SwapParentsProcessor()
        ));

        person.executePersonProcessorsChain(personProcessors);

        assertEquals("FatherName", Optional.ofNullable(person).map(Person::getMother).map(Person::getName).orElse(null));
    }

    public void testRemoveFriend()
    {
        Person person = getSimplePerson();
        List<Consumer<Person>> personProcessors = new ArrayList<>(List.of(
                new RemoveFriendProcessor()
        ));

        person.executePersonProcessorsChain(personProcessors);

        assertFalse(Optional.ofNullable(person).map(Person::getFriend).isPresent());
    }

    public void testSwapMaternalGrandparents()
    {
        Person person = getComplexPerson();
        List<Consumer<Person>> personProcessors = new ArrayList<>(List.of(
                new SwapParentsProcessor()
        ));

        Optional.ofNullable(person).map(Person::getMother).orElse(null).executePersonProcessorsChain(personProcessors);

        assertEquals("MaternalGrandmotherName", Optional.ofNullable(person)
                .map(Person::getMother)
                .map(Person::getFather)
                .map(Person::getName).orElse(null));
    }

    public void testRemoveFathersFriend()
    {
        Person person = getComplexPerson();
        List<Consumer<Person>> personProcessors = new ArrayList<>(List.of(
                new RemoveFriendProcessor()
        ));

        Optional.ofNullable(person).map(Person::getFather).orElse(null).executePersonProcessorsChain(personProcessors);

        assertFalse(Optional.ofNullable(person).map(Person::getFather).map(Person::getFriend).isPresent());
    }

    public void testComplexChain()
    {
        Person person = getComplexPerson();
        List<Consumer<Person>> personProcessors = new ArrayList<>(List.of(
                new RemoveFriendProcessor(),
                new LogProcessor(),
                new SwapParentsProcessor()
        ));

        person.executePersonProcessorsChain(personProcessors);

        assertEquals("FatherName", Optional.ofNullable(person).map(Person::getMother).map(Person::getName).orElse(null));
        assertEquals("MaternalGrandmotherName", Optional.ofNullable(person).map(Person::getFather).map(Person::getMother).map(Person::getName).orElse(null));
        assertFalse(Optional.ofNullable(person).map(Person::getFriend).isPresent());
    }

    private Person getSimplePerson() {
        return new Person(
                "KidName",
                new Person("MotherName"),
                new Person("FatherName"),
                new Person("FriendName")
        );
    }

    private Person getComplexPerson() {
        Person mother = new Person(
                "MotherName",
                new Person("MaternalGrandmotherName"),
                new Person("MaternalGrandfatherName"),
                new Person("MothersFriend")
        );
        Person father = new Person(
                "FatherName",
                new Person("PaternalGrandmotherName"),
                new Person("PaternalGrandfatherName"),
                new Person("FathersFriend")
        );
        Person friend = new Person(
                "FriendName",
                new Person("FriendsMother"),
                new Person("FriendsFather"),
                null
        );
        Person person = new Person(
                "KidName",
                mother,
                father,
                friend
        );
        friend.setFriend(person);

        return person;
    }
}
