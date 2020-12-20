package Design.Mailbox;

public enum Tags {

        IMPORTANT("important"),
        MARKED("marked"),
        UNTAGGED("");

        private String name;

        public String getName() {
            return name;
        }

        Tags(String name) {
            this.name = name;
        }


}

