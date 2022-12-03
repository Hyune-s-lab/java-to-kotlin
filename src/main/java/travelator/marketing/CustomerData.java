package travelator.marketing;

import java.util.Objects;

public class CustomerData {
    private final String id;
    private final String givenName;
    private final String familyName;
    private final int score;
    private final double spend;

    public CustomerData(
        String id,
        String givenName,
        String familyName,
        int score,
        double spend
    ) {
        this.id = id;
        this.givenName = givenName;
        this.familyName = familyName;
        this.score = score;
        this.spend = spend;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CustomerData that = (CustomerData) o;
        return score == that.score &&
            Double.compare(that.spend, spend) == 0 &&
            id.equals(that.id) &&
            givenName.equals(that.givenName) &&
            familyName.equals(that.familyName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, givenName, familyName, score, spend);
    }

    public String getId() {
        return id;
    }

    public String getGivenName() {
        return givenName;
    }

    public String getFamilyName() {
        return familyName;
    }

    public int getScore() {
        return score;
    }

    public double getSpend() {
        return spend;
    }
}
