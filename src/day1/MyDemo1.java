package day1;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

/*
 基础回顾：
 集合：存储对象数据的集合容器
 
 单例集合
--------| Collection 单列集合根接口
------------| List接口 有序可重复
----------------| ArrayList 通过Object数组维护，特点：查询快，增删慢
----------------| LinkedList 通过链表维护，特点：查询慢，增删快
----------------| Vector 和ArrayList一样，但是是线程安全的，操作效率低
------------| Set接口 无序不可重复
----------------| HashSet 通过哈希表维护，特点：存取速度快
	HashSet添加元素原理：
		往HashSet添加元素的时候，HashSet会调用该元素的HashCode方法得到该元素的哈希码，用这个哈希码经过一系列的运算得到一个哈希表中的位置，1.如果
		该位置没有元素，则直接存储在该位置，2.如果该位置有元素，那么要调用该元素的equals与该位置的其他元素相比较，如果返回false，则该元素就存在
		该位置，如果返回true，则视为重复元素，不能存储
----------------| TreeSet 通过红黑树（二叉树）进行维护，会对元素进行排序
 	TreeSet要注意：
 		1.往TreeSet添加元素的时候，如果元素本身具备自然排序的特性，那么会根据元素的自然排序的特性进行排序存储
 		2.往TreeSet添加元素的时候，如果元素本身不具备自然排序的特性，那么元素所属的类要实现Comparable接口，实现compareTo方法，定义排序规则
		3.往TreeSet添加元素的时候，如果元素本身不具备自然排序的特性，元素所属类也没有实现Comparable接口，那么要在创建TreeSet时传入一个自定义比较器类
			自定义比较器类实现Comparator接口，实现Comparator接口的compare方法定义比较规则
			class 比较器类名 implements Comparator{}
		4.如果比较方法（CompareTo或Compare）返回的是0，就被视为重复元素，不允许添加
 
 双列集合：
--------| Map<K,V> 根接口，特点：存储的数据都是以键值对形式存在的，键不可重复，值可以重复
------------| HashMap 底层也是基于哈希表实现的
	HashMap存储原理：（和HashSet类似）
		往HashMap添加元素的时候，首先会调用键的hashCode方法得到元素的哈希码值，如果经过运算就可以算出该元素在哈希表中的存储位置
		情况1：如果该位置没有存储元素，则存在该位置，情况2：如果算出的位置已经有其他元素，会调用该元素的equals方法与位置上的元素都比较，
		如果equals方法返回false，就存在该位置，如果返回true，就视为重复元素，不允许存储
------------| TreeMap 底层也是基于二叉树数据机构实现的，特点：会对元素的键镜像排序存储
	TreeMap要注意的事项：
		1.往TreeMap添加元素的时候，如果元素的键具备自然顺序，那么就按照键的自然顺序特性进行排序存储。
		2.往TreeMap添加元素的时候，如果元素的键不具备自然顺序，那么元素的键所属的类必须要实现Comparable接口，把比较规则定义在comparaTo方法中
		3.往TreeMap添加元素的时候，如果元素的键不具备自然顺序，而且元素的键所属的类也没有实现Comparable接口，那么就必须在创建TreeMap的时候传入一个自定义比较器

------------| HashTable (了解，jdk1.0) 底层也是依赖了哈希表实现的，实现方式与HashMap是一致的，但是他是线程安全的，操作效率低
	
 */
public class MyDemo1 {
	public static void main(String[] args) {
		method1();
	}
	//map集合遍历
	public static void method1() {
		Map<Integer, String> map=new HashMap<>();
		map.put(1, "a");
		map.put(2, "b");
		map.put(3, "a");
		map.put(4, "d");
//		System.out.println(map);
		
		Set<Entry<Integer, String>> set=map.entrySet();
		for(Entry<Integer, String> entry:set){
//			System.out.println(entry);
			System.out.print(entry.getKey());
			System.out.println("="+entry.getValue());
		}
	}
}
