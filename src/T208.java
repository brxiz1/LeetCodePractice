public class T208 {


    public static void main(String[] args) {
        Tree t=new Tree();
        for(Tree ts:t.trees){
            if(ts==null){
                System.out.println("a");
            }
        }
    }
}
class Trie {
    Tree root;
    public Trie() {
        root=new Tree();
    }

    public void insert(String word) {
        char[] letters=word.toCharArray();
        Tree node=root;
        for(char letter:letters){
            if(node.trees[letter-'a']==null){
                node.trees[letter-'a']=new Tree();
            }
            node=node.trees[letter-'a'];
        }
        node.isEnd=true;

    }

    public boolean search(String word) {
        char[] letters=word.toCharArray();
        Tree node=root;
        for(char letter:letters){
            if(node.trees[letter-'a']==null){
                return false;
            }else{
                node=node.trees[letter-'a'];
            }
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
        char[] letters=prefix.toCharArray();
        Tree node=root;
        for(char letter:letters){
            if(node.trees[letter-'a']==null){
                return false;
            }else{
                node=node.trees[letter-'a'];
            }
        }
        return true;
    }
}
class Tree{
    Tree[] trees=new Tree[26];
    boolean isEnd;

    Tree(){
        isEnd=false;
    }

}