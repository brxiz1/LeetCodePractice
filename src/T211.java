/**
 * @author ZhangYihe
 * @since 2024/10/18
 **/
public class T211 {


    public static void main(String[] args) {
        WordDictionary wd=new WordDictionary();
        wd.addWord("bad");
        wd.addWord("dad");
        wd.addWord("mad");
        wd.search(".ad");
        System.out.println("finish");
    }
}
class WordDictionary {
    Letter letterTree;
    public WordDictionary() {
        letterTree=new Letter();
    }

    public void addWord(String word) {
        letterTree.addWord(word,0);
    }

    public boolean search(String word) {
        return letterTree.searchWord(word,0,word.length());
    }
}
class Letter{
    Letter[] sonLetters;
    boolean isEnd;
    public Letter(){
        sonLetters=new Letter[26];
        isEnd=false;
    }
    public Letter(boolean isEnd){
        sonLetters=new Letter[26];
        this.isEnd=isEnd;
    }

    public void addSon(char ch,boolean isEnd){
        if(sonLetters[ch-'a']==null){
            sonLetters[ch-'a']=new Letter(isEnd);

        }else{
            if(isEnd){
                sonLetters[ch-'a'].isEnd=isEnd;
            }

        }
    }
    public void addWord(String s,int index){
        if(index==s.length()-1){
            addSon(s.charAt(index),true);
        }else{
            addSon(s.charAt(index),false);
            sonLetters[s.charAt(index)-'a'].addWord(s,index+1);
        }
    }
    public boolean searchSon(char ch,boolean isEnd){
        return sonLetters[ch-'a']!=null&&(!isEnd ||sonLetters[ch-'a'].isEnd==isEnd);
    }
    public boolean searchWord(String s,int index,int length){
        if(index==length)return true;
        char ch=s.charAt(index);
        boolean res=false;
        if(ch=='.'){
            //需要特别处理以.结尾的情况
            for(Letter l:sonLetters){
                if(l!=null){
                    if(index==length-1&&!l.isEnd)continue;
                    res=l.searchWord(s,index+1,length);

                    if(res)return res;
                }
            }
        }else{
            res=searchSon(ch,index==length-1);
            if(!res)return false;
            res=sonLetters[ch-'a'].searchWord(s,index+1,length);
        }
        return res;
    }
}