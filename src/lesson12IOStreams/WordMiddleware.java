package lesson12IOStreams;

public class WordMiddleware extends Middleware{

    public WordMiddleware() {
    }

    public WordMiddleware(Middleware successor){
        this.setSuccessor(successor);
    }

    @Override
    public boolean check(String s) {
        int result = utils.StringUtils.countWords(s);
        System.out.println(result);
        return checkNext(s);
    }
}
