package Design.Mailbox;

public enum Tags {

        IMPORTANT("important"),
        MARKED("marked");


        private String name;

        public String getName() {
            return name;
        }

        Tags(String name) {
            this.name = name;
        }
}
