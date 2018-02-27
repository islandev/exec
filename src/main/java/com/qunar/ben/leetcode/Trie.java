package com.qunar.ben.leetcode;

/**
 * Created by ben.wang on 2018/2/26.
 */

public class Trie {

  /**
   * Initialize your data structure here.
   */
  public Trie[] childTrie;

  public char val;

  public int feq;

  public Trie() {
    childTrie = new Trie[26];
  }

  /**
   * Inserts a word into the trie.
   */
  public void insert(String word) {
    if (word.length() == 0) {
      return;
    }
    addWithRoot(this, word);

  }


  public void addWithRoot(Trie curRoot, String word) {
    if (word.length() == 0) {
      curRoot.feq += 1;
      return;
    }
    char c = word.charAt(0);
    int index = c - 'a';
    if (curRoot.childTrie == null) {
      curRoot.childTrie = new Trie[26];
    }
    if (curRoot.childTrie[index] == null) {
      curRoot.childTrie[index] = new Trie();
    }
    curRoot.childTrie[index].val = c;

    addWithRoot(curRoot.childTrie[index], word.substring(1));

  }

  /**
   * Returns if the word is in the trie.
   */
  public boolean search(String word) {

    Trie node = this;
    String curWord = word;

    while (curWord.length() > 0) {
      if (node == null) {
        return false;
      }
      int c = curWord.charAt(0) - 'a';
      if (node.childTrie[c] != null && node.childTrie[c].feq > 0 &&curWord.length()==1) {
        return true;
      }
      node = node.childTrie[c];
      curWord = curWord.substring(1);
    }
    return false;
  }

  /**
   * Returns if there is any word in the trie that starts with the given prefix.
   */
  public boolean startsWith(String prefix) {
    Trie node = this;
    String curWord = prefix;

    while (curWord.length() > 0) {
      if (node == null) {
        return false;
      }
      int c = curWord.charAt(0) - 'a';
      if (node.childTrie[c] != null && curWord.length()==1) {
        return true;
      }
      node = node.childTrie[c];
      curWord = curWord.substring(1);
    }
    return false;
  }
}