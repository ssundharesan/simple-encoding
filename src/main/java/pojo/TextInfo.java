package pojo;

import java.util.Objects;

public class TextInfo extends Info {
    private Integer verticalIndex;

    private Integer horizontalIndex;

    private String character;

    private TextInfo(Integer verticalIndex, Integer horizontalIndex, String character) {
        this.horizontalIndex = horizontalIndex;
        this.verticalIndex = verticalIndex;
        this.character = character;

    }

    @Override
    public boolean equals(Object obj) {
        if(obj instanceof TextInfo) {
            TextInfo textInfo = (TextInfo) obj;
            return this.verticalIndex == textInfo.verticalIndex && this.horizontalIndex == textInfo.horizontalIndex;
        }
        return false;
    }

    @Override
    public String toString() {
        return "TextInfo{" +
                "verticalIndex=" + verticalIndex +
                ", horizontalIndex=" + horizontalIndex +
                ", character=" + character +
                ", index=" + this.getIndex() +
                '}';
    }

    @Override
    public int hashCode() {

        return Objects.hash(verticalIndex, horizontalIndex);
    }

    public static TextInfo getInstance(Integer verticalIndex, Integer horizontalIndex, String character) {
        return new TextInfo(verticalIndex, horizontalIndex, character);
    }

    public Integer getHorizontalIndex() {
        return horizontalIndex;
    }

    public Integer getVerticalIndex() {
        return verticalIndex;
    }

    public String getCharacter() {
        return character;
    }
}
