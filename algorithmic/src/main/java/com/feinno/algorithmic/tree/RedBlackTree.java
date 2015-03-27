package com.feinno.algorithmic.tree;

import java.util.LinkedList;
import java.util.List;
import java.util.Random;

/**
 * 
 * @author renzhaolong
 *
 * @param <K>
 * @param <V>
 */
public class RedBlackTree<K extends Comparable<K>, V> {
	
	//哨兵节点
	private Node nil = new Node();
	//根节点
	private Node root = nil;
	
	/**
	 * 插入新值
	 * @param key
	 * @param value
	 */
	public void insert(K key, V value) {
		Node newNode = new Node(key, value);
		if (root == nil) {
			root = newNode;
			root.color = Color.Black;
			return;
		}
		Node currentNode = root;
		newNode.color = Color.Red;
		while (currentNode != nil) {
			int compare = key.compareTo(currentNode.key);
			if (compare >= 0) {
				if (currentNode.rightChild != nil) {
					currentNode = currentNode.rightChild;
				} else {
					currentNode.rightChild = newNode;
					newNode.parent = currentNode;
					break;
				}
			} else {
				if (currentNode.leftChild != nil) {
					currentNode = currentNode.leftChild;
				} else {
					currentNode.leftChild = newNode;
					newNode.parent = currentNode;
					break;
				}
			}
		}
		if (currentNode.color == Color.Red) {
			insertBalance(newNode);
		}
	}
	
	/**
	 * 添加节点后平衡红黑树
	 * 如果父节点为红色，两个连续红色节点
	 * 1. 如果父节点为黑色，平衡完成
	 * 2. 如果叔节点为红色，向上循环
	 * 3. 如果叔节点为黑色，把多余红色节点旋转到叔节点
	 * @param node
	 */
	private void insertBalance(Node node) {
		Node parent = node.parent;
		//如果父节点同为红色，违反红黑树性质
		while (node != root && node.parent != root && parent.color == Color.Red) {
			//if left child
			if (parent.parent.leftChild == parent) {
				Node y = parent.parent.rightChild;
				//如果叔父节点也为红色，祖父节点已满，需要向上分裂
				if (y.color == Color.Red) {
					parent.color = Color.Black;
					y.color = Color.Black;
					parent.parent.color = Color.Red;
					node = parent.parent;
					parent = node.parent;
				} else { //否则通过旋转维持平衡
					//if right child
					if (parent.rightChild == node) {
						parent = leftRotate(parent);
					}
					parent.color = parent.parent.color;
					parent.parent.color = Color.Red;
					parent = rightRotate(parent.parent);
					break;
				}
			} else {
				Node y = parent.parent.leftChild;
				if (y.color == Color.Red) {
					parent.color = Color.Black;
					y.color = Color.Black;
					parent.parent.color = Color.Red;
					node = parent.parent;
					parent = node.parent;
				} else {
					if (parent.leftChild == node) {
						parent = rightRotate(parent);
					}
					parent.color = parent.parent.color;
					parent.parent.color = Color.Red;
					parent = leftRotate(parent.parent);
					break;
				}
			}
		}
		root.color = Color.Black;
	}
	
	/**
	 * 删除key所在node
	 * @param key
	 */
	public V delete(K key) {
		Node del = search(key);
		if (nil == del) {
			return null;
		}
		V result = del.value;
		if (del.leftChild != nil && del.rightChild != nil) {
			Node successor = getSuccessorNode(del);
			del.key = successor.key;
			del.value = successor.value;
			del = successor;
		}
		Node current;
		if (del.leftChild != nil) {
			current = del.leftChild;
		} else {
			current = del.rightChild;
		}
		current.parent = del.parent;
		if (current.parent.leftChild == del) {
			current.parent.leftChild = current;
		} else {
			current.parent.rightChild = current;			
		}
		//如果删除的是黑色节点，需要重新平衡
		if (del.color == Color.Black) {
			DeleteBalance(current);
		}
		
		return result;
	}
	
	/**
	 * 删除节点后平衡红黑树
	 * 删除节点的子树深度不够
	 * 补足深度
	 * 1. 如果节点为红色，直接变为黑色补足
	 * 2. 如果兄弟节点为黑色，侄子也为黑色，将兄弟变为红色；
	 *    与兄弟深度平衡后继续向上循环
	 * 3. 如果兄弟为红色，或者侄子为红色，抢夺一个红色的节点补足自身
	 * @param node
	 */
	private void DeleteBalance(Node node) {
		while (node != root && node.color == Color.Black) {
			Node parent = node.parent;
			if (parent.leftChild == node) {
				Node right = parent.rightChild;
				if (right.color == Color.Red) {
					right.color = Color.Black;
					parent.color = Color.Red;
					node = leftRotate(parent);
					right = parent.rightChild;
				}
				if (right.leftChild.color == Color.Black &&
						right.rightChild.color == Color.Black) {
					right.color = Color.Red;
					node = parent;
					continue;
				} else {
					if (right.rightChild.color == Color.Black) {
						right.color = Color.Red;
						right.leftChild.color = Color.Black;
						right = rightRotate(right);
					}
					parent = leftRotate(parent);
					parent.color = parent.leftChild.color;
					parent.rightChild.color = Color.Black;
					parent.leftChild.color = Color.Black;
					break;
				}
			} else {
				Node left = parent.leftChild;
				if (left.color == Color.Red) {
					left.color = Color.Black;
					parent.color = Color.Red;
					rightRotate(parent);
					left = parent.leftChild;
				}
				if (left.leftChild.color == Color.Black &&
						left.rightChild.color == Color.Black) {
					left.color = Color.Red;
					node = parent;
					continue;
				} else {
					if (left.leftChild.color == Color.Black) {
						left.color = Color.Red;
						left.rightChild.color = Color.Black;
						left = leftRotate(left);
					}
					parent = rightRotate(parent);
					parent.color = parent.rightChild.color;
					parent.rightChild.color = Color.Black;;
					parent.leftChild.color = Color.Black;
					//node = parent;
					break;
				}
			}
		}
		node.color = Color.Black;
	}
	
	/**
	 * 获取当前节点的后继节点
	 * @param node
	 * @return
	 */
	private Node getSuccessorNode(Node node) {
		if (node.rightChild == nil) {
			Node temp = node;
			while (temp.parent != nil) {
				if (temp.parent.leftChild == temp) {
					return temp.parent;
				}
			}
			return nil;
		}
		if (node.rightChild != nil) {
			Node temp = node.rightChild;
			while (temp.leftChild != nil) {
				temp = temp.leftChild;
			}
			return temp;
		}
		return nil;
	}
	
	/**
	 * 右旋
	 * 把左子节点提上来
	 * @param node
	 * @return
	 */
	private Node rightRotate(Node node) {
		Node left = node.leftChild;
		node.leftChild = left.rightChild;
		node.leftChild.parent = node;
		left.rightChild = node;
		left.parent = node.parent;
		node.parent = left;
		if (left.parent.leftChild == node) {
			left.parent.leftChild = left;
		} else {
			left.parent.rightChild = left;
		}
		return left;
	}
	
	/**
	 * 左旋
	 * 把右子节点提上来
	 * @param node
	 * @return
	 */
	private Node leftRotate(Node node) {
		Node right = node.rightChild;
		node.rightChild = right.leftChild;
		node.rightChild.parent = node;
		right.leftChild = node;
		right.parent = node.parent;
		node.parent = right;
		if (right.parent.leftChild == node) {
			right.parent.leftChild = right;
		} else {
			right.parent.rightChild = right;
		}
		return right;
	}
	
	/**
	 * 根据key获取value
	 * @param key
	 * @return
	 */
	public V get(K key) {
		return search(key).value;
	}
	
	/**
	 * 根据key查找Node
	 * @param key
	 * @return
	 */
	private Node search(K key) {
		Node result = root;
		while (result != nil) {
			int compare = key.compareTo(result.key);
			if (compare == 0) {
				return result;
			} else if (compare > 0) {
				result = result.rightChild;
			} else {
				result = result.leftChild;
			}
		}
		return nil;
	}
	
	private boolean checkBalance() {
		if (root == nil) { return true; }
		if (root.color == Color.Red) { return false; } 
		int height = getNodeHeight(root); 
		if (-1 == height) {
			return false;
		}
		return true;
	}
	
	/**
	 * 如果满足红黑树性质
	 * 如果不满足，返回-1
	 * @param node
	 * @return
	 */
	private int getNodeHeight(Node node) {
		if (node == nil) {
			return 0;
		}
		if (Color.Red == node.color && Color.Red == node.parent.color) {
			return -1;
		}
		int left = getNodeHeight(node.leftChild);
		if (-1 == left) {
			return -1;
		}
		int right = getNodeHeight(node.rightChild);
		if (left != right) {
			return -1;
		}
		if (Color.Red == node.color)
			return right;
		return right + 1;
	}
	
	private class Node implements Comparable<Node> {
		private Node parent = nil;
		private Node leftChild = nil;
		private Node rightChild = nil;
		private Color color = Color.Black;
		private K key;
		private V value;
		
		public Node(){}
		
		public Node(K key, V value) {
			this.key = key;
			this.value = value;
		}
		
		@Override
		public int compareTo(Node o) {
			return key.compareTo(o.key);
		}
		
		public String toString() {
			return "Key:" + key.toString() + " Color:" + color;
		}
	}
	private static enum Color {
		Red,
		Black
	}
	
	public static void main(String[] args) throws Exception {
		RedBlackTree<Integer, Integer> rb = new RedBlackTree<Integer, Integer>();
		List<Integer> keys = new LinkedList<Integer>();
		Random ran = new Random();
		
		for (int i = 0; i < 1000; i++) {
			int key = ran.nextInt(100000);
			rb.insert(key, 1);
			keys.add(key);
			if (rb.checkBalance() == false) {
				throw new Exception("error");
			} else {
				System.out.println("good:" + key);
			}
		}
		for (int key : keys) {
			rb.delete(key);
			if (rb.checkBalance() == false) {
				throw new Exception("error" + key);
			} else {
				//System.out.println("good");
			}
		}
	}
}
