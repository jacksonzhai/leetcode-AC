enum Shrubbery {GROUND,CRAWLING,HAVING}
public class EnumTest {
    public static void main(String[] args) {
        for(Shrubbery s:Shrubbery.values()){
            System.out.println(s+" ordinal: " + s.ordinal());
            //System.out.println(s.compareTo(Shrubbery.CRAWLING) + "");
        }
    }
}
