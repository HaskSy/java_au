package Generator.src;

import java.util.Objects;

public class SolutionLeetcode {
    private String title = null;
    private String link = null;
    private String sourceCode = null;


    String getTitle() {
        return (this.title == null || this.title.length() == 0) ? null : this.title;
    }

    String getLink() {
        return (this.link == null || this.link.length() == 0) ? null : this.link;
    }

    String getSourceCode() {
        return (this.sourceCode == null || this.sourceCode.length() == 0) ? null : this.sourceCode;
    }

    final public void setTitle(String title) {
        this.title = title;
    }

    final public void setLink(String link) {
        this.link = link;
    }

    final public void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        SolutionLeetcode that = (SolutionLeetcode) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(link, that.link) &&
                Objects.equals(sourceCode, that.sourceCode);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, link, sourceCode);
    }
}