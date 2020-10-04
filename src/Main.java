public class Main {
    public static void main(String[] args) throws Exception {
        if (args.length < 2) {
            System.out.printf("Given not enough arguments. Required 2. Given %d\n", args.length);
            return;
        }
        ReadWriteFileUtils.txtToMarkdown(args[0], args[1]);
    }
}
