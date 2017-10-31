package Unknown;

public class LC208_ImplementTrie {
    public static class Trie {

        /**
         * Initialize your data structure here.
         */
        class TrieNode {
            char val;
            boolean isWord;
            TrieNode[] children;

            TrieNode(char val) {
                children = new TrieNode[26];
                val = val;
                isWord = false;
            }
        }

        private TrieNode root;

        public Trie() {
            root = new TrieNode(' ');
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            char[] word_chs = word.toCharArray();
            TrieNode tr = root;
            for (int i = 0; i < word_chs.length; i++) {
                int index = word_chs[i] - 'a';
                if (tr.children[index] == null) {
                    tr.children[index] = new TrieNode(word_chs[i]);
                }
                tr = tr.children[index];
            }
            tr.isWord = true;
        }

        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            char[] word_chs = word.toCharArray();
            TrieNode tr = root;
            for (int i = 0; i < word_chs.length; i++) {
                int index = word_chs[i] - 'a';
                if (tr.children[index] == null) {
                    return false;
                }
                tr = tr.children[index];
            }
            return tr.isWord;
        }

        /** Returns if there is any word in the trie that starts with the given prefix. */
        public boolean startsWith(String prefix) {
            char[] word_chs = prefix.toCharArray();
            TrieNode tr = root;
            for (int i = 0; i < word_chs.length; i++) {
                int index = word_chs[i] - 'a';
                if (tr.children[index] == null) {
                    return false;
                }
                tr = tr.children[index];
            }
            return true;
        }
    }
}
