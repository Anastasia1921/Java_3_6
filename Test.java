import java.util.*;

public class Test
{
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        HashMap<Integer, List<User>> mapUser = new HashMap<Integer, List<User>>();

        String name;
        int age;

        for (int i = 1; i <= 5; i++) {
            System.out.printf("Введите имя %d пользователя (строка):\n", i);
            name = in.nextLine();
            System.out.printf("Введите возраст %d пользователя (целое число):\n", i);
            age = in.nextInt();
            in.nextLine();
            if (mapUser.containsKey(age))
                mapUser.get(age).add(new User(name, age));
            else {
                List<User> lst = new ArrayList<User>();
                lst.add(new User(name, age));
                mapUser.put(age, lst);
            }
        }

        System.out.println("Введите требуемый возраст пользователя (целое число):");
        int inAge = in.nextInt();

        if (mapUser.containsKey(inAge)) {
            for (User u : mapUser.get(inAge))
                System.out.println(u.toString());
        }
        else {
            System.out.println("Пользователя с запрашиваемым возрастом в списке нет");
            System.out.println("   -----------Зато есть пользователи:----------");
            for (int i : mapUser.keySet())
                for (User u1 : mapUser.get(i))
                    System.out.println(u1.toString());

        }
    }
}