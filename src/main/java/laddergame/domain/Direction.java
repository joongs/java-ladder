package laddergame.domain;

import java.util.Objects;

import static java.lang.Boolean.FALSE;
import static laddergame.service.LadderPointGenerator.generatePoint;

public class Direction {
    private final boolean toLeft;
    private final boolean toRight;

    private Direction(boolean toLeft, boolean toRight) {
        if (toLeft && toRight) {
            throw new IllegalStateException();
        }

        this.toLeft = toLeft;
        this.toRight = toRight;
    }

    public boolean isToRight() {
        return toRight;
    }

    public boolean isToLeft() {
        return toLeft;
    }

    public Direction next(boolean nextToRight) {
        return of(toRight, nextToRight);
    }

    public Direction next() {
        if (toRight) {
            return next(FALSE);
        }
        return next(generatePoint());
    }

    public static Direction of(boolean toLeft, boolean toRight) {
        return new Direction(toLeft, toRight);
    }

    public static Direction first(boolean toRight) {
        return of(FALSE, toRight);
    }

    public Direction last() {
        return of(toRight, FALSE);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Direction pair = (Direction) o;
        return toLeft == pair.toLeft &&
                toRight == pair.toRight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(toLeft, toRight);
    }

    @Override
    public String toString() {
        return "Direction{" +
                "toLeft=" + toLeft +
                ", toRight=" + toRight +
                '}';
    }
}