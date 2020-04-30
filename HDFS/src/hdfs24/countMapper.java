package hdfs24;

public class countMapper implements mapper{
    @Override
    public void map(String line, context context) {
        String[] s = line.split(" ");
        for (String word:s){
            if (context.get(word)==null){
                context.write(word,1);
            }
            else {
                int num = (Integer) context.get(word);
                context.write(word,num+1);
            }
        }
    }
}
