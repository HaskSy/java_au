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

    final void setTitle(String title) {
        this.title = title;
    }

    final void setLink(String link) {
        this.link = link;
    }

    final void setSourceCode(String sourceCode) {
        this.sourceCode = sourceCode;
    }
}