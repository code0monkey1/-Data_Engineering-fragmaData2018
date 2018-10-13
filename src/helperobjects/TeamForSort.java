package helperobjects;

public class TeamForSort implements Comparable<TeamForSort> {
    private String name;
    private int score;

    public TeamForSort(String name, int score) {
        this.name = name;
        this.score = score;
    }

    @Override

    public int compareTo(TeamForSort o) {
        return this.score - o.score;
    }

    public String getName() {
        return name;
    }
}
