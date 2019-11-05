package lesson12IOStreams;

public class SentenceMiddleware extends Middleware{

    public SentenceMiddleware() {
    }

    public SentenceMiddleware(Middleware successor){
        this.setSuccessor(successor);
    }

    @Override
    public boolean check(String s) {
        int result = utils.StringUtils.countSentences(s);
        System.out.println(result);
        return checkNext(s);
    }

}
