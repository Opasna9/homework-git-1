package lesson12IOStreams;

public class ParagraphMiddleware extends Middleware {

    public ParagraphMiddleware() {
    }

    public ParagraphMiddleware(Middleware successor){
        this.setSuccessor(successor);
    }

    @Override
    public boolean check(String s) {
        int result = utils.StringUtils.countParagraphs(s);
        System.out.println(result);
        return checkNext(s);
    }
}
