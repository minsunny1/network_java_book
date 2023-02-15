public class Babarian extends Character{
    public Babarian() { // alt + insert + constructor
        hp = 1000;
        mp = 150;
    }

    @Override
    void info() {
        System.out.println("체력: " + hp + "\n지능: " + mp);
    }
}
