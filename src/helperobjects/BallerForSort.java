package helperobjects;

public class BallerForSort implements Comparable<BallerForSort> {
    private double score;
    private String name;

    public BallerForSort(String name, double score) {
        this.score = score;
        this.name = name;
    }

    @Override
    public int compareTo(BallerForSort o) {
        return (int) (this.score - o.score);
    }

    public String getName() {
        return name;
    }

    public double getScore() {
        return score;
    }
}
