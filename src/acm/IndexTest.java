/**
 * 版权所有: wulihua
 * 创建日期: 2020/10/12
 * 创建作者：wuqia
 * 文件名称：IndexTest.java
 * 版本: 1.0
 * 修改记录:
 */
package acm;


import java.util.List;

/**
 * Description: 区间索引.
 * @author wuqia
 * @since 2020/10/12
 */
public class IndexTest {

    private class Index {
        private int left;
        private int right;

        public Index(int left, int right) {
            this.left = left;
            this.right = right;
        }

        public int getLeft() {
            return left;
        }

        public void setLeft(int left) {
            this.left = left;
        }

        public int getRight() {
            return right;
        }

        public void setRight(int right) {
            this.right = right;
        }
    }

    private class Node {
        /**
         * index
         */
        private Index index;
        private List<Integer> list;

        public Node(Index index, List<Integer> list) {
            this.index = index;
            this.list = list;
        }

        public Index getIndex() {
            return index;
        }

        public void setIndex(Index index) {
            this.index = index;
        }

        public List<Integer> getList() {
            return list;
        }

        public void setList(List<Integer> list) {
            this.list = list;
        }


    }

    private List treeList = new org.apache.commons.collections.list.TreeList();

    public List<Integer> get(Integer i) {
      return null;
    }

    public Node biSearch() {
        return null;
    }


    public void put(Index index, List<Integer> val) {
        Node node = new Node(index, val);
        // 有序存入數據
        treeList.add(node);
    }
}
