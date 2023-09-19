package homework1;

public class Person {
    private Person friend;
    private Person mother;
    private Person father;
    private final String name;

    public Person(String name){
        this.name = name;
    }

    public Person getFriend() {
        return friend;
    }

    public void setFriend(Person friend) {
        this.friend = friend;
    }

    public Person getMother() {
        return mother;
    }

    public void setMother(Person mother) {
        this.mother = mother;
    }

    public Person getFather() {
        return father;
    }

    public void setFather(Person father) {
        this.father = father;
    }

    @Override
    public String toString(){
        return this.name;
    }
}
