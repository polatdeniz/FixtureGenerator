import java.util.*;

public class Main {
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        List <String> teams = new ArrayList <>();
        List<String> tempTeams = new ArrayList<>();
        LinkedHashMap<String, ArrayList<ArrayList<String>>> rounds = new LinkedHashMap<>();

        System.out.print("Enter number of teams: ");
        int count = scan.nextInt();
        System.out.println("Enter team name: ");

        for (int i = 0; i < count; i++)
        {
            String team = scan.next();
            teams.add(team);
        }

        if ((count % 2) == 1) 
        {
            teams.add("Bay");
            count++;
        }

        while (0 < teams.size())
        {
            int index = (int) (Math.random()*teams.size());
            tempTeams.add(teams.get(index));
            teams.remove(teams.get(index));
        }

        teams = tempTeams;
        int totalRound = count - 1;
        int numMatchPerRound = count / 2;

        for (int i = 0; i < totalRound; i++)
        {
            String round = String.valueOf(i + 1);
            rounds.put(round, new ArrayList<ArrayList<String>>());
        }

        for (int i = 0; i<totalRound; i++)
        {
            ArrayList<String> home = new ArrayList<>();
            ArrayList<String> away = new ArrayList<>();

            for (int j = 0; j < numMatchPerRound; j++)
            {
                home.add(teams.get(j));
                away.add(teams.get((count-1) -j));
            }

            String round = String.valueOf(i+1);
            rounds.get(round).add(home);
            rounds.get(round).add(away);

            List <String> newTeams = new ArrayList<>();

            newTeams.add(teams.get(0));
            newTeams.add(teams.get((count - 1)));

            for (int j = 1; j < (teams.size()-1) ; j++)
            {
                newTeams.add(teams.get(j));
            }
            teams = newTeams;
        }
        System.out.println();

        for (int i = 0; i < (2*totalRound) ; i++)
        {
            System.out.println((i + 1) + ". Round");
            for (int j = 0; j < numMatchPerRound; j++)
            {
                if (i < totalRound)
                {
                    System.out.println(rounds.get(String.valueOf(i + 1)).get(0).get(j) + " vs " + rounds.get(String.valueOf(i + 1)).get(1).get(j));
                } 
                else
                {
                    System.out.println(rounds.get(String.valueOf(i + 1 - totalRound)).get(1).get(j) + " vs " + rounds.get(String.valueOf(i + 1 - totalRound)).get(0).get(j));
                }
            }
            System.out.println();
            scan.close();
        }
    }
}