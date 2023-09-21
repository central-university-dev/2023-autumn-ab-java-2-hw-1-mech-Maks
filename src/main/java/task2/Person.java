package task2;

public class Person {
    private String name;
    private Person mother;
    private Person father;
    private Person friend;

    public Person(String name) {

        this.name = name;
    }

    public Person(String name, Person mother, Person father, Person friend) {
        this.name = name;
        this.mother = mother;
        this.father = father;
        this.friend = friend;
    }

    @Override
    public String toString() {
        return String.format("%s has mother - %s, father - %s, friend - %s",
                name,
                this.mother != null ? this.mother.name : null,
                this.father != null ? this.father.name : null,
                this.friend != null ? this.friend.name : null
        );
    }

    public String getName() {
        return name;
    }

    public Person getFather() {
        return father;
    }

    public Person getMother() {
        return mother;
    }

    public Person getFriend() {
        return friend;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    public void setFriend(Person newFriend) {
        friend = newFriend;
    }
}
