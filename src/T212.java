import java.util.ArrayList;
import java.util.List;

/**
 * @author ZhangYihe
 * @since 2024/10/23
 **/
public class T212 {
    public static void main(String[] args) {
        Solution212 s212=new Solution212();
        char[][] board=new char[][]{{'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'},
        {'a','a','a','a','a','a','a','a','a','a','a','a'}};
        String[] words=new String[]{"a","aa","aaa","aaaa","aaaaa","aaaaaa","aaaaaaa","aaaaaaaa","aaaaaaaaa","aaaaaaaaaa"};
        List<String> list=s212.findWords(board,words);
        System.out.println(list);
    }
}
class Solution212{

    public List<String> findWords(char[][] board, String[] words) {
        Dictionary dictionary=new Dictionary();
        for(String s:words){
            dictionary.addWord(s);
        }

        List<String> resList=new ArrayList<>();
        for(int i=0;i<board.length;i++){
            if(dictionary.wordsNum==0)break;
            for(int j=0;j<board[0].length;j++){
                if(dictionary.wordsNum==0)break;
                resList.addAll(dps(board,i,j,dictionary,new StringBuilder(),dictionary));

            }

        }
        return resList;
    }
    public List<String> dps(char[][] board, int i, int j, Dictionary d, StringBuilder sb, Dictionary head){

        char ch=board[i][j];
        List<String> list=new ArrayList<>();
        if(d.nextList[ch-'a']==null){
             return list;
        }
        sb.append(ch);
        //匹配到
        if(d.nextList[ch-'a'].isEnd){
            list.add(sb.toString());
            //匹配到一次就将词语移除字典
            head.wordsNum--;
            d.nextList[ch-'a'].isEnd=false;
        }
        board[i][j]='~';
        //注意，这里的联通仅包含水平联通和竖直联通，不包含斜向联通
//        for(int m=-1;m<2;m++){
//            for(int n=-1;n<2;n++){
//                if(i+m>=0&&i+m< board.length&&j+n>=0&&j+n<board[0].length&&board[i+m][j+n]!='~'){
//                    list.addAll(dps(board,i+m,j+n,d.nextList[ch-'a'],sb,head));
//                }
//            }
//        }
        if(i-1>=0&&board[i-1][j]!='~'){
            list.addAll(dps(board,i-1,j,d.nextList[ch-'a'],sb,head));
        }
        if(i+1< board.length&&board[i+1][j]!='~'){
            list.addAll(dps(board,i+1,j,d.nextList[ch-'a'],sb,head));
        }
        if(j-1>=0&&board[i][j-1]!='~'){
            list.addAll(dps(board,i,j-1,d.nextList[ch-'a'],sb,head));
        }
        if(j+1<board[0].length&&board[i][j+1]!='~'){
            list.addAll(dps(board,i,j+1,d.nextList[ch-'a'],sb,head));
        }
        board[i][j]=ch;
        sb.deleteCharAt(sb.length()-1);
        return list;
    }
}
class Dictionary{
//    char letter;
    Dictionary[] nextList;
    boolean isEnd;
    int wordsNum;//如何更新？
    Dictionary(){
        nextList=new Dictionary[26];
        isEnd=false;
    }

    public void addSon(char letter,boolean isEnd){
        if(nextList[letter-'a']==null){
            nextList[letter-'a']=new Dictionary();
            nextList[letter-'a'].isEnd=isEnd;
        }else if(isEnd){
            if(!nextList[letter-'a'].isEnd){
                wordsNum++;
            }
            nextList[letter-'a'].isEnd=isEnd;
        }

    }
    public void addWord(String str){
        char[] ctr=str.toCharArray();
        int length=ctr.length;
        if(hasWord(ctr,length))return;
        wordsNum++;
        Dictionary d=this;
        for(int i=0;i<length-1;i++){
            d.addSon(ctr[i],false);
            d=d.nextList[ctr[i]-'a'];
        }
        d.addSon(ctr[length-1],true);
    }

    public boolean hasWord(char[] ctr,boolean isEnd){
        Dictionary d=this;
        for(int i=0;i<ctr.length-1;i++){
            if(d.nextList[ctr[i]-'a']==null){
                return false;
            }
            d=d.nextList[ctr[i]-'a'];
        }
        if(d.nextList[ctr[ctr.length-1]-'a']==null||(isEnd&&!d.nextList[ctr[ctr.length-1]-'a'].isEnd))return false;
        return true;
    }
    public boolean hasWord(char[] ctr,int length){
        Dictionary d=this;
        for(int i=0;i<length-1;i++){
            if(d.nextList[ctr[i]-'a']==null){
                return false;
            }
            d=d.nextList[ctr[i]-'a'];
        }
        if(d.nextList[ctr[length-1]-'a']==null||!d.nextList[ctr[length-1]-'a'].isEnd)return false;
        return true;
    }
}